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
        //TODO
        return 0;
    }
}
