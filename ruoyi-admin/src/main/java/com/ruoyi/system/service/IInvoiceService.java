package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Invoice;

/**
 * 发票Service接口
 * 
 * @author ruoyi
 * @date 2020-07-09
 */
public interface IInvoiceService 
{
    /**
     * 查询发票
     * 
     * @param id 发票ID
     * @return 发票
     */
    public Invoice selectInvoiceById(Long id);

    /**
     * 查询发票列表
     * 
     * @param invoice 发票
     * @return 发票集合
     */
    public List<Invoice> selectInvoiceList(Invoice invoice);

    /**
     * 新增发票
     * 
     * @param invoice 发票
     * @return 结果
     */
    public int insertInvoice(Invoice invoice);

    /**
     * 修改发票
     * 
     * @param invoice 发票
     * @return 结果
     */
    public int updateInvoice(Invoice invoice);

    /**
     * 批量删除发票
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteInvoiceByIds(String ids);



    public List<Invoice> selectInvoiceListbycontractid(String contractid );
    /**
     * 删除发票信息
     * 
     * @param id 发票ID
     * @return 结果
     */
    public int deleteInvoiceById(Long id);

    /**
     * 当前年的发票金额
     * @param newDate
     * @return
     */
   public List<Invoice> sumMoneyGYear(String newDate);


    public List<Invoice> findList();
}
