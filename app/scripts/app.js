'use strict';

/**
 * @ngdoc overview
 * @name gtplaceFrontendApp
 * @description
 * # gtplaceFrontendApp
 *
 * Main module of the application.
 */
angular
  .module('gtplaceFrontendApp', [
    'ngAnimate',
    'ngCookies',
    'ngMessages',
    'ngResource',
    'ngRoute',
    'ngSanitize',
    'ngTouch'
  ])
  .config(function ($routeProvider) {
    $routeProvider
      .when('/', {
        templateUrl: 'views/main.html',
        controller: 'MainCtrl'
      })
      .when('/about', {
        templateUrl: 'views/about.html',
        controller: 'AboutCtrl'
      })
      .otherwise({
        redirectTo: '/'
      });
  })

  // global route resolve for authentication.
  .config(function($routeProvider) {
    var globalRouteResolver = {
      checkAuth: ['authenticationservice', function(authenticationservice) {
        return authenticationservice.checkAuth();
      }]
    };

    var when = $routeProvider.when;
    $routeProvider.when = function(path, params) {
      params.resolve = (params.resolve) ? params.resolve : {};
      angular.extend(params.resolve, globalRouteResolver);
      return when(path, params);
    };
  })
