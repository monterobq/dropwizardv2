package eu.kielczewski.example.dropwizard.hello;

import com.google.common.base.Optional;
import eu.kielczewski.example.dropwizard.model.ListMsg;
import eu.kielczewski.example.dropwizard.model.Message;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by montero on 11/12/13.
 */
@Path("/api/chat")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MessageResource {
    ListMsg messageList=new ListMsg(0,null);


    public MessageResource() {

    }


    @GET
    public ListMsg getMsg(@QueryParam("next_seq") Optional<String> next_seq) {
        ListMsg lm=this.messageList;
        if(lm.getLast_seq()<=(Integer.parseInt(next_seq.get()))){
            Message m=new Message("","");
            List <Message> messageList=null;
            messageList.add(m);
            ListMsg aux=new ListMsg(lm.getLast_seq(),messageList);
            return lm;
        }else if (next_seq!=null){
            ListMsg aux=new ListMsg(lm.getLast_seq(),lm.getMessages().subList((Integer.parseInt(next_seq.get())),lm.getMessages().size()));
            return aux;
        } else
            return lm;




    }


    @POST
    public Response newMsg(Message msg) {
        ListMsg lm=this.messageList;
        try {
            lm.getMessages().add(msg);
            lm.setLast_seq(lm.getMessages().size());
            return Response.status(200).build();
        } catch (Exception e) {
            return Response.status(400).build();
        }






    }
}
