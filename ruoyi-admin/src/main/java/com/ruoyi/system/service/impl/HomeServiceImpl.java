package com.ruoyi.system.service.impl;

import com.ruoyi.system.domain.Customer;
import com.ruoyi.system.domain.Supplier;
import com.ruoyi.system.mapper.*;
import com.ruoyi.system.service.HomeService;
import com.ruoyi.system.utils.dateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author: qincan
 * @create: 2021-02-22 9:30
 * @description:
 * @version: 1.0
 */
@Service
public class HomeServiceImpl implements HomeService {
    @Autowired
    private InvoiceMapper invoiceMapper;
    @Autowired
    private SupplierMapper supplierMapper;
    @Autowired
    private CustomerMapper customerMapper;
    @Autowired
    private SalescontractMapper salescontractMapper;
    @Autowired
    private PurchasecontractMapper purchasecontractMapper;

    

    @Override
    public Double invoiceMoneyByYear() {
        String yyyy = dateUtil.dataToString("yyyy", new Date());
        Double money = invoiceMapper.sumMoneyByYear(yyyy);
        if (money!=null){
            return invoiceMapper.sumMoneyByYear(yyyy);
        }
          return 0d;
    }



    @Override
    public int customersize() {
        List<Customer> customers = customerMapper.selectCustomerList(null);
        if(customers.size()>0){
            return customers.size();
        }
        return 0;
    }

    @Override
    public int suppliersize() {
        List<Supplier> customers = supplierMapper.selectSupplierList(null);
        if(customers.size()>0){
            return customers.size();
        }
        return 0;
    }

    @Override
    public Double moneyByYear() {
        String yyyy = dateUtil.dataToString("yyyy", new Date());
        Double money = salescontractMapper.sumMoneyGYear(yyyy);
        if(money!=null){
            return salescontractMapper.sumMoneyGYear(yyyy);
        }
       return 0d;
    }

    @Override
    public List<Map<String,Object>> selectSalesamountBmonth(String newDate) {
        return salescontractMapper.selectSalesamountBmonth(newDate);
    }

    @Override
    public List<Map<String, Object>> selectPurchasesamountByMonth(String newdate) {
        return purchasecontractMapper.selectPurchasesamountByMonth(newdate);
    }

    @Override
    public List<Map<String, Object>> selectPurchasesamountByday(String newyear, String newmonth) {
        return purchasecontractMapper.selectPurchasesamountByday(newyear,newmonth);
    }

    @Override
    public List<Map<String, Object>> selectSalesamountByday(String newyear, String newmonth) {
        return salescontractMapper.selectSalesamountByday(newyear,newmonth);
    }
}
