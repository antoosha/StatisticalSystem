package cli;

import java.util.List;

/**
 * Main service, which works as Interface, that takes arguments and give tasks for smaller services
 */
public class Devider {
    private final String nameOfInFile;
    private final List<String> listOfTasks;
    private final List<String> listOfOutFormats;

    public Devider(String nameOfInFile, List<String> listOfTasks, List<String> listOfOutFormats) {
        this.nameOfInFile = nameOfInFile;
        this.listOfTasks = listOfTasks;
        this.listOfOutFormats = listOfOutFormats;
    }

    public String getNameOfInFile() {
        return nameOfInFile;
    }

    public List<String> getListOfTasks() {
        return listOfTasks;
    }

    public List<String> getListOfOutFormats() {
        return listOfOutFormats;
    }

    public void processRequests(){
        //TODO
    }
}
