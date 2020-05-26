package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.PurchasedetailChild;

/**
 * 采购订单子Mapper接口
 * 
 * @author ruoyi
 * @date 2020-05-26
 */
public interface PurchasedetailChildMapper 
{
    /**
     * 查询采购订单子
     * 
     * @param id 采购订单子ID
     * @return 采购订单子
     */
    public PurchasedetailChild selectPurchasedetailChildById(Long id);







    /**
     * 查询采购订单子列表
     * 
     * @param purchasedetailChild 采购订单子
     * @return 采购订单子集合
     */
    public List<PurchasedetailChild> selectPurchasedetailChildList(PurchasedetailChild purchasedetailChild);

    /**
     * 新增采购订单子
     * 
     * @param purchasedetailChild 采购订单子
     * @return 结果
     */
    public int insertPurchasedetailChild(PurchasedetailChild purchasedetailChild);

    /**
     * 修改采购订单子
     * 
     * @param purchasedetailChild 采购订单子
     * @return 结果
     */
    public int updatePurchasedetailChild(PurchasedetailChild purchasedetailChild);

    /**
     * 删除采购订单子
     * 
     * @param id 采购订单子ID
     * @return 结果
     */
    public int deletePurchasedetailChildById(Long id);

    /**
     * 批量删除采购订单子
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deletePurchasedetailChildByIds(String[] ids);
}
