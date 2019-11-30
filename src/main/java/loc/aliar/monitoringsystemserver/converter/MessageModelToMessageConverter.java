package loc.aliar.monitoringsystemserver.converter;

import loc.aliar.monitoringsystemserver.domain.Message;
import loc.aliar.monitoringsystemserver.model.MessageModel;
import loc.aliar.monitoringsystemserver.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MessageModelToMessageConverter implements Converter<MessageModel, Message> {
    private final UserRepository userRepository;

    @Override
    public Message convert(MessageModel source) {
        return Message.builder()
                .body(source.getBody())
                .isRead(source.getIsRead())
                .fromUser(userRepository.getOne(source.getFromUserId()))
                .toUser(userRepository.getOne(source.getToUserId()))
                .build();
    }
}
