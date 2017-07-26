(function(){
	'use strict';

// Declare app level module which depends on filters, and services
var app = angular.module('app', [ 'ngRoute','ThController','FilesController','AngularJsApp.directives','ngProgress','ngCacheBuster'])
.config(['$routeProvider', function($routeProvider) {
    //MyFiles
	$routeProvider.when('/files', {templateUrl: 'partials/files.html', controller: 'FilesController'});
	$routeProvider.when('/transmissionlist', {templateUrl: 'partials/transmissionlist.html', controller: 'ThController'});

	// Default
    $routeProvider.otherwise({redirectTo: '/files'});
}
])
.value("version","1.0");
 
 
})();