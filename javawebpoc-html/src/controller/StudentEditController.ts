///<reference path='../../definitionFiles/angular/angular.d.ts'/>
///<reference path='../entity/Student.ts'/>
///<reference path='../service/contract/StudentServiceContract.ts'/>
///<reference path='../util/UploadManager.ts'/>

module controller {

    export interface StudentEditViewModel extends ng.IScope {
        student: entity.Student;
        photos: any[];
    }

    export class StudentEditController {

        constructor(public $scope: StudentEditViewModel, $routeParams: any,
            public $studentService: service.contract.StudentServiceContract,
            public $uploadManager: util.UploadManager,
            public $rootScope: ng.IRootScopeService) {

            $scope.photos = [];

            $studentService.findById($routeParams.studentId, (data) => this.$scope.student = data, () => null);

            $rootScope.$on("fileAdded", (e, name) => this.onFileAdded(name));
            $rootScope.$on("uploadProgress", (e, percentage: number) => this.uploadProgressCallback(percentage));
        }

        uploadProgressCallback(percentage: number) {

        }

        onFileAdded(name) {
            this.$scope.photos.push(name);
            this.$scope.$apply();
        }

        upload() {
            this.$uploadManager.upload();
        }
    }
}