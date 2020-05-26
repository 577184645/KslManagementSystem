package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.PurchasedetailMapper;
import com.ruoyi.system.domain.Purchasedetail;
import com.ruoyi.system.service.IPurchasedetailService;
import com.ruoyi.common.core.text.Convert;

/**
 * 采购订单列表Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-05-25
 */
@Service
public class PurchasedetailServiceImpl implements IPurchasedetailService 
{
    @Autowired
    private PurchasedetailMapper purchasedetailMapper;

    /**
     * 查询采购订单列表
     * 
     * @param id 采购订单列表ID
     * @return 采购订单列表
     */
    @Override
    public Purchasedetail selectPurchasedetailById(Long id)
    {
        return purchasedetailMapper.selectPurchasedetailById(id);
    }

    @Override
    public List<Purchasedetail> selectPurchasedetailListByPurchasecontractId(String purchasecontractid) {
        return purchasedetailMapper.selectPurchasedetailListByPurchasecontractId(purchasecontractid);
    }

    /**
     * 查询采购订单列表列表
     * 
     * @param purchasedetail 采购订单列表
     * @return 采购订单列表
     */
    @Override
    public List<Purchasedetail> selectPurchasedetailList(Purchasedetail purchasedetail)
    {
        return purchasedetailMapper.selectPurchasedetailList(purchasedetail);
    }

    /**
     * 新增采购订单列表
     * 
     * @param purchasedetail 采购订单列表
     * @return 结果
     */
    @Override
    public int insertPurchasedetail(Purchasedetail purchasedetail)
    {
        purchasedetail.setCreateTime(DateUtils.getNowDate());
        return purchasedetailMapper.insertPurchasedetail(purchasedetail);
    }

    /**
     * 修改采购订单列表
     * 
     * @param purchasedetail 采购订单列表
     * @return 结果
     */
    @Override
    public int updatePurchasedetail(Purchasedetail purchasedetail)
    {
        return purchasedetailMapper.updatePurchasedetail(purchasedetail);
    }

    /**
     * 删除采购订单列表对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deletePurchasedetailByIds(String ids)
    {
        return purchasedetailMapper.deletePurchasedetailByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除采购订单列表信息
     * 
     * @param id 采购订单列表ID
     * @return 结果
     */
    @Override
    public int deletePurchasedetailById(Long id)
    {
        return purchasedetailMapper.deletePurchasedetailById(id);
    }
}
