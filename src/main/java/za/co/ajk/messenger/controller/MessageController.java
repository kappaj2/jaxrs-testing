package za.co.ajk.messenger.controller;

import za.co.ajk.messenger.model.Message;
import za.co.ajk.messenger.service.MessageService;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/messages")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MessageController {

    private static MessageService messageService = new MessageService();

    @GET
    public List<Message> getMessages(@QueryParam("year")int year,
                                     @QueryParam("start")int start,
                                     @QueryParam("size")int size) {
        if(year > 0) {
            return messageService.getAllMessageForYear(year);
        }
        if (start > 0 && size > 0){
            return messageService.getAllMessagesPaginated(start, size);
        }
        return messageService.getAllMessage();
    }


    @GET
    @Path("/{messageId}")
    public Message getMessage(@PathParam("messageId") Long messageId) {
        return messageService.getMessage(messageId);
    }

    @POST
    public Message createMessage(Message message) {
        return messageService.addMessage(message);
    }

    @PUT
    @Path("/{messageId}")
    public Message updateMessage(@PathParam("messageId") long messageId, Message message) {
        message.setId(messageId);
        return messageService.updateMessage(message);
    }

    @DELETE
    @Path("/{messageId}")
    public void deleteMessage(@PathParam("messageId") long messageId) {
        messageService.deleteMessage(messageId);
    }

}
