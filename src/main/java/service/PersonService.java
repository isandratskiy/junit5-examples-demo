package service;

import lombok.AllArgsConstructor;
import model.PersonModel;

@AllArgsConstructor
public class PersonService {
    private PersonModel person;

    public boolean takeVacation() {
        this.person.setVacation(true);
        return this.person.isVacation();
    }

    public boolean completeVacation() {
        this.person.setVacation(false);
        return this.person.isVacation();
    }
}
