package com.zhazhapan.demo.test;

import com.zhazhapan.demo.test.model.Student;

import java.util.*;

/**
 * @author pantao
 * @since 2019/2/14
 **/
public class SortTest {

    public static void main(String[] args) {
        // 准备一些数据，用于测试
        final String classOne = "一班";
        final String classTwo = "二班";
        final String classThree = "三班";
        List<Student> students = new ArrayList<>();
        students.add(new Student(classOne, "李一", 43));
        students.add(new Student(classOne, "王二", 75));
        students.add(new Student(classOne, "张三", 91));
        students.add(new Student(classTwo, "郭子", 59));
        students.add(new Student(classTwo, "潘子", 88));
        students.add(new Student(classTwo, "刘子", 97));
        students.add(new Student(classThree, "陈六", 66));
        students.add(new Student(classThree, "唐七", 77));
        students.add(new Student(classThree, "周八", 89));

        // 按分数进行降序排序
        Comparator<Student> comparator = (o1, o2) -> o2.getScore().compareTo(o1.getScore());
        // 测试排序结果
        Collections.sort(students, comparator);
        students.forEach(System.out::println);

        // 分组排序
        Comparator<Student> groupComparator = (o1, o2) -> {
            int diff = o1.getClassName().compareTo(o2.getClassName());
            return diff == 0 ? o2.getScore().compareTo(o1.getScore()) : diff;
        };
        System.out.println();
        // 测试排序结果
        Collections.sort(students, groupComparator);
        students.forEach(System.out::println);

        // 定义一个分组顺序
        Map<String, Integer> groupOrder = new HashMap<>(4);
        groupOrder.put(classOne, 1);
        groupOrder.put(classTwo, 2);
        groupOrder.put(classThree, 3);
        // 有序的分组排序
        Comparator<Student> orderlyGroupComparator = (o1, o2) -> {
            int diff = groupOrder.get(o1.getClassName()).compareTo(groupOrder.get(o2.getClassName()));
            return diff == 0 ? o2.getScore().compareTo(o1.getScore()) : diff;
        };
        System.out.println();
        // 测试排序结果
        Collections.sort(students, orderlyGroupComparator);
        students.forEach(System.out::println);
    }
}
