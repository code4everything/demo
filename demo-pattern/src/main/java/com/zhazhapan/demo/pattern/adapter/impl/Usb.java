package com.zhazhapan.demo.pattern.adapter.impl;

import com.zhazhapan.demo.pattern.adapter.IUsb;

/**
 * @author pantao
 * @since 2018/7/23
 */
public class Usb implements IUsb {

    @Override
    public void asymmetric() {
        System.out.println("usb 2.0 接口");
    }
}
