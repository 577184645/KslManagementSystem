package com.ruoyi.system.service;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author: qincan
 * @create: 2021-02-22 9:28
 * @description: 首页接口
 * @version: 1.0
 */

public interface HomeService {
    /**
     * 当前年的发票金额
     * @param
     * @return
     */
    public Double invoiceMoneyByYear();

    /**
     * 获得客户数量
     * @return
     */
    public int customersize();

    /**
     * 获得供应商数量
     * @return
     */
    public int suppliersize();

    /**
     * 当前年的销售金额
     * @return
     */
    Double moneyByYear();


    /**
     * 根据某一年查询每个月的总金额
     *
     * @return
     */
    public List<Map<String,Object>> selectSalesamountBmonth(String newDate);

    /**
     * 根据某一年查询每个月的总金额
     * @param newdate
     * @return
     */
    public List<Map<String,Object>> selectPurchasesamountByMonth( String newdate);


    /**
     * 根据某一个月查询每天的总金额
     * @param newyear
     *    @param newmonth
     * @return
     */
    public List<Map<String,Object>> selectPurchasesamountByday(String newyear,String newmonth);


    /**
     * 根据某一个月查询每天的总金额
     * @param newyear
     *    @param newmonth
     * @return
     */
    public List<Map<String,Object>> selectSalesamountByday(String newyear , String newmonth);



}
