package com.ruoyi.system.controller;


import com.ruoyi.system.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * @author: qincan
 * @create: 2021-02-22 9:07
 * @description: 首页
 * @version: 1.0
 */
@RestController
@RequestMapping("system/home")
public class HomeController {


    @Autowired
    private HomeService homeService;

    @RequestMapping("/customersize")
    public int customersize(){
    return homeService.customersize();
   }

    @RequestMapping("/suppliersize")
    public int suppliersize(){

        return homeService.suppliersize();
    }


    @RequestMapping("/invoicemoneybyyear")
    public Double invoicemoneybyyear() {
        return homeService.invoiceMoneyByYear();
    }

   @RequestMapping("/salesamountBymonth")
    public List<Map<String, Object>> SalesamountBymonth(@RequestParam("newdate") String newdate) {

        return  homeService.selectSalesamountBmonth(newdate);
    }

    @RequestMapping("/saleMoneyByYear")
    public Double moneyByYear() {
        return  homeService.moneyByYear();
    }

    @RequestMapping("/PurchasesamountBymonth")
    public List<Map<String, Object>> PurchasesamountBymonth(@RequestParam("newdate") String newdate) {

        return    homeService.selectPurchasesamountByMonth(newdate);

    }

    @RequestMapping(value = "/PurchasesamountByday")
    public List<Map<String, Object>> PurchasesamountByday(@RequestParam("newyear") String newyear,@RequestParam("newmonth") String newmonth) {
        return  homeService.selectPurchasesamountByday(newyear,newmonth);

    }



    @RequestMapping(value = "salesamountByday")
    public List<Map<String, Object>> salesamountByday(@RequestParam("newyear") String newyear,@RequestParam("newmonth") String newmonth) {

        return  homeService.selectSalesamountByday(newyear,newmonth);

    }

}
