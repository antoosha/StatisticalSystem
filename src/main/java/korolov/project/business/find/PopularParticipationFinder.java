package korolov.project.business.find;

import korolov.project.dao.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * (MP) Service, which finds most frequently driven participation.
 */
public class PopularParticipationFinder implements IFinder<String> {
    private final Repository repository;

    public PopularParticipationFinder(Repository repository) {
        this.repository = repository;
    }

    @Override
    public String find() {
        Map<String, Integer> mapOfDirections = new HashMap<>();
        System.out.println(repository.getListOfRecords());
        for (korolov.project.domain.Record record : repository.getListOfRecords()) {
            if (mapOfDirections.containsKey(record.getDirectionId())) {
                int replace = mapOfDirections.get(record.getDirectionId());
                mapOfDirections.remove(record.getDirectionId());
                mapOfDirections.put(record.getDirectionId(), replace + record.getNumberOfRecords());
            } else mapOfDirections.put(record.getDirectionId(), record.getNumberOfRecords());
        }

        int max = 0;
        String direction = repository.getListOfRecords().get(0).getDirectionId();
        System.out.println(mapOfDirections);
        for (Map.Entry<String, Integer> entry : mapOfDirections.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                direction = entry.getKey();
            }
        }

        return "The most popular direction is: " + direction;
    }
}
