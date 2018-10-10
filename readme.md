# Spring WebFlux

#### Requirements:
- Java
- IntelliJ Lombok plugin
- MongoDB
- Maven 


#### To install mongoDB:
```
brew install mongodb
mkdir -p /data/db
sudo chown -R $USER /data/db
```

#### Kafka

```
Install
-------
brew install zookeeper
brew install kafka

Start
-----
brew services start zookeeper
brew services start kafka

Stop
----
brew services stop zookeeper
brew services stop kafka
```
#### To run mongoDB:
`mongod`

#### Server URL's:
[http://localhost:8080/init]() - to setup dummy data in the db
Other URL's can be found in `TweetController`
