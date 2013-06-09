///<reference path='../../contract/base/CrudServiceContract.ts'/>
///<reference path='../../../../definitionFiles/angular/angular.d.ts'/>

module service.impl.base {
    export class AbstractCrudServiceImpl implements service.contract.base.CrudServiceContract{

        private http: ng.IHttpService;

        constructor(http:ng.IHttpService) {
            this.http = http;
        }

        save(value: any, successCallback: Function, faultCallback: Function) {
            this.http.get("rest/student/save")
                .success(() => successCallback.call([]))
                .error(() => faultCallback.call([]));
        }

    }
}