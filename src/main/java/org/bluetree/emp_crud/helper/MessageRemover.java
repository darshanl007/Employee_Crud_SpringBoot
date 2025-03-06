package org.bluetree.emp_crud.helper;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import jakarta.servlet.http.HttpSession;

@Component
public class MessageRemover {
	public void remove() {
		ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes();
		HttpSession session = requestAttributes.getRequest().getSession();
		session.removeAttribute("success");
		session.removeAttribute("failure");
	}
}
