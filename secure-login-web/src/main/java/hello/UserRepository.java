package hello;

import org.springframework.data.repository.CrudRepository;
import hello.SystemUser;

public interface UserRepository extends CrudRepository<SystemUser, Long> {
    SystemUser findByUserName(String username);
}