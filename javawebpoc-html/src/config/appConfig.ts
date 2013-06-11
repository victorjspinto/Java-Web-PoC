///<reference path='../../definitionFiles/angular/angular.d.ts'/>
///<reference path='../entity/Student.ts'/>
///<reference path='../service/contract/StudentServiceContract.ts'/>

///<reference path='../service/impl/StudentServiceImpl.ts'/>

///<reference path='../service/mock/StudentServiceMock.ts'/>
///<reference path='../controller/StudentListController.ts'/>

var routeProviderFunction = ($routeProvider: ng.IRouteProviderProvider) =>
{
    $routeProvider.when("/student", { templateUrl: "view/crud/student/StudentList.html", controller: controller.StudentListController });
}

angular.module("javawebpoc-html", [])

    .config(["$routeProvider", routeProviderFunction])

//    .service("$userService", ($http: ng.IHttpService) => new service.impl.StudentServiceImpl($http))

    .service("$studentService", () => new service.mock.StudentServiceMock());

    ;

