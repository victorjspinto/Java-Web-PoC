///<reference path='../reference.ts' />

module entity {
    export interface Student extends entity.base.BaseEntity {
        name: String;
        telephones: Array<entity.vo.Telephone>;
    }
}