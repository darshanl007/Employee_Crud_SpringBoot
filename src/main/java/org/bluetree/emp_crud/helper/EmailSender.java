package org.bluetree.emp_crud.helper;

import org.bluetree.emp_crud.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import jakarta.mail.internet.MimeMessage;

@Component
public class EmailSender {

	@Autowired
	JavaMailSender mailSender;

	@Autowired
	TemplateEngine templateEngine;

	public void send(Employee employee) {
		String email = employee.getEmail();
		int otp = employee.getOtp();
		String name = employee.getName();

		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);

		try {
			helper.setFrom("darshanl1254@gmail.com", "Employee CRUD Operations");
			helper.setTo(email);
			helper.setSubject("OTP for Email Verification");
			Context context = new Context();
			context.setVariable("name", name);
			context.setVariable("otp", otp);
			String text = templateEngine.process("otp-template.html", context);
			helper.setText(text, true);
			mailSender.send(message);
		} catch (Exception e) {
			System.err.println("There is some Issue");
		}
	}
}
