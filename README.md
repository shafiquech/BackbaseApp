# BackbaseApp
BackbaseApp test

# Steps to test


Deployment:
Option 1:
	Open the poject in any IDE and run it with any server for example tomcat
Option 2:
	Using maven clean the project and install all the dependencies (mvn clean install)
	Deploy the generated WAR file in a tomcat server

Testing:
	The test is using basic Spring Security that is username and password
	For this test the username=[backbase]  and password = [backbase]
	
Api Endpoint URls:
	To get all the transaction: http://localhost:8080/BackbaseApp/api/v1/transactions/
	Transactions based on transaction type : http://localhost:8080/BackbaseApp/api/v1/transactions/SANDBOX_TAN
	Total amount for transaction type: http://localhost:8080/BackbaseApp/api/v1/transactionsAmount/SANDBOX_TAN



