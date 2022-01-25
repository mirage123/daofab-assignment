# DAOFAB Assignment solution

* Api is built in java (11) springboot
* Database is postgresql. Configure the required credentials of db from application.properties file.
* table and data will be created automatically while starting the application
* Check requests.http file to run the apis.
* Application is running on port 8081 (internal tomcat server)
* /api/parents [GET] endpoint for getting PARENTS can accept currentPage, size and sortByOrder parameters in requestParam.
  Else default values will be used (currentPage =1, size=2, sortByOrder=asc).
* /api/child [GET] endpoint for getting child. (no pagination for this api)