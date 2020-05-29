package com.ruoyi.system.service;

import java.util.List;
import java.util.Map;

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
    public int insertPurchasecontract(Purchasecontract purchasecontract);

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
    public int deletePurchasecontractById(Long id);



    /**
     * 查询采购合同
     * @param contractid
     * @return
     */
    public List<Purchasecontract> selectPurchasecontractByContractId(String contractid);

    /**
     * 生成采购合同
     * @param contractid
     * @return
     */
    String findcontractid(String contractid);

    /**
     * 根据销售合同查询所有的采购金额
     * @param contractid
     * @return
     */
    public Double selectPurchasesamountsumByContractId(String contractid);


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


}
