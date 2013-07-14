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
            var target: entity.base.BaseEntity;
            this.repo.forEach((x) => { if (x.id == id) target = x });
            this.timeoutService(() => faultCallback(target, 200, null, null), 3000);
        }

        all(successCallback: (data: T[], status: number, headers: (headerName: string) => string, config: ng.IRequestConfig) => any,
            faultCallback: (data: any, status: number, headers: (headerName: string) => string, config: ng.IRequestConfig) => any) {

            this.timeoutService(() => successCallback(this.repo, 200, null, null), 3000);
        }
    }
}

