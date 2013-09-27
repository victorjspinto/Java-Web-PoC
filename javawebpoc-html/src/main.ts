/// <reference path="reference.ts" />

require.config({
    baseUrl: '/',

    paths: {
        'jquery': 'http://code.jquery.com/jquery-1.8.3.min.js',
        'angular': 'http://ajax.googleapis.com/ajax/libs/angularjs/1.1.5/angular'
    },

    shim: {
        jquery: {
            exports: '$'
        },
        angular: {
            exports: 'angular',
            depends: ['jquery']
        }
    }
    // , urlArgs: 'v=1.0'
});


require(['config/appConfig', 'angular'],
    function (config) {
        var app = { 'lazy': angular.module('lazyOverride', []) };
        angular.bootstrap(document, ['javawebpoc-html']);
    }
    );