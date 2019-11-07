package za.co.ajk.messenger.service;

import za.co.ajk.messenger.model.Comment;
import za.co.ajk.messenger.model.DatabaseSim;
import za.co.ajk.messenger.model.Message;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CommentService {

    private Map<Long, Message> messageMap = DatabaseSim.getMessages();

    public List<Comment> getAllComments(Long messageId) {
        Map<Long, Comment> commentMap = messageMap.get(messageId).getCommentMap();
        return new ArrayList<>(commentMap.values());
    }

    public Comment getComment(long messageId, long commentId) {
        Map<Long, Comment> commentMap = messageMap.get(messageId).getCommentMap();
        return commentMap.get(commentId);
    }

    public Comment addComment(long messageId, Comment comment) {
        Map<Long, Comment> commentMap = messageMap.get(messageId).getCommentMap();
        comment.setId(commentMap.size() + 1);
        commentMap.putIfAbsent(comment.getId(), comment);
        return comment;
    }

    public Comment updateComment(long messageId, Comment comment) {
        Map<Long, Comment> commentMap = messageMap.get(messageId).getCommentMap();
        if (comment.getId() <= 0) {
            return null;
        }
        commentMap.put(comment.getId(), comment);
        return comment;
    }

    public Comment removeComment(long messageId, long commentId) {
        Map<Long, Comment> commentMap = messageMap.get(messageId).getCommentMap();
        return commentMap.remove(commentId);
    }
}
