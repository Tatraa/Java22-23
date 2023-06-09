package pl.edu.uj.sender;

public class EmailMessage extends Message {

  private final String messageTitle;
  private final String messageBody;

  public EmailMessage(String messageTitle, String messageBody) {
    this.messageTitle = messageTitle;
    this.messageBody = messageBody;
  }

  @Override
  public String getMessageTitle() {
    return messageTitle;
  }

  @Override
  public String getMessageBody() {
    return messageBody;
  }

  // TODO zaimplementuj validateMessage()
  //  Sprawdź, czy messageTitle i messageBody
  //  są poprawne, np. nie puste. Możesz użyć np StringUtils.isEmpty(...)
  //  W przypadku błędu, rzuć wyjątkiem.

  @Override
  void validateMessage() throws SenderException {

  }
}
