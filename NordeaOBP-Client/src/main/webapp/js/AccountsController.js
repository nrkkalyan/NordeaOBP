(function() {
	'use strict'

	var personCtrl = angular.module('AccountsController',
			[ 'HttpAccessService', 'ngDialog' ])//
	.controller('AccountsController', AccountsController);

	function AccountsController($scope, $window, $http, $filter, HttpAccessService, ngDialog,
			ngProgressFactory) {
		$scope.errorMessage = "";
		$scope.th = [];
		$scope.fileHistoryDetails = [];
		$scope.fileTypes = [];
		$scope.isDisabled = false;
		var now = new Date();
		$scope.dateFrom = $filter("date")(
				now.getTime() - 7 * 24 * 60 * 60 * 1000, 'dd.MM.yyyy');
		$scope.dateTo = $filter("date")(now.getTime(), 'dd.MM.yyyy');
		$scope.disableSignerId = true;
		$scope.disableServiceId = true;
		$scope.submitedFileType = "";
		
		
		$scope.showSigner = function() {
	        var validValues = ['NDCAPXMLI', 'NDCAPXMLO', 'NDCAPXMLD54O', 'NDCAPCANXMLI', 'NDCAPCANXMLO'];
	        for (var i = 0; i < validValues.length; i++) {
	          if ($scope.submitedFileType == validValues[i]) {
	            return true;
	          }
	        }
	        return false;
	    }

	    $scope.showService = function() {
	        var validValues = ['NDARSTXMLO','NDAREXXMLO', 'NDARCRAXMLO', 'NDARCRSXMLO', 'NDARCRUXMLO', 'NDARDEAXMLO', 'NDARDEBPXMLO', 'NDARDESAXMLO', 'NDSWMT940O', 'NDSWMT941O', 'NDSWMT942O'];
	        for (var i = 0; i < validValues.length; i++) {
	          if ($scope.submitedFileType == validValues[i]) {
	            return true;
	          }
	        }
	        return false;
	    }


		$scope.getAvailableFiles = function(senderId, signerId, dateFrom, dateTo, action, fileType, serviceId, maxFiles) {
			console.log('AccountsController.getAvailableFiles:', senderId, dateFrom, dateTo, action, fileType, serviceId, maxFiles);
			$scope.isDisabled = true;
			$scope.errorMessage = "";
			$scope.contained_progressbar = ngProgressFactory.createInstance();
			$scope.contained_progressbar.start();
			$scope.submitedFileType = fileType;
			HttpAccessService
					.getAvailableFiles(senderId, signerId, dateFrom, dateTo, action, fileType, serviceId, maxFiles)
					.success(
							function(data) {
								console.log('Response:', data);
								if (data.TransmissionFileError != null) {
									$scope.errorMessage = data.TransmissionFileError.errorMessage;
									$scope.th = [];
								} else {
									$scope.th = data;
									$scope.errorMessage = "";
								}
							})
					.error(
							function(error) {
								console.log('errorMessage: ', error);
								if (error.TransmissionFileError != null) {
									$scope.errorMessage = error.TransmissionFileError.errorMessage;
								} else {
									$scope.errorMessage = error.errorMessage
											|| "Request failed";
								}
								$scope.th = [];
							});
			$scope.isDisabled = false;
			$scope.contained_progressbar.complete();
			console.log('getAvailableFiles  done');
		}

		$scope.showFileDetails = function(fileId) {
			$scope.errorMessage = "";
			console.log('showFileDetails', fileId);
			HttpAccessService
					.getFileTransferDetails(fileId)
					.success(
							function(data) {
								$scope.fileDetails = data.TransmissionDetails;
								ngDialog.open({
									template : 'partials/filedetails.html',
									scope : $scope
								});
								console.log('showFileDetails: ',
										data.TransmissionDetails);
							})
					.error(
							function(error) {
								console.log('errorMessage: ', error);
								if (error.TransmissionDetailsError != null) {
									$scope.errorMessage = error.TransmissionDetailsError.errorMessage;
								} else {
									$scope.errorMessage = error.errorMessage
											|| "Request failed";
								}
							});
		}
		
		
		$scope.showMT = function(mtLink) {
			$scope.errorMessage = "";
			console.log('showMT', mtLink);
			$window.open(mtLink, "popup", "resizable=yes,width=800,height=800,left=10,top=150");
		}

		$scope.getFileHistoryDetails = function(fileId) {
			$scope.errorMessage = "";
			console.log('getFileHistoryDetails', fileId);
			HttpAccessService
					.getFileHistoryDetails(fileId)
					.success(function(data) {
						$scope.fileHistoryDetails = data.fileHistoryDetails;
						console.log('getFileHistoryDetails: ', data);
					})
					.error(
							function(error) {
								console.log('errorMessage: ', error);
								if (error.fileDetailsError != null) {
									$scope.errorMessage = error.fileDetailsError.errorMessage;
								} else {
									$scope.errorMessage = error.errorMessage
											|| "Request failed";
								}
							});
		}

		$scope.loadFileTypes = function() {
			$scope.errorMessage = "";
			console.log('getFileTypes');
			HttpAccessService
					.getFileTypes()
					.success(function(data) {
						$scope.fileTypes = data;
						console.log('getFileTypes: ', data);
					})
					.error(
							function(error) {
								console.log('errorMessage: ', error);
								if (error.fileDetailsError != null) {
									$scope.errorMessage = error.fileDetailsError.errorMessage;
								} else {
									$scope.errorMessage = error.errorMessage
											|| "Request failed";
								}
							});
		}

		$scope.onFileTypeComboBoxChanged = function(fileType) {
			$scope.signerId = "";
			$scope.serviceId = "";
			
			if (fileType == undefined) {
				$scope.disableSignerId = true;
				$scope.disableServiceId = true;
			} else {
				
				$scope.disableSignerId = !(fileType == 'NDCAPXMLI'
						|| fileType == 'NDCAPXMLO'
						|| fileType == 'NDCAPXMLD54O'
						|| fileType == 'NDCAPCANXMLI' 
						|| fileType == 'NDCAPCANXMLO');
				
				$scope.disableServiceId = !$scope.disableSignerId;
			}

		}
		
		$scope.formatDate = function(input,pattern) {
			if(input != null){
				return moment(input,"YYYYMMDD HH:mm").format(pattern);
			}
			return "";
		}
	}

})();