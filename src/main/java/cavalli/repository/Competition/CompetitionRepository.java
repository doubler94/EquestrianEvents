package cavalli.repository.Competition;

import cavalli.entity.Competition.Competition;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Ola on 08.12.2016.
 */
public interface CompetitionRepository extends JpaRepository<Competition, Integer> {
}
