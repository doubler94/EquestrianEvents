package cavali.service.User;

import cavali.entity.User.User;
import cavali.exception.User.UserNotFoundException;

import java.util.List;

/**
 * Created by Ola on 05.11.2016.
 */
public interface UserService {

    User create(User user);
    User delete(int id) throws UserNotFoundException;
    List<User> findAll();
    User update(User user) throws UserNotFoundException;
    User findByid(int id);
}
