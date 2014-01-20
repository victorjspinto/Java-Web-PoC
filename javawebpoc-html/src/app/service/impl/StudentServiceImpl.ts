///<reference path='../../reference.ts'/>

import abstractCrudServiceImpl = require("base/AbstractCrudServiceImpl");

export module service.impl {

    export class StudentServiceImpl extends abstractCrudServiceImpl.service.impl.base.AbstractCrudServiceImpl<entity.Student>
        implements batatinha.contract.StudentServiceContract {

		static $inject = ['$http'];

        constructor($http: ng.IHttpService) {
            super($http, "student");
        }
    }
}
