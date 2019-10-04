package org.code4everything.demo.pattern.filter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pantao
 * @since 2018-07-24
 */
public class CriterialMale implements Criteria {

    @Override
    public List<Person> meetCriteria(List<Person> personList) {
        List<Person> femalePersons = new ArrayList<>();
        for (Person person : personList) {
            if ("FEMALE".equalsIgnoreCase(person.getGender())) {
                femalePersons.add(person);
            }
        }
        return femalePersons;
    }
}
