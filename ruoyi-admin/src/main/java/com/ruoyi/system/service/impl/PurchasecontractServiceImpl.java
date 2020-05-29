package com.ruoyi.system.service.impl;

import java.util.List;
import java.util.Map;

import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.PurchasecontractMapper;
import com.ruoyi.system.domain.Purchasecontract;
import com.ruoyi.system.service.IPurchasecontractService;
import com.ruoyi.common.core.text.Convert;

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
    public int insertPurchasecontract(Purchasecontract purchasecontract)
    {
        purchasecontract.setCreateTime(DateUtils.getNowDate());
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

        if( purchasecontractMapper.selectPurchasecontractByContractId(contractid).size()<1){
            return contractid+contractid.substring(2, 3)+"001";
        }else{
            String s = purchasecontractMapper.selectMaxPurchasecontractByContractId(contractid);
            String   s1= s.substring(0,s.length()-3);
            Integer s2= Integer.valueOf(s.substring(s.length()-3))+1;
            String s3="";
            if(s2<10){
                s3="00"+s2;
            }else if(s2<100){
                s3="0"+s2;
            }else{
                s3=String.valueOf(s2);
            }
            return   s1+s3;
        }


    }

    @Override
    public Double selectPurchasesamountsumByContractId(String contractid) {
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
