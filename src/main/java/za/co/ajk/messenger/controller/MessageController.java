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
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@Path("/messages")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MessageController {

    private static MessageService messageService = new MessageService();

    @GET
    public List<Message> getMessages(@QueryParam("year") int year,
                                     @QueryParam("start") int start,
                                     @QueryParam("size") int size) {
        if (year > 0) {
            return messageService.getAllMessageForYear(year);
        }
        if (start > 0 && size > 0) {
            return messageService.getAllMessagesPaginated(start, size);
        }
        return messageService.getAllMessage();
    }

    /*
        @GET
    public List<Message> getMessages(@BeanParam MessageFilterBean messageFilterBean) {
        if (messageFilterBean.getYear() > 0) {
            return messageService.getAllMessageForYear(messageFilterBean.getYear());
        }
        if (messageFilterBean.getStart() > 0 && messageFilterBean.getSize() > 0) {
            return messageService.getAllMessagesPaginated(messageFilterBean.getStart(), messageFilterBean.getSize());
        }
        return messageService.getAllMessage();
    }
     */

    @GET
    @Path("/{messageId}")
    public Message getMessage(@PathParam("messageId") Long messageId) {
        return messageService.getMessage(messageId);
    }

    @POST
    public Response createMessage(Message message, @Context UriInfo uriInfo) {

//        return Response.status(Response.Status.CREATED)
//                .entity(messageService.addMessage(message))
//                .build();

        Message newMessage = messageService.addMessage(message);

        URI uri = uriInfo.getAbsolutePathBuilder()
                .path(String.valueOf(newMessage.getId()))
                .build();

        return Response.created(uri)    // created will set code to 201 and add uri value to header
                .entity(messageService.addMessage(message))
                .build();

//        return messageService.addMessage(message);
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

    // now do the rest endpoint for message -> /message/{messageId}/comments/{commentId}


    @Path("/{messageId}/comments")
    public CommentController getCommentsController() {
        return new CommentController();
    }

}


