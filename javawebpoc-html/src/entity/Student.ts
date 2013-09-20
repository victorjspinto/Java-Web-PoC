///<reference path='base/BaseEntity.ts'/>
///<reference path='VO/Telephone.ts'/>

import baseEntity = require('base/BaseEntity');
import telephone = require('VO/Telephone');


export module entity {
    export class Student extends baseEntity.entity.base.BaseEntity {
        constructor(public id: number, public name: String, public telephones: telephone.entity.vo.Telephone[]) {
            super(id);
            console.log('Construindo estudante');
        }
    }
}