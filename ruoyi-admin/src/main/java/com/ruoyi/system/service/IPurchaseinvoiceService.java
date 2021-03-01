package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Purchaseinvoice;
import org.apache.ibatis.annotations.Param;

/**
 * 采购发票Service接口
 * 
 * @author ruoyi
 * @date 2020-07-09
 */
public interface IPurchaseinvoiceService 
{
    /**
     * 查询采购发票
     * 
     * @param id 采购发票ID
     * @return 采购发票
     */
    public Purchaseinvoice selectPurchaseinvoiceById(Long id);




    /**
     * 查询采购发票列表
     * 
     * @param purchaseinvoice 采购发票
     * @return 采购发票集合
     */
    public List<Purchaseinvoice> selectPurchaseinvoiceList(Purchaseinvoice purchaseinvoice);

    /**
     * 新增采购发票
     * 
     * @param purchaseinvoice 采购发票
     * @return 结果
     */
    public boolean insertPurchaseinvoice(Long purchasecontractid ,Purchaseinvoice purchaseinvoice,String purchasedetailids);

    /**
     * 修改采购发票
     * 
     * @param purchaseinvoice 采购发票
     * @return 结果
     */
    public int updatePurchaseinvoice(Purchaseinvoice purchaseinvoice);

    /**
     * 批量删除采购发票
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deletePurchaseinvoiceByIds(String ids);

    /**
     * 删除采购发票信息
     *
     * @param id 采购发票ID
     * @return 结果
     */
    public int deletePurchaseinvoiceById(Long id);



}
