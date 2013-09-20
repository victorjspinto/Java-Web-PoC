///<reference path='../../reference.ts'/>

import student = require("../../entity/Student");
import crudService = require("base/CrudServiceContract");

module service.contract {

    export interface StudentServiceContract extends crudService.service.contract.base.CrudServiceContract<student.entity.Student> {

    }

}
