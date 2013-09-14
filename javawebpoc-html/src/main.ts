require.config({
    baseUrl: '/',
    paths: {}
    // , urlArgs: 'v=1.0'
});



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