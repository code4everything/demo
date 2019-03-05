package com.zhazhapan.demo.test;

import java.time.ZoneId;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author pantao
 * @since 2019-03-03
 */
public class DateTest {

    public static void main(String[] args) {
        Set<String> zone = new TreeSet<>(ZoneId.getAvailableZoneIds());
        zone.forEach(System.out::println);
    }
}
