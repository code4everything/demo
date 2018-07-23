package com.zhazhapan.demo.pattern.adapter;

import com.zhazhapan.demo.pattern.adapter.impl.Usb;

/**
 * @author pantao
 * @since 2018/7/23
 */
public class AdapterDemo {

    public static void main(String[] args) {
        IUsb usb = new Usb();
        UsbAdapter adapter = new UsbAdapter(usb);
        Mi5 mi5 = new Mi5(adapter);
        mi5.charge();
    }
}
