package com.zhazhapan.demo.test;

/**
 * @author pantao
 * @since 2018/7/16
 */
public class ValueTransfer {

    public static void main(String[] args) {
        String string = "value";
        StringBuilder builder = new StringBuilder("hello");
        ValueTransfer transfer = new ValueTransfer();
        transfer.transfer(string, builder);
        System.out.println(string);
        System.out.println(builder.toString());
        transfer.transfer(builder);
        System.out.println(builder);
    }

    private void transfer(String s, StringBuilder sb) {
        s = "change";
        sb.append(" word");
    }

    private void transfer(StringBuilder sb) {
        sb = new StringBuilder("word");
    }
}
