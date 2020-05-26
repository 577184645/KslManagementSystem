package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Invoice;

/**
 * 销售发票列表Service接口
 * 
 * @author ruoyi
 * @date 2020-05-21
 */
public interface IInvoiceService 
{
    /**
     * 查询销售发票列表
     * 
     * @param id 销售发票列表ID
     * @return 销售发票列表
     */
    public Invoice selectInvoiceById(Long id);

    /**
     * 查询销售发票列表列表
     * 
     * @param invoice 销售发票列表
     * @return 销售发票列表集合
     */
    public List<Invoice> selectInvoiceList(Invoice invoice);

    /**
     * 新增销售发票列表
     * 
     * @param invoice 销售发票列表
     * @return 结果
     */
    public int insertInvoice(Invoice invoice);

    /**
     * 修改销售发票列表
     * 
     * @param invoice 销售发票列表
     * @return 结果
     */
    public int updateInvoice(Invoice invoice);

    /**
     * 批量删除销售发票列表
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteInvoiceByIds(String ids);

    /**
     * 删除销售发票列表信息
     * 
     * @param id 销售发票列表ID
     * @return 结果
     */
    public int deleteInvoiceById(Long id);
}
