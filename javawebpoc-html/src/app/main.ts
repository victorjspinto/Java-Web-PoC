/// <reference path="reference.ts" />

require.config({
    baseUrl: '/app',

    paths: {
        'jquery': './../lib/jquery/jquery',
        'angular': './../lib/angular/angular',
        'bootstrap': './../lib/bootstrap/dist/js/bootstrap'
    },

    shim: {
        jquery: {
            exports: '$'
        },
        angular: {
            exports: 'angular',
            deps: ['jquery']
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