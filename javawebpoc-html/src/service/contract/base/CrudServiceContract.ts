module service.contract.base{

    // Class
    export interface CrudServiceContract {

        save(item: any, successCallback: Function, faultCallback: Function);

    }
}
