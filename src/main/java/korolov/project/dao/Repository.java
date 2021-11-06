package korolov.project.dao;

import korolov.project.domain.Record;
import java.util.List;

/**
 * Our DAO class with data structure of Record
 */

public class Repository {
    private List<Record> listOfRecords;

    public Repository(List<Record> listOfRecords) {
        this.listOfRecords = listOfRecords;
    }

    public Repository() {
    }

    public List<Record> getListOfRecords() {
        return listOfRecords;
    }

    public void setListOfRecords(List<Record> listOfRecords) {
        this.listOfRecords = listOfRecords;
    }
}
