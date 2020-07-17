package com.ruoyi.system.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.SellDetail;
import com.ruoyi.system.mapper.SellDetailMapper;
import com.ruoyi.system.util.dateUtil;
import com.ruoyi.system.util.numberUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SalescontractMapper;
import com.ruoyi.system.domain.Salescontract;
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
public class SalescontractServiceImpl implements ISalescontractService {
    @Autowired
    private SalescontractMapper salescontractMapper;
    @Autowired
    private SellDetailMapper sellDetailMapper;

    @Override
    public Double sumMoneyGYear(String newDate) {
        return salescontractMapper.sumMoneyGYear(newDate);
    }

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

    @Override
    @Transactional
    public int insertSalescontractAndSelldetail(String salescontractList, Salescontract salescontract) {

        JSONArray productArray = JSONArray.fromObject(salescontractList);
       Float sum=0f;
        for (int i = 0; i < productArray.size(); i++) {
            JSONObject jsonObject = productArray.getJSONObject(i);
            SellDetail sellDetail = new SellDetail();
            sellDetail.setProductname(jsonObject.getString("productname"));
            sellDetail.setUnit(jsonObject.getString("unit"));
            sellDetail.setSpecifications(jsonObject.getString("specifications"));
            sellDetail.setProducttype(jsonObject.getString("producttype"));

            if (!jsonObject.getString("price").equals("")) {
                sellDetail.setPrice(Float.valueOf(jsonObject.getString("price")));
            }

            if (!jsonObject.getString("money").equals("")) {
                sellDetail.setMoney(Float.valueOf(jsonObject.getString("money")));
            }
            if (!jsonObject.getString("productnum").equals("")) {
                sellDetail.setProductnum(Float.valueOf(jsonObject.getString("productnum")));
            }
            sum+=Float.valueOf(jsonObject.getString("money"));
            sellDetail.setContractid(salescontract.getContractid());
            sellDetailMapper.insertSellDetail(sellDetail);
        }
       salescontract.setSalesamount(sum);
        return salescontractMapper.insertSalescontract(salescontract);
    }


    /**
     * 新增销售合同列表
     * 
     * @param salescontract 销售合同列表
     * @return 结果
     */

    /**
     * 修改销售合同列表
     * 
     * @param salescontract 销售合同列表
     * @return 结果
     */
    @Override
    public int updateSalescontract(Salescontract salescontract)
    {
        return salescontractMapper.updateSalescontract(salescontract);
    }

    /**
     * 删除销售合同列表对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSalescontractByIds(String ids)
    {
        return salescontractMapper.deleteSalescontractByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除销售合同列表信息
     * 
     * @param id 销售合同列表ID
     * @return 结果
     */
    @Override
    public int deleteSalescontractById(Long id)
    {
        return salescontractMapper.deleteSalescontractById(id);
    }

    @Override
    public String getContractid(String type) {

       String date= dateUtil.dataToString("yyyy",new Date());
        String datetwo = date.substring(2, date.length());
        String maxContractid = salescontractMapper.maxContractid(type,datetwo);
        String contractid="";

        if(maxContractid==null||maxContractid.equals("null")){
           if (type.equals("G")){
               contractid = datetwo + "G" + "0001";
           }else if (type.equals("Z")){
               contractid = datetwo + "Z" + "0001";
           }else if(type.equals("X")){
               contractid = datetwo + "X" + "0001";
           }
        }else{

            String size = numberUtil.numberToStringAddOne(Integer.valueOf(maxContractid.substring(3)));
            if (type.equals("G")) {

             contractid = datetwo + "G" + size;
         }
            if (type.equals("Z")) {

                contractid = datetwo + "Z" + size;
            }
            if (type.equals("X")) {

                contractid = datetwo + "X" + size;
            }

        }

        return contractid;
    }

    @Override
    public List<Map<String,Object>> selectSalesamountBmonth(String newdate) {
        return salescontractMapper.selectSalesamountBmonth(newdate);
    }

    @Override
    public List<Map<String, Object>> selectSalesamountByday(String newyear, String newmonth) {
        return salescontractMapper.selectSalesamountByday(newyear,newmonth);
    }
}
