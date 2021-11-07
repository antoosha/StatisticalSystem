package korolov.project.business.find;

import korolov.project.dao.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (DM) Service, which finds day with maximum number of records per day.
 */
public class DayWithMaxNumberOfRecordsFinder implements IFinder<List<DayWithMaxNumberOfRecordsFinder.ExportClass>> {
    private final Repository repository;

    public DayWithMaxNumberOfRecordsFinder(Repository repository) {
        this.repository = repository;
    }

    protected class ExportClass {
        protected String date;
        protected int numberOfPasses;

        public ExportClass(String date, int numberOfPasses) {
            this.date = date;
            this.numberOfPasses = numberOfPasses;
        }

        @Override
        public String toString() {
            return "date = '" + date + '\'' +
                    ", numberOfPasses = " + numberOfPasses;
        }
    }

    @Override
    public List<ExportClass> find() {
        Map<String, Integer> mp = new HashMap<>();

        for (korolov.project.domain.Record record : repository.getListOfRecords()) {
            mp.put(record.getMeasuredFrom().toLocalDate().toString(),
                    mp.get(record.getMeasuredFrom().toLocalDate().toString()) == null ? 1 : mp.get(record.getMeasuredFrom().toLocalDate().toString()) + 1);
        }

        int max = 0;
        for (Map.Entry<String, Integer> entry : mp.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
            }
        }

        List<ExportClass> resultListOfMaxDayRecords = new ArrayList<>();

        if (max != 0) {
            for (Map.Entry<String, Integer> entry : mp.entrySet()) {
                if (entry.getValue() == max) {
                    resultListOfMaxDayRecords.add(new ExportClass(entry.getKey(), max));
                }
            }
            resultListOfMaxDayRecords.sort((o1, o2) -> o1.date.compareTo(o2.date));
        }

        return resultListOfMaxDayRecords;
    }
}
