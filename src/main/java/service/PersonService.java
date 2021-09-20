package service;

import lombok.AllArgsConstructor;
import model.PersonModel;

import static java.lang.System.out;

@AllArgsConstructor
public class PersonService {
    private final PersonModel person;

    public void takeVacation() {
        this.person.setVacation(true);
        out.println(this.person.getFirstName() + " take vacation");
    }

    public void completeVacation() {
        this.person.setVacation(false);
        out.println(this.person.getFirstName() + " is out of vacation");
    }

    public PersonModel getPersonInformation() {
        out.println("Information ==> " + this.person.toString());
        return this.person;
    }
}
