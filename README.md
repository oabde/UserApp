# UserApp

A Springboot API that exposes two services:
• one that allows to register a user
• one that displays the details of a registered user

### Prerequisites

* Java SDK 15+.
* Maven 3.8+

### Installation guide

First, you need to clone the project on your machine. To do this, create an empty directory, **C:\Projects** for example,
then open the command prompt (PowerShell or CMD) and run the following commands:

cd C:\Projects``
git clone https://github.com/oabde/UserApp.git 

After downloading the repository to your machine, navigate to the **UserApp** folder and run the project build 
with the following command: 

`mvn clean install`

To launch the application, you will need to run the maven command:

`mvn spring-boot:run`

### Test the API

You can use Postman
* to register : http://localhost:8086/user/Register-user
you can use the body bellow

{

    "idUser":1,
    "name":"ALEN",
    "birth":" 1999-12-11",
    "country":"FRANCE",
    "gender":"MALE",
    "phoneNumber":"677633"
    
}

* to Get user Details : http://localhost:8086/user/1 (1 is Id of user)
