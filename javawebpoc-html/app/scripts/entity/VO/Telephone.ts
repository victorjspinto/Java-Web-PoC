///<reference path='../../reference.ts'/>

module entity.vo{
    export interface Telephone extends entity.base.BaseEntity {
        ddi:number;
        ddd:number;
        telephoneNumber:number;
    }
}