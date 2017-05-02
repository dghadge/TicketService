var myApp = angular.module('appstatus', []);

var appStatus = {};
var dbStatus = {};
var serverStatus = {};
var storageStatus = {};
var dashboardURL = "https://appmonitor.cbp.dhs.gov/controller/#/location=CDASHBOARD_DETAIL&timeRange=last_15_minutes.BEFORE_NOW.-1.-1.15&mode=MODE_DASHBOARD&dashboard=";

myApp.controller('cspdController', function ($scope, $http, restService) {

	$scope.appStatus = {};
	$scope.dbStatus = {};
	$scope.storageStatus = {};
	$scope.serverStatus = {};

	$scope.appStatusArray = [
		{
			name: "L-ACE",
			appId: "7",
			availabilityUrl: dashboardURL + "30",
			databaseUrl: dashboardURL + "32",
			storageUrl: dashboardURL + "33",
			serverUrl: dashboardURL + "34",
			returnStatus: restService.getStatuses($scope, $http, 7)
        },
		{
			name: "ITDS",
			appId: "12",
			availabilityUrl: dashboardURL + "30",
			databaseUrl: dashboardURL + "32",
			storageUrl: dashboardURL + "33",
			serverUrl: dashboardURL + "34",
			returnStatus: restService.getStatuses($scope, $http, 12)
        },
		{
			name: "ES",
			appId: "14",
			availabilityUrl: dashboardURL + "30",
			databaseUrl: dashboardURL + "32",
			storageUrl: dashboardURL + "33",
			serverUrl: dashboardURL + "34",
			returnStatus: restService.getStatuses($scope, $http, 14)
        },
		{
			name: "ES-INTRFC",
			appId: "29",
			availabilityUrl: dashboardURL + "30",
			databaseUrl: dashboardURL + "32",
			storageUrl: dashboardURL + "33",
			serverUrl: dashboardURL + "34",
			returnStatus: restService.getStatuses($scope, $http, 29)
        },
		{
			name: "SE",
			appId: "40",
			availabilityUrl: dashboardURL + "30",
			databaseUrl: dashboardURL + "32",
			storageUrl: dashboardURL + "33",
			serverUrl: dashboardURL + "34",
			returnStatus: restService.getStatuses($scope, $http, 40)
        },
		{
			name: "AES",
			appId: "35",
			availabilityUrl: dashboardURL + "30",
			databaseUrl: dashboardURL + "32",
			storageUrl: dashboardURL + "33",
			serverUrl: dashboardURL + "34",
			returnStatus: restService.getStatuses($scope, $http, 35)
        },
		{
			name: "AESDirect",
			appId: "42",
			availabilityUrl: dashboardURL + "30",
			databaseUrl: dashboardURL + "32",
			storageUrl: dashboardURL + "33",
			serverUrl: dashboardURL + "34",
			returnStatus: restService.getStatuses($scope, $http, 42)
        },
		{
			name: "QMD",
			appId: "13",
			availabilityUrl: dashboardURL + "30",
			databaseUrl: dashboardURL + "32",
			storageUrl: dashboardURL + "33",
			serverUrl: dashboardURL + "34",
			returnStatus: restService.getStatuses($scope, $http, 13)
        },
		{
			name: "ESV",
			appId: "10",
			availabilityUrl: dashboardURL + "30",
			databaseUrl: dashboardURL + "32",
			storageUrl: dashboardURL + "33",
			serverUrl: dashboardURL + "34",
			returnStatus: restService.getStatuses($scope, $http, 10)
        },
		{
			name: "ABI",
			appId: "20",
			availabilityUrl: dashboardURL + "30",
			databaseUrl: dashboardURL + "32",
			storageUrl: dashboardURL + "33",
			serverUrl: dashboardURL + "34",
			returnStatus: restService.getStatuses($scope, $http, 20)
        },
		{
			name: "Collections",
			appId: "86",
			availabilityUrl: dashboardURL + "30",
			databaseUrl: dashboardURL + "32",
			storageUrl: dashboardURL + "33",
			serverUrl: dashboardURL + "34",
			returnStatus: restService.getStatuses($scope, $http, 86)
        },
		{
			name: "RECON",
			appId: "191",
			availabilityUrl: dashboardURL + "30",
			databaseUrl: dashboardURL + "32",
			storageUrl: dashboardURL + "33",
			serverUrl: dashboardURL + "34",
			returnStatus: restService.getStatuses($scope, $http, 191)
        },
		{
			name: "PROTESTS",
			appId: "204",
			availabilityUrl: dashboardURL + "30",
			databaseUrl: dashboardURL + "32",
			storageUrl: dashboardURL + "33",
			serverUrl: dashboardURL + "34",
			returnStatus: restService.getStatuses($scope, $http, 204)
        },
		{
			name: "ITDS_APTL",
			appId: "44",
			availabilityUrl: dashboardURL + "30",
			databaseUrl: dashboardURL + "32",
			storageUrl: dashboardURL + "33",
			serverUrl: dashboardURL + "34",
			returnStatus: restService.getStatuses($scope, $http, 44)
        }
    ]
});

