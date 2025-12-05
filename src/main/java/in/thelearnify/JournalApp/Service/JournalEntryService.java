package in.thelearnify.JournalApp.Service;

import in.thelearnify.JournalApp.Entity.JournalEntry;
import in.thelearnify.JournalApp.Entity.User;
import in.thelearnify.JournalApp.Repository.JournalEntryRepo;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
@Slf4j
public class JournalEntryService {
    @Autowired
    private JournalEntryRepo journalEntryRepo;
    @Autowired
    private UserService userService;

@Transactional
    public void saveEntry(JournalEntry journalEntry, String userName){
        try{
            User user = userService.findByUserName(userName);
            journalEntry.setDate(LocalDateTime.now());
            JournalEntry saved = journalEntryRepo.save(journalEntry);
            user.getJournalEntries().add(saved);
            userService.createUser(user);
        }catch (Exception e){
            log.error("Exception{}", String.valueOf(e));
        }

    }
    public void saveEntry(JournalEntry journalEntry){
        journalEntryRepo.save(journalEntry);

    }


    public List<JournalEntry> getAllEntry(){
        return journalEntryRepo.findAll();
    }

    public Optional<JournalEntry> findById(ObjectId Id){
        return journalEntryRepo.findById(Id);
    }
  @Transactional
    public boolean deleteById(ObjectId Id, String userName){
       boolean removed=false;
    try{
        User user = userService.findByUserName(userName);
         removed= user.getJournalEntries().removeIf(x -> x.getId().equals(Id));
        if(removed) {
            userService.createUser(user);
            journalEntryRepo.deleteById(Id);
        }
        return removed;
    }
    catch(Exception ex){
       log.error("Error",ex);
        throw new RuntimeException("Error while deleting data by id.",ex);
    }

    }
}
