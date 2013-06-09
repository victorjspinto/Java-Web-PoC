///<reference path='../../../../definitionFiles/angular/angular.d.ts'/>
///<reference path='../../../entity/base/BaseEntity.ts'/>

module service.contract.base {

    export interface CrudServiceContract {

        save(item: entity.base.BaseEntity,
            successCallback: (data: entity.base.BaseEntity, status: number, headers: (headerName: string) => string, config: ng.IRequestConfig) => any,
            faultCallback: (data: any, status: number, headers: (headerName: string) => string, config: ng.IRequestConfig) => any);

        update(item: entity.base.BaseEntity,
            successCallback: (data: entity.base.BaseEntity, status: number, headers: (headerName: string) => string, config: ng.IRequestConfig) => any,
            faultCallback: (data: any, status: number, headers: (headerName: string) => string, config: ng.IRequestConfig) => any);

        remove(item: entity.base.BaseEntity,
            successCallback: (data: entity.base.BaseEntity, status: number, headers: (headerName: string) => string, config: ng.IRequestConfig) => any,
            faultCallback: (data: any, status: number, headers: (headerName: string) => string, config: ng.IRequestConfig) => any);

        findById(item: number,
            successCallback: (data: entity.base.BaseEntity, status: number, headers: (headerName: string) => string, config: ng.IRequestConfig) => any,
            faultCallback: (data: any, status: number, headers: (headerName: string) => string, config: ng.IRequestConfig) => any);

        all(successCallback: (data: entity.base.BaseEntity[], status: number, headers: (headerName: string) => string, config: ng.IRequestConfig) => any,
            faultCallback: (data: any, status: number, headers: (headerName: string) => string, config: ng.IRequestConfig) => any);

    }
}
