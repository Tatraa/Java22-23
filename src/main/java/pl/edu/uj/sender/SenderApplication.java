package pl.edu.uj.sender;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SenderApplication {

  private static final int THREADS_COUNT = 4;
  static int messagesSent = 0;
  private static final Logger logger = LoggerFactory.getLogger(SenderApplication.class);

  public static void main(String[] args) throws InterruptedException {

    EmailSender emailSender = new EmailSender();
    MessageProvider messageProvider = new EmailMessageProvider();
    RecipientProvider recipientProvider = new EmailRecipientProvider();

    Runnable sendEmails =
        new Runnable() {
          @Override
          public void run() {
            // TODO implement code which in a safe way gets message, recipient and sends it
            Message message = messageProvider.getNextMessage();
            Recipient recipient = recipientProvider.getNextRecipient();

            try {
              emailSender.send(message, recipient);
            } catch (SenderException e) {
              throw new RuntimeException(e);
            }

            logger.info("Messege %s sent to %s".formatted(message, recipient));
            messagesSent++;
          }
        };

    Thread[] threads = new Thread[THREADS_COUNT];

    for (int i = 0; i < THREADS_COUNT; i++) {
      Thread t = new Thread(sendEmails);
      threads[i] = t;
      t.start();
    }

    for (int i = 0; i < THREADS_COUNT; i++) {
      threads[i].join();
    }

    logger.info("Total %d messages sent".formatted(messagesSent));  // TODO fix it so it will always show real number of messages sent
  }
}
