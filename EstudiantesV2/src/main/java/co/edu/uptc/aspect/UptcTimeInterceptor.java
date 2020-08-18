package co.edu.uptc.aspect;

import static java.util.Objects.nonNull;

import java.time.ZonedDateTime;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import co.edu.uptc.component.JMSSender;
import co.edu.uptc.dto.AuditBasicDto;

@Component
@Aspect
public class UptcTimeInterceptor {

	@Autowired
	private JMSSender jmsSender;

	@Around(value = "@annotation(uptcTime)", argNames = "uptcTime")
	public void calculateTime(ProceedingJoinPoint point, UptcTime uptcTime) throws Throwable {
		point.proceed();
		AuditBasicDto dto = new AuditBasicDto();
		dto.setAction(point.getSignature().getName());
		dto.setTime(ZonedDateTime.now().toEpochSecond());
		dto.setUsername(getUsername());
		jmsSender.sendAuditInfo(dto);
	}

	private String getUsername() {
		return hasSecurityContext()
				? ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername()
				: "notFoundSeurity";
	}

	private boolean hasSecurityContext() {
		return nonNull(SecurityContextHolder.getContext().getAuthentication());
	}

}
