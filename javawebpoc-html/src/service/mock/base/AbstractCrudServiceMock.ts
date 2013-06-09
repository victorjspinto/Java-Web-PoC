///<reference path='../../contract/base/CrudServiceContract.ts'/>

module service.mock.base {

    export class AbstractCrudServiceMock implements contract.base.CrudServiceContract{
        
        private repo: any[] = [];

        save(value: any, successCallback: Function, faultCallback: Function) {
            this.repo.push(value);
            successCallback.call([]);
        }
    }

}

