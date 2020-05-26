# Micro_Services_Case_Study

# repo_saga3

Steps to run :

1) Download and run the axon jar / docker image from  https://axoniq.io/
2) Run DemoOrderServiceApplication.java
3) Run DemoPaymentServiceApplication.java
4) Run DemoShipmentServiceApplication.java

Open Postman and hit the URls:

1) localhost:8090/authenticate with username: "anand" and password : "password" as request body
2) localhost:8090/api/create/order  , send along with bearer token

Monitor logs and hit localhost:8024 Axon dashboard
