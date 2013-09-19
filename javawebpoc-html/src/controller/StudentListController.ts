/// <reference path='../reference.ts' />

module controller {

    export interface StudentEditViewModel extends ng.IScope {
        students: any[];
        alerts: any[];
        refreshList: () => void;
    }

    export class StudentListController {

        private scope: StudentEditViewModel;

        constructor($scope: StudentEditViewModel,
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
