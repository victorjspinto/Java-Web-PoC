///<reference path='../../contract/base/CrudServiceContract.ts'/>
///<reference path='../../../../definitionFiles/angular/angular.d.ts'/>

module service.mock.base {

    export class AbstractCrudServiceMock<T extends entity.base.BaseEntity> implements contract.base.CrudServiceContract<T> {

        public repo: T[] = [];

        public timeoutService: ng.ITimeoutService;

        constructor($timeout: ng.ITimeoutService) {
            this.timeoutService = $timeout;
        }

        save(item: T, successCallback: (data: any, status: number, headers: (headerName: string) => string, config: ng.IRequestConfig) => any,
            faultCallback: (data: any, status: number, headers: (headerName: string) => string, config: ng.IRequestConfig) => any) {
        }

        update(item: T, successCallback: (data: any, status: number, headers: (headerName: string) => string, config: ng.IRequestConfig) => any,
            faultCallback: (data: any, status: number, headers: (headerName: string) => string, config: ng.IRequestConfig) => any) {
        }

        remove(item: T, successCallback: (data: any, status: number, headers: (headerName: string) => string, config: ng.IRequestConfig) => any,
            faultCallback: (data: any, status: number, headers: (headerName: string) => string, config: ng.IRequestConfig) => any) {
        }

        findById(id: number, successCallback: (data: T, status: number, headers: (headerName: string) => string, config: ng.IRequestConfig) => any,
            faultCallback: (data: any, status: number, headers: (headerName: string) => string, config: ng.IRequestConfig) => any) {
            
        }

        all(successCallback: (data: T[], status: number, headers: (headerName: string) => string, config: ng.IRequestConfig) => any,
            faultCallback: (data: any, status: number, headers: (headerName: string) => string, config: ng.IRequestConfig) => any) {

            this.timeoutService(() => faultCallback(this.repo, 200, null, null), 3000);
        }
    }
}

