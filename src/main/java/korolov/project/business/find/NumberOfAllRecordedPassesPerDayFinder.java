package korolov.project.business.find;

import korolov.project.dao.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

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
        class Node {
            protected LocalDateTime localDateTime;
            protected int numberOfRecords;
            boolean is = false;
        }
        List<ExportClass> resultList = new ArrayList<>();
        ArrayList<Node> nodes = new ArrayList<>();
        for (int i = 0; i < 367; i++) {
            nodes.add(new Node());
            nodes.get(i).numberOfRecords = 0;
        }
        for (korolov.project.domain.Record record : repository.getListOfRecords()) {
            nodes.get(record.getMeasuredFrom().getDayOfYear()).localDateTime = record.getMeasuredFrom();
            (nodes.get(record.getMeasuredFrom().getDayOfYear()).numberOfRecords) += record.getNumberOfRecords();
            nodes.get(record.getMeasuredFrom().getDayOfYear()).is = true;
        }

        nodes.sort(new Comparator<Node>() {
            public int compare(Node o1, Node o2) {
                return Integer.compare(o1.numberOfRecords, o2.numberOfRecords);
            }
        });

        for (Node node : nodes) {
            if (node.is) {

                resultList.add(new ExportClass(node.localDateTime.getYear() + "-"
                        + node.localDateTime.getMonth().getValue() + "-"
                        + node.localDateTime.getDayOfMonth()
                        , node.numberOfRecords));
            }
        }

        return resultList;
    }
}
