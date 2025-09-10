package bug_tracker_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bug_tracker_app.entity.Bug;

@Repository
public interface BugRepository extends JpaRepository<Bug, Long> {

}