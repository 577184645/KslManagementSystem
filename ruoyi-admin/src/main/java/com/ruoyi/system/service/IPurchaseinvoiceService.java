package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Purchaseinvoice;

/**
 * 采购发票列表Service接口
 * 
 * @author ruoyi
 * @date 2020-05-25
 */
public interface IPurchaseinvoiceService 
{
    /**
     * 查询采购发票列表
     * 
     * @param id 采购发票列表ID
     * @return 采购发票列表
     */
    public Purchaseinvoice selectPurchaseinvoiceById(Long id);

    /**
     * 查询采购发票列表列表
     * 
     * @param purchaseinvoice 采购发票列表
     * @return 采购发票列表集合
     */
    public List<Purchaseinvoice> selectPurchaseinvoiceList(Purchaseinvoice purchaseinvoice);

    /**
     * 新增采购发票列表
     * 
     * @param purchaseinvoice 采购发票列表
     * @return 结果
     */
    public int insertPurchaseinvoice(Purchaseinvoice purchaseinvoice);

    /**
     * 修改采购发票列表
     * 
     * @param purchaseinvoice 采购发票列表
     * @return 结果
     */
    public int updatePurchaseinvoice(Purchaseinvoice purchaseinvoice);

    /**
     * 批量删除采购发票列表
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deletePurchaseinvoiceByIds(String ids);

    /**
     * 删除采购发票列表信息
     * 
     * @param id 采购发票列表ID
     * @return 结果
     */
    public int deletePurchaseinvoiceById(Long id);
}
