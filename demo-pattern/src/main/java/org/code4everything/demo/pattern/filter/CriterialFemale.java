package org.code4everything.demo.pattern.filter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pantao
 * @since 2018-07-24
 */
public class CriterialFemale implements Criteria {

    @Override
    public List<Person> meetCriteria(List<Person> personList) {
        List<Person> femalePersons = new ArrayList<Person>();
        for (Person person : personList) {
            if ("MALE".equalsIgnoreCase(person.getGender())) {
                femalePersons.add(person);
            }
        }
        return femalePersons;
    }
}
