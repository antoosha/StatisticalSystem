package korolov.project.business.find;

import korolov.project.dao.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (MP) Service, which finds most frequently driven participation.
 */
public class PopularParticipationFinder implements IFinder<List<PopularParticipationFinder.ExportClass>> {
    private final Repository repository;

    public PopularParticipationFinder(Repository repository) {
        this.repository = repository;
    }

    protected class ExportClass {
        protected String popularDirection;
        protected int numberOfPasses;

        public ExportClass(String direction, int number) {
            this.popularDirection = direction;
            this.numberOfPasses = number;
        }

        @Override
        public String toString() {
            return "popularDirection = '" + popularDirection + '\'' +
                    ", numberOfPasses = " + numberOfPasses;
        }
    }

    @Override
    public List<ExportClass> find() {
        Map<String, Integer> mp = new HashMap<>();

        for (korolov.project.domain.Record record : repository.getListOfRecords()) {
            mp.put(record.getDirectionId(),
                    mp.get(record.getDirectionId()) == null
                            ?
                            record.getNumberOfRecords()
                            :
                            mp.get(record.getDirectionId()) + record.getNumberOfRecords());
        }


        int max = 0;
        for (Map.Entry<String, Integer> entry : mp.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
            }
        }

        List<ExportClass> resultListOfDirections = new ArrayList<>();

        if (max != 0) {
            for (Map.Entry<String, Integer> entry : mp.entrySet()) {
                if (entry.getValue() == max) {
                    resultListOfDirections.add(new ExportClass(entry.getKey(), max));
                }
            }
        }
        return resultListOfDirections;
    }
}
