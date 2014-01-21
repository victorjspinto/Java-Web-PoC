/// <reference path='../reference.ts' />

module controller {
    export interface StudentListViewModel extends ng.IScope {
        students: Array<entity.Student>;
        alerts: any[];
        refreshList: () => void;
    }

    export class StudentListController {

        private $scope: StudentListViewModel;

        private $studentService: service.contract.StudentServiceContract;

        constructor($scope: StudentListViewModel,
            $studentService: service.contract.StudentServiceContract) {

            this.$scope = $scope;
            this.$studentService = $studentService;
        }
    }
}