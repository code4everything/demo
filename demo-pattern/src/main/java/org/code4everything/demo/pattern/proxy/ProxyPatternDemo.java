package org.code4everything.demo.pattern.proxy;

/**
 * @author pantao
 * @since 2018-07-25
 */
public class ProxyPatternDemo {

    public static void main(String[] args) {
        Image image = new ProxyImage("test.jpg");
        image.display();
    }
}
