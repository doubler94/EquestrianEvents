(function () {
    var app = angular.module('myApp', ['ngRoute']);

    app.controller('Controller', ['$scope', '$http', function ($scope, $http) {
        $scope.getMyUser = function (fileName) {
            $http.get(fileName).success(function (data) {
                $scope.users = data;
                console.log(data);
            });
            return true;
        };

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
        };
    }]); // Controller

    app.config(['$httpProvider', function ($httpProvider) {
        $httpProvider.defaults.withCredentials = false;
        delete $httpProvider.defaults.headers.common["X-Requested-With"];
    }]); // httpConfig

    app.config(['$routeProvider',
        function ($routeProvider) {
            $routeProvider
                .when('/contributors', {
                    templateUrl: 'lists/contributors.html',
                    controller: 'Controller'
                }, null)
                .when('/contributorsTable', {
                    templateUrl: 'lists/contributors_table.html',
                    controller: 'Controller'
                }, null)
                .when('/repositories', {
                    templateUrl: 'lists/repositories.html',
                    controller: 'Controller'
                }, null)
                .when('/repositoriesTable', {
                    templateUrl: 'lists/repositories_table.html',
                    controller: 'Controller'
                });
        }]); // RouteConfig
})();
