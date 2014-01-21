/// <reference path='../reference.ts' />

module controller {
    export interface StudentEditViewModel extends ng.IScope {
        student: entity.Student;
        photos: any[];
        upload: () => void;
    }

    export class StudentEditController {

        constructor(public $scope: StudentEditViewModel, $routeParams: any,
            public $studentService: service.contract.StudentServiceContract
            ) {

        }
    }
}