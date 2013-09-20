///<reference path='../base/BaseEntity.ts'/>

import baseEntity = require('../base/BaseEntity');

export module entity.vo{
    export class Telephone extends baseEntity.entity.base.BaseEntity {
        constructor(public id:number, public ddi:number, public ddd:number, public telephoneNumber:number) {
            super(id);
        }
    }
}