myApp.controller('taspdController', function ($scope, $http, restService) {

	$scope.appStatus = {};
	$scope.dbStatus = {};
	$scope.storageStatus = {};
	$scope.serverStatus = {};

	$scope.appStatusArray = [
		{
			name: "VesselRisk",
			appId: "120",
			availabilityUrl: dashboardURL + "30",
			databaseUrl: dashboardURL + "32",
			storageUrl: dashboardURL + "33",
			serverUrl: dashboardURL + "34",
			returnStatus: restService.getStatuses($scope, $http, 120)
        },
		{
			name: "UPAX-IDTY-VRFN",
			appId: "132",
			availabilityUrl: dashboardURL + "30",
			databaseUrl: dashboardURL + "32",
			storageUrl: dashboardURL + "33",
			serverUrl: dashboardURL + "34",
			returnStatus: restService.getStatuses($scope, $http, 132)
        },
		{
			name: "IMPORT-CARGO",
			appId: "123",
			availabilityUrl: dashboardURL + "30",
			databaseUrl: dashboardURL + "32",
			storageUrl: dashboardURL + "33",
			serverUrl: dashboardURL + "34",
			returnStatus: restService.getStatuses($scope, $http, 123)
        },
		{
			name: "PRIDE2",
			appId: "148",
			availabilityUrl: dashboardURL + "30",
			databaseUrl: dashboardURL + "32",
			storageUrl: dashboardURL + "33",
			serverUrl: dashboardURL + "34",
			returnStatus: restService.getStatuses($scope, $http, 148)
        }
    ]
});

myApp.controller('bemsdController', function ($scope, $http, restService) {

	$scope.appStatus = {};
	$scope.dbStatus = {};
	$scope.storageStatus = {};
	$scope.serverStatus = {};

	$scope.appStatusArray = [
		{
			name: "VesselRisk",
			appId: "120",
			availabilityUrl: dashboardURL + "30",
			databaseUrl: dashboardURL + "32",
			storageUrl: dashboardURL + "33",
			serverUrl: dashboardURL + "34",
			returnStatus: restService.getStatuses($scope, $http, 120)
        },
		{
			name: "UPAX-IDTY-VRFN",
			appId: "132",
			availabilityUrl: dashboardURL + "30",
			databaseUrl: dashboardURL + "32",
			storageUrl: dashboardURL + "33",
			serverUrl: dashboardURL + "34",
			returnStatus: restService.getStatuses($scope, $http, 132)
        },
		{
			name: "IMPORT-CARGO",
			appId: "123",
			availabilityUrl: dashboardURL + "30",
			databaseUrl: dashboardURL + "32",
			storageUrl: dashboardURL + "33",
			serverUrl: dashboardURL + "34",
			returnStatus: restService.getStatuses($scope, $http, 123)
        },
		{
			name: "PRIDE2",
			appId: "148",
			availabilityUrl: dashboardURL + "30",
			databaseUrl: dashboardURL + "32",
			storageUrl: dashboardURL + "33",
			serverUrl: dashboardURL + "34",
			returnStatus: restService.getStatuses($scope, $http, 148)
        }
    ]
});

