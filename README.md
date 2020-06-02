# Micro_Services_Case_Study

Steps to run :

1) Download and run the axon jar / docker image from  https://axoniq.io/
2) Run OrderServiceApplication.java
3) Run PaymentServiceApplication.java
4) Run ShipmentServiceApplication.java

Open Postman and hit the URls:

1) Run http://localhost:8090/authenticate with the below details.

POST /authenticate HTTP/1.1
Host: localhost:8090
Content-Type: application/json
Cookie: JSESSIONID=B06BD98D1985684D91697E5342957AB2
{
	"username": "Shirisha",
	"password": "password"
}

2) Run http://localhost:8090/api/orders/create with the below details. 

POST /api/orders/create HTTP/1.1
Host: localhost:8090
Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJTaGlyaXNoYSIsImV4cCI6MTU5MDUxMzM2NSwiaWF0IjoxNTkwNDk1MzY1fQ.YAoed2I_v3POvVma8RLG-EpSYcd-kLbtMczd6RpzyaF1NL5QHjFUqJpxA7-C3BHT5ssALFelrF1NrpaZbNqvWQ
Content-Type: application/json
Cookie: JSESSIONID=B06BD98D1985684D91697E5342957AB2
{
	"itemType": "LAPTOP",
	"price": 120,
	"currency": "INR"
}

3) Run http://localhost:8090/api/orders/all with the below details. 

GET /api/orders/all HTTP/1.1
Host: localhost:8090
Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJTaGlyaXNoYSIsImV4cCI6MTU5MDUxMzM2NSwiaWF0IjoxNTkwNDk1MzY1fQ.YAoed2I_v3POvVma8RLG-EpSYcd-kLbtMczd6RpzyaF1NL5QHjFUqJpxA7-C3BHT5ssALFelrF1NrpaZbNqvWQ
Cookie: JSESSIONID=B06BD98D1985684D91697E5342957AB2


4) Monitor logs and hit http://localhost:8024/ Axon dashboard
