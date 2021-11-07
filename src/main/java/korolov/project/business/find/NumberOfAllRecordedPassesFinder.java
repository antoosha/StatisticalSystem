package korolov.project.business.find;

import korolov.project.dao.Repository;

/**
 * (TR) Service, which finds number of all cyclists passes throw all records.
 */
public class NumberOfAllRecordedPassesFinder implements IFinder<NumberOfAllRecordedPassesFinder.ExportClass> {
    private final Repository repository;

    public NumberOfAllRecordedPassesFinder(Repository repository) {
        this.repository = repository;
    }

    protected class ExportClass {
        protected int numberOfAllPassesRecords;

        public ExportClass(int numberOfAllPassesRecords) {
            this.numberOfAllPassesRecords = numberOfAllPassesRecords;
        }

        @Override
        public String toString() {
            return "numberOfAllPassesRecords = " + numberOfAllPassesRecords;
        }
    }

    @Override
    public ExportClass find() {
        int result = 0;
        for (korolov.project.domain.Record record : repository.getListOfRecords()) {
            result += record.getNumberOfRecords();
        }
        return new ExportClass(result);
    }
}
