package in.thelearnify.JournalApp.Service;

import in.thelearnify.JournalApp.Entity.User;
import in.thelearnify.JournalApp.Repository.UserRepo;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceTests {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private UserService userService;

    @ParameterizedTest
//    @CsvSource({
//            "Ram",
//            "Shyam",
//            "Ram1"
//    })
//
    @Disabled
    @ArgumentsSource(UserArgumentsProvider.class)

   public void testCreateNewUser(User user) {
//     assertEquals(4,2+2);
//     User user=userRepo.findByUserName("Ram");
     assertTrue(userService.createNewUser(user));
    }
    @Disabled
    @ParameterizedTest
    @CsvSource({
            "1, 1, 2",
            "2,10,12",
            "3, 3, 9"
    })

    public void test(int a,int b,int expected){
        assertEquals(expected,a+b);

    }
}
