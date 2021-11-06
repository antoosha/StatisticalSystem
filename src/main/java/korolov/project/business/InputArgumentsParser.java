package korolov.project.business;

import java.util.Arrays;
import java.util.List;

/**
 * Service to parse input arguments array of Strings
 */
public class InputArgumentsParser {
    private String nameOfInFile;
    private List<String> listOfTasks;
    private List<String> listOfOutFormats;

    public boolean parseArgs(String fileFrom, String tasks, String formats) {
        if (fileFrom.isEmpty() || tasks.isEmpty() || formats.isEmpty()) return false;

        //"\s" anything that is a space character (including space, tab characters etc)
        nameOfInFile = fileFrom.replaceAll("\\s+", "");
        listOfTasks = Arrays.stream(tasks.split("[, ]+")).toList(); //may be problem with regex
        listOfOutFormats = Arrays.stream(formats.split("[, ]+")).toList(); //may be problem with regex
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
