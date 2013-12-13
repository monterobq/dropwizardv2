package server.kata.montero.hello;

import com.google.common.base.Optional;
import server.kata.montero.model.ListMsg;
import server.kata.montero.model.Message;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

/**
 * Created by montero on 11/12/13.
 */
@Path("chat-kata/api/chat")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MessageResource {
    ListMsg messageList;


    public MessageResource() {
           messageList=new ListMsg(0,new ArrayList<Message>());

    }


    @GET
    public ListMsg getMsg(@QueryParam("next_seq") Optional<String> next_seq) {
        if(next_seq.equals(Optional.absent())){
            return messageList;

        }else {
            try {
                Integer.parseInt(next_seq.get());
            } catch (NumberFormatException e) {
                ListMsg aux=new ListMsg(0,new ArrayList<Message>());
                aux.getMessages().add(new Message("error","invalid seq parameter"));
                return aux;
            }
            if(Integer.parseInt(next_seq.get())<0){
                ListMsg aux=new ListMsg(0,new ArrayList<Message>());
                aux.getMessages().add(new Message("error","invalid seq parameter, mustn't be negative"));
                return aux;

            }else if(messageList.getNextSeq()<=(Integer.parseInt(next_seq.get()))){
                Message m=new Message("","");
                ArrayList <Message> messageList2=new ArrayList<Message>();
                messageList2.add(m);
                ListMsg aux=new ListMsg(messageList.getNextSeq(),messageList2);
                return aux;
            }else if (next_seq!=null){
                ListMsg aux=new ListMsg(messageList.getNextSeq(),subList(next_seq));
                return aux;
            } else
                return messageList;
        }


    }

    private ArrayList<Message> subList(Optional<String> next_seq) {
        ArrayList<Message> aux=new ArrayList<Message>();
        int seq=Integer.parseInt(next_seq.get());
        for(;seq<messageList.getMessages().size();seq++){
              aux.add(messageList.getMessages().get(seq));
              }

        return aux;
    }




    @POST
    public Response add(Message msg) {
        if(msg.getMessage()=="" || msg.getNick()=="" || msg==null)
            return Response.status(400).build();

        else{

        try {
            messageList.getMessages().add(msg);
            messageList.setNextSeq(messageList.getMessages().size());
            return Response.status(200).build();
        } catch (Exception e) {
            return Response.status(400).build();
        }
        }

    }
}
