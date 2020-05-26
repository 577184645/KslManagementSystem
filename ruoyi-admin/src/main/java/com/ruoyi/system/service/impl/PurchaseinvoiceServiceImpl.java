package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.PurchaseinvoiceMapper;
import com.ruoyi.system.domain.Purchaseinvoice;
import com.ruoyi.system.service.IPurchaseinvoiceService;
import com.ruoyi.common.core.text.Convert;

/**
 * 采购发票列表Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-05-25
 */
@Service
public class PurchaseinvoiceServiceImpl implements IPurchaseinvoiceService 
{
    @Autowired
    private PurchaseinvoiceMapper purchaseinvoiceMapper;

    /**
     * 查询采购发票列表
     * 
     * @param id 采购发票列表ID
     * @return 采购发票列表
     */
    @Override
    public Purchaseinvoice selectPurchaseinvoiceById(Long id)
    {
        return purchaseinvoiceMapper.selectPurchaseinvoiceById(id);
    }

    /**
     * 查询采购发票列表列表
     * 
     * @param purchaseinvoice 采购发票列表
     * @return 采购发票列表
     */
    @Override
    public List<Purchaseinvoice> selectPurchaseinvoiceList(Purchaseinvoice purchaseinvoice)
    {
        return purchaseinvoiceMapper.selectPurchaseinvoiceList(purchaseinvoice);
    }

    /**
     * 新增采购发票列表
     * 
     * @param purchaseinvoice 采购发票列表
     * @return 结果
     */
    @Override
    public int insertPurchaseinvoice(Purchaseinvoice purchaseinvoice)
    {
        purchaseinvoice.setCreateTime(DateUtils.getNowDate());
        return purchaseinvoiceMapper.insertPurchaseinvoice(purchaseinvoice);
    }

    /**
     * 修改采购发票列表
     * 
     * @param purchaseinvoice 采购发票列表
     * @return 结果
     */
    @Override
    public int updatePurchaseinvoice(Purchaseinvoice purchaseinvoice)
    {
        return purchaseinvoiceMapper.updatePurchaseinvoice(purchaseinvoice);
    }

    /**
     * 删除采购发票列表对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deletePurchaseinvoiceByIds(String ids)
    {
        return purchaseinvoiceMapper.deletePurchaseinvoiceByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除采购发票列表信息
     * 
     * @param id 采购发票列表ID
     * @return 结果
     */
    @Override
    public int deletePurchaseinvoiceById(Long id)
    {
        return purchaseinvoiceMapper.deletePurchaseinvoiceById(id);
    }
}
