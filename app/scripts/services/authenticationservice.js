'use strict';

/**
 * @ngdoc service
 * @name gtplaceFrontendApp.authenticationservice
 * @description
 * # authenticationservice
 * Service in the gtplaceFrontendApp.
 */
angular.module('gtplaceFrontendApp')
  .service('authenticationservice', function ($log) {

    function checkAuth() {
      $log.log('Authentication checked')
      return true;
    }

    return {
      checkAuth: checkAuth
    };
  });
