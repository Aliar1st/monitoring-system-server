package loc.aliar.monitoringsystemserver.model;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MessageUserModel {
    private Long id;
    private Boolean isRead;
    private String body;
    private Long fromUserId;
    private String fromUserFirstName;
    private String fromUserLastName;
}
