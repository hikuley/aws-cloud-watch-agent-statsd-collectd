# aws-cloud-watch-agent-statsd-collectd


What is StatsD?

StatsD is a network daemon that allows you to collect and send metrics from your application to various backend systems. It is typically used to track and monitor various performance metrics, such as request rates, response times, and error rates.

StatsD works by listening for metrics over UDP, and then aggregating and forwarding these metrics to backend systems for storage and analysis. This allows for low-overhead metric collection, as UDP is a connectionless protocol that does not require the overhead of establishing and maintaining a connection.

Packages sent over User Datagram Protocol (UDP) do not have guaranteed delivery. Let's take a look one sample application.

## How to package the application
```bash
./gradlew bootJar
```

## How to run the application
```bash
java -jar build/libs/cloud-watch-agent-statsd-collectd-0.0.1-SNAPSHOT.jar
```

## How to make a HTTP request to trigger a StatsD write 
```bash
curl -X POST -H 'Content-type: application/json' -i localhost:8080/v1/users/login -d '{"username": "custom_username", "password": "*******"}'
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
