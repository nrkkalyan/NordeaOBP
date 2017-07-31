(function() {
	'use strict'

	angular.module('HttpAccessService', [])//
	.service('HttpAccessService', HttpAccessService);

	function HttpAccessService($http) {
		var baseUrl = 'restapi/aisp/';

		this.getAccounts = function(bankName) {
			console.log('thHttpService.getAccounts:',bankName);
			return $http.get(baseUrl + 'accounts', {
				params : {
					"bankName" : bankName
				},
				headers: {
					   'Accept': 'application/json'
				}
			});
		}

		this.getAccountDetails = function(accountId, bankName) {
			console.log('getAccountDetails accountId:' + accountId);
			return $http.get(baseUrl + 'accounts/' + accountId, {
				params : {
					"bankName" : bankName
				},
				headers: {
					   'Accept': 'application/json'
				}
			});
		}
		
		this.getTransactions = function(accountId, bankName) {
			console.log('getTransactions accountId:' + accountId);
			return $http.get(baseUrl + 'accounts/' + accountId+ '/transactions', {
				params : {
					"bankName" : bankName
				},
				headers: {
					   'Accept': 'application/json'
				}
			});
		}
		
		
		this.getBanks = function() {
			console.log('getBanks');
			return $http.get(baseUrl + 'banks', {
				headers: {
					   'Accept': 'application/json'
				}
			});
		}

	}

})()