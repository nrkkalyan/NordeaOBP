(function(){
	'use strict';

// Declare app level module which depends on filters, and services
var app = angular.module('app', [ 'ngRoute','AccountsController','AngularJsApp.directives',
                                  'ngProgress','ngCacheBuster'])
.config(['$routeProvider', function($routeProvider) {
	$routeProvider.when('/accounts', {templateUrl: 'partials/accounts.html', controller: 'AccountsController'});

	// Default
    $routeProvider.otherwise({redirectTo: '/accounts'});
}
])
.value("version","1.0");
 
 
})();