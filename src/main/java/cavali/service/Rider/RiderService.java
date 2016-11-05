package cavali.service.Rider;

import cavali.entity.Rider.Rider;
import cavali.exception.Rider.RiderNotFoundException;

import java.util.List;

/**
 * Created by Ola on 05.11.2016.
 */
public interface RiderService {

    Rider create(Rider rider);
    Rider delete(int id) throws RiderNotFoundException;
    List<Rider> findAll();
    Rider update(Rider rider) throws RiderNotFoundException;
    Rider findById(int id);
}
