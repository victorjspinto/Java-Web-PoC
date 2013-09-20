///<reference path='../../reference.ts'/>

import student = require("../../entity/Student");
import telephone = require("../../entity/VO/Telephone");
import abstractCrudMock = require("base/AbstractCrudServiceMock");
import studentServiceContract = require("../contract/StudentServiceContract");

module service.mock {
    export class StudentServiceMock extends abstractCrudMock.base.AbstractCrudServiceMock<student.entity.Student>
            implements studentServiceContract.contract.StudentServiceContract {
        
        constructor($timeout: ng.ITimeoutService) {
            super($timeout);
            
            this.repo.push(new student.entity.Student(1, "Victor", [ new entity.vo.Telephone(1, 55,22,88311203), new entity.vo.Telephone(1, 55, 21, 36293591) ] ));
            this.repo.push(new student.entity.Student(2, "Vinicius", [ new entity.vo.Telephone(1, 55,22,88311203), new entity.vo.Telephone(1, 55, 21, 36293591) ]));
            this.repo.push(new student.entity.Student(3, "Test", [ new entity.vo.Telephone(1, 55,22,88311203), new entity.vo.Telephone(1, 55, 21, 36293591) ]));
        }
    }
}