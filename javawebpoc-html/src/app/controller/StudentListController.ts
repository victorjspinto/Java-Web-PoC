/// <reference path='../reference.ts' />
/// <amd-dependency path='../service/mock/StudentServiceMock' />

export module controller {

    export interface StudentListViewModel extends ng.IScope {
        students: Array<entity.Student>;
        alerts: any[];
        refreshList: () => void;
    }

    export class StudentListController {

        private scope: StudentListViewModel;

        private userService: batatinha.contract.StudentServiceContract;

        constructor($scope: StudentListViewModel,
            $timeout: ng.ITimeoutService,
            $userService: batatinha.contract.StudentServiceContract) {

            this.scope = $scope;
            this.userService = $userService;
                this.userService.all((x) => this.scope.students = x, () => { });
        }
    }
}

console.log("Registrei a controller");

(<any> angular.module('javawebpoc-html')).lazy.controller("StudentListController",
    ["$scope", "$timeout", "$userService", ($scope, $timeout, $userService) => new controller.StudentListController($scope, $timeout, $userService)]);
