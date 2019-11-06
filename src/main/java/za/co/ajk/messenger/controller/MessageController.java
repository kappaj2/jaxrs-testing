package za.co.ajk.messenger.controller;

import za.co.ajk.messenger.model.Message;
import za.co.ajk.messenger.service.MessageService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/messages")
public class MessageController {

    private MessageService messageService = new MessageService();

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Message> getMessages(){
        return messageService.getAllMessage();
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
