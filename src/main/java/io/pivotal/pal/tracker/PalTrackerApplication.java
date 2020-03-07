package io.pivotal.pal.tracker;

import com.mysql.cj.jdbc.MysqlDataSource;
import io.pivotal.pal.tracker.model.TimeEntry;
import io.pivotal.pal.tracker.repo.InMemoryTimeEntryRepository;
import io.pivotal.pal.tracker.repo.JdbcTimeEntryRepository;
import io.pivotal.pal.tracker.repo.TimeEntryRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@SpringBootApplication
public class PalTrackerApplication {
    private DataSource dataSource;

    public static void main(String[] args){
        SpringApplication.run(PalTrackerApplication.class, args);
    }

    public PalTrackerApplication(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    TimeEntryRepository<TimeEntry> timeEntryRepository() {
        return new JdbcTimeEntryRepository(dataSource);
    }


}
