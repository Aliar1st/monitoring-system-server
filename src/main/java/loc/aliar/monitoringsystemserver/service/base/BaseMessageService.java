package loc.aliar.monitoringsystemserver.service.base;

import loc.aliar.monitoringsystemserver.domain.Message;
import loc.aliar.monitoringsystemserver.domain.User;
import loc.aliar.monitoringsystemserver.model.MessageModel;
import loc.aliar.monitoringsystemserver.repository.MessageRepository;
import loc.aliar.monitoringsystemserver.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BaseMessageService implements MessageService {
    private final MessageRepository repository;

//    @PostConstruct
//    public void test() throws InterruptedException {
//        for (Message m : Arrays.asList(
//                mm(1L, 2L), mm(1L, 3L), mm(1L, 2L), mm(1L, 3L), mm(1L, 4L),
//                mm(2L, 1L), mm(2L, 3L), mm(2L, 4L), mm(2L, 1L), mm(2L, 3L),
//                mm(3L, 1L), mm(3L, 2L), mm(3L, 1L), mm(3L, 4L), mm(3L, 2L)
//        )) {
//            repository.saveAndFlush(m);
//            Thread.sleep(100);
//        }

//        List<Message> firstByUserId = repository.findFirstByUserId(1L);
//    }

    private Message mm(Long to, Long from) {
        Message m = new Message();
        User fromu = new User();
        fromu.setId(from);
        m.setFromUser(fromu);
        User tou = new User();
        fromu.setId(to);
        m.setToUser(tou);
        m.setIsRead(false);
        m.setBody(from + " - " + to);
        return m;
    }

    @Override
    public List<MessageModel> get(Long userId) {
        return null;
    }

    @Override
    public void read(Long userId) {

    }
}
