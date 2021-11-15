# bazel-guice-dropwizard-demo

## Build
bazel build //:app_deploy.jar         

## Run
java -jar bazel-bin/app_deploy.jar server app.yml

## Usage
GET http://localhost:8080/hello-world?name=anonymous
