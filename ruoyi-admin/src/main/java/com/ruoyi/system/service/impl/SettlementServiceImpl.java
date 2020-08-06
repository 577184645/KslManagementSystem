package com.ruoyi.system.service.impl;

import java.util.Date;
import java.util.List;

import com.ruoyi.system.domain.Salescontract;
import com.ruoyi.system.domain.Settlementchild;
import com.ruoyi.system.mapper.SalescontractMapper;
import com.ruoyi.system.mapper.SettlementchildMapper;
import com.ruoyi.system.util.dateUtil;
import io.swagger.models.auth.In;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SettlementMapper;
import com.ruoyi.system.domain.Settlement;
import com.ruoyi.system.service.ISettlementService;
import com.ruoyi.common.core.text.Convert;
import org.springframework.transaction.annotation.Transactional;

/**
 * 结算Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-07-17
 */
@Service
public class SettlementServiceImpl implements ISettlementService 
{
    @Autowired
    private SettlementMapper settlementMapper;
    @Autowired
private SettlementchildMapper settlementchildMapper;
    @Autowired
    private SalescontractMapper salescontractMapper;
    /**
     * 查询结算
     * 
     * @param id 结算ID
     * @return 结算
     */
    @Override
    public Settlement selectSettlementById(Long id)
    {
        return settlementMapper.selectSettlementById(id);
    }

    /**
     * 查询结算列表
     * 
     * @param settlement 结算
     * @return 结算
     */
    @Override
    public List<Settlement> selectSettlementList(Settlement settlement)
    {
        return settlementMapper.selectSettlementList(settlement);
    }

    @Override
    @Transactional
    public int add(String settlementList, Settlement settlement) {
        settlement.setSettlementtime(new Date());
        String yy = dateUtil.dataToString("yy", new Date());
      String maxSerialNumber=  settlementMapper.selectSettlementMaxSerialNumber();
     if(maxSerialNumber==null){
         settlement.setSerialnumber(yy+"JS-001");
     }else{

      int index= maxSerialNumber.indexOf("-");
        Integer size =Integer.valueOf(maxSerialNumber.substring(index+1));

            if (size+1<10){
                settlement.setSerialnumber(yy+"JS-00"+(size+1));
            }else  if (size+1<100){
                settlement.setSerialnumber(yy+"JS-0"+(size+1));
            }else{
                settlement.setSerialnumber(yy+"JS-"+(size+1));

            }


        }
        

        JSONArray productArray = JSONArray.fromObject(settlementList);
        for (int i = 0; i < productArray.size(); i++) {
            JSONObject jsonObject = productArray.getJSONObject(i);
            Settlementchild settlementchild=new Settlementchild();
            settlementchild.setContractid(jsonObject.getString("contractid"));
            settlementchild.setCustomers(jsonObject.getString("firstparty"));
            settlementchild.setInvoiceid(jsonObject.getString("invoices"));
            settlementchild.setSalemoney(Float.valueOf(jsonObject.getString("salesamount")));
            settlementchild.setSuppliers(jsonObject.getString("suppliers"));
            settlementchild.setPurchasecontractids(jsonObject.getString("purchasecontractids"));
            settlementchild.setPurchaseinvoiceid(jsonObject.getString("purchaseinvoices"));
            settlementchild.setPurchasemoney(jsonObject.getString("purcharsemoneys"));
            settlementchild.setSaletaxrate(Float.valueOf(jsonObject.getString("taxrate")));
            settlementchild.setCostprice(Float.valueOf(jsonObject.getString("costprice")));
            settlementchild.setSaletaxrate(Float.valueOf(jsonObject.getString("saletaxrate")));
            settlementchild.setRevenue(Float.valueOf(jsonObject.getString("revenue")));
            settlementchild.setDiscount(Float.valueOf(jsonObject.getString("discount")));
            settlementchild.setPersonalincome(Float.valueOf(jsonObject.getString("personalincome")));
            settlementchild.setSerialnumber(settlement.getSerialnumber());
            settlementchild.setTaxrate(Float.valueOf(jsonObject.getString("taxrate")));
            settlementchildMapper.insertSettlementchild(settlementchild);
            salescontractMapper.updateSettlementstatus(settlementchild.getContractid());
        }

        return settlementMapper.insertSettlement(settlement);
    }

    /**
     * 新增结算
     * 
     * @param settlement 结算
     * @return 结果
     */

    /**
     * 修改结算
     * 
     * @param settlement 结算
     * @return 结果
     */
    @Override
    public int updateSettlement(Settlement settlement)
    {
        return settlementMapper.updateSettlement(settlement);
    }

    @Override
    @Transactional
    public int editSettlement(Settlement settlement, String settlementList) {

        deleteSettlementBySerialNumber(settlement.getSerialnumber());

        JSONArray productArray = JSONArray.fromObject(settlementList);


        for (int i = 0; i < productArray.size(); i++) {
            JSONObject jsonObject = productArray.getJSONObject(i);
            Settlementchild settlementchild=new Settlementchild();
            settlementchild.setContractid(jsonObject.getString("contractid"));
            settlementchild.setCustomers(jsonObject.getString("customers"));

            if(!jsonObject.getString("invoiceid").equals("null")){
                settlementchild.setInvoiceid(jsonObject.getString("invoiceid"));
            }



            settlementchild.setSalemoney(Float.valueOf(jsonObject.getString("salemoney")));
            settlementchild.setSuppliers(jsonObject.getString("suppliers"));
            settlementchild.setPurchasecontractids(jsonObject.getString("purchasecontractids"));
            settlementchild.setPurchaseinvoiceid(jsonObject.getString("purchaseinvoiceid"));
            settlementchild.setPurchasemoney(jsonObject.getString("purchasemoney"));
            settlementchild.setSaletaxrate(Float.valueOf(jsonObject.getString("taxrate")));
            settlementchild.setCostprice(Float.valueOf(jsonObject.getString("costprice")));
            settlementchild.setSaletaxrate(Float.valueOf(jsonObject.getString("saletaxrate")));
            settlementchild.setRevenue(Float.valueOf(jsonObject.getString("revenue")));
            settlementchild.setDiscount(Float.valueOf(jsonObject.getString("discount")));
            settlementchild.setPersonalincome(Float.valueOf(jsonObject.getString("personalincome")));
            settlementchild.setSerialnumber(settlement.getSerialnumber());
            settlementchild.setTaxrate(Float.valueOf(jsonObject.getString("taxrate")));
            settlementchildMapper.insertSettlementchild(settlementchild);
            salescontractMapper.updateSettlementstatus(settlementchild.getContractid());
        }

        return settlementMapper.insertSettlement(settlement);
    }

    @Override
    @Transactional
    public int deleteSettlementBySerialNumber(String serialnumber) {
        Settlementchild settlementchild=new Settlementchild();
        settlementchild.setSerialnumber(serialnumber);
        List<Settlementchild> settlementchildren = settlementchildMapper.selectSettlementchildList(settlementchild);
        for (Settlementchild settlementchild1 : settlementchildren) {
            settlementchildMapper.deleteSettlementchildById(settlementchild1.getId());
            salescontractMapper.updateSettlementbackstatus(settlementchild1.getContractid());
        }
        return settlementMapper.deleteSettlementBySerialNumber(serialnumber);
    }

    /**
     * 删除结算对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */


    /**
     * 删除结算信息
     * 
     * @param id 结算ID
     * @return 结果
     */
    @Override
    public int deleteSettlementById(Long id)
    {
        return settlementMapper.deleteSettlementById(id);
    }
}
