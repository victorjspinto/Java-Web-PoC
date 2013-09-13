///<reference path='base/AbstractCrudServiceImpl.ts'/>
///<reference path='../contract/StudentServiceContract.ts'/>

module service.impl {

    export class StudentServiceImpl extends base.AbstractCrudServiceImpl<entity.Student> implements contract.StudentServiceContract {

		static $inject = ['$http'];

        constructor($http: ng.IHttpService) {
            super($http, "student");
        }
    }
}
