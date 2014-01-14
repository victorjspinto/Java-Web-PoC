///<reference path='../reference.ts'/>

module util {
    export class UploadManager {

        private _files: any[] = [];

        constructor(public $rootScope: ng.IRootScopeService) {
        }

        add(file: any) {
            this._files.push(file);
            this.$rootScope.$broadcast("fileAdded", file.files[0].name);
        }

        clear() {
            this._files = [];
        }

        files(): String[] {
            var filesName: String[] = [];
            this._files.forEach((file) => filesName.push(file.name));
            return filesName;
        }

        upload(): void {
            this._files.forEach((file) => file.submit());
        }

        setProgress(percentage: number) {
            this.$rootScope.$broadcast("uploadProgress", percentage);
        }

    }
}
