/// <reference path='../reference.ts' />

module controller {

    export interface AccessViewModel extends ng.IScope {
        isLogged:Boolean;
    }

    export class AccessController {
        constructor(private $scope:AccessViewModel, private $userService:service.impl.UserService) {
            $scope.isLogged = $userService.isLogged();

            $scope.$on("userLoggedIn", () => $scope.isLogged = true);
            $scope.$on("userLoggedOut", () => $scope.isLogged = false);
        }
    }
}