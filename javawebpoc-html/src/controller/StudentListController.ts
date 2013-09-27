/// <reference path='../reference.ts' />
/// <amd-reference path='../service/impl/StudentServieImpl' />

export module controller {

    export interface StudentListViewModel extends ng.IScope {
        students: any[];
        alerts: any[];
        refreshList: () => void;
    }

    export class StudentListController {

        private scope: StudentListViewModel;

        constructor($scope: StudentListViewModel,
            $timeout: ng.ITimeoutService) {
            this.scope = $scope;
            $scope.students = [{ 'name': 'Victor' }];

            console.log("StudentListController Runnin ", $scope);
        }
    }
}

console.log("Registrei a controller");

(<any> angular.module('javawebpoc-html')).lazy.controller("StudentListController",
    ["$scope", "$timeout", ($scope, $timeout) =>
        new controller.StudentListController($scope, $timeout)]);
