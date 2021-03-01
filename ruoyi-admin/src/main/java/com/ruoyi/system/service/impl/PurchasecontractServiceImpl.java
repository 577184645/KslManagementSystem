package com.ruoyi.system.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.Purchasedetail;
import com.ruoyi.system.domain.Salescontract;
import com.ruoyi.system.domain.SellDetail;
import com.ruoyi.system.mapper.PurchasedetailMapper;
import com.ruoyi.system.mapper.SellDetailMapper;
import com.ruoyi.system.utils.jsonlistUtil;
import com.ruoyi.system.utils.numberUtil;
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
@Transactional
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
    public int addPurchasecontract(String purchasecontractList, Purchasecontract purchasecontract) {
        List<String[]> jsonList = jsonlistUtil.getJsonList(purchasecontractList, new String[]{"id", "purchaseprice", "purchasemoney", "purchaseproductnum"});
        Double sum=0.0;
      int result=  purchasecontractMapper.insertPurchasecontract(purchasecontract);
        for (int i = 0; i < jsonList.size(); i++) {
            String[] strings = jsonList.get(i);
            Purchasedetail purchasedetail=new Purchasedetail();
            purchasedetail.setSelldetailId(Long.valueOf(strings[0]));
            purchasedetail.setPrice(Double.valueOf(strings[1]));
            purchasedetail.setMoney(Double.valueOf(strings[2]));
            purchasedetail.setProductnum(Integer.valueOf(strings[3]));
            purchasedetail.setPurchasecontractId(purchasecontract.getId());
            purchasedetailMapper.insertPurchasedetail(purchasedetail);
            sellDetailMapper.updatePurchaseStatusById(Long.valueOf(Long.valueOf(strings[0])));
            sum+=purchasedetail.getMoney();
        }
        Purchasecontract updatepurchasecontract=new Purchasecontract();
        updatepurchasecontract.setId(purchasecontract.getId());
        updatepurchasecontract.setPurchasesamount(sum);
        purchasecontractMapper.updatePurchasecontract(updatepurchasecontract);
        return result;
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
    public AjaxResult deletePurchasecontractById(Long id)
    {
        List<Purchasedetail> purchasedetails = purchasedetailMapper.selectPurchasedetailListByPurchasecontractId(id);
        if(purchasedetails!=null&&purchasedetails.size()>0) {
            return AjaxResult.error("操作失败,采购合同下有订单信息!");
        }
        purchasecontractMapper.deletePurchasecontractById(id);
        return   AjaxResult.success("操作成功!");

    }

    @Override
    public Map<String, Object> print(String PurchasecontractId) {
        Map<String, Object> map=new HashMap<>();
        Purchasecontract purchasecontract=new Purchasecontract();
        if( numberUtil.isNumeric(PurchasecontractId)) {
            purchasecontract = purchasecontractMapper.selectPurchasecontractById(Long.valueOf(PurchasecontractId));
        }else{
            purchasecontract= purchasecontractMapper.selectPurchasecontractByPurchaseContractid(PurchasecontractId);
        }
        List<Purchasedetail> purchasedetails = purchasedetailMapper.selectPurchasedetailListByPurchasecontractId(purchasecontract.getId());
        map.put("purchasecontract", purchasecontract);
        map.put("purchasedetails", purchasedetails);
        return map;
    }


    @Override
    public String findcontractid(Long contractid,String contractnumber) {
        String maxcontractid= purchasecontractMapper.selectMaxPurchasecontractByContractId(contractid);
         String contractidType=contractnumber.substring(2,3);
          if (maxcontractid!=null){
              String purchasecontractid="";
              Integer purchasecontractidCount= Integer.valueOf(maxcontractid.substring(maxcontractid.lastIndexOf(contractidType)+1))+1;
              if(purchasecontractidCount<10){
                  purchasecontractid="00"+purchasecontractidCount;
              }else if(purchasecontractidCount<100){
                  purchasecontractid="0"+purchasecontractidCount;
              }else{
                  purchasecontractid=String.valueOf(purchasecontractidCount);
              }
              return   contractnumber+contractidType+purchasecontractid;
          }
          else{
              return contractnumber+contractidType+"001";
          }

    }





 
}
