package korolov.project.business.find;

import korolov.project.dao.Repository;

/**
 * (TR) Service, which finds number of all cyclists passes throw all records.
 */
public class NumberOfAllRecordedPassesFinder implements IFinder<Integer> {
    private final Repository repository;

    public NumberOfAllRecordedPassesFinder(Repository repository) {
        this.repository = repository;
    }

    @Override
    public Integer find() {
        int result = 0;
        for (korolov.project.domain.Record record : repository.getListOfRecords()) {
            result += record.getNumberOfRecords();
        }
        return result;
    }
}
