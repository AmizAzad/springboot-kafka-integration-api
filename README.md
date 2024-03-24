# springboot-kafka-integration-api
This project consists of 2 API endpoint URLs to consume input data, write it to a Kafka topic (producer) and subsequently other service will read it from Kafka topic (consumer).

#### Endpoints:
1. http://localhost:8080/api/v1/kafka/publish  
Method: POST  
Request Body:  
`{  
    "id": 101,  
    "firstName": "Lara",  
    "lastName": "Croft"  
}`  
Response:  
Json message sent to Kafka topic  

2. http://localhost:8080/api/v1/kafka/publish?message=Message via Query Arg  
Method: GET  
Response:  
Message sent to the topic  

----------------

### Apache Kafka Notes:

#### Starting the Zoopkeeper. Default port is 2181.
`bin\windows\zookeeper-server-start.bat config\zookeeper.properties`

#### Starting the Kafka Server / Broker. Default port is 9092. In server.properties, make sure to update the below properties:
> 1. listeners=PLAINTEXT://0.0.0.0:9092
> 2. advertised.listeners=PLAINTEXT://localhost:9092
> 3. listener.security.protocol.map=PLAINTEXT:PLAINTEXT,SSL:SSL,SASL_PLAINTEXT:SASL_PLAINTEXT,SASL_SSL:SASL_SSL

`bin\windows\kafka-server-start.bat config\server.properties`

#### Listing down all the Kafka Topics
`bin\windows\kafka-topics.bat --list --bootstrap-server localhost:9092`

#### Creating a Kafka Topic
`bin\windows\kafka-topics.bat --create --topic topicdemo --bootstrap-server localhost:9092`

#### Deleting a Kafka Topic. Note that, deleting a topic may require you to clear the logs files of Kafka & Zookeeper.
`bin\windows\kafka-topics.bat --delete --topic topicdemo --bootstrap-server localhost:9092`

#### Describing a Kafka Topic
`bin\windows\kafka-topics.sh --describe --topic topicdemo --bootstrap-server localhost:9092`

##### Describe command output sample
>C:\kafka_2.12-3.7.0>bin\windows\kafka-topics.bat --describe --topic topicdemo --bootstrap-server localhost:9092  
Topic: topicdemo        TopicId: I79rWedSRuuTI_XvtGDbRg PartitionCount: 1       ReplicationFactor: 1    Configs:  
        Topic: topicdemo        Partition: 0    Leader: 0       Replicas: 0     Isr: 0

#### Create a Kafka Producer to write messages into a Topic.
`bin\windows\kafka-console-producer.sh --topic topicdemo --bootstrap-server localhost:9092`

#### Creating a Kafka Producer to read messages from a Topic.
`bin\windows\kafka-console-consumer.sh --topic topicdemo --from-beginning --bootstrap-server localhost:9092`

----------------

### GitHub Notes:

When checking into a new remote repository, the remote repository URL needs to be set in your local repository. This can be done using the below command:
`git remote add origin <repository_url>`

Check your Git remote: Ensure that your Git remote is correctly set to the repository you want to push to. You can check your remote repositories using:
`git remote -v`

If the remote is incorrect, you can update it using:
`git remote set-url origin <repository_url>`
