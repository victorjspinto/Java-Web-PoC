///<reference path='base/BaseEntity.ts'/>

module entity {
    export class Student extends base.BaseEntity {
        constructor(public id: number, public name: String) {
            super(id);
        }
    }
}