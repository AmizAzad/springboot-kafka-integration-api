package net.javaguides.springbootkafka.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springbootkafka.kafka.JsonKafkaProducer;
import net.javaguides.springbootkafka.payload.User;

@RestController
@RequestMapping("/api/v1/kafka")
public class JsonMessageController 
{
	private JsonKafkaProducer jsonKafkaProducer;

	public JsonMessageController(JsonKafkaProducer jsonKafkaProducer) 
	{
		super();
		this.jsonKafkaProducer = jsonKafkaProducer;
	}
	
	@PostMapping("/publish")
	public ResponseEntity<String> publish(@RequestBody User data)
	{
		jsonKafkaProducer.sendMessage(data);
		return ResponseEntity.ok("Json message sent to Kafka topic");
	}
}
