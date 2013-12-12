package server.kata.montero.hello;

import com.yammer.dropwizard.testing.ResourceTest;
import org.junit.Test;
import server.kata.montero.model.ListMsg;
import server.kata.montero.model.Message;

import javax.ws.rs.core.Response;

import static com.yammer.dropwizard.testing.JsonHelpers.*;

import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Created by montero on 12/12/13.
 */
public class MessageResourceTest {

    @Test
    public void testAddNewMessage() throws Exception {
        ListMsg messageList;
        Message msg;
        msg=new Message("","");
        messageList=new ListMsg(0,new ArrayList<Message>());
        msg.setMessage("Blas");
        msg.setNick("What happends?");
        messageList.getMessages().add(msg);
        assertEquals(msg,messageList.getMessages().get(0));


    }

    @Test
    public void testGetSublist() throws Exception {
        ListMsg messageList;
        int seq;
        Message msg;
        msg=new Message("","");
        messageList=new ListMsg(0,new ArrayList<Message>());
        seq=1;
        msg.setMessage("Blas");
        msg.setNick("What happends?");
        messageList.getMessages().add(msg);
        msg.setMessage("Matt");
        msg.setNick("Nothing.. Why?");
        messageList.getMessages().add(msg);
        msg.setMessage("Mary");
        msg.setNick("See you guys");
        messageList.getMessages().add(msg);

        messageList.setNextSeq(messageList.getMessages().size());


        ArrayList<Message> aux=new ArrayList<Message>();
        for(;seq<messageList.getMessages().size();seq++){
            aux.add(messageList.getMessages().get(seq));
        }
        assertEquals(aux.get(1).getMessage(), messageList.getMessages().get(2).getMessage());
    }

    @Test
    public void testGetSublist2() throws Exception {
        ListMsg messageList;
        int seq;
        Message msg;
        msg=new Message("","");
        messageList=new ListMsg(0,new ArrayList<Message>());
        seq=1;
        msg.setMessage("Blas");
        msg.setNick("What happends?");
        messageList.getMessages().add(msg);
        msg.setMessage("Matt");
        msg.setNick("Nothing.. Why?");
        messageList.getMessages().add(msg);
        msg.setMessage("Mary");
        msg.setNick("See you guys");
        messageList.getMessages().add(msg);

        messageList.setNextSeq(messageList.getMessages().size());


        ArrayList<Message> aux=new ArrayList<Message>();
        for(;seq<messageList.getMessages().size();seq++){
            aux.add(messageList.getMessages().get(seq));
        }
        assertEquals(aux.get(1).getNick(), messageList.getMessages().get(2).getNick());
    }

    @Test
    public void serializesToJSON() throws Exception {
        ListMsg listMsg = new ListMsg(6,new ArrayList<Message>());
        Message message=new Message("user1","hi there");
        listMsg.getMessages().add(message);
        message=new Message("user2","hola");
        listMsg.getMessages().add(message);
        assertThat("a listMsg can be serialized to JSON",
                asJson(listMsg),
                is(equalTo(jsonFixture("fixtures/ListMsg.json"))));
    }

    @Test
    public void deserializesFromJSON() throws Exception {
        ListMsg listMsg = new ListMsg(6,new ArrayList<Message>());
        Message message=new Message("user1","hi there");
        listMsg.getMessages().add(message);
        message=new Message("user2","hola");
        listMsg.getMessages().add(message);
        assertThat("a listMsg can be deserialized from JSON",
                fromJson(jsonFixture("fixtures/ListMsg.json"), ListMsg.class),
                is(equalTo(listMsg)));
    }

    @Test
    public void testGoodResponse() throws Exception {
        Message message=new Message("user1","hi there");
        int response = new MessageResource().add(message).getStatus();
        assertEquals(Response.status(200).build().getStatus(),response);
    }

    @Test
    public void testBadResponse1() throws Exception {
        Message message=new Message("user1","");
        int response = new MessageResource().add(message).getStatus();
        assertEquals(Response.status(400).build().getStatus(),response);
    }

    @Test
    public void testBadResponse2() throws Exception {
        Message message=new Message("","hi hi hi");
        int response = new MessageResource().add(message).getStatus();
        assertEquals(Response.status(400).build().getStatus(),response);
    }
    public void testBadResponse3() throws Exception {
        Message message=null;
        int response = new MessageResource().add(message).getStatus();
        assertEquals(Response.status(400).build().getStatus(),response);
    }

}
