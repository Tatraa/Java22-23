package pl.edu.uj.sender;

public interface Sender {

  String send(Message message, Recipient recipient) throws SenderException, InterruptedException;
}
