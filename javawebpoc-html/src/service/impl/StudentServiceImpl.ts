///<reference path='../../reference.ts'/>

import student = require("../../entity/Student");
import abstractCrudServiceImpl = require("base/AbstractCrudServiceImpl");
import studentServiceContract = require("../contract/StudentServiceContract");

module service.impl {

    export class StudentServiceImpl extends abstractCrudServiceImpl.base.AbstractCrudServiceImpl<student.entity.Student>
        implements studentServiceContract.contract.StudentServiceContract {

		static $inject = ['$http'];

        constructor($http: ng.IHttpService) {
            super($http, "student");
        }
    }
}
