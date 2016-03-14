# SpringMVC_RestDemo

This is Spring REST demo project with basic Authentication.

URI tested using rest client are : http://localhost:8080/rest/top/30

GET /rest/top/30 HTTP/1.1 Host: localhost:8080 Authorization: Basic YWRtaW46UGFzc3cwcmQ= content-type: text/csv Cache-Control: no-cache

http://localhost:8080/rest/search POST /rest/search HTTP/1.1 Host: localhost:8080 Content-Type: application/json Authorization: Basic YWRtaW46UGFzc3cwcmQ= Cache-Control: no-cache

{

"searchText": [ "Duis", "Sed" ]

}

Authentication Credentials : username: admin password: Passw0rd
