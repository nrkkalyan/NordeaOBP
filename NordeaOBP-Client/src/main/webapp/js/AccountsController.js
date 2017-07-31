(function() {
	'use strict'

	var personCtrl = angular.module('AccountsController',
			[ 'HttpAccessService', 'ngDialog' ])//
	.controller('AccountsController', AccountsController);

	function AccountsController($scope, $window, $http, $timeout, $filter, HttpAccessService, ngDialog,
			ngProgressFactory) {
		$scope.errorMessage = "";
		$scope.accountsList = [];
		$scope.transactionsList = [];
		$scope.availableBanks = [];
		$scope.selectedBank = "";
		$scope.isDisabled = false;
		var now = new Date();
		$scope.dateFrom = $filter("date")(
				now.getTime() - 7 * 24 * 60 * 60 * 1000, 'dd.MM.yyyy');
		$scope.dateTo = $filter("date")(now.getTime(), 'dd.MM.yyyy');
		
		
		$scope.getAccounts = function(bankName, dateFrom) {
			console.log('AccountsController.getAccounts:', bankName, dateFrom);
			$scope.isDisabled = true;
			$scope.errorMessage = "";
			$scope.selectedBank = bankName;
			$scope.contained_progressbar = ngProgressFactory.createInstance();
			$scope.contained_progressbar.start();
			HttpAccessService
					.getAccounts(bankName)
					.success(
							function(data) {
								console.log('Response:', data);
								$scope.accountsList = data;
							})
					.error(
							function(error) {
								console.log('errorMessage: ', error);
								$scope.errorMessage = error
								$scope.accountsList = [];
							});
			$scope.isDisabled = false;
			$scope.contained_progressbar.complete();
			console.log('getAccounts  done');
		}

		$scope.showAccountDetails = function(accountId) {
			$scope.errorMessage = "";
			console.log('showAccountDetails', accountId, $scope.selectedBank);
			HttpAccessService
					.getAccountDetails(accountId, $scope.selectedBank)
					.success(
							function(data) {
								console.log('showAccountDetails: ', data);
								$scope.accountInfoDetails = data;
								console.log('showAccountDetails.accountInfoDetails: ', $scope.accountInfoDetails);
								var dialog = ngDialog.open({
									template : 'partials/accountdetails.html',
									scope : $scope
								});
								dialog.closePromise.then(function(data) {
									console.log('ngDialog close promise: reloading the page.');
									$scope.getAccounts($scope.bankName, $scope.dateFrom);
								    return true;
								});
							})
					.error(
							function(error) {
								console.log('errorMessage: ', error);
								$scope.errorMessage = error;
								$scope.accountInfoDetails = [];
							});
		}
		
		$scope.getTransactions = function(accountId) {
			$scope.errorMessage = "";
			console.log('getTransactions', accountId, $scope.selectedBank);
			HttpAccessService
					.getTransactions(accountId, $scope.selectedBank)
					.success(function(data) {
						$scope.transactionsList = data;
						console.log('getTransactions: ', data);
					})
					.error(
							function(error) {
								console.log('errorMessage: ', error);
								$scope.errorMessage = error;
								$scope.transactionsList = [];
							});
		}

		$scope.loadAvailableBanks = function() {
			$scope.errorMessage = "";
			console.log('loadAvailableBanks');
			HttpAccessService
					.getBanks()
					.success(function(data) {
						$scope.availableBanks = data;
						console.log('availableBanks: ', data);
					})
					.error(
							function(error) {
								console.log('errorMessage: ', error);
								$scope.errorMessage = error;
							});
		}

		$scope.formatDate = function(input,pattern) {
			if(input != null){
				return moment(input,"YYYYMMDD HH:mm").format(pattern);
			}
			return "";
		}
	}

})();