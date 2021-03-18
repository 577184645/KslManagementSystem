package com.ruoyi.system.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: qincan
 * @create: 2021-03-18 14:47
 * @description:  用款单打印
 * @version: 1.0
 */
@Controller
@RequestMapping("/system/payment")
public class PaymentController {

    private String prefix = "system/payment";
    @GetMapping("/kslprint")
    public String kslprint()
    {
        return prefix + "/kslprint";
    }

    @GetMapping("/hrprint")
    public String hrprint()
    {
        return prefix + "/hrprint";
    }

}
