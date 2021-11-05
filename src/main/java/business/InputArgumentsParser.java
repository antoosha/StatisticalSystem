package business;

import java.util.List;

/**
 * Service to parse input arguments array of Strings
 */
public class InputArgumentsParser {
    private String nameOfInFile;
    private List<String> listOfTasks;
    private List<String> listOfOutFormats;

    public static boolean parseArgs(String fileFrom, String tasks, String formats){
        return true;
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
}
