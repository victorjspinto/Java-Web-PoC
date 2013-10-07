/// <reference path="reference.ts" />

require.config({
    baseUrl: '/app',

    paths: {
        'jquery': '../lib/jquery/jquery',
        'angular': '../lib/angular/angular',
        'angularRoute': '../lib/angular-route/angular-route',
        'bootstrap': '../lib/bootstrap/dist/js/bootstrap'
    },

    shim: {
        jquery: {
            exports: '$'
        },
        angular: {
            deps: ['jquery'],
            exports: 'angular'
        },
        angularRoute: {
            deps: ['angular'],
            exports: 'angularRoute'
        },
        bootstrap: {
            deps: ['jquery']
        }
    }
    // , urlArgs: 'v=1.0'
});


require(['config/appConfig','angular','bootstrap'],
    (config: any) => {
        var app = { 'lazy': angular.module('lazyOverride', []) };
        angular.bootstrap(document, ['javawebpoc-html']);
    }
);