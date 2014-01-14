///<reference path='../reference.ts' />

var app = angular.module('javawebpoc-html', []);

var telephoneDirectiveFactory = (): ng.IDirective => {
    return {
        scope: {
            data: "="
        },
        replace: true, //substitui a tag do DOM
        restrict: "E", // A- attribure E-Element C-Class css M-on coment directive
        template:
        "<div> " +
        "<div><b><h6>Telefone</h6></b>" +
        "<div>DDI: {{data.ddi}}</div>" +
        "<div>DDD: {{data.ddd}}</div>" +
        "<div>Telefone: {{data.telephoneNumber}}</div>" +
        "</div>" +
        "</div>"
    }
};

var crudTemplate = (): ng.IDirective => {
    return {
        restrict: "E",
        replace: true,
        transclude: true,
        template:
        "<div class='container-fluid'>" +
        "<div class='row-fuild' ng-transclude></div>" +
        "<div class='row-fluid'>" +
        "<div class='span12'>" +
        "<button class='btn'>Salvar</button>" +
        "<button class='btn'>Cancelar</button>" +
        "</div>" +
        "</div>" +
        "</div>"
    }
}


//var uploadDirectiveFactory = ($uploadManager: util.UploadManager): ng.IDirective => {
//    return {
//        restrict: "A",
//        link: function (scope, element, attrs) {
//            (<any>(element)).fileupload(
//                {
//                    dataType: 'text',
//                    disableImageResize: false,
//                    previewCrop: true,
//                    add: function (e, data) {
//                        $uploadManager.add(data);
//                    },
//                    progressall: function (e, data) {
//                        var progress = data.loaded / data.total * 100;
//                        $uploadManager.setProgress(progress);
//                    },
//                    done: function (e, data) {
//                        $uploadManager.setProgress(0);
//                    },
//                    process: function (data) {
//                        return console.log(data);
//                    }
//                }
//                );
//        }
//    };
//}
