///<reference path='../../definitionFiles/angular/angular.d.ts'/>
///<reference path='../entity/Student.ts'/>
///<reference path='../service/contract/StudentServiceContract.ts'/>

module controller {

    export interface StudentViewModel extends ng.IScope {
        students: entity.Student[];
        refreshList: () => void;
    }

    export class StudentListController {
        constructor($scope: StudentViewModel, $studentService: service.contract.StudentServiceContract) {
            $scope.students = [];
            $scope.students.push(new entity.Student(1, "Victor"));
            $scope.students.push(new entity.Student(2, "Vinicius"));
            $scope.students.push(new entity.Student(3, "Test"));
        }
    }

}