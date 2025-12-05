package in.thelearnify.JournalApp.Service;

import in.thelearnify.JournalApp.Entity.User;
import in.thelearnify.JournalApp.Repository.UserRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;

import static org.mockito.Mockito.*;

@ActiveProfiles("dev")
public class UserDetailsServiceImpTests {
    @InjectMocks
    private UserDetailsServiceImp userDetailsServiceImp;
    @Mock
    private UserRepo userRepo;
    @BeforeEach
    void setUp(){
        MockitoAnnotations.initMocks(this);
    }
    @Disabled
    @Test
    public void loadUserByUserNameTest(){
        when(userRepo.findByUserName(ArgumentMatchers.anyString())).thenReturn(User.builder().userName("Rama").password("Rama").roles(new ArrayList<>()).build());
        UserDetails user=userDetailsServiceImp.loadUserByUsername("Ram");
        Assertions.assertNotNull(user);
    }
}
