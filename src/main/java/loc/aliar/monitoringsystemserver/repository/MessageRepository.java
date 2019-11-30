package loc.aliar.monitoringsystemserver.repository;

import loc.aliar.monitoringsystemserver.domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(readOnly = true)
public interface MessageRepository extends JpaRepository<Message, Long> {
    @Query(value = "with last_messages as ( " +
            "    select m.*, " +
            "           row_number() over (partition by " +
            "               (case when m.from_user_id = :userId then m.to_user_id else m.from_user_id end) " +
            "               order by m.created_date desc) as rk " +
            "      from message m " +
            "     where m.from_user_id = :userId " +
            "        or m.to_user_id = :userId " +
            ") " +
            "select " +
            "       u.first_name as fromUser_firstName, " +
            "       u.last_name as fromUser_lastName, " +
            "       lm.body as body, " +
            "       lm.is_read as isRead, " +
            "       lm.created_date as createdDate" +
            "  from last_messages lm " +
            "  join usr u on lm.from_user_id = u.id " +
            " where rk = 1 " +
            " order by lm.created_date desc", nativeQuery = true)
    List<Message> findFirstByUserId(Long userId);

    List<Message> findAllByFromUserIdOrToUserId(Long fromUserId, Long toUserId);

    long countAllByToUserIdAndIsReadFalse(Long toUserId);

    @Query("UPDATE Message m " +
            "   SET m.isRead = true " +
            " WHERE m.isRead = false " +
            "   AND m.fromUser.id = :fromUserId " +
            "   AND m.toUser.id = :toUserId")
    @Modifying
    void readMessages(Long fromUserId, Long toUserId);
}
