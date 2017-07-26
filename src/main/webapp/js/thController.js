(function() {
	'use strict'
	
	var personCtrl = angular.module('ThController', [ 'ThHttpService','ngDialog' ])//
	.controller('ThController', ThController);
	

	function ThController($scope, $http, $filter, ThHttpService, ngDialog, ngProgressFactory) {
		$scope.errorMessage = "";
		$scope.th = [];
		$scope.fileTypes = [];
		$scope.isDisabled = false;
		var now = new Date();
		$scope.transmissionFromDate = $filter("date")(now.getTime(), 'dd.MM.yyyy');
		$scope.transmissionToDate = $filter("date")(now.getTime(), 'dd.MM.yyyy');
		$scope.disableSignerId = true;
		
		$scope.getFileTransferForCustomer = function(senderId, direction, status, fileType, signerId, dateFrom, dateTo) {
			console.log('ThController.getFileTransferForCustomer:',senderId, direction, status, fileType, signerId, dateFrom, dateTo);
			$scope.isDisabled = true;
			$scope.errorMessage = "";
			$scope.contained_progressbar = ngProgressFactory.createInstance();
			$scope.contained_progressbar.start();
			ThHttpService.getFileTransferForCustomer(senderId, direction, status, fileType, signerId, dateFrom, dateTo)//
			.success(function(data) {
				console.log('Response:',data);
				if(data.TransmissionListError != null){
					$scope.errorMessage = data.TransmissionListError.errorMessage;
					$scope.th = [];
				}else{
					$scope.th = data;
					$scope.errorMessage = "";
				}
			}).error(function(error) {
				console.log('errorMessage: ',error);
				if(error.TransmissionListError != null){
					$scope.errorMessage = error.TransmissionListError.errorMessage;
				}else{
					$scope.errorMessage = error.errorMessage || "Request failed";
				}
				$scope.th = [];
			});
			$scope.isDisabled = false;
			$scope.contained_progressbar.complete();
			console.log('getFileTransferForCustomer  done');
		}
		
		
		$scope.showThDetails = function(internalTxnId) {
			$scope.errorMessage = "";
			console.log('showThDetails', internalTxnId);
			ThHttpService.getFileTransferDetails(internalTxnId).success(
					function(data) {
						$scope.fileDetails = data.TransmissionDetails;
						ngDialog.open({ template: 'partials/filedetails.html', scope: $scope });
						console.log('showThDetails: ',data.TransmissionDetails);
					}).error(function(error) {
						console.log('errorMessage: ',error);
						if(error.TransmissionDetailsError != null){
							$scope.errorMessage = error.TransmissionDetailsError.errorMessage;
						}else{
							$scope.errorMessage = error.errorMessage || "Request failed";
						}
			});
		}
		
		$scope.loadFileTypes = function() {
			$scope.errorMessage = "";
			console.log('getFileTypes');
			ThHttpService.getFileTypes().success(
					function(data) {
						$scope.fileTypes = data;
						console.log('getFileTypes: ',data);
					}).error(function(error) {
						console.log('errorMessage: ',error);
						if(error.fileDetailsError != null){
							$scope.errorMessage = error.fileDetailsError.errorMessage;
						}else{
							$scope.errorMessage = error.errorMessage || "Request failed";
						}
			});
		}
		
		$scope.onChanged = function(fileType) {
			$scope.signerId = "";
			if (fileType == undefined) {
				$scope.disableSignerId = true;
			} else {
				
				$scope.disableSignerId = !(fileType == 'NDCAPXMLI' || fileType == 'NDCAPCANXMLI');
				
			}

		}
		
	}

})();