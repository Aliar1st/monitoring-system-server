package loc.aliar.monitoringsystemserver.service;

import loc.aliar.monitoringsystemserver.model.MessageModel;

import java.util.List;

public interface MessageService {
    List<MessageModel> get(Long userId);


    void read(Long userId);
}
