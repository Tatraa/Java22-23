package pl.edu.uj.textindexer.service;

import org.springframework.stereotype.Service;
import pl.edu.uj.sender.*;

@Service("sendService")
public class SenderService {
    public String sendEmail(String email, String title, String message1) throws SenderException, InterruptedException {
        Sender sender = new EmailSender();
        Message message = new EmailMessage(title, message1);
        Recipient recipient = new EmailRecipient(email);
        return sender.send(message, recipient);
    }

    public String sendPush(String push, String title, String message1) throws SenderException, InterruptedException {
        Sender sender = new PushSender();
        Message message = new PushMessage(title, message1);
        Recipient recipient = new PushRecipient(push);
        return sender.send(message, recipient);
    }
}
