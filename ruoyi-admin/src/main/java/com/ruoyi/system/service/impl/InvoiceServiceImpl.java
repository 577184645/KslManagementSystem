package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.InvoiceMapper;
import com.ruoyi.system.domain.Invoice;
import com.ruoyi.system.service.IInvoiceService;
import com.ruoyi.common.core.text.Convert;

/**
 * 销售发票列表Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-05-21
 */
@Service
public class InvoiceServiceImpl implements IInvoiceService 
{
    @Autowired
    private InvoiceMapper invoiceMapper;

    @Override
    public Double sumMoneyGYear(String newDate) {
        return invoiceMapper.sumMoneyGYear(newDate);
    }

    /**
     * 查询销售发票列表
     * 
     * @param id 销售发票列表ID
     * @return 销售发票列表
     */
    @Override
    public Invoice selectInvoiceById(Long id)
    {
        return invoiceMapper.selectInvoiceById(id);
    }

    /**
     * 查询销售发票列表列表
     * 
     * @param invoice 销售发票列表
     * @return 销售发票列表
     */
    @Override
    public List<Invoice> selectInvoiceList(Invoice invoice)
    {
        return invoiceMapper.selectInvoiceList(invoice);
    }

    /**
     * 新增销售发票列表
     * 
     * @param invoice 销售发票列表
     * @return 结果
     */
    @Override
    public int insertInvoice(Invoice invoice)
    {
        invoice.setCreateTime(DateUtils.getNowDate());
        return invoiceMapper.insertInvoice(invoice);
    }

    /**
     * 修改销售发票列表
     * 
     * @param invoice 销售发票列表
     * @return 结果
     */
    @Override
    public int updateInvoice(Invoice invoice)
    {
        return invoiceMapper.updateInvoice(invoice);
    }

    /**
     * 删除销售发票列表对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteInvoiceByIds(String ids)
    {
        return invoiceMapper.deleteInvoiceByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除销售发票列表信息
     * 
     * @param id 销售发票列表ID
     * @return 结果
     */
    @Override
    public int deleteInvoiceById(Long id)
    {
        return invoiceMapper.deleteInvoiceById(id);
    }
}
