package cavali.service.Rider;

import cavali.entity.Rider.Rider;
import cavali.exception.Rider.RiderNotFoundException;
import cavali.repository.Rider.RiderRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Ola on 05.11.2016.
 */
@Service
public class RiderServiceImpl implements RiderService {

    @Resource
    RiderRepository riderRepository;

    @Override
    public Rider create(Rider rider) {
        Rider createdRider = rider;
        return riderRepository.save(createdRider);
    }

    @Override
    @Transactional(rollbackOn = RiderNotFoundException.class)
    public Rider delete(int id) throws RiderNotFoundException {
        Rider deletedRider = riderRepository.findOne(id);

        if(deletedRider==null)
            throw new RiderNotFoundException();

        riderRepository.delete(deletedRider);
        return deletedRider;
    }

    @Override
    @Transactional
    public List<Rider> findAll() {
        return riderRepository.findAll();
    }

    @Override
    @Transactional(rollbackOn = RiderNotFoundException.class)
    public Rider update(Rider rider) throws RiderNotFoundException {
        Rider updatedRider = riderRepository.findOne(rider.getId());

        if(updatedRider==null)
            throw new RiderNotFoundException();

        updatedRider.setLastName(rider.getLastName());
        updatedRider.setEmail(rider.getEmail());
        updatedRider.setPhone(rider.getPhone());
        return updatedRider;
    }

    @Override
    @Transactional
    public Rider findById(int id) {
        return riderRepository.findOne(id);
    }

}
