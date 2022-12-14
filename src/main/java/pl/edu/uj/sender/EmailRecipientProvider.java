package pl.edu.uj.sender;

import java.util.Random;

public class EmailRecipientProvider extends RecipientProvider {

    Random random = new Random();

    @Override
    public Recipient getNextRecipient() {
        String alph = "ABCDEFGHIJKLMNOPRSTUWXYZ";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        int letterInMail = 15;

        for(int i = 0; i < letterInMail; i++) {
            int index = random.nextInt(alph.length());

            char randChar = alph.charAt(index);

            sb.append(randChar);
        }
        String randEmail = sb.toString() + "@gmail.com";
        return new EmailRecipient(randEmail);
    }
}
