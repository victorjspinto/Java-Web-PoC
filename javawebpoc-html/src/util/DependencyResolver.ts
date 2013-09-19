define([], function()
{
    return function(dependencies)
    {
        console.log('Tentarei resolver dependencia de :', dependencies);
        var definition =
        {
            resolver: ['$q','$rootScope', function($q, $rootScope)
            {
                var deferred = $q.defer();

                require(dependencies, function()
                {
                    console.log('Resolvi a dependencia!!', dependencies);
                    $rootScope.$apply(function()
                    {
                        console.log('Cumpri');
                        deferred.resolve();
                    });
                });
                console.log('Prometi');
                return deferred.promise;
            }]
        }

        return definition;
    }
});