package server.kata.montero.model;

/**
 * Created by montero on 11/12/13.
 */
public class Message {

    private String nick;
    private String message;

    private Message(){}

    public Message(String nick, String message) {
        this.nick = nick;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Message)) return false;

        Message message1 = (Message) o;

        if (!message.equals(message1.message)) return false;
        if (!nick.equals(message1.nick)) return false;

        return true;
    }


}
