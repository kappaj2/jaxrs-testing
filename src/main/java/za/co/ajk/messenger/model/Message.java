package za.co.ajk.messenger.model;


import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@XmlRootElement(name = "message")
public class Message {

    private long id;
    private String message;
    private Date created = new Date();
    private String author;
    private Map<Long, Comment> commentMap = new HashMap<>();

    public Message() {
    }

    public Message(long id, String message, String author) {
        this.id = id;
        this.message = message;
        this.author = author;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @XmlTransient   // dont show comment data when message is converted.
    public Map<Long, Comment> getCommentMap() {
        return commentMap;
    }

    public void setCommentMap(Map<Long, Comment> commentMap) {
        this.commentMap = commentMap;
    }
}
