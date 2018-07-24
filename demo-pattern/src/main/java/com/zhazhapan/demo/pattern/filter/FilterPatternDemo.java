package com.zhazhapan.demo.pattern.filter;

import com.zhazhapan.util.ListUtils;

import java.util.List;

/**
 * @author pantao
 * @since 2018-07-24
 */
public class FilterPatternDemo {

    public static void main(String[] args) {
        Person[] people = new Person[]{new Person("Robert", "Male", "Single"), new Person("John", "Male", "Married"),
                new Person("Laura", "Female", "Married"), new Person("Diana", "Female", "Single"), new Person("Mike",
                "Male", "Single"), new Person("Bobby", "Male", "Single")};
        List<Person> list = ListUtils.getArrayList(people);
        System.out.println(new CriterialMale().meetCriteria(list));
        System.out.println(new CriterialFemale().meetCriteria(list));
    }
}
