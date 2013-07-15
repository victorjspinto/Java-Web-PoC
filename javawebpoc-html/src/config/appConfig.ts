///<reference path='../../definitionFiles/angular/angular.d.ts'/>
///<reference path='../entity/Student.ts'/>
///<reference path='../service/contract/StudentServiceContract.ts'/>

///<reference path='../service/impl/StudentServiceImpl.ts'/>

///<reference path='../service/mock/StudentServiceMock.ts'/>
///<reference path='../controller/StudentListController.ts'/>
///<reference path='../controller/StudentEditController.ts'/>

///<reference path='../util/UploadManager.ts'/>


var routeProviderFunction = ($routeProvider: ng.IRouteProvider) => {
    $routeProvider.when("/student", { templateUrl: "view/crud/student/StudentList.html", controller: controller.StudentListController });
    $routeProvider.when("/student/:studentId", { templateUrl: "view/crud/student/StudentEdit.html", controller: controller.StudentEditController })
}

angular.module("javawebpoc-html", ['ui.bootstrap'])

    .config(["$routeProvider", routeProviderFunction])
//.service("$userService", ($http: ng.IHttpService) => new service.impl.StudentServiceImpl($http))
    .service("$studentService", ($timeout) => new service.mock.StudentServiceMock($timeout))
    .directive("upload", ["$uploadManager", ($uploadManager: util.UploadManager) => uploadDirectiveFactory($uploadManager)])
    .factory("$uploadManager", ($rootScope) => new util.UploadManager($rootScope))
;
    

var uploadDirectiveFactory = ($uploadManager: util.UploadManager): ng.IDirective => {
    return {
        restrict: "A",
        link: function (scope, element, attrs) {
            (<any>(element)).fileupload(
                {
                    dataType: 'text',
                    add: function (e, data) {
                        $uploadManager.add(data);
                    },
                    progressall: function (e, data) {
                        var progress = data.loaded / data.total * 100;
                        $uploadManager.setProgress(progress);
                    },
                    done: function (e, data) {
                        $uploadManager.setProgress(0);
                    }
                }
            );
        }
    };
}

