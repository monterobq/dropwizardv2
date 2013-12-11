package eu.kielczewski.example.dropwizard.model;

import java.util.List;

/**
 * Created by montero on 11/12/13.
 */
public class ListMsg {
    int last_seq;
    List<Message> messages;

    public ListMsg(int last_seq, List<Message> messages) {
        this.last_seq = last_seq;
        this.messages = messages;
    }

    public int getLast_seq() {
        return last_seq;
    }

    public void setLast_seq(int last_seq) {
        this.last_seq = last_seq;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
}
