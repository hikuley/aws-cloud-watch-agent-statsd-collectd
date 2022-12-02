# aws-cloud-watch-agent-statsd-collectd


What is StatsD?

StatsD a network daemon that runs on the Node.js platform and listens for statistics, like counters and timers, sent over UDP or TCP and sends aggregates to one or more pluggable backend services (e.g., Graphite).

When to use and when not to use StatsD
You should not expect metrics generated with statsD to be 100% precise and extract business metrics from it (e.g: how many clients bought a product, or how many users registered for your newsletter) since data is sent over UDP (more on that below). Use statsD metrics to identify abnormalities in your services (e.g.: too many error statuses; methods taking too long to complete; etc).

Packages sent over User Datagram Protocol (UDP) do not have guaranteed delivery. Let's take a look one sample application.

## How to package the application
```bash
./gradlew bootJar
```

## How to run the application
```bash
java -jar build/libs/cloud-watch-agent-statsd-collectd-0.0.1-SNAPSHOT.jar
```

## Make a request
```bash
curl -X POST -H 'Content-type: application/json' -i localhost:8080/v1/users/login -d '{"username": "custom_username", "password": "*******"}'
```

## Storage for our Jar file
Create a bucket on `S3` with a unique name

victor-creditas-custom-app-jar-files

Upload the `jar` file to the created bucket:
```bash
aws-vault --debug exec scd-stg -- aws s3api put-object --bucket victor-creditas-custom-app-jar-files --key build/libs/cloud-watch-agent-statsd-collectd-0.0.1-SNAPSHOT.jar --body build/libs/cloud-watch-agent-statsd-collectd-0.0.1-SNAPSHOT.jar
```

## Starting statsd locally
```bash
docker run \
 --name graphite\
 --restart=always\
 -p 80:80\
 -p 81:81\
 -p 2003-2004:2003-2004\
 -p 2023-2024:2023-2024\
 -p 8125:8125/udp\
 -p 8126:8126\
 hopsoft/graphite-statsd
```
