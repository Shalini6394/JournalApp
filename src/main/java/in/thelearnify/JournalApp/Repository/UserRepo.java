package in.thelearnify.JournalApp.Repository;

import in.thelearnify.JournalApp.Entity.JournalEntry;
import in.thelearnify.JournalApp.Entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepo extends MongoRepository<User, ObjectId> {      // Entity and Id's Data Passed in Angular Braces.
    User findByUserName(String username);
    void deleteByUserName(String username);
}
