var myApp = angular.module('ticketservice', []);
var restEndPoint = "http://awseb-AWSEB-R8FLUO92OZ4H-89552945.us-east-2.elb.amazonaws.com:80"
myApp.controller('ticketsController', function ($scope, $http) {

    $scope.holdSeats = function () {
        $http({
                headers: {
                    "Access-Control-Allow-Origin": '*',
                    "Access-Control-Allow-Headers": 'Content-Type,X-Amz-Date,Authorization,X-Api-Key,X-Amz-Security-Token',
                    "Access-Control-Allow-Methods": 'GET, PUT'
                },
                method: "PUT",
                async: false,
                url: restEndPoint +
                    "/hold?numSeats=" + $scope.numSeats + "&customerEmail=" + $scope.email
            })
            .then(
                function mySuccess(response) {
                    $scope.seatHoldId = response.data.data.seatHoldId;
                    $scope.seatText = "";
                    if (response.data.data.seats.length > 1)
                        $scope.seatText = response.data.data.seats[0].seatId +
                    "-" + response.data.data.seats[response.data.data.seats.length - 1].seatId;
                    else
                        $scope.seatText = response.data.data.seats[0].seatId;
                    $scope.seatText = "Your Seat Numbers: " + $scope.seatText;
                    $scope.seatHoldIdText = "Confirmation Code: " + response.data.data.seatHoldId;
                    $scope.action = 2;
                },
                function myError(response) {
                    $scope.errorRsp = response.error.description;
                });
    }

    $scope.reserveSeats = function () {
        $http({
                headers: {
                    "Access-Control-Allow-Origin": '*',
                    "Access-Control-Allow-Headers": 'Content-Type,X-Amz-Date,Authorization,X-Api-Key,X-Amz-Security-Token',
                    "Access-Control-Allow-Methods": 'GET, PUT'
                },
                method: "PUT",
                async: false,
                url: restEndPoint +
                    "/reserve?seatHoldId=" + $scope.seatHoldId + "&customerEmail=" + $scope.email
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
