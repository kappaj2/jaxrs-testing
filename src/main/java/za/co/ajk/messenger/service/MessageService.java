package za.co.ajk.messenger.service;

import za.co.ajk.messenger.model.Message;

import java.util.ArrayList;
import java.util.List;

public class MessageService {

    public List<Message> getAllMessage(){
        List<Message> messagesList = new ArrayList<>();

        Message m1 = new Message(1L, "Hellow World1","Andre");
        Message m2 = new Message(2L, "Hellow Jersey","Andre");

        messagesList.add(m1);
        messagesList.add(m2);

        return messagesList;
    }
}
