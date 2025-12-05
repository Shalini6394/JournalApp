package in.thelearnify.JournalApp.Controller;

import in.thelearnify.JournalApp.Entity.JournalEntry;
import in.thelearnify.JournalApp.Entity.User;
import in.thelearnify.JournalApp.Repository.UserRepo;
import in.thelearnify.JournalApp.Service.JournalEntryService;
import in.thelearnify.JournalApp.Service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepo userRepo;
    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAll();
    }
    @PostMapping
    public void createUser(@RequestBody User user){
        userService.createNewUser(user);
    }

    @PutMapping
    public ResponseEntity<?> updateUser(@RequestBody User user){
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        String userName=authentication.getName();
        User userInDB = userService.findByUserName(userName);
        userInDB.setUserName(user.getUserName());
        userInDB.setPassword(user.getPassword());
        userService.createNewUser(userInDB);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @DeleteMapping
    public ResponseEntity<?> deleteUserById(){
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        String userName=authentication.getName();
        userRepo.deleteByUserName(userName);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
