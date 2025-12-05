package in.thelearnify.JournalApp.Controller;

import in.thelearnify.JournalApp.Entity.User;
import in.thelearnify.JournalApp.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public")
public class PublicController {
    @Autowired
    private UserService userService;
    @GetMapping("health-check")
    public String healthCheck(){
        return "Healthy";
    }

    @PostMapping("/create-user")
    public void createUser(@RequestBody User user){
        userService.createNewUser(user);
    }


}
