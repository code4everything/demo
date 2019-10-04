package org.code4everything.demo.algorithm.leetcode.binary.search;

/**
 * @author pantao
 * @since 2019-01-06
 */
public class VersionControl {

    private int firstBadVersion;

    private int callTimes = 0;

    protected boolean isBadVersion(int version) {
        callTimes++;
        return version >= firstBadVersion;
    }

    public int getCallTimes() {
        return callTimes;
    }

    public int getFirstBadVersion() {
        System.out.println("first bad version >>> " + firstBadVersion + ", call times >>> " + callTimes);
        return firstBadVersion;
    }

    public void setFirstBadVersion(int firstBadVersion) {
        callTimes = 0;
        this.firstBadVersion = firstBadVersion;
    }
}
