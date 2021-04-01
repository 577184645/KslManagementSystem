package com.ruoyi.system.service.impl;

import java.util.List;
import java.util.Map;

import com.ruoyi.common.constant.AdminConstants;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.Salescontract;
import com.ruoyi.system.domain.SellDetail;
import com.ruoyi.system.mapper.SalescontractMapper;
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
@Transactional
public class InvoiceServiceImpl implements IInvoiceService 
{
    @Autowired
    private InvoiceMapper invoiceMapper;
    @Autowired
    private SellDetailMapper sellDetailMapper;
    @Autowired
    private SalescontractMapper salescontractMapper;


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
    public boolean insertInvoice(Long salescontractId,String selldetailids,Invoice invoice)
    {
        String[] ids = selldetailids.split(",");
        //判断这张发票是否存在,如果在则更新金额反之新增发票
        Invoice oldinvoice = invoiceMapper.selectInvoiceByInvoiceid(invoice.getInvoiceid());
        if(oldinvoice!=null ){
          invoiceMapper.updateInvoiceByInvoiceid(invoice.getMoney(),invoiceMapper.selectInvoiceByInvoiceid(invoice.getInvoiceid()).getId());
         invoice.setId(oldinvoice.getId());
        }else{
         invoiceMapper.insertInvoice(invoice);
      }
        for (String id : ids) {
            SellDetail sellDetail = new SellDetail();
            sellDetail.setId(Long.valueOf(id));
            sellDetail.setInvoiceId(invoice.getId());
            sellDetailMapper.updateSellDetail(sellDetail);
        }
        updateSalescontract(salescontractId);
        return  true;
    }


    /**
     * 修改发票状态
     * @param salescontractId
     */
    private void updateSalescontract(Long salescontractId){
        Map map = salescontractMapper.selectSalescontractByInvoiceStatus(salescontractId);
        Salescontract salescontract=new Salescontract();
        salescontract.setId(salescontractId);
        if((long)map.get("icount")==0){
            salescontract.setInvoiceStatus(AdminConstants.Salescontract.INVOICESTATUS_NOOPEN);
        }else if((long)map.get("icount")!=(long)map.get("scount")){
            salescontract.setInvoiceStatus(AdminConstants.Salescontract.INVOICESTATUS_INCOMPLATE);
        }else{
            salescontract.setInvoiceStatus(AdminConstants.Salescontract.INVOICESTATUS_OPEN);
        }
        salescontractMapper.updateSalescontract(salescontract);
    };

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
    public int deleteInvoiceByIds(String ids)
    {
        for (String s : ids.split(",")) {
            //找到这张发票下所有的关联的合同 修改发票关联商品发票id为null 修改合同状态
            List<Long> contractids = invoiceMapper.selectInvoiceListByIdGetContractid(Long.valueOf(s));
            sellDetailMapper.updateInvoiceIdNullByInvoiceId(s);
            for (Long contractid : contractids) {
                updateSalescontract(contractid);
            }
         }

        return invoiceMapper.deleteInvoiceByIds(Convert.toStrArray(ids));
    }







}
