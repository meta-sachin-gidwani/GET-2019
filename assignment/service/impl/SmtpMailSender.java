package com.metacube.assignment.service.impl;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.metacube.assignment.service.MailSender;


public class SmtpMailSender implements MailSender{

	@Override
	public String sendMail() {
		return "smtp mail";
	}

}
