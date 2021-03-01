package com.ruoyi.system.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.system.domain.*;
import com.ruoyi.system.mapper.PurchasecontractMapper;
import com.ruoyi.system.mapper.SellDetailMapper;
import com.ruoyi.system.utils.jsonlistUtil;
import com.ruoyi.system.utils.numberUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SalescontractMapper;
import com.ruoyi.system.service.ISalescontractService;
import com.ruoyi.common.core.text.Convert;
import org.springframework.transaction.annotation.Transactional;

/**
 * 销售合同列表Service业务层处理
 *
 * @author ruoyi
 * @date 2020-05-20
 */
@Service
@Transactional
public class SalescontractServiceImpl implements ISalescontractService {
    @Autowired
    private SalescontractMapper salescontractMapper;
    @Autowired
    private SellDetailMapper sellDetailMapper;
    @Autowired
    private PurchasecontractMapper purchasecontractMapper;


    /**
     * 查询销售合同列表
     *
     * @param id 销售合同列表ID
     * @return 销售合同列表
     */
    @Override
    public Salescontract selectSalescontractById(Long id) {
        return salescontractMapper.selectSalescontractById(id);
    }

    /**
     * 查询销售合同列表列表
     *
     * @param salescontract 销售合同列表
     * @return 销售合同列表
     */
    @Override
    public List<Salescontract> selectSalescontractList(Salescontract salescontract) {
        return salescontractMapper.selectSalescontractList(salescontract);
    }


    /**
     * 新增销售合同列表
     *
     * @param salescontractList
     * @param salescontract     salescontractList 销售合同列表
     * @return
     */
    @Override
    public int insertSalescontractAndSelldetail(String salescontractList, Salescontract salescontract) {
        List<String[]> jsonList = jsonlistUtil.getJsonList(salescontractList, new String[]{"productname", "unit", "specifications", "producttype", "price", "productnum", "money"});
        Double sum = 0.0;
        int result = salescontractMapper.insertSalescontract(salescontract);
        for (int i = 0; i < jsonList.size(); i++) {
            String[] strings = jsonList.get(i);
            SellDetail sellDetail = new SellDetail();
            sellDetail.setProductname(strings[0]);
            sellDetail.setUnit(strings[1]);
            sellDetail.setSpecifications(strings[2]);
            sellDetail.setProducttype(strings[3]);
            sellDetail.setPrice(Double.valueOf(strings[4]));
            sellDetail.setProductnum(Integer.valueOf(strings[5]));
            sellDetail.setMoney(Double.valueOf(strings[4]) * Integer.valueOf(strings[5]));
            sellDetail.setContractId(salescontract.getId());
            sum += sellDetail.getMoney();
            sellDetailMapper.insertSellDetail(sellDetail);
        }
        Salescontract updatesalescontract = new Salescontract();
        updatesalescontract.setId(salescontract.getId());
        updatesalescontract.setSalesamount(sum);
        salescontractMapper.updateSalescontract(updatesalescontract);
        return result;
    }


    /**
     * 修改销售合同列表
     *
     * @param salescontract 销售合同列表
     * @return 结果
     */
    @Override
    public int updateSalescontract(Salescontract salescontract) {
        return salescontractMapper.updateSalescontract(salescontract);
    }

    /**
     * 删除销售合同列表对象
     *
     * @param id 需要删除的数据ID
     * @return 结果
     */
    @Override
    public AjaxResult deleteSalescontractById(Long id) {
        List<SellDetail> sellDetails = sellDetailMapper.selectSellDetailByContractId(id);
        if (sellDetails != null && sellDetails.size() > 0) {
            return AjaxResult.error("操作失败,销售合同下有订单信息!");
        }
        List<Purchasecontract> purchasecontracts = purchasecontractMapper.selectPurchasecontractByContractId(id);
        if (purchasecontracts != null && purchasecontracts.size() > 0) {
            return AjaxResult.error("操作失败,销售合同下有采购合同!");
        }
        salescontractMapper.deleteSalescontractById(id);
        return AjaxResult.success("操作成功!");
    }


    @Override
    public String getContractid(String type, String year) {
        String contractid = "";
        String maxContractid = salescontractMapper.maxContractid(type, year);
        if (null == maxContractid) {
            if (type.equals("G")) {
                contractid = year + "G" + "0001";
            } else if (type.equals("Z")) {
                contractid = year + "Z" + "0001";
            } else if (type.equals("X")) {
                contractid = year + "X" + "0001";
            }
        } else {

            String size = numberUtil.numberToStringAddOne(Integer.valueOf(maxContractid.substring(3)));
            if (type.equals("G")) {

                contractid = year + "G" + size;
            }
            if (type.equals("Z")) {

                contractid = year + "Z" + size;
            }
            if (type.equals("X")) {

                contractid = year + "X" + size;
            }

        }

        return contractid;
    }

    @Override
    public Map<String, Object> findSalescontractInfo(Long id) {
        return salescontractMapper.findSalescontractInfo(id);
    }


}
