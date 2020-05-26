package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Purchasecontract;

/**
 * 采购合同Mapper接口
 * 
 * @author ruoyi
 * @date 2020-05-22
 */
public interface PurchasecontractMapper 
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
    public int insertPurchasecontract(Purchasecontract purchasecontract);

    /**
     * 修改采购合同
     * 
     * @param purchasecontract 采购合同
     * @return 结果
     */
    public int updatePurchasecontract(Purchasecontract purchasecontract);

    /**
     * 删除采购合同
     * 
     * @param id 采购合同ID
     * @return 结果
     */
    public int deletePurchasecontractById(Long id);

    /**
     * 批量删除采购合同
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deletePurchasecontractByIds(String[] ids);


    /**
     * 查询采购合同
     * @param contractid
     * @return
     */
    public List<Purchasecontract> selectPurchasecontractByContractId(String contractid);


    /**
     * 根据销售合同查询最大的采购合同值
     * @param contractid
     * @return
     */
    public String selectMaxPurchasecontractByContractId(String contractid);
}
