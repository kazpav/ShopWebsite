package ua.website.service;

public interface MailSendingService {
	
	public void sendMail(String content, String email, String mailBody);
}
