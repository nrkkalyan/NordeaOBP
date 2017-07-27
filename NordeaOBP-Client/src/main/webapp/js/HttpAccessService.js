(function() {
	'use strict'

	angular.module('HttpAccessService', [])//
	.service('HttpAccessService', HttpAccessService);

	function HttpAccessService($http) {
		var baseUrl = 'restapi/myfiles';

		this.getFileTransferForCustomer = function(senderId, direction, status, fileType, signerId, dateFrom, dateTo) {
			console.log('thHttpService.getFileTransferForCustomer:',senderId, direction, status, fileType, signerId, dateFrom, dateTo);
			return $http.get(baseUrl + '/getFileTransferForCustomer', {
				params : {
					"senderId" : senderId,
					"direction" : direction,
					"status" : status,
					"fileType" : fileType,
					"signerId" : signerId,
					"dateFrom" : dateFrom,
					"dateTo" : dateTo
				},
				headers: {
					   'Accept': 'application/json'
				}
			});
		}

		this.getAvailableFiles = function(senderId, signerId, dateFrom, dateTo, action, fileType, serviceId, maxFiles) {
			console.log('thHttpService.getAvailableFiles:',senderId, signerId, dateFrom, dateTo, action, fileType, serviceId, maxFiles);
			return $http.get(baseUrl + '/getAvailableFiles', {
				params : {
					"senderId" : senderId,
					"signerId" : signerId,
					"dateFrom" : dateFrom,
					"dateTo" : dateTo,
					"action" : action,
					"fileType" : fileType,
					"serviceID" : serviceId,
					"maxFiles" : maxFiles
				},
				headers: {
					   'Accept': 'application/json'
				}
			});
		}

		this.getFileTransferDetails = function(internalTxnIdOrFileId) {
			console.log('getFileTransferDetails internalTxnIdOrFileId:' + internalTxnIdOrFileId);
			return $http.get(baseUrl + '/getFileTransferDetails', {
				params : {
					"fileId" : internalTxnIdOrFileId
				},
				headers: {
					   'Accept': 'application/json'
				}
			});
		}
		
		this.getFileHistoryDetails = function(fileId) {
			console.log('getFileHistoryDetails fileId:' + fileId);
			return $http.get(baseUrl + '/filehistory', {
				params : {
					"fileId" : fileId
				},
				headers: {
					   'Accept': 'application/json'
				}
			});
		}
		
		
		this.getFileTypes = function() {
			console.log('getFileTypes');
			return $http.get(baseUrl + '/filetypes', {
				headers: {
					   'Accept': 'application/json'
				}
			});
		}

	}

})()