package net.javaguides.springbootkafka.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import net.javaguides.springbootkafka.payload.User;

@Service
public class JsonKafkaConsumer {

	private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaConsumer.class);
	
	@KafkaListener(topics = "javaguides_json", groupId = "consumerGroup1")
	public void consume(User data)
	{
		LOGGER.info(String.format("Message received -> %s", data.toString()));
	}
}
