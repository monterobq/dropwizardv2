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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ListMsg)) return false;

        ListMsg listMsg = (ListMsg) o;

        if (nextSeq != listMsg.nextSeq) return false;
        if (!messages.equals(listMsg.messages)) return false;

        return true;
    }

}
