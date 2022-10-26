# Amazon SearchProduct Automation Project
 This Project uses JUnit 5, Maven, + Selenide libraries.


## Clone the project
```
$ git clone https://github.com/a-arias/selenideExample
$ cd selenideExample
```
## How to run tests locally?
```
$ mvn clean test
```
## How to run this project on selenoid?
You need to have installed docker on your machine, you can follow steps on 
Windows: https://docs.docker.com/desktop/install/windows-install/ and 
Linux: https://docs.docker.com/engine/install/ubuntu/

### Setting up Docker containers

```
$sudo docker pull selenoid/vnc:chrome_65.0
$sudo docker pull aerokube/selenoid
$sudo docker pull aerokube/selenoid-ui
$sudo docker pull selenoid/video-recorder

$sudo docker-compose up -d
```
After it started, you can check the status of the container
```
$ sudo docker-compose ps
```
### Set environment variable

OSX
```
You can initialise environment variables so that they're available to the current session, both the current one and any started in the current session, as well as any processes started in the current session, by using the builtin export command, as in the example below.
 export ENVIRONMENT="Selenoid"
```
Windows
```
# Set USER_ID in the Windows Command Prompt
set ENVIRONMENT="Selenoid"

# Set USER_ID in the Windows PowerShell console
$Env:ENVIRONMENT="Selenoid"
```
### Run Tests
```
  mvn clean test  
```
After starting your tests you can view your session in the Selenoid portal: http://localhost:8080/#/ and see the video on real time of your tests running.