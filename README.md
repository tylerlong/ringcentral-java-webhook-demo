# RingCentral Java WebHook demo

## Part 1: WebHook Server

### Ref

https://www.eclipse.org/jetty/documentation/current/advanced-embedding.html

### Download Jetty

```
curl -o jetty-all-uber.jar https://repo1.maven.org/maven2/org/eclipse/jetty/aggregate/jetty-all/9.4.19.v20190610/jetty-all-9.4.19.v20190610-uber.jar
```

### Write code

Create file `WebHookServer.java` with source code as shown in this project.

### Compile

```
mkdir classes
javac -d classes -cp jetty-all-uber.jar WebHookServer.java
```

### Run

```
java -cp classes:jetty-all-uber.jar com.ringcentral.WebHookServer
```

### Get a public uri

RingCentral WebHook requires a public uri to work. If you don't already have one, you can try [ngrok](https://ngrok.com/download).

We are not going to cover the ngork installation & usage detail, here is the quick command to get started:

```
ngrok http 8080
```

Please note down the ngork https uri which we will use later, such as `https://xxxxxx.ngrok.io`.


## Part 2: Setup WebHook

### Setup a Gradle project

We start a Gradle hello world style Java application. If you are not familar with Gradle, please read [its documentation](https://docs.gradle.org/current/userguide/building_java_projects.html#introduction).

Here is the [gradle build file](./build.gradle), and here is the [Java source code](./src/main/java/com/ringcentral/SetupWebHook.java).

Please do remember the replace those environment variables with real values.

And don't forget to replace `WEBHOOK_ADDRESS` with the ngrok uri we created above.



### Run

```
./gradlew run
```


## Part 3: Test

Send an sms to the phone number you used in Part 2. And watch the console of the app we created in Part 1. There should be incoming WebHook notifications.