myApp.controller('pspdController', function ($scope, $http, restService) {

	$scope.appStatus = {};
	$scope.dbStatus = {};
	$scope.storageStatus = {};
	$scope.serverStatus = {};

	$scope.appStatusArray = [
		{
			name: "APC",
			appId: "69",
			availabilityUrl: dashboardURL + "30",
			databaseUrl: dashboardURL + "32",
			storageUrl: dashboardURL + "33",
			serverUrl: dashboardURL + "34",
			returnStatus: restService.getStatuses($scope, $http, 69)
        },
		{
			name: "TECS-TPAC",
			appId: "239",
			availabilityUrl: dashboardURL + "30",
			databaseUrl: dashboardURL + "32",
			storageUrl: dashboardURL + "33",
			serverUrl: dashboardURL + "34",
			returnStatus: restService.getStatuses($scope, $http, 239)
        },
		{
			name: "TECS-PORTAL",
			appId: "153",
			availabilityUrl: dashboardURL + "30",
			databaseUrl: dashboardURL + "32",
			storageUrl: dashboardURL + "33",
			serverUrl: dashboardURL + "34",
			returnStatus: restService.getStatuses($scope, $http, 153)
        },
		{
			name: "TECS-LR",
			appId: "163",
			availabilityUrl: dashboardURL + "30",
			databaseUrl: dashboardURL + "32",
			storageUrl: dashboardURL + "33",
			serverUrl: dashboardURL + "34",
			returnStatus: restService.getStatuses($scope, $http, 163)
        },
		{
			name: "TECS-NNSV",
			appId: "164",
			availabilityUrl: dashboardURL + "30",
			databaseUrl: dashboardURL + "32",
			storageUrl: dashboardURL + "33",
			serverUrl: dashboardURL + "34",
			returnStatus: restService.getStatuses($scope, $http, 164)
        },
		{
			name: "TECS-TSSV",
			appId: "244",
			availabilityUrl: dashboardURL + "30",
			databaseUrl: dashboardURL + "32",
			storageUrl: dashboardURL + "33",
			serverUrl: dashboardURL + "34",
			returnStatus: restService.getStatuses($scope, $http, 244)
        },
		{
			name: "TECS-TDED",
			appId: "184",
			availabilityUrl: dashboardURL + "30",
			databaseUrl: dashboardURL + "32",
			storageUrl: dashboardURL + "33",
			serverUrl: dashboardURL + "34",
			returnStatus: restService.getStatuses($scope, $http, 184)
        },
		{
			name: "TECS-CSIS",
			appId: "212",
			availabilityUrl: dashboardURL + "30",
			databaseUrl: dashboardURL + "32",
			storageUrl: dashboardURL + "33",
			serverUrl: dashboardURL + "34",
			returnStatus: restService.getStatuses($scope, $http, 212)
        },
		{
			name: "TECS-MNFST",
			appId: "220",
			availabilityUrl: dashboardURL + "30",
			databaseUrl: dashboardURL + "32",
			storageUrl: dashboardURL + "33",
			serverUrl: dashboardURL + "34",
			returnStatus: restService.getStatuses($scope, $http, 220)
        },
		{
			name: "TECS-PQS",
			appId: "226",
			availabilityUrl: dashboardURL + "30",
			databaseUrl: dashboardURL + "32",
			storageUrl: dashboardURL + "33",
			serverUrl: dashboardURL + "34",
			returnStatus: restService.getStatuses($scope, $http, 226)
        },
		{
			name: "TECS-PIP-SVCS",
			appId: "240",
			availabilityUrl: dashboardURL + "30",
			databaseUrl: dashboardURL + "32",
			storageUrl: dashboardURL + "33",
			serverUrl: dashboardURL + "34",
			returnStatus: restService.getStatuses($scope, $http, 240)
        },
		{
			name: "TECS-PIP-AIRSEA",
			appId: "241",
			availabilityUrl: dashboardURL + "30",
			databaseUrl: dashboardURL + "32",
			storageUrl: dashboardURL + "33",
			serverUrl: dashboardURL + "34",
			returnStatus: restService.getStatuses($scope, $http, 241)
        },
		{
			name: "TECS-PIP-LAND",
			appId: "242",
			availabilityUrl: dashboardURL + "30",
			databaseUrl: dashboardURL + "32",
			storageUrl: dashboardURL + "33",
			serverUrl: dashboardURL + "34",
			returnStatus: restService.getStatuses($scope, $http, 242)
        },
		{
			name: "TECS-PIP-VEH",
			appId: "243",
			availabilityUrl: dashboardURL + "30",
			databaseUrl: dashboardURL + "32",
			storageUrl: dashboardURL + "33",
			serverUrl: dashboardURL + "34",
			returnStatus: restService.getStatuses($scope, $http, 243)
        },
    ]
});

