///<reference path='../../definitionFiles/angular/angular.d.ts'/>
///<reference path='../entity/Student.ts'/>
///<reference path='../service/contract/StudentServiceContract.ts'/>

module controller {
    export class StudentEditController {

        private student: entity.Student;

        constructor($scope: ng.IScope, $routParams: any, public $service: service.contract.StudentServiceContract) {
            $routParams.studentId;
            $service.findById($routParams.studentId, (data) => this.student = data, () => null);

        }
    }
}