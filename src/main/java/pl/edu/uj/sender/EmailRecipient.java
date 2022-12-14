package pl.edu.uj.sender;

public class EmailRecipient extends Recipient {

  private final String recipientAddress;


  public EmailRecipient(String recipientAddress) {
    this.recipientAddress = recipientAddress;
  }

  public String getRecipientAddress() {
    return recipientAddress;
  }

  // TODO zaimplementuj validateRecipient() do sprawdzania poprawności adresu email
  //  (czyli np czy jest jednokrotny symbol @).
  //  W przypadku błędu, rzuć wyjątkiem.


  @Override
  void validateRecipient() throws SenderException {

  }

  @Override
  String anonymize() {
    String[] split = recipientAddress.split("@");
    StringBuilder sb = new StringBuilder();

    for(int i = 0; i < split[0].length(); i++) {
      if(i < split[0].length() - 1)
        sb.append("*");
      else sb.append(split[0].charAt(i));
    }
    return sb + "@" + split[1];
  }
}
