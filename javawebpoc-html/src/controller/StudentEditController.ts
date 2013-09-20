/// <reference path="../reference.ts">

import student = require("../entity/Student");
import uploadManager = require("../util/UploadManager");
import studentService = require("../service/contract/StudentServiceContract");

module controller {

    export interface StudentEditViewModel extends ng.IScope {
        student: student.entity.Student;
        photos: any[];
        upload: () => void;
    }

    export class StudentEditController {

        constructor(public $scope: StudentEditViewModel, $routeParams: any,
            public $studentService: studentService.service.contract.StudentServiceContract,
            public $uploadManager: uploadManager.util.UploadManager,
            public $rootScope: ng.IRootScopeService) {

            $scope.photos = [];
            $scope.upload = () => this.upload();

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