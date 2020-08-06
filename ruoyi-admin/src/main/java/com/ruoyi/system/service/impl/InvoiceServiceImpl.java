package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.mapper.SellDetailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.InvoiceMapper;
import com.ruoyi.system.domain.Invoice;
import com.ruoyi.system.service.IInvoiceService;
import com.ruoyi.common.core.text.Convert;

/**
 * 发票Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-07-09
 */
@Service
public class InvoiceServiceImpl implements IInvoiceService 
{
    @Autowired
    private InvoiceMapper invoiceMapper;
    @Autowired
    private SellDetailMapper sellDetailMapper;


    /**
     * 查询发票
     * 
     * @param id 发票ID
     * @return 发票
     */
    @Override
    public Invoice selectInvoiceById(Long id)
    {
        return invoiceMapper.selectInvoiceById(id);
    }

    /**
     * 查询发票列表
     * 
     * @param invoice 发票
     * @return 发票
     */
    @Override
    public List<Invoice> selectInvoiceList(Invoice invoice)
    {
        return invoiceMapper.selectInvoiceList(invoice);
    }

    /**
     * 新增发票
     * 
     * @param invoice 发票
     * @return 结果
     */
    @Override
    public int insertInvoice(Invoice invoice)
    {

        if(invoice.getSelldetailids()!=null){
            String[] split = invoice.getSelldetailids().split(",");
            for (int i=0;i<split.length;i++){
                invoice.setSelldetailid(Long.valueOf(split[i]));
                invoiceMapper.insertInvoice(invoice);
            }
            return 1;
        }else{
            invoice.setCreateTime(DateUtils.getNowDate());
            return invoiceMapper.insertInvoice(invoice);
        }


    }

    /**
     * 修改发票
     * 
     * @param invoice 发票
     * @return 结果
     */
    @Override
    public int updateInvoice(Invoice invoice)
    {
        return invoiceMapper.updateInvoice(invoice);
    }

    /**
     * 删除发票对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteInvoiceByIds(String invoiceid)
    {

        return invoiceMapper.deleteInvoiceByIds(invoiceid);
    }

    @Override
    public List<Invoice> selectInvoiceListbycontractid(String contractid) {
        return invoiceMapper.selectInvoiceListbycontractid(contractid);
    }

    /**
     * 删除发票信息
     * 
     * @param id 发票ID
     * @return 结果
     */
    @Override
    public int deleteInvoiceById(Long id)
    {

        return invoiceMapper.deleteInvoiceById(id);
    }

    @Override
    public List<Invoice> sumMoneyGYear(String newDate) {
        return invoiceMapper.sumMoneyGYear(newDate);
    }

    @Override
    public List<Invoice> findList() {
        return invoiceMapper.findList();
    }
}
