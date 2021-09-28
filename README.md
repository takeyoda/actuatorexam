# actuatorexam
Spring-boot-actuator and Micrometer example.

## Build
```
./gradlew build
```

## Build image
```
./gradlew jibDockerBuild
```

## Run
```
java -jar build/libs/actuatorexam-1.0.0-SNAPSHOT.jar 

# endpoint index
curl localhost:8081/actuator | jq .

# custom endpoint
curl -H 'X-Foo: bar' localhost:8081/actuator/ore | jq .

# writable custom endpoint
curl localhost:8081/actuator/orew
curl -v -H 'Content-Type: application/json' -d '{"value":32}' localhost:8081/actuator/orew
curl localhost:8081/actuator/orew # => 32

# custom info
curl localhost:8081/actuator/info

# custom health
curl localhost:8081/actuator/health
```
