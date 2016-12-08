package cavalli.service.Competition;

import cavalli.entity.Competition.Competition;
import cavalli.exception.Competition.CompetitionNotFoundException;

import java.util.List;

/**
 * Created by Ola on 08.12.2016.
 */
public interface CompetitionService {

    Competition create(Competition competition);
    Competition delete(int id) throws CompetitionNotFoundException;
    List<Competition> findAll();
    Competition update(Competition competition) throws CompetitionNotFoundException;
    Competition findById(int id);
}
