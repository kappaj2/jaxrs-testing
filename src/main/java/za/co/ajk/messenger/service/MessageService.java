package za.co.ajk.messenger.service;

import za.co.ajk.messenger.exceptions.DataNotFoundException;
import za.co.ajk.messenger.model.DatabaseSim;
import za.co.ajk.messenger.model.ErrorMessage;
import za.co.ajk.messenger.model.Message;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MessageService {

    private Map<Long, Message> messages = DatabaseSim.getMessages();

    public MessageService() {
        messages.put(1L, new Message(1, "Hello World", "Andre"));
        messages.put(2L, new Message(2, "Hello Jersey", "Andre"));
        messages.put(3L, new Message(3, "Hello Jaxb", "Andre"));
    }

    public List<Message> getAllMessage() {
        return new ArrayList<>(messages.values());
    }

    int getYear(Message message) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(message.getCreated());
        return cal.get(Calendar.YEAR);
    }

    public List<Message> getAllMessageForYear(int year) {
        return messages.values().stream()
                .filter(message1 -> getYear(message1) == year)
                .collect(Collectors.toList());
    }

    public List<Message> getAllMessagesPaginated(int start, int size) {

        List<Message> list = new ArrayList<>(messages.values());
        if (start + size > list.size()) {
            return new ArrayList<>();
        }
        return list.subList(start, start + size);
    }

    public Message getMessage(long id) {
        if (!messages.containsKey(id)) {
            //  Two options - customer mapper or WebApplicationException
            //  WebApplicationException is now bleeding into the business layer...not clean!
            //
            ErrorMessage errorMessage = new ErrorMessage("Not Found", 404, null);
            Response response = Response.status(Response.Status.NOT_FOUND)
                    .entity(errorMessage)
                    .build();
                throw new WebApplicationException(response);
//            throw new DataNotFoundException("Message with id " + id + " not found");
        }
        return messages.get(id);
    }

    public Message addMessage(Message message) {
        message.setId(messages.size() + 1);
        messages.put(message.getId(), message);
        return message;
    }

    public Message updateMessage(Message message) {
        if (message.getId() <= 0) {
            return null;
        }
        messages.put(message.getId(), message);
        return message;
    }

    public Message deleteMessage(long id) {
        return messages.remove(id);
    }

}
