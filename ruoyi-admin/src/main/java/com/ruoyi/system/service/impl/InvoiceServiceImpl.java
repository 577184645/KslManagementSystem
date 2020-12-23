package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.SellDetail;
import com.ruoyi.system.mapper.SellDetailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.InvoiceMapper;
import com.ruoyi.system.domain.Invoice;
import com.ruoyi.system.service.IInvoiceService;
import com.ruoyi.common.core.text.Convert;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
    public int insertInvoice(String selldetailids,Invoice invoice)
    {
        String[] ids = selldetailids.split(",");
      if(invoiceMapper.selectInvoiceByInvoiceid(invoice.getInvoiceid())!=null ){
          invoiceMapper.updateInvoiceByInvoiceid(invoice.getMoney(),invoiceMapper.selectInvoiceByInvoiceid(invoice.getInvoiceid()).getId());
          for (String id : ids) {
              SellDetail sellDetail = new SellDetail();
              sellDetail.setId(Long.valueOf(id));
              sellDetail.setInvoiceId(invoiceMapper.selectInvoiceByInvoiceid(invoice.getInvoiceid()).getId());
              sellDetailMapper.updateSellDetail(sellDetail);
          }

      }else{
          if(invoiceMapper.insertInvoice(invoice)>0){
              for (String id : ids) {
                  SellDetail sellDetail = new SellDetail();
                  sellDetail.setId(Long.valueOf(id));
                  sellDetail.setInvoiceId(invoice.getId());
                  sellDetailMapper.updateSellDetail(sellDetail);
              }
          }
      }


          return  1;
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
    @Transactional
    public int deleteInvoiceByIds(String ids)
    {
        for (String s : ids.split(",")) {
            sellDetailMapper.updateSellDetailByInvoiceId(s);
         }

        return invoiceMapper.deleteInvoiceByIds(Convert.toStrArray(ids));
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
    public Double sumMoneyGYear(String newDate) {
        return invoiceMapper.sumMoneyGYear(newDate);
    }

    @Override
    public List<Invoice> selectInvoiceListbycontractid(String contractid) {
        return invoiceMapper.selectInvoiceListbycontractid(contractid);
    }


}
