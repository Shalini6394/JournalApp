package in.thelearnify.JournalApp.Service;

import in.thelearnify.JournalApp.Entity.JournalEntry;
import in.thelearnify.JournalApp.Entity.User;
import in.thelearnify.JournalApp.Repository.JournalEntryRepo;
import in.thelearnify.JournalApp.Repository.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
@Slf4j
public class UserService {
    @Autowired
    private UserRepo userRepo;
    private static final PasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
//    public void createNewUser(User user){
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        user.setRoles(Arrays.asList("USER"));
//        userRepo.save(user);
//    }
    public boolean createNewUser(User user){
        try{
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setRoles(List.of("USER"));
            userRepo.save(user);
            return true;
        }
        catch (Exception ex){
            log.info("hahaahahahahahaah");
            log.warn("hahaahahahahahaah");
            log.debug("hahaahahahahahaah");
            log.error("hahaahahahahahaah");
            return false;
        }

    }
    public void createUser(User user){
        userRepo.save(user);
    }

    public List<User> getAll(){
        return userRepo.findAll();
    }

    public Optional<User> findById(ObjectId Id){
        return userRepo.findById(Id);
    }

    public void deleteById(ObjectId Id){
        userRepo.deleteById(Id);
    }
    public User findByUserName(String username){
        return userRepo.findByUserName(username);
    }
}
