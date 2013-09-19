/// <reference path="reference.ts" />

require.config({
    baseUrl: '/',
    paths: {}
    // , urlArgs: 'v=1.0'
});

var app = {'lazy': angular.module('lazyOverride',[])};

require
(
    [
        'config/appConfig'
    ],
    function(app)
    {
        angular.bootstrap(document, ['javawebpoc-html']);
    }
);