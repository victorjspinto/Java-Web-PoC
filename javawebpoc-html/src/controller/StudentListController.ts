///<reference path='../../definitionFiles/angular/angular.d.ts'/>
///<reference path='../entity/Student.ts'/>
///<reference path='../service/contract/StudentServiceContract.ts'/>

module controller {

    export interface StudentViewModel extends ng.IScope {
        students: entity.Student[];
        alerts: any[];
        refreshList: () => void;
    }

    export class StudentListController {

        private scope: StudentViewModel;
        private service: service.contract.StudentServiceContract;

        constructor($scope: StudentViewModel, $studentService: service.contract.StudentServiceContract) {
            this.scope = $scope;

            $scope.students = [];
            $scope.refreshList = this.refreshList;
            this.scope = $scope;
            this.service = $studentService;
            this.refreshList();
        }

        refreshList() {
            this.service.all((data) => { this.scope.students = data },
                () => {
                    var id: number = this.createAlert("Houve um erro ao consultar a lista de estudantes.", "error");
                    setTimeout(() => this.closeAlert(id), 6000);
                });
        }

        createAlert(message: String, alertType: String) {
            return this.scope.alerts.push({ message: message, alertType: alertType });
        }

        closeAlert(id: number) {
            this.scope.alerts.splice(id)
        }
    }
}