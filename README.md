# Simple interceptors Spring example 
For this simple example, I used the interceptors classes concept, allowing to prove a special petition that simulates that the user have to has logged into the system previously to make that metioned petition.
## Db configuration
It is actually a very simple command to our SQL Datbase, due all work is provided by the ORM.
- create database interceptors;
### MvcConfig class
This class is situated in the main package of the application, it declares which and where we want to use our interceptors. In this case, we have an example class and a `loginIntercepor` class, which is responsible to handle the `"user/find/all"` special petition.


### UserController class

In the user controller class we have some routes, first, we assume that every petition is correct and it doesn't any big validations, so we create one or more users, with the path `"localhost:8080/user/save"`.

Then, we can log in by using a post petition that must have a correct email and password wit the `"localhost:8080/user/login"` path.

Now, we can go to the `"localhost:8080/user/find/all"` path to see all the registered usres. Here's the trick, if as a user, you didn't log in correctly or din't try to log in, this path doesn't works. It doesn't works because of the interceptor applied in the initial configuration.

`Note:` Doesn't work with an api request maker that doesn't mantain the session id (postman recommended)
