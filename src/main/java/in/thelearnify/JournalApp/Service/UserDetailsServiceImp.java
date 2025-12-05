package in.thelearnify.JournalApp.Service;

import in.thelearnify.JournalApp.Entity.User;
import in.thelearnify.JournalApp.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsServiceImp implements UserDetailsService {
    @Autowired
    private UserRepo userrepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       User user=userrepo.findByUserName(username);
       if(user!=null){
           return org.springframework.security.core.userdetails.User.builder()
                    .username(user.getUserName())
                    .password(user.getPassword())
                    .roles(user.getRoles().toArray(new String[0]))
                    .build();
       }
        throw new UsernameNotFoundException("User not found with username: "+username);
    }
}
