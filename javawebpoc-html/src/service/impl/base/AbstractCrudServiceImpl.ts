///<reference path='../../../entity/base/BaseEntity.ts'/>
///<reference path='../../contract/base/CrudServiceContract.ts'/>
///<reference path='../../../../definitionFiles/angular/angular.d.ts'/>

module service.impl.base {
    export class AbstractCrudServiceImpl implements service.contract.base.CrudServiceContract {

        private http: ng.IHttpService;
        private rootUrlContext: string;

        constructor($http: ng.IHttpService, urlContext: string) {
            this.http = $http;
            this.rootUrlContext = "rest/" + urlContext;
        }

        save(item: entity.base.BaseEntity, successCallback: (data: entity.base.BaseEntity, status: number, headers: (headerName: string) => string, config: ng.IRequestConfig) => any,
            faultCallback: (data: any, status: number, headers: (headerName: string) => string, config: ng.IRequestConfig) => any) {
            this.http.post(this.rootUrlContext + "/save", item)
                .success((callback: (data: any, status: number, headers: (headerName: string) => string, config: ng.IRequestConfig) => any) => successCallback.call(callback))
                .error((callback: (data: any, status: number, headers: (headerName: string) => string, config: ng.IRequestConfig) => any) => faultCallback.call(callback));

        }

        update(item: entity.base.BaseEntity, successCallback: (data: entity.base.BaseEntity, status: number, headers: (headerName: string) => string, config: ng.IRequestConfig) => any,
            faultCallback: (data: any, status: number, headers: (headerName: string) => string, config: ng.IRequestConfig) => any) {
            this.http.post(this.rootUrlContext + "/update", item)
                .success((callback: (data: any, status: number, headers: (headerName: string) => string, config: ng.IRequestConfig) => any) => successCallback.call(callback))
                .error((callback: (data: any, status: number, headers: (headerName: string) => string, config: ng.IRequestConfig) => any) => faultCallback.call(callback));
        }

        remove(item: entity.base.BaseEntity, successCallback: (data: entity.base.BaseEntity, status: number, headers: (headerName: string) => string, config: ng.IRequestConfig) => any,
            faultCallback: (data: any, status: number, headers: (headerName: string) => string, config: ng.IRequestConfig) => any) {
            this.http.post(this.rootUrlContext + "/remove", item)
                 .success((callback: (data: any, status: number, headers: (headerName: string) => string, config: ng.IRequestConfig) => any) => successCallback.call(callback))
                 .error((callback: (data: any, status: number, headers: (headerName: string) => string, config: ng.IRequestConfig) => any) => faultCallback.call(callback));
        }

        findById(id: number, successCallback: (data: entity.base.BaseEntity, status: number, headers: (headerName: string) => string, config: ng.IRequestConfig) => any,
            faultCallback: (data: any, status: number, headers: (headerName: string) => string, config: ng.IRequestConfig) => any) {
            this.http.get(this.rootUrlContext + "/find/" + id)
                .success((callback: (data: any, status: number, headers: (headerName: string) => string, config: ng.IRequestConfig) => any) => successCallback.call(callback))
                .error((callback: (data: any, status: number, headers: (headerName: string) => string, config: ng.IRequestConfig) => any) => faultCallback.call(callback));
        }

        all(successCallback: (data: entity.base.BaseEntity[], status: number, headers: (headerName: string) => string, config: ng.IRequestConfig) => any,
            faultCallback: (data: any, status: number, headers: (headerName: string) => string, config: ng.IRequestConfig) => any) {
            this.http.get(this.rootUrlContext + "/all")
                .success((callback: (data: any, status: number, headers: (headerName: string) => string, config: ng.IRequestConfig) => any) => successCallback.call(callback))
                .error((callback: (data: any, status: number, headers: (headerName: string) => string, config: ng.IRequestConfig) => any) => faultCallback.call(callback));
        }

    }
}