myApp.service(
	'restService',
	function () {

		this.getStatuses = function ($scope, $http, appId) {

			$scope.appStatus[appId] = "ok";
			$scope.dbStatus[appId] = "ok";
			$scope.storageStatus[appId] = "ok";
			$scope.serverStatus[appId] = "ok";

			var restEndPoint = "https://appmonitor.cbp.dhs.gov/controller/rest/applications/" +
				appId;
			$http({
					headers: {
						'Access-Control-Allow-Origin': '*',
						'Authorization': 'Basic cmVzdHJlYWRAY3VzdG9tZXIxOnBhc3N3b3JkMQ=='
					},
					method: "GET",
					async: false,
					url: restEndPoint +
						"/events?time-range-type=BEFORE_NOW&duration-in-mins=15&event-types=RESOURCE_POOL_LIMIT,DEADLOCK&severities=INFO,WARN,ERROR&output=JSON"
				})
				.then(
					function mySucces(response) {
						$scope.eventRsp = response.data;
						angular.forEach($scope.eventRsp, function (event, id) {
								if (event.type == "RESOURCE_POOL_LIMIT" || event.type == "DEADLOCK")
									$scope.appStatus[appId] = "critical";
						});
					},
					function myError(response) {
						$scope.eventRsp = response.data;
					});

			$http({
				headers: {
					'Access-Control-Allow-Origin': '*',
					'Authorization': 'Basic cmVzdHJlYWRAY3VzdG9tZXIxOnBhc3N3b3JkMQ=='
				},
				method: "GET",
				async: false,
				url: restEndPoint +
					"/problems/healthrule-violations?time-range-type=BEFORE_NOW&duration-in-mins=15&output=JSON"
			}).then(
				function mySucces(response) {
					$scope.hrvRsp = response.data;
					angular.forEach($scope.hrvRsp, function (hrv, id) {

						if (hrv.incidentStatus == "OPEN" && hrv.severity == "CRITICAL") {
							if (hrv.name == "Application : Availability")
								$scope.appStatus[appId] = "critical";
							else if (hrv.name == "Database : Performance")
								$scope.dbStatus[appId] = "critical";
							else if (hrv.name == "Storage : Performance")
								$scope.storageStatus[appId] = "critical";
							else if (hrv.name == "Server : Agent not reporting" || hrv.name == "Server : Node performance")
								$scope.serverStatus[appId] = "critical";

						}
						if (hrv.incidentStatus == "OPEN" && hrv.severity == "WARNING") {
							if (hrv.name == "Application : Availability")
								$scope.appStatus[appId] = "warning";
							else if (hrv.name == "Database : Performance")
								$scope.dbStatus[appId] = "warning";
							else if (hrv.name == "Storage : Performance")
								$scope.storageStatus[appId] = "warning";
							else if (hrv.name == "Server : Agent not reporting" || hrv.name == "Server : Node performance")
								$scope.serverStatus[appId] = "warning";
						}

					});
				},
				function myError(response) {
					$scope.hrvRsp = response.data;
				});
			return $scope;
		}
	});