package cavalli.service.Competition;

import cavalli.entity.Competition.Competition;
import cavalli.exception.Competition.CompetitionNotFoundException;
import cavalli.repository.Competition.CompetitionRepository;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Ola on 08.12.2016.
 */
@Service
public class CompetitionServiceImpl implements CompetitionService {

    @Resource
    CompetitionRepository competitionRepository;

    @Override
    public Competition create(Competition competition) {
        Competition createCompetition = competition;
        System.out.println("2"+competition.getGround());
        return competitionRepository.save(createCompetition);
    }

    @Override
    @Transactional(rollbackOn = CompetitionNotFoundException.class)
    public Competition delete(int id) throws CompetitionNotFoundException{
        Competition deleteCompetition = competitionRepository.findOne(id);
        if(deleteCompetition==null)
            throw new CompetitionNotFoundException();

        competitionRepository.delete(deleteCompetition);
        return deleteCompetition;
    }

    @Override
    public List<Competition> findAll() {
        return competitionRepository.findAll();
    }

    @Override
    public Competition findById(int id) {
        return competitionRepository.findOne(id);
    }

    @Override
    @Transactional(rollbackOn = CompetitionNotFoundException.class)
    public Competition update(Competition competition) throws CompetitionNotFoundException{
        Competition updateCompetition = competitionRepository.findOne(competition.getId());
        if(updateCompetition==null)
            throw new CompetitionNotFoundException();

        updateCompetition.setStartDate(competition.getStartDate());
        updateCompetition.setStopDate(competition.getStopDate());
        updateCompetition.setManagerTrack(competition.getManagerTrack());
        updateCompetition.setManager(competition.getManager());
        updateCompetition.setPlaceSize(competition.getPlaceSize());
        updateCompetition.setWarmUpSize(competition.getWarmUpSize());
        updateCompetition.setGround(competition.getGround());
        updateCompetition.setPrice(competition.getPrice());
        return updateCompetition;
    }


}
