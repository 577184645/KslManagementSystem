package com.ruoyi.system.service;

import java.util.List;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.system.domain.Purchasedetail;

/**
 * 采购订单列表Service接口
 * 
 * @author ruoyi
 * @date 2020-05-25
 */
public interface IPurchasedetailService 
{
    /**
     * 查询采购订单列表
     * 
     * @param id 采购订单列表ID
     * @return 采购订单列表
     */
    public Purchasedetail selectPurchasedetailById(Long id);



    /**
     * 查询采购订单列表列表
     * 
     * @param purchasedetail 采购订单列表
     * @return 采购订单列表集合
     */
    public List<Purchasedetail> selectPurchasedetailList(Purchasedetail purchasedetail);

    /**
     * 新增采购订单列表
     * 
     * @param purchasedetail 采购订单列表
     * @return 结果
     */
    public int insertPurchasedetail(Purchasedetail purchasedetail);

    /**
     * 修改采购订单列表
     * 
     * @param purchasedetail 采购订单列表
     * @return 结果
     */
    public int updatePurchasedetail(Purchasedetail purchasedetail);

    /**
     * 批量删除采购订单列表
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deletePurchasedetailByIds(String ids);

    /**
     * 删除采购订单列表信息
     * 
     * @param id 采购订单列表ID
     * @return 结果
     */
    public AjaxResult deletePurchasedetailById(Long id);
}
