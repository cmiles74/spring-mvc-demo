# To Do List: Spring MVC Demo Project

This is a simple demo project that uses Spring Boot with MVC and Thymeleaf. It
provides a very simple to-do list application. This project is about 
getting the current versions of these libraries together to see how they work.

![Screenshot](https://github.com/cmiles74/spring-mvc-demo/blob/main/screenshot.png)

## Working on the Project

This project is all set to use [GitHub Codespaces][codespaces] to get you
working with the project as quickly as possible. If you prefer to develop
locally, scripts for [Docker][docker] are also included.

### Working Through GitHub Codespaces

If you use GitHub and have an active account, you can get the project
up-and-running (and yourself contributing) in just one click. From the project
homepage, click on the "Code" button in the upper right and then select the
"Codespaces" tab. From there you can click the button to "Create codespace on
main" (or another branch if you prefer) and GitHub will start up a new
development environment. Once that is all set you will be dropped at the
web-based Visual Studio Code editor where you can start working with the
project. The Java extension pack as well as a PostgreSQL extention will be
automatically installed for you.

### Working Under Docker

This project uses [Docker][docker] to manage your development environment. 
There is a [Docker Compose][docker-compose] script that you may invoke to bring
up a database and run the migrations to get you started with development. All
of the various settings will be read from a `.env` file, a sample is provided.
To get started quickly, simply copy the file and leave the content as-is.

    $ cp env-sample .env

With that done, run `docker-compose` from the root of the project to get a 
PostgreSQL container up and running. The command below will start up a container
with PostgreSQL, another container with Flyway and then apply the database 
migrations. The `-d` flags runs this in the background. :wink:

     $ docker compose up -d

When you're done working on the project you may shut down the database server
with the following command.

     $ docker compose down

The containers in the Docker environment will use the values in the `.env`
file to connect to the database server. When you run your application locally
the settings in the `application.properties` file will be used. If you
change the values in the `.env` file be sure to update the values in the
`application.properties` file as well.

### Building and Running

This project requires [Java][java] to build and run, it uses [Maven][maven] 
to manage the project itself. You will need to have Maven installed and 
available on your path. With that setup, you can ask Maven to build the 
project.

     $ mvn package

Maven will ensure that all of the required dependencies are available and will
build the project and write the Java archive (JAR) file to the `target`
directory.

The default `application.properties` that come with the project expect that the
PostgreSQL database server will be available. You may use the same Docker
Compose stack that you use during development.

     $ docker compose up -d

Now that Docker is running, you may start the application with the invocation 
below.

     $ java -jar target/spring-mvc-demo-0.0.1-SNAPSHOT.jar

The application should be available on [your local machine](http://localhost:8080).

* [http://localhost:8080](http://localhost:8080)

When you are done, don't forget to `down` your Docker containers.

#### Starting from Your IDE

To start the application from inside your IDE, point your IDE at the 
bootstrapping class. It contains a `main` method that will start the application.

     com.nervestaple.springmvcdemo.SpringMvcDemoApplication

----
[docker]: https://www.docker.com/
[docker-compose]: https://docs.docker.com/compose/
[maven]: https://maven.apache.org/
[java]: https://adoptium.net/temurin/releases/
[codespaces]: https://github.com/features/codespaces
[devcontainer]: https://code.visualstudio.com/docs/remote/containers