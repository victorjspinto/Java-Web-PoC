/// <reference path='../reference.ts' />

module controller{

	export interface LoginViewModel extends ng.IScope {
		username:String;
		password:String;
		login:()=>void;
	}

	export class LoginController {
		constructor(public $scope:LoginViewModel, public $loginService:service.impl.UserService){
			$scope.login = () => this.login();
		}

		login() {
			this.$loginService.login(this.$scope.username, this.$scope.password);
		}
	}
}