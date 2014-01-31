///<reference path='../../reference.ts'/>

module service.impl{
	export class UserService {

		constructor(private $http:ng.IHttpService, 
			private $window:ng.IWindowService) {

		}

		login(username:String, password:String) {
			var promise = this.$http.post("rest/login?username=" + username + "&password=" + password, null);
			promise.then( 
				(x) => {
					this.$window.sessionStorage.setItem("logged","true");
					return x.data;
				},
				(x) => {
					this.$window.sessionStorage.removeItem("logged");
				}
			);
			return promise;
		}

		logout() {
			this.$window.sessionStorage.removeItem("logged");
		}

		isLogged(): boolean {
			return this.$window.sessionStorage.getItem("logged") == "true";
		}
	}
}