package pl.edu.uj.sender;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class PushRecipient extends Recipient {
  private final String recipientAddress;
  private static final Pattern AdressPattern = Pattern.compile("^[a-zA-Z0-9]*$", Pattern.CASE_INSENSITIVE);


  public PushRecipient(String recipientAddress) {
    this.recipientAddress = recipientAddress;
  }

  @Override
  public String getRecipientAddress() {
    return recipientAddress;
  }

  @Override
  void validateRecipient() throws SenderException {
    Matcher m = AdressPattern.matcher(recipientAddress);
    if(!m.find()) {
      throw new SenderException("push recipent zawiera nieprawidlowe znaki!");
    }
    if(recipientAddress.length() > 32) {
      throw new SenderException("push recipent za długi!");
    }
  }

  @Override
  String anonymize() {
    String anonymizedRecipientAddress;
    if(recipientAddress.length() > 5) {
      char[] arr = recipientAddress.toCharArray();
      for(int i = 0; i < recipientAddress.length() - 5; i++) {
        arr[i] = '*';
      }
      anonymizedRecipientAddress = new String(arr);
    } else {
      anonymizedRecipientAddress = new String(new char[recipientAddress.length()]).replace('\0', '*');
    }
    return anonymizedRecipientAddress;
  }
}
