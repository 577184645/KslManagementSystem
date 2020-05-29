package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.PurchasedetailChildMapper;
import com.ruoyi.system.domain.PurchasedetailChild;
import com.ruoyi.system.service.IPurchasedetailChildService;
import com.ruoyi.common.core.text.Convert;

/**
 * 采购订单子Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-05-26
 */
@Service
public class PurchasedetailChildServiceImpl implements IPurchasedetailChildService 
{
    @Autowired
    private PurchasedetailChildMapper purchasedetailChildMapper;


    @Override
    public List<PurchasedetailChild> selectPurchasedetailChildPurchasedetailid(Long purchasedetailid) {
        return purchasedetailChildMapper.selectPurchasedetailChildPurchasedetailid(purchasedetailid);
    }

    /**
     * 查询采购订单子
     * 
     * @param id 采购订单子ID
     * @return 采购订单子
     */
    @Override
    public PurchasedetailChild selectPurchasedetailChildById(Long id)
    {
        return purchasedetailChildMapper.selectPurchasedetailChildById(id);
    }

    /**
     * 查询采购订单子列表
     * 
     * @param purchasedetailChild 采购订单子
     * @return 采购订单子
     */
    @Override
    public List<PurchasedetailChild> selectPurchasedetailChildList(PurchasedetailChild purchasedetailChild)
    {
        return purchasedetailChildMapper.selectPurchasedetailChildList(purchasedetailChild);
    }

    /**
     * 新增采购订单子
     * 
     * @param purchasedetailChild 采购订单子
     * @return 结果
     */
    @Override
    public int insertPurchasedetailChild(PurchasedetailChild purchasedetailChild)
    {
        purchasedetailChild.setCreateTime(DateUtils.getNowDate());
        return purchasedetailChildMapper.insertPurchasedetailChild(purchasedetailChild);
    }

    /**
     * 修改采购订单子
     * 
     * @param purchasedetailChild 采购订单子
     * @return 结果
     */
    @Override
    public int updatePurchasedetailChild(PurchasedetailChild purchasedetailChild)
    {
        return purchasedetailChildMapper.updatePurchasedetailChild(purchasedetailChild);
    }

    /**
     * 删除采购订单子对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deletePurchasedetailChildByIds(String ids)
    {
        return purchasedetailChildMapper.deletePurchasedetailChildByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除采购订单子信息
     * 
     * @param id 采购订单子ID
     * @return 结果
     */
    @Override
    public int deletePurchasedetailChildById(Long id)
    {
        return purchasedetailChildMapper.deletePurchasedetailChildById(id);
    }
}
