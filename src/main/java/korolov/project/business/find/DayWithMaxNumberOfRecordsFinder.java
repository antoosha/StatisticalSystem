package korolov.project.business.find;

import korolov.project.dao.Repository;

import java.time.LocalDateTime;

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
        class Node {
            protected LocalDateTime localDateTime;
            protected int numberOfRecords;
        }

        Node[] nodes = new Node[367];
        for (int i = 0; i < 367; i++) {
            nodes[i] = new Node();
            nodes[i].numberOfRecords = 0;
        }
        for (korolov.project.domain.Record record : repository.getListOfRecords()) {
            nodes[record.getMeasuredFrom().getDayOfYear()].localDateTime = record.getMeasuredFrom();
            (nodes[record.getMeasuredFrom().getDayOfYear()].numberOfRecords)++;
        }
        int max = 0;
        LocalDateTime resultLocalDateTime = repository.getListOfRecords().get(0).getMeasuredFrom();
        for (Node node : nodes) {
            if (node.numberOfRecords > max) {
                max = node.numberOfRecords;
                resultLocalDateTime = node.localDateTime;
            }
        }
        return resultLocalDateTime.getYear() + "-" + resultLocalDateTime.getMonth().getValue() + "-" + resultLocalDateTime.getDayOfMonth();
    }
}
