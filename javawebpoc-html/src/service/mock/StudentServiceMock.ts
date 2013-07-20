///<reference path='../contract/StudentServiceContract.ts'/>
///<reference path='base/AbstractCrudServiceMock.ts'/>
///<reference path='../../entity/Student.ts'/>
///<reference path='../../entity/VO/Telephone.ts'/>

module service.mock {
    export class StudentServiceMock extends base.AbstractCrudServiceMock<entity.Student> implements contract.StudentServiceContract {
        constructor($timeout: ng.ITimeoutService) {
            super($timeout);
            
            this.repo.push(new entity.Student(1, "Victor", [ new entity.vo.Telephone(1, 55,22,88311203), new entity.vo.Telephone(1, 55, 21, 36293591) ] ));
            this.repo.push(new entity.Student(2, "Vinicius", [ new entity.vo.Telephone(1, 55,22,88311203), new entity.vo.Telephone(1, 55, 21, 36293591) ]));
            this.repo.push(new entity.Student(3, "Test", [ new entity.vo.Telephone(1, 55,22,88311203), new entity.vo.Telephone(1, 55, 21, 36293591) ]));
        }
    }
}