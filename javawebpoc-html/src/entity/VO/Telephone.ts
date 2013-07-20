///<reference path='../base/BaseEntity.ts'/>

module entity.vo{
    export class Telephone extends entity.base.BaseEntity {
        constructor(public id:number, public ddi:number, public ddd:number, public telephoneNumber:number) {
            super(id);
        }
    }
}