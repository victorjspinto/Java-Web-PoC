///<reference path='../../definitionFiles/angular/angular.d.ts'/>
///<reference path='../entity/Student.ts'/>
///<reference path='../service/contract/StudentServiceContract.ts'/>

///<reference path='../service/impl/StudentServiceImpl.ts'/>

///<reference path='../service/mock/StudentServiceMock.ts'/>
///<reference path='../controller/StudentListController.ts'/>
///<reference path='../controller/StudentEditController.ts'/>

///<reference path='../util/UploadManager.ts'/>

'use strict';

define(['config/appRoutes','util/DependencyResolver'], function(config, dependencyResolverFor)
{
    var app = angular.module('javawebpoc-html', []);

    app.config(
    [
        '$routeProvider',
        '$locationProvider',
        '$controllerProvider',
        '$compileProvider',
        '$filterProvider',
        '$provide',

        function($routeProvider, $locationProvider, $controllerProvider, $compileProvider, $filterProvider, $provide)
        {
            app.lazy =
            {
                controller : $controllerProvider.register,
                directive  : $compileProvider.directive,
                filter     : $filterProvider.register,
                factory    : $provide.factory,
                service    : $provide.service
            };

            $locationProvider.html5Mode(true);

            if(config.routes !== undefined)
            {
                angular.forEach(config.routes, function(route, path)
                {
                    $routeProvider.when(path, {templateUrl:route.templateUrl, resolve:dependencyResolverFor(route.dependencies)});
                });
            }

            if(config.defaultRoutePaths !== undefined)
            {
                $routeProvider.otherwise({redirectTo:config.defaultRoutePaths});
            }
        }
    ]);

   return app;
});


// var routeProviderFunction = ($routeProvider: ng.IRouteProvider) => {
//     $routeProvider.when("/student", { templateUrl: "view/crud/student/StudentList.html", controller: controller.StudentListController });
//     $routeProvider.when("/student/:studentId", { templateUrl: "view/crud/student/StudentEdit.html", controller: controller.StudentEditController })
// }

// angular.module("javawebpoc-html", ['ui.bootstrap'])

//     .config(["$routeProvider", routeProviderFunction])
// //.service("$userService", ($http: ng.IHttpService) => new service.impl.StudentServiceImpl($http))
//     .service("$studentService", ($timeout) => new service.mock.StudentServiceMock($timeout))
//     .factory("$uploadManager", ($rootScope) => new util.UploadManager($rootScope))
//     .directive("upload", ["$uploadManager", ($uploadManager: util.UploadManager) => uploadDirectiveFactory($uploadManager)])
//     .directive("telephone", () => telephoneDirectiveFactory())
//     .directive("crudform", () => crudTemplate())
//     ;

// ;

var telephoneDirectiveFactory = ():ng.IDirective => {
    return {
        scope:{
            data:"="
        },
        replace: true, //substitui a tag do DOM
        restrict: "E", // A- attribure E-Element C-Class css M-on coment directive
        template:
            "<div> " +
                "<div><b><h6>Telefone</h6></b>" +
                    "<div>DDI: {{data.ddi}}</div>" +
                    "<div>DDD: {{data.ddd}}</div>" +
                    "<div>Telefone: {{data.telephoneNumber}}</div>" +
                "</div>" +
            "</div>"
    }
};

var crudTemplate = ():ng.IDirective => {
    return {
        restrict:"E",
        replace:true,
        transclude:true,
        template:
            "<div class='container-fluid'>" +
                "<div class='row-fuild' ng-transclude></div>" +
                "<div class='row-fluid'>" +
                    "<div class='span12'>" +
                        "<button class='btn'>Salvar</button>" +
                        "<button class='btn'>Cancelar</button>" +
                    "</div>" +
                "</div>" +
            "</div>"
    }
}


var uploadDirectiveFactory = ($uploadManager: util.UploadManager): ng.IDirective => {
    return {
        restrict: "A",
        link: function (scope, element, attrs) {
            (<any>(element)).fileupload(
                {
                    dataType: 'text',
                    disableImageResize : false,
                    previewCrop: true,
                    add: function (e, data) {
                        $uploadManager.add(data);
                    },
                    progressall: function (e, data) {
                        var progress = data.loaded / data.total * 100;
                        $uploadManager.setProgress(progress);
                    },
                    done: function (e, data) {
                        $uploadManager.setProgress(0);
                    },
                    process: function (data) {
                        return console.log(data);
                    }
                }
            );
        }
    };
}

