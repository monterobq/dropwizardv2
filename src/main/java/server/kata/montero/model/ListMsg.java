package server.kata.montero.model;

import java.util.ArrayList;

/**
 * Created by montero on 11/12/13.
 */
public class ListMsg {
    int nextSeq;
    ArrayList<Message> messages;

    private ListMsg(){}

    public ListMsg(int last_seq, ArrayList<Message> messages) {
        this.nextSeq = last_seq;
        this.messages = messages;
    }

    public int getNextSeq() {
        return nextSeq;
    }

    public void setNextSeq(int last_seq) {
        this.nextSeq = last_seq;
    }

    public ArrayList<Message> getMessages() {
        return messages;
    }

    public void setMessages(ArrayList<Message> messages) {
        this.messages = messages;
    }
}
