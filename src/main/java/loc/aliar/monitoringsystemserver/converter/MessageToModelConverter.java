package loc.aliar.monitoringsystemserver.converter;

import loc.aliar.monitoringsystemserver.domain.Message;
import loc.aliar.monitoringsystemserver.model.MessageModel;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class MessageToModelConverter implements Converter<Message, MessageModel> {
    @Override
    public MessageModel convert(Message source) {
        return MessageModel.builder()
                .body(source.getBody())
                .isRead(source.getIsRead())
                .build();
    }
}
