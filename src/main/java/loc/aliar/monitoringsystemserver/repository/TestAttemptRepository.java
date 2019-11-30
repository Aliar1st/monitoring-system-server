package loc.aliar.monitoringsystemserver.repository;

import loc.aliar.monitoringsystemserver.domain.test.TestAttempt;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
public interface TestAttemptRepository extends JpaRepository<TestAttempt, Long> {
    @EntityGraph(TestAttempt.EG_TEST)
    List<TestAttempt> getAllByTargetUserIdAndTestVisibleTrueOrderByCreatedDateDesc(Long targetUserId);

    //    @Query(value = "with last_test_attempts as ( " +
//            "    select ta.created_date, t.name, " +
//            "           row_number() over (partition by t.id " +
//            "               order by ta.created_date desc) as rk " +
//            "    from test_attempt ta " +
//            "             join test t on ta.test_id = t.id " +
//            "    where ta.target_user_id = :targetUserId " +
//            ") " +
//            "select  " +
//            "       lta.name, " +
//            "       lta.created_date " +
//            "from last_test_attempts lta " +
//            "where rk = 1 " +
//            "order by lta.created_date desc", nativeQuery = true)
    @EntityGraph(TestAttempt.EG_TEST)
    Optional<TestAttempt> getFirstByTestIdAndTargetUserIdAndTestVisibleTrueOrderByCreatedDateDesc(Long testId, Long targetUserId);

    @Override
    @EntityGraph(TestAttempt.EG_ALL)
    Optional<TestAttempt> findById(Long aLong);
}
