package com.ruoyi.system.service.impl;

import java.util.List;
import java.util.Map;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.Purchasedetail;
import com.ruoyi.system.domain.Salescontract;
import com.ruoyi.system.domain.SellDetail;
import com.ruoyi.system.mapper.PurchasedetailMapper;
import com.ruoyi.system.mapper.SellDetailMapper;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.PurchasecontractMapper;
import com.ruoyi.system.domain.Purchasecontract;
import com.ruoyi.system.service.IPurchasecontractService;
import com.ruoyi.common.core.text.Convert;
import org.springframework.transaction.annotation.Transactional;

/**
 * 采购合同Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-05-22
 */
@Service
public class PurchasecontractServiceImpl implements IPurchasecontractService 
{
    @Autowired
    private PurchasecontractMapper purchasecontractMapper;
    @Autowired
    private PurchasedetailMapper purchasedetailMapper;
    @Autowired
    private SellDetailMapper sellDetailMapper;
    /**
     * 查询采购合同
     * 
     * @param id 采购合同ID
     * @return 采购合同
     */
    @Override
    public Purchasecontract selectPurchasecontractById(Long id)
    {
        return purchasecontractMapper.selectPurchasecontractById(id);
    }

    /**
     * 查询采购合同列表
     * 
     * @param purchasecontract 采购合同
     * @return 采购合同
     */
    @Override
    public List<Purchasecontract> selectPurchasecontractList(Purchasecontract purchasecontract)
    {
        return purchasecontractMapper.selectPurchasecontractList(purchasecontract);
    }

    /**
     * 新增采购合同
     *
     * @param purchasecontract 采购合同
     * @return 结果
     */
    @Override
    @Transactional
    public int addPurchasecontract(String purchasecontractList, Purchasecontract purchasecontract) {
        JSONArray productArray = JSONArray.fromObject(purchasecontractList);
        Float sum=0f;
            for (int i = 0; i < productArray.size(); i++) {
            JSONObject jsonObject = productArray.getJSONObject(i);
            Purchasedetail purchasedetail = new Purchasedetail();
            purchasedetail.setProductname(jsonObject.getString("productname"));
            purchasedetail.setUnit(jsonObject.getString("unit"));
            purchasedetail.setSpecifications(jsonObject.getString("specifications"));
            if(!jsonObject.getString("producttype").equals("null")) {
                purchasedetail.setProducttype(jsonObject.getString("producttype"));
            }
            purchasedetail.setPrice(Float.valueOf(jsonObject.getString("purchaseprice")));
            purchasedetail.setProductnum(Float.valueOf(jsonObject.getString("purchaseproductnum")));
            purchasedetail.setMoney(Float.valueOf(jsonObject.getString("purchasemoney")));
            purchasedetail.setSelldetailid(Long.valueOf(jsonObject.getString("id")));
            sum+=Float.valueOf(jsonObject.getString("purchasemoney"));
            purchasedetail.setPurchasecontractid(purchasecontract.getPurchasecontractid());
            purchasedetailMapper.insertPurchasedetail(purchasedetail);
            SellDetail sellDetail=new SellDetail();
                sellDetail.setId(Long.valueOf(jsonObject.getString("id")));
                sellDetail.setPurchasecontractid(purchasecontract.getPurchasecontractid());
            sellDetailMapper.updatePurchasestatusAndPurchasecontractid(sellDetail);
        }
        purchasecontract.setPurchasesamount(sum);
        return purchasecontractMapper.insertPurchasecontract(purchasecontract);

    }



    /**
     * 修改采购合同
     * 
     * @param purchasecontract 采购合同
     * @return 结果
     */
    @Override
    public int updatePurchasecontract(Purchasecontract purchasecontract)
    {
        return purchasecontractMapper.updatePurchasecontract(purchasecontract);
    }

    /**
     * 删除采购合同对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deletePurchasecontractByIds(String ids)
    {
        return purchasecontractMapper.deletePurchasecontractByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除采购合同信息
     * 
     * @param id 采购合同ID
     * @return 结果
     */
    @Override
    public int deletePurchasecontractById(Long id)
    {
        return purchasecontractMapper.deletePurchasecontractById(id);
    }

    @Override
    public List<Purchasecontract> selectPurchasecontractByContractId(String contractid) {
        return purchasecontractMapper.selectPurchasecontractByContractId(contractid);
    }

    @Override
    public String findcontractid(String contractid) {
        if(contractid.indexOf(",")!=-1){
            contractid=contractid.replace(",","-")+"-";
          String maxcontractid= purchasecontractMapper.selectMaxPurchasecontractByContractId(contractid);

          if (maxcontractid==null||maxcontractid.length()==0){
              return contractid+"001";
          } else{
              Integer purchasecontractidCount= Integer.valueOf(maxcontractid.substring(maxcontractid.lastIndexOf("-")+1))+1;
              if(purchasecontractidCount<10){
                  contractid="00"+purchasecontractidCount;
              }else if(purchasecontractidCount<100){
                  contractid="0"+purchasecontractidCount;
              }else{
                  contractid=String.valueOf(purchasecontractidCount);
              }
              return  contractid;
          }

        }

         String contractidType=contractid.substring(2, 3);
        if( purchasecontractMapper.selectPurchasecontractByContractId(contractid).size()<1){
            return contractid+contractidType+"001";
        }else{
            String maxPurchasecontractid = purchasecontractMapper.selectMaxPurchasecontractByContractId(contractid);
            Integer purchasecontractidCount= Integer.valueOf(maxPurchasecontractid.substring(maxPurchasecontractid.lastIndexOf(contractidType)+1))+1;
            String purchasecontractid="";
            if(purchasecontractidCount<10){
                purchasecontractid="00"+purchasecontractidCount;
            }else if(purchasecontractidCount<100){
                purchasecontractid="0"+purchasecontractidCount;
            }else{
                purchasecontractid=String.valueOf(purchasecontractidCount);
            }
            return   contractid+contractidType+purchasecontractid;
        }


    }

    @Override
    public Float selectPurchasesamountsumByContractId(String contractid) {
        return purchasecontractMapper.selectPurchasesamountsumByContractId(contractid);
    }

    @Override
    public List<Map<String, Object>> selectPurchasesamountByMonth(String newdate) {
        return purchasecontractMapper.selectPurchasesamountByMonth(newdate);
    }

    @Override
    public List<Map<String, Object>> selectPurchasesamountByday(String newyear, String newmonth) {
        return purchasecontractMapper.selectPurchasesamountByday(newyear,newmonth);
    }
}
