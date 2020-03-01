package io.pivotal.pal.tracker;

import io.pivotal.pal.tracker.model.TimeEntry;
import io.pivotal.pal.tracker.repo.InMemoryTimeEntryRepository;
import io.pivotal.pal.tracker.repo.TimeEntryRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PalTrackerApplication {
    public static void main(String[] args){
        SpringApplication.run(PalTrackerApplication.class, args);
    }

    @Bean
    TimeEntryRepository<TimeEntry> timeEntryRepository(){
        return new InMemoryTimeEntryRepository();
    }


}
