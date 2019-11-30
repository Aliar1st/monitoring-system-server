package loc.aliar.monitoringsystemserver.repository;

import loc.aliar.monitoringsystemserver.domain.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional(readOnly = true)
public interface UserRepository extends JpaRepository<User, Long> {
    Boolean existsByUsername(String username);

    Boolean existsByUsernameAndIdNot(String username, Long excludeId);

    @Modifying
    @Query("UPDATE User u " +
            "SET u.password = :newPassword " +
            "WHERE u.id = :id")
    void updatePassword(Long id, String newPassword);

    @EntityGraph(attributePaths = "departments")
    Optional<User> getByUsername(String username);

    @Override
    @Transactional
    @EntityGraph(attributePaths = "departments")
    Optional<User> findById(Long aLong);
}
