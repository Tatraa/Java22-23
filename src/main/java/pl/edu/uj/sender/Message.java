package pl.edu.uj.sender;

public abstract class Message {

    abstract String getMessageTitle();

    abstract String getMessageBody();

    abstract void validateMessage() throws SenderException;

    String anonymizeMessageBody() {
        return org.apache.commons.codec.digest.DigestUtils.md5Hex(getMessageBody());
    }
}
