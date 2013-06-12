///<reference path='../../contract/base/CrudServiceContract.ts'/>
///<reference path='../../../../definitionFiles/angular/angular.d.ts'/>

module service.mock.base {

    export class AbstractCrudServiceMock implements contract.base.CrudServiceContract {

        public repo: any[] = [];

        public timeoutService: ng.ITimeoutService;

        constructor($timeout: ng.ITimeoutService) {
            this.timeoutService = $timeout;
        }

        save(item: entity.base.BaseEntity, successCallback: (data: any, status: number, headers: (headerName: string) => string, config: ng.IRequestConfig) => any,
            faultCallback: (data: any, status: number, headers: (headerName: string) => string, config: ng.IRequestConfig) => any) {
        }

        update(item: entity.base.BaseEntity, successCallback: (data: any, status: number, headers: (headerName: string) => string, config: ng.IRequestConfig) => any,
            faultCallback: (data: any, status: number, headers: (headerName: string) => string, config: ng.IRequestConfig) => any) {
        }

        remove(item: entity.base.BaseEntity, successCallback: (data: any, status: number, headers: (headerName: string) => string, config: ng.IRequestConfig) => any,
            faultCallback: (data: any, status: number, headers: (headerName: string) => string, config: ng.IRequestConfig) => any) {
        }

        findById(id: number, successCallback: (data: any, status: number, headers: (headerName: string) => string, config: ng.IRequestConfig) => any,
            faultCallback: (data: any, status: number, headers: (headerName: string) => string, config: ng.IRequestConfig) => any) {
            
        }

        all(successCallback: (data: any, status: number, headers: (headerName: string) => string, config: ng.IRequestConfig) => any,
            faultCallback: (data: any, status: number, headers: (headerName: string) => string, config: ng.IRequestConfig) => any) {

            this.timeoutService(() => faultCallback(this.repo, 200, null, null), 3000);
        }
    }
}

