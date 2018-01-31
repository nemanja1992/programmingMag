var magApp = angular.module("magApp", ['ngRoute']);

magApp.config(['$routeProvider', function ($routeProvider){
	$routeProvider.when('/',{
		templateUrl: '/static/app/html/partial/magazine.html'
	}).otherwise({
		redirectTo: '/'
	});
}]);