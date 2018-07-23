package com.zhazhapan.demo.pattern.adapter;

/**
 * @author pantao
 * @since 2018/7/23
 */
public class UsbAdapter implements ItypeC {

    private IUsb usb;

    public UsbAdapter(IUsb usb) {
        this.usb = usb;
    }

    @Override
    public void symmetry() {
        usb.asymmetric();
    }
}
