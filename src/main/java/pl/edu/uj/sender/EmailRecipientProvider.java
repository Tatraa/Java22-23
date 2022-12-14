package pl.edu.uj.sender;

import java.util.Random;

public class EmailRecipientProvider extends RecipientProvider {

    Random random = new Random();

    @Override
    public Recipient getNextRecipient() {
        String[] recipients = {"jan.kowalski@wp.pl", "mmozo@gmail.com"};
        int index = random.nextInt(recipients.length);
        return new EmailRecipient(recipients[index]);
    }
}
