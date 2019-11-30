package loc.aliar.monitoringsystemserver.model;

import loc.aliar.monitoringsystemserver.repository.UserRepository;
import loc.aliar.monitoringsystemserver.validation.annotation.Exists;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MessageModel {
    private Long id;
    private Boolean isRead;

    @NotEmpty
    private String body;

    private Long fromUserId;

    @NotNull
    @Exists(UserRepository.class)
    private Long toUserId;
}
