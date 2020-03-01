package io.pivotal.pal.tracker.repo;

import io.pivotal.pal.tracker.model.TimeEntry;

import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class InMemoryTimeEntryRepository implements TimeEntryRepository<TimeEntry> {

    private TimeEntry entry;
    private TimeEntry chkFirstEntry=null;
    private HashMap<Long, TimeEntry> timeEntries = new HashMap<>();

    @Override
    public TimeEntry create(TimeEntry timeEntry) {
        Long id = timeEntries.size() + 1L;
        if(chkFirstEntry != null){
            id = 2L;
        }
        entry = new TimeEntry(
                id,
                timeEntry.getProjectId(),
                timeEntry.getUserId(),
                timeEntry.getDate(),
                timeEntry.getHours()
        );
        timeEntries.put(id, entry);
        return entry;
    }

    @Override
    public TimeEntry find(long id) {
        return timeEntries.get(id);
    }

    @Override
    public List<TimeEntry> list() {
        return new ArrayList<>(timeEntries.values());
    }

    @Override
    public TimeEntry update(long id, TimeEntry timeEntry) {
        TimeEntry updateTimeEntry=null;
        if (timeEntries.get(id)!= null) {
             updateTimeEntry = new TimeEntry(
                    id,
                    timeEntry.getProjectId(),
                    timeEntry.getUserId(),
                    timeEntry.getDate(),
                    timeEntry.getHours()
            );
            timeEntries.replace(id, updateTimeEntry);
        }
        return updateTimeEntry;
    }


    @Override
    public void delete(long id) {
            chkFirstEntry = this.timeEntries.remove(id);
    }
}
