package korolov.project.business.find;

import korolov.project.dao.Repository;

/**
 * (TD) Service, which finds number of all cyclists passes throw all records per each day.
 */
public class NumberOfAllRecordedPassesPerDayFinder implements IFinder<Integer> {
    private final Repository repository;

    public NumberOfAllRecordedPassesPerDayFinder(Repository repository) {
        this.repository = repository;
    }

    @Override
    public Integer find() {
        //TODO
        return 0;
    }
}
