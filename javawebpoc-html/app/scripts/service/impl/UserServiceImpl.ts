///<reference path='../../reference.ts'/>

module service.impl{
	export class UserService {

		constructor(private $http:ng.IHttpService, 
			private $window:ng.IWindowService, private $rootScope:ng.IRootScopeService) {

		}

		login(username:String, password:String) {
			var promise = this.$http.post("rest/login?username=" + username + "&password=" + password, null);
			promise.then( 
				(x) => {
					this.$window.sessionStorage.setItem("logged","true");
                    this.$rootScope.$broadcast("userLoggedIn");
					return x.data;
				},
				() => {
                    this.logout();
				}
			);
			return promise;
		}

		logout() {
            this.$window.sessionStorage.removeItem("logged");
            this.$rootScope.$broadcast("userLoggedOut");
		}

		isLogged(): boolean {
			return this.$window.sessionStorage.getItem("logged") == "true";
		}
	}
}