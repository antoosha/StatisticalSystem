package korolov.project.business.find;

import korolov.project.dao.Repository;

/**
 * (DM) Service, which finds day with maximum number of records per day.
 */
public class DayWithMaxNumberOfRecordsFinder implements IFinder<String> {
    private final Repository repository;

    public DayWithMaxNumberOfRecordsFinder(Repository repository) {
        this.repository = repository;
    }

    @Override
    public String find() {
        //TODO
        return "";
    }
}
