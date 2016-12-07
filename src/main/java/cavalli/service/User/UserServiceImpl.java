package cavalli.service.User;

import cavalli.entity.User.User;
import cavalli.exception.User.UserNotFoundException;
import cavalli.repository.User.UserRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Ola on 05.11.2016.
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserRepository userRepository;

    @Override
    @Transactional
    public User create(User user) {
        User createdUser = user;
        return userRepository.save(createdUser);
    }

    @Override
    @Transactional(rollbackOn = UserNotFoundException.class)
    public User delete(int id) throws UserNotFoundException {
        User deletedUser = userRepository.findOne(id);

        if(deletedUser==null)
            throw new UserNotFoundException();

        userRepository.delete(deletedUser);
        return deletedUser;
    }

    @Override
    @Transactional
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    @Transactional(rollbackOn = UserNotFoundException.class)
    public User update(User user) throws UserNotFoundException {
        User updatedUser = userRepository.findOne(user.getId());

        if(updatedUser==null)
            throw new UserNotFoundException();

        updatedUser.setPassword(user.getPassword());
        updatedUser.setRole(user.getRole());
        return updatedUser;
    }

    @Override
    @Transactional
    public User findByid(int id) {
        return userRepository.findOne(id);
    }

    @Override
    public User findBylogin(String username) {
        return userRepository.findBylogin(username);
    }

}
