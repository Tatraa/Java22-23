package pl.edu.uj.sender;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SenderApplication {

  private static final Logger logger = LoggerFactory.getLogger(SenderApplication.class);

  public static void main(String[] args) throws SenderException, InterruptedException {
    Message message = new PushMessage("Push message Title", "Push message body");
    Recipient recipient = new PushRecipient("ihatejava");
    Sender pushSender = new PushSender();
    pushSender.send(message, recipient);
    logger.info("push poszedl w ruch");

    Message emailMessage = new EmailMessage("Email message Title", "Email message body");
    Recipient emailRecipient = new EmailRecipient("ilovejava@gmail.com");
    Sender emailSender = new EmailSender();
    emailSender.send(emailMessage, emailRecipient);
    logger.info("email zostal wyslany");
  }
}
