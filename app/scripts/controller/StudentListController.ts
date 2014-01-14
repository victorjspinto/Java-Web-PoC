/// <reference path='../reference.ts' />

module controller {
    export interface StudentListViewModel extends ng.IScope {
        students: Array<entity.Student>;
        alerts: any[];
        refreshList: () => void;
    }

    export class StudentListController {

        private $scope: StudentListViewModel;

        private $userService: service.contract.StudentServiceContract;

        constructor($scope: StudentListViewModel,
            $timeout: ng.ITimeoutService,
            $userService: service.contract.StudentServiceContract) {

            this.$scope = $scope;
            this.$userService = $userService;
        }
    }
}