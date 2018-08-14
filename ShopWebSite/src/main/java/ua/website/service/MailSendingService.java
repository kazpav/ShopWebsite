package ua.website.service;

/**
 * Service interface that is responsible for sending messages to {@code Users}
 * @author Pavel Kazarin
 * @version 1.0
 * @see ua.website.serviceImpl.MailSendingServiceImpl
 */
public interface MailSendingService {

	/**
	 * Sends emails
	 * @param content Subject of email
	 * @param email Recipient of email
	 * @param mailBody Text of email
	 */
	public void sendMail(String content, String email, String mailBody);
}
