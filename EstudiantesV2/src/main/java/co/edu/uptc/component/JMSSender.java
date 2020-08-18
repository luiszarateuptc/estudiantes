package co.edu.uptc.component;

import static java.util.Objects.nonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import co.edu.uptc.dto.AuditBasicDto;

@Component
public class JMSSender {

	@Autowired
	private JmsTemplate jmsTemplate;

	@Value("${queue.name}")
	private String queueAudit;

	public void sendAuditInfo(AuditBasicDto dto) {
		if (nonNull(dto))
			jmsTemplate.convertAndSend(queueAudit, dto);
	}
}
