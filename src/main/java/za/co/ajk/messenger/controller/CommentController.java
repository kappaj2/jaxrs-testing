package za.co.ajk.messenger.controller;

import za.co.ajk.messenger.model.Comment;
import za.co.ajk.messenger.service.CommentService;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Sub-resource demo
 *
 */
@Path("/")  // inferred from calling Controller class/method -> /messages/{}/comments
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CommentController {

    private CommentService commentService = new CommentService();

    @GET
    public List<Comment> getAllComments(@PathParam("messageId")long messageId){
        return commentService.getAllComments(messageId);
    }

    @POST
    public Comment addMessage(@PathParam("messageId")long messageId, Comment comment){
        return commentService.addComment(messageId, comment);
    }

    @PUT
    @Path("/{commentId}")
    public Comment updateMessage(@PathParam("messageId")long messageId, @PathParam("commentId")long commentId, Comment comment){
        comment.setId(commentId);
       return commentService.updateComment(messageId, comment);
    }
    //  messageId is available from the calling (parent)controller stack
    @GET
    @Path("/{commentId}")
    public String getComment(@PathParam("messageId")long messageId, @PathParam("commentId")long commentId){
        return "messageId : "+messageId+" with comment id : "+commentId;
    }

    @DELETE
    @Path("/{commentId}")
    public Comment deleteComment(@PathParam("messageId")long messageId, @PathParam("commentId")long commentId){
        return commentService.removeComment(messageId, commentId);
    }
}
