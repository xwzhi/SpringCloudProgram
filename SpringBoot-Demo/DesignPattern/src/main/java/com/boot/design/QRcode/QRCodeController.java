package com.boot.design.QRcode;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

@Controller
public class QRCodeController {

    /**
     * 生成二维码
     *
     * @param
     * @param response response对象
     */
    @RequestMapping(value = "/api/qrcode")
    public void getEquipmentQrcode(String url, HttpServletResponse response) {
        CreateQrcode createQrcode = new CreateQrcode();
        People people = new People("afdfadf",12,"afadfdfa","511024188405291221");
        //生成二维码
        try {
            createQrcode.getQrcode(people.toString(), response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
