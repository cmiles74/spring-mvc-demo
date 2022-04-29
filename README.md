# Spring MVC Demo Project

This is a simple demo project that uses Spring Boot with MVC and Thymeleaf. The
whole point, really, it to get the new versions of these libraries together and
to see if I can make them put a small, simple web application together.

## Contributing to the Project

This project uses [Docker][docker] to manage your development environment. 
There is a [Docker Compose][docker-compose] script that you may invoke to bring
up a database and run the migrations to get you started with development. All
of the various settings will be read from a `.env` file, a smaple is provided.
Copy the sample file and then edit it as you see fit.

    $ cp env-sample .env

With that done, run `docker-compose` from the root of the project to get a 
PostgreSQL container up and running.

     $ docker-compose

Next, edit the `application.properties` file in the `src/resources` directory
to have the correct database URL, username and password. When you run the
application in your IDE, it will be able to connect to the database server.

----
[docker]: https://www.docker.com/
[docker-compose]: https://docs.docker.com/compose/