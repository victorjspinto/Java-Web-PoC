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
        private timeoutService:ng.ITimeoutService;

        constructor($scope: StudentViewModel, 
            $studentService: service.contract.StudentServiceContract,
            $timeout:ng.ITimeoutService) {
            this.scope = $scope;
            this.timeoutService = $timeout;

            $scope.students = [];
            $scope.alerts = [];
            $scope.refreshList = this.refreshList;
            this.scope = $scope;
            this.service = $studentService;
            this.refreshList();
        }

        refreshList() {
            this.service.all((data) => { this.scope.students = data },
                () => {
                    var id: number = this.createAlert("Houve um erro ao consultar a lista de estudantes.", "error");
                    this.timeoutService(() => this.closeAlert(id), 6000);
                });
        }

        createAlert(message: String, alertType: String) {
            return this.scope.alerts.push({ message: message, type: alertType });
        }

        closeAlert(id: number) {

        }
    }
}