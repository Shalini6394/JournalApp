package in.thelearnify.JournalApp.Repository;

import in.thelearnify.JournalApp.Entity.JournalEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JournalEntryRepo extends MongoRepository<JournalEntry, ObjectId> {
    // Entity and Id's Data Passed in Angular Braces.
}
