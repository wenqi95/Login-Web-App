package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
public class UserService implements UserDetailsService {
    @Autowired // This means to get the bean called userRepository
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        // query username from database
        SystemUser systemUser = userRepository.findByUserName(s);
        if (systemUser == null) {
            throw new UsernameNotFoundException("username is not exists");
        }
            System.out.println("username is : " + systemUser.getUsername() + ", password is :" + systemUser.getPassword());
            return systemUser;
        }
}
