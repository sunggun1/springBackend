package web.demo.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import web.demo.model.UserEntity;
import web.demo.repository.UserRepository;

@Slf4j
@Service
public class UserService {

    @Autowired private UserRepository userRepository;

    public UserEntity create(final UserEntity entity){
        if(entity == null || entity.getUsername() == null){
            throw new RuntimeException("Invalid arguments");
        }

        final String username = entity.getUsername();
        if(userRepository.existsByUsername(username)){
            log.warn("Username already exists{}", username);
            throw new RuntimeException("Username already exists");
        }

        return userRepository.save(entity);
    }

    public UserEntity getByCredentials(final String username, final String password, PasswordEncoder encoder){
        final UserEntity originalUser = userRepository.findByUsername(username);

        if(originalUser != null && encoder.matches(password, originalUser.getPassword())){
            return originalUser;
        }
        return null;
    }
}
