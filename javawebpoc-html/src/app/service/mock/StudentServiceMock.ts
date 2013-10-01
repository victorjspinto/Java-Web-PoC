///<reference path='../../reference.ts'/>

import abstractCrudMock = require("service/mock/base/AbstractCrudServiceMock");

export module service.mock {
    export class StudentServiceMock extends abstractCrudMock.service.mock.base.AbstractCrudServiceMock<entity.Student>
        implements batatinha.contract.StudentServiceContract {

        constructor($timeout: ng.ITimeoutService) {
            super($timeout);

            var asd: entity.vo.Telephone = { id: 1, ddd: 23, ddi: 55, telephoneNumber: 88311203 };
            this.repo.push({ id: 1, name: "Victor Jose", telephones: [asd] });

            //this.repo.push(new student.entity.Student(1, "Victor", [ new entity.vo.Telephone(1, 55,22,88311203), new entity.vo.Telephone(1, 55, 21, 36293591) ] ));
            //this.repo.push(new student.entity.Student(2, "Vinicius", [ new entity.vo.Telephone(1, 55,22,88311203), new entity.vo.Telephone(1, 55, 21, 36293591) ]));
            //this.repo.push(new student.entity.Student(3, "Test", [ new entity.vo.Telephone(1, 55,22,88311203), new entity.vo.Telephone(1, 55, 21, 36293591) ]));
        }
    }
}

(<any> angular.module("javawebpoc-html")).lazy.service("$userService", ["$timeout", ($timeout: ng.ITimeoutService) => new service.mock.StudentServiceMock($timeout)]);