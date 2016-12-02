package cavali.repository.User;

import cavali.entity.User.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Ola on 05.11.2016.
 */
public interface UserRepository extends JpaRepository<User,Integer> {

    User findBylogin(String username);
}
