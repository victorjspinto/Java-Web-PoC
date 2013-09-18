define([], function()
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
                dependencies: [
                    'controller/StudentListController',
                    'entity/VO/Telephone',
                    'entity/base/BaseEntity',
                    'entity/Student'
                ]
            }
        }
    };
});