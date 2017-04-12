'use strict';

App.factory('UserService', ['$http', '$q', function($http, $q){

	return {

		fetchAllUsers: function() {
			return $http.get('http://192.168.99.100:8181/hr-rest/hrrest/users/',
					{ callback: "JSON_CALLBACK", format:'jsonp' })
			.then(
					function(response){
						console.log('Getting results... \n'+response.data);
						return response.data;
					}, 
					function(errResponse){
						console.error('Error while fetching users');
						return $q.reject(errResponse);
					}
			);
		},

		createUser: function(user){
			return $http.post('http://192.168.99.100:8181/hr-rest/hrrest/create/', user)
			.then(
					function(response){
						return response.data;
					}, 
					function(errResponse){
						console.error('Error while creating user');
						return $q.reject(errResponse);
					}
			);
		},

		updateUser: function(user, id){
			console.log('updateUser: '+id);
			return $http.post('http://192.168.99.100:8181/hr-rest/hrrest/update', user)
			.then(
					function(response){
						return response.data;
					}, 
					function(errResponse){
						console.error('Error while updating user');
						return $q.reject(errResponse);
					}
			);
		},

		deleteUser: function(id){
			console.log('deleteUser: '+id);
			
			return $http.post('http://192.168.99.100:8181/hr-rest/hrrest/remove',id)
			.then(
					function(response){
						return response.data;
					}, 
					function(errResponse){
						console.error('Error while deleting user');
						return $q.reject(errResponse);
					}
			);
		}

	};
}]);
