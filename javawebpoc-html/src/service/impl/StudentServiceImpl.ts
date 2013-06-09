///<reference path='base/AbstractCrudServiceImpl.ts'/>
///<reference path='../contract/StudentServiceContract.ts'/>

module service.impl {

    export class StudentServiceImpl extends base.AbstractCrudServiceImpl implements contract.StudentServiceContract {
        constructor($http: ng.IHttpService) {
            super($http, "student");
        }
    }

}
