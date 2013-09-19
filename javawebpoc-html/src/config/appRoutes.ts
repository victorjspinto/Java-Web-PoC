/// <reference path='../reference.ts' />

define([], function ()
{
    return {
        defaultRoutePath: '/',
        routes: {
            // '/': {
            //     templateUrl: '/views/home.html',
            //     dependencies: [
            //         'controllers/HomeViewController'
            //     ]
            // },
            '/student': {
                templateUrl: 'view/crud/student/StudentList.html',
                dependencies: [ 'controller/StudentListController' ]
            }
        }
    };
});