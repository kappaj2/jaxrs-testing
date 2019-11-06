package za.co.ajk.messenger.controller;

import jdk.nashorn.internal.objects.annotations.Getter;
import za.co.ajk.messenger.model.Message;
import za.co.ajk.messenger.service.MessageService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/messages")
public class MessageController {

    private MessageService messageService = new MessageService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Message> getMessages() {
        return messageService.getAllMessage();
    }

    @GET
    @Path("/{messageId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Message getMessage(@PathParam("messageId") Long messageId) {
        return messageService.getMessage(messageId);
    }


//    @GET
//    @Path("/getJSON")
//    @Produces({ MediaType.APPLICATION_JSON})
//    public List<Message> getMessagesJSON(){
//        return messageService.getAllMessage();
//    }

//    @GET
//    @Path("/getXML")
//    @Produces(MediaType.APPLICATION_XML)
//    public List<Message> getMessagesXML(){
//        return messageService.getAllMessage();
////        return Response.ok(messageService.getAllMessage()).build();
//    }
}
