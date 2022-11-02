package pl.edu.uj.sender;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailRecipient extends Recipient {

  private final String recipientAddress;
  private static final Pattern EmailPattern = Pattern.compile("^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$", Pattern.CASE_INSENSITIVE);

  public EmailRecipient(String recipientAddress) {
    this.recipientAddress = recipientAddress;
  }

  public String getRecipientAddress() {
    return recipientAddress;
  }

  @Override
  void validateRecipient() throws SenderException {
    Matcher m = EmailPattern.matcher(recipientAddress);
    if(!m.find()){
      throw new SenderException("niepoprawny adres email!");
    }
  }

  @Override
  String anonymize() {
    int a = 0;
    char[] arr = recipientAddress.toCharArray();
    while (arr[a] != '@') {
      arr[a] = '*';
      a++;
    }
    return new String(arr);
  }
}
