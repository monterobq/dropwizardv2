package eu.kielczewski.example.dropwizard.model;

/**
 * Created by montero on 11/12/13.
 */
public class Message {

    String nick;
    String message;

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
}
