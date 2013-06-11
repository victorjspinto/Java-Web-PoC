///<reference path='base/CrudServiceContract.ts'/>
///<reference path='../../entity/Student.ts'/>
module service.contract {

    export interface StudentServiceContract extends service.contract.base.CrudServiceContract {

        save(item: entity.Student,
            successCallback: (data: entity.Student, status: number, headers: (headerName: string) => string, config: ng.IRequestConfig) => any,
            faultCallback: (data: any, status: number, headers: (headerName: string) => string, config: ng.IRequestConfig) => any);

        update(item: entity.Student,
            successCallback: (data: entity.Student, status: number, headers: (headerName: string) => string, config: ng.IRequestConfig) => any,
            faultCallback: (data: any, status: number, headers: (headerName: string) => string, config: ng.IRequestConfig) => any);

        remove(item: entity.Student,
            successCallback: (data: entity.Student, status: number, headers: (headerName: string) => string, config: ng.IRequestConfig) => any,
            faultCallback: (data: any, status: number, headers: (headerName: string) => string, config: ng.IRequestConfig) => any);

        findById(item: number,
            successCallback: (data: entity.Student, status: number, headers: (headerName: string) => string, config: ng.IRequestConfig) => any,
            faultCallback: (data: any, status: number, headers: (headerName: string) => string, config: ng.IRequestConfig) => any);

        all(successCallback: (data: entity.Student[], status: number, headers: (headerName: string) => string, config: ng.IRequestConfig) => any,
            faultCallback: (data: any, status: number, headers: (headerName: string) => string, config: ng.IRequestConfig) => any);
    }

}
