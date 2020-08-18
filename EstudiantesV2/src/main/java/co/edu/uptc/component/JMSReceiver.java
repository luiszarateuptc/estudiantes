package co.edu.uptc.component;

import javax.jms.JMSException;

import org.apache.activemq.command.ActiveMQTextMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.edu.uptc.dto.AuditBasicDto;

@Component
public class JMSReceiver {
	
	@Autowired
	private ObjectMapper mapper;

	@JmsListener(destination = "${queue.name}", containerFactory = "myFactory")
	public void receiveMessage(ActiveMQTextMessage message) {
		try {
			System.out.println("-----------------------------");
			System.out.println("Llego mensaje");
			System.out.println(message.getText());
			AuditBasicDto dto = mapper.readValue(message.getText(), AuditBasicDto.class);
			System.out.println(dto);
			System.out.println("-----------------------------");
		} catch (JMSException | JsonProcessingException e) {
			e.printStackTrace();
		}
	}
}
