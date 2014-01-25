///<reference path='../../../reference.ts'/>

module service.contract.base {
    export interface CrudServiceContract<T extends entity.base.BaseEntity> {

        save(item: T,
            successCallback: (data: any, status: number, headers: (headerName: string) => string, config: ng.IRequestConfig) => any,
            faultCallback: (data: any, status: number, headers: (headerName: string) => string, config: ng.IRequestConfig) => any);

        update(item: T,
            successCallback: (data: any, status: number, headers: (headerName: string) => string, config: ng.IRequestConfig) => any,
            faultCallback: (data: any, status: number, headers: (headerName: string) => string, config: ng.IRequestConfig) => any);

        remove(item: T,
            successCallback: (data: any, status: number, headers: (headerName: string) => string, config: ng.IRequestConfig) => any,
            faultCallback: (data: any, status: number, headers: (headerName: string) => string, config: ng.IRequestConfig) => any);

        findById(item: number,
            successCallback: (data: T, status: number, headers: (headerName: string) => string, config: ng.IRequestConfig) => any,
            faultCallback: (data: any, status: number, headers: (headerName: string) => string, config: ng.IRequestConfig) => any);

        all(successCallback: (data: T[], status: number, headers: (headerName: string) => string, config: ng.IRequestConfig) => any,
            faultCallback: (data: any, status: number, headers: (headerName: string) => string, config: ng.IRequestConfig) => any);

    }
}
