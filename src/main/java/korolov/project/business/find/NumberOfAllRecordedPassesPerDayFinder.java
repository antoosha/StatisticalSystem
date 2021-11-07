package korolov.project.business.find;

import korolov.project.dao.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (TD) Service, which finds number of all cyclists passes throw all records per each day.
 */
public class NumberOfAllRecordedPassesPerDayFinder implements IFinder<List<NumberOfAllRecordedPassesPerDayFinder.ExportClass>> {
    private final Repository repository;

    public NumberOfAllRecordedPassesPerDayFinder(Repository repository) {
        this.repository = repository;
    }

    protected class ExportClass {
        protected String date;
        protected int numberOfRecords;

        public ExportClass(String date, int numberOfRecords) {
            this.date = date;
            this.numberOfRecords = numberOfRecords;
        }

        @Override
        public String toString() {
            return "{date='" + date + '\'' +
                    ", numberOfRecords = " + numberOfRecords + "}";
        }
    }

    @Override
    public List<ExportClass> find() {
        Map<String, Integer> mp = new HashMap<>();

        for (korolov.project.domain.Record record : repository.getListOfRecords()) {
            mp.put(record.getMeasuredFrom().toLocalDate().toString(),
                    mp.get(record.getMeasuredFrom().toLocalDate().toString()) == null
                            ?
                            record.getNumberOfRecords()
                            :
                            mp.get(record.getMeasuredFrom().toLocalDate().toString()) + record.getNumberOfRecords());
        }


        List<ExportClass> resultList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : mp.entrySet()) {
            resultList.add(new ExportClass(entry.getKey(), entry.getValue()));
        }
        if (!resultList.isEmpty()) resultList.sort((o1, o2) -> o1.date.compareTo(o2.date));

        return resultList;
    }
}
