package com.ruoyi.system.service;

import java.util.List;
import java.util.Map;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.system.domain.Purchasecontract;
import org.apache.ibatis.annotations.Param;

/**
 * 采购合同Service接口
 * 
 * @author ruoyi
 * @date 2020-05-22
 */
public interface IPurchasecontractService 
{
    /**
     * 查询采购合同
     *
     * @param id 采购合同ID
     * @return 采购合同
     */
    public Purchasecontract selectPurchasecontractById(Long id);

    /**
     * 查询采购合同列表
     * 
     * @param purchasecontract 采购合同
     * @return 采购合同集合
     */
    public List<Purchasecontract> selectPurchasecontractList(Purchasecontract purchasecontract);

    /**
     * 新增采购合同
     * 
     * @param purchasecontract 采购合同
     * @return 结果
     */
    public int addPurchasecontract(String purchasecontractList,Purchasecontract purchasecontract);

    /**
     * 修改采购合同
     * 
     * @param purchasecontract 采购合同
     * @return 结果
     */
    public int updatePurchasecontract(Purchasecontract purchasecontract);

    /**
     * 批量删除采购合同
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deletePurchasecontractByIds(String ids);

    /**
     * 删除采购合同信息
     * 
     * @param id 采购合同ID
     * @return 结果
     */
    public AjaxResult deletePurchasecontractById(Long id);


    /**
     * 打印
     * @param PurchasecontractId
     * @return
     */
    public Map<String,Object>  print(String  PurchasecontractId);



    /**
     * 生成采购合同
     * @param contractid
     * @return
     */
    String findcontractid(Long contractid,String type);









}
