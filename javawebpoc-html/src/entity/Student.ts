///<reference path='base/BaseEntity.ts'/>
///<reference path='VO/Telephone.ts'/>

module entity {
    export class Student extends base.BaseEntity {
        constructor(public id: number, public name: String, public telephones: entity.vo.Telephone[]) {
            super(id);
        }
    }
}