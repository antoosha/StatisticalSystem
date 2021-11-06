package korolov.project.business.find;

import korolov.project.dao.Repository;
import java.util.Optional;

public class FinderFactoryMethod {
    private final String task;
    private final Repository repository;

    public FinderFactoryMethod(String task, Repository repository) {
        this.task = task;
        this.repository = repository;
    }

    public Optional<IFinder<?>> getFinder(){
        IFinder<?> result;
        switch (task) {
            case "DM" -> {
                result = new DayWithMaxNumberOfRecordsFinder(repository);
            }
            case "TR" -> {
                result = new NumberOfAllRecordedPassesFinder(repository);
            }
            case "MP" -> {
                result = new PopularParticipationFinder(repository);
            }
            case "TD" -> {
                result = new NumberOfAllRecordedPassesPerDayFinder(repository);
            }
            default -> {
                result = null;
            }

        }
        return Optional.ofNullable(result);
    }

}
