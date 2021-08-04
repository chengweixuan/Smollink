# Smollink (URL Shortener)

## This project is now deployed live at:  https://smol-link.herokuapp.com/
Note: Heroku apps go to sleep after 1 hour of inacitvity. If live link is slow, please visit [this link](https://github.com/chengweixuan/smollink-front/) to wake backend

### Architecture  

* This project is a URL shortening service that allows users to create shortened URLs from any URL to be used or shared.   
* Users can create their own custom short URLs or allow the system to generate a random one for them.    
* This project consists of a frontend component developed in Vue.js and a backend component developed in Java. 
* Frontend component is developed in Vue.js using the Quasar framework.
* Backend component is devleloped as a Spring Boot application in Java. 


### Description  

This repository contains the Java Spring Boot Web Application that runs the RESTFUL backend API for Smollink.  
A mySQL database is used to store converted URLs.  

This Spring Boot Backend is deployed live at:  https://smollink-heroku.herokuapp.com/  
Endpoints for backend can be viewed [here](https://smollink-heroku.herokuapp.com/swagger-ui.html#/short-controller).

Repository for the frontend component is found at: https://github.com/chengweixuan/smollink-front/


### Local Set Up

#### Backend
* Clone this repository and build the maven package  
* Run jar file
#### Frontend
* Follow set up instructions at: https://github.com/chengweixuan/smollink-front/

### Unit Testing

Run JUnit tests found in src/test/java/com/weixuan/shorturl/ShorturlApplicationTests.  

### About

Made by Cheng Weixuan  
GitHub: https://github.com/chengweixuan/


