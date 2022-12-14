package pl.edu.uj.sender;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SenderApplication {

  private static final int THREADS_COUNT = 4;

  static final int nextMessage = 100;
  static int messagesSent = 0;
  private static final Logger logger = LoggerFactory.getLogger(SenderApplication.class);
  private static java.lang.Runnable Runnable;

  static ExecutorService threadPool = Executors.newFixedThreadPool(THREADS_COUNT);

  public static void main(String[] args) throws InterruptedException {

    EmailSender emailSender = new EmailSender();
    MessageProvider messageProvider = new EmailMessageProvider();
    RecipientProvider recipientProvider = new EmailRecipientProvider();

    Runnable sendEmails =
          Runnable; sendEmails = new Runnable() {
            @Override
            public void run() {
              while (messagesSent != nextMessage) {
                Message message = messageProvider.getNextMessage();
                Recipient recipient = recipientProvider.getNextRecipient();

                threadPool.submit(new Runnable() {
                  @Override
                  public void run() {
                    try {
                      emailSender.send(message, recipient);
                      logger.info("Messege %s sent to %s".formatted(message, recipient));
                      messagesSent++;
                    } catch (SenderException e) {
                      throw new RuntimeException(e);
                    } catch (InterruptedException e) {
                      throw new RuntimeException(e);
                    }
                  }
                });
              }
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

    logger.info("Total %d messages sent".formatted(messagesSent));
    //mysle że działa to poprawnie
    System.exit(0);
  }
}
