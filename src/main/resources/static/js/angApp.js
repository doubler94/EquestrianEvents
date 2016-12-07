(function () {
    var app = angular.module('myApp', ['ngRoute']);

    app.controller('Controller', ['$scope', '$http', function ($scope, $http) {
        $scope.getMyRepo = function (path) {
            $http.get(path)
                .success(function (data, status, headers, config) {
                    var json = JSON.stringify(data);
                    $scope.repositiories = data;
                    console.log(json);
                })
                .error(function (error, status, headers, config) {
                    console.log(status);
                    console.log("Error occured");
                });
            return true;
        }; // funkcja do pobrania danych
    }]); // Controller

    app.config(['$httpProvider', function ($httpProvider) {
        $httpProvider.defaults.withCredentials = false;
        delete $httpProvider.defaults.headers.common["X-Requested-With"];
    }]); // httpConfig

    // app.config(function ($stateProvider, $urlRouterProvider) {

    //     $stateProvider
    //         .state('addHorse', {
    //             url:'/addHorse',
    //             templateUrl: '/page/lists/addHorse',
    //             controller: 'Controller'
    //         })
    //         .state('repositories', {
    //             url:'/repositories',
    //             templateUrl:'/page/lists/repositories.html',
    //             controller: 'HotelCtrl'
    //         });
    // });

    app.config(['$routeProvider',
        function ($routeProvider) {
            $routeProvider
                .when('/repositories', {
                    templateUrl: '/page/lists/repositories.html',
                    controller: 'Controller'
                }, null)
                .when('/addHorses', {
                    templateUrl: '/page/lists/addHorse.html',
                    controller: 'Controller'
                })
                .otherwise({
                    redirectTo: '/rider/horseDelete'
                });
        }]); // RouteConfig

})();
