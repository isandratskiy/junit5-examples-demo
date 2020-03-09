package service;

import com.google.common.flogger.FluentLogger;
import lombok.AllArgsConstructor;
import model.PersonModel;

import static com.google.common.flogger.FluentLogger.forEnclosingClass;

@AllArgsConstructor
public class PersonService {
    private static final FluentLogger log = forEnclosingClass();
    private PersonModel person;

    public void takeVacation() {
        this.person.setVacation(true);
        log.atInfo().log(
                this.person.getFirstName() + " take vacation"
        );
    }

    public void completeVacation() {
        this.person.setVacation(false);
        log.atInfo().log(
                this.person.getFirstName() + " is out of vacation"
        );
    }

    public PersonModel getPersonInformation() {
        log.atInfo().log(
                "Information ==> " + this.person.toString()
        );
        return this.person;
    }
}
