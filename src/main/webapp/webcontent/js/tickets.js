var myApp = angular.module('ticketservice', []);

myApp.controller('ticketsController', function ($scope, $http) {

    $scope.holdSeats = function () {
        var restEndPoint = "http://localhost:8090";
        $http({
                method: "PUT",
                async: false,
                url: restEndPoint +
                    "/hold?numSeats=" + $scope.numSeats + "&customerEmail=" + $scope.email
            })
            .then(
                function mySuccess(response) {
                    $scope.seatHoldId = response.data.data.seatHoldId;
                    $scope.seatHoldIdText = "Confirmation Code: " + response.data.data.seatHoldId;
                    $scope.action = 2;
                },
                function myError(response) {
                    $scope.errorRsp = response.error.description;
                });
    }

    $scope.reserveSeats = function () {
        var restEndPoint = "http://localhost:8090";
        $http({
                method: "PUT",
                async: false,
                url: restEndPoint +
                    "/hold?numSeats=" + $scope.numSeats + "&customerEmail=" + $scope.email
            })
            .then(
                function mySuccess(response) {
                    $scope.action = 3;
                },
                function myError(response) {
                    $scope.errorRsp = response.error.description;
                });
    }

    $scope.resetPage = function () {
        $scope.action = 1;
    }

});