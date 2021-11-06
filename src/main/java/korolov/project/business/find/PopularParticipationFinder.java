package korolov.project.business.find;

import korolov.project.dao.Repository;

/**
 * (MP) Service, which finds most frequently driven participation.
 */
public class PopularParticipationFinder implements IFinder<String> {
    private final Repository repository;

    public PopularParticipationFinder(Repository repository) {
        this.repository = repository;
    }

    @Override
    public String find() {
        //TODO
        return "";
    }
}
