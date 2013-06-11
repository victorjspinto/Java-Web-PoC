///<reference path='../contract/StudentServiceContract.ts'/>
///<reference path='base/AbstractCrudServiceMock.ts'/>
///<reference path='../../../entity/Student.ts'/>

module service.mock {
    export class StudentServiceMock extends base.AbstractCrudServiceMock implements contract.StudentServiceContract {
        constructor($timeout:ng.ITimeoutService) {
            super($timeout);
            this.repo.push(new entity.Student(1, "Victor"));
            this.repo.push(new entity.Student(2, "Vinicius"));
            this.repo.push(new entity.Student(3, "Test"));
        }
    }
}