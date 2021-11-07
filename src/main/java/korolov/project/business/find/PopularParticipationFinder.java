package korolov.project.business.find;

import korolov.project.dao.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * (MP) Service, which finds most frequently driven participation.
 */
public class PopularParticipationFinder implements IFinder<PopularParticipationFinder.ExportClass> {
    private final Repository repository;

    public PopularParticipationFinder(Repository repository) {
        this.repository = repository;
    }

    protected class ExportClass {
        protected String popularDirection;

        public ExportClass(String direction) {
            this.popularDirection = direction;
        }

        @Override
        public String toString() {
            return "popularDirection = " + popularDirection;
        }
    }

    @Override
    public ExportClass find() {
        Map<String, Integer> mapOfDirections = new HashMap<>();
        for (korolov.project.domain.Record record : repository.getListOfRecords()) {
            if (mapOfDirections.containsKey(record.getDirectionId())) {
                int replace = mapOfDirections.get(record.getDirectionId());
                mapOfDirections.remove(record.getDirectionId());
                mapOfDirections.put(record.getDirectionId(), replace + record.getNumberOfRecords());
            } else mapOfDirections.put(record.getDirectionId(), record.getNumberOfRecords());
        }

        int max = 0;
        String popularDirection = repository.getListOfRecords().get(0).getDirectionId();
        for (Map.Entry<String, Integer> entry : mapOfDirections.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                popularDirection = entry.getKey();
            }
        }

        return new ExportClass(popularDirection);
    }
}
