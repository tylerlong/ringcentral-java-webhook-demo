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


## Part 2: Setup WebHook

### Download RingCentral

```
wget -O ringcentral.jar https://dl.bintray.com/tylerlong/maven/com/ringcentral/ringcentral/1.0.0-beta10/ringcentral-1.0.0-beta10.jar
```

### Write code

Create file `SetupWebHook.java` with source code as shown in this project.

### Compile

```
javac -d classes -cp ringcentral.jar SetupWebHook.java
```

### Run

```
java -cp classes:ringcentral.jar com.ringcentral.SetupWebHook
```
