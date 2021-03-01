package com.ruoyi.system.service.impl;

import java.util.List;
import java.util.Map;

import com.ruoyi.common.constant.AdminConstants;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.*;
import com.ruoyi.system.mapper.PurchasecontractMapper;
import com.ruoyi.system.mapper.PurchasedetailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.PurchaseinvoiceMapper;
import com.ruoyi.system.service.IPurchaseinvoiceService;
import com.ruoyi.common.core.text.Convert;
import org.springframework.transaction.annotation.Transactional;

/**
 * 采购发票Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-07-09
 */
@Service
@Transactional
public class PurchaseinvoiceServiceImpl implements IPurchaseinvoiceService 
{
    @Autowired
    private PurchaseinvoiceMapper purchaseinvoiceMapper;
    @Autowired
    private PurchasedetailMapper purchasedetailMapper;
    @Autowired
    private PurchasecontractMapper purchasecontractMapper;

    /**
     * 查询采购发票
     * 
     * @param id 采购发票ID
     * @return 采购发票
     */
    @Override
    public Purchaseinvoice selectPurchaseinvoiceById(Long id)
    {
        return purchaseinvoiceMapper.selectPurchaseinvoiceById(id);
    }



    /**
     * 查询采购发票列表
     * 
     * @param purchaseinvoice 采购发票
     * @return 采购发票
     */
    @Override
    public List<Purchaseinvoice> selectPurchaseinvoiceList(Purchaseinvoice purchaseinvoice)
    {
        return purchaseinvoiceMapper.selectPurchaseinvoiceList(purchaseinvoice);
    }

    /**
     * 新增采购发票
     * 
     * @param purchaseinvoice 采购发票
     * @return 结果
     */
    @Override
    public boolean insertPurchaseinvoice(Long purchasecontractid,Purchaseinvoice purchaseinvoice,String purchasedetailids) {

        String[] ids = purchasedetailids.split(",");
        //判断这张发票是否存在
        Purchaseinvoice oldpurchaseinvoice = purchaseinvoiceMapper.selectPurchaseinvoiceByPurchaseinvoiceid(purchaseinvoice.getPurchaseinvoiceid());
        if(oldpurchaseinvoice!=null){
            purchaseinvoiceMapper.updatePurchaseinvoiceByPurchaseinvoiceid(purchaseinvoice.getMoney(),purchaseinvoiceMapper.selectPurchaseinvoiceByPurchaseinvoiceid(purchaseinvoice.getPurchaseinvoiceid()).getId());
            purchaseinvoice.setId(oldpurchaseinvoice.getId());
        }else{
            purchaseinvoiceMapper.insertPurchaseinvoice(purchaseinvoice);
        }
        for (String id : ids) {
            Purchasedetail purchasedetail=new Purchasedetail();
            purchasedetail.setPurchaseinvoiceId(purchaseinvoice.getId());
            purchasedetail.setId(Long.valueOf(id));
            purchasedetailMapper.updatePurchaseinvoiceId(purchasedetail);
        }
        updatePurchasecontract(purchasecontractid);
        return true;
    }

    /**
     * 修改采购发票
     * 
     * @param purchaseinvoice 采购发票
     * @return 结果
     */
    @Override
    public int updatePurchaseinvoice(Purchaseinvoice purchaseinvoice)
    {
        return purchaseinvoiceMapper.updatePurchaseinvoice(purchaseinvoice);
    }

    /**
     * 修改发票状态
     */
    private void updatePurchasecontract(Long purchasecontractId){
        Map map = purchasecontractMapper.selectPurchasecontractByInvoiceStatus(purchasecontractId);
        Purchasecontract purchasecontract1=new Purchasecontract();
        purchasecontract1.setId(purchasecontractId);
        if((long)map.get("icount")==0){
            purchasecontract1.setInvoiceStatus(AdminConstants.Salescontract.INVOICESTATUS_NOOPEN);
        }else if((long)map.get("icount")!=(long)map.get("scount")){
            purchasecontract1.setInvoiceStatus(AdminConstants.Salescontract.INVOICESTATUS_INCOMPLATE);
        }else{
            purchasecontract1.setInvoiceStatus(AdminConstants.Salescontract.INVOICESTATUS_OPEN);
        }
        purchasecontractMapper.updatePurchasecontract(purchasecontract1);
    }

    /**
     * 删除采购发票对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deletePurchaseinvoiceByIds(String ids)
    {
        for (String s : ids.split(",")) {
            List<Long> purchasecontracts = purchaseinvoiceMapper.selectInvoiceListByIdGetPurchaseContractid(Long.valueOf(s));
            purchasedetailMapper.updatePurchasedetailByPurchaseinvoiceId(Long.valueOf(s));
            for (Long purchasecontract : purchasecontracts) {
                updatePurchasecontract(purchasecontract);
            }
        }
        return purchaseinvoiceMapper.deletePurchaseinvoiceByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除采购发票信息
     *
     * @param id 采购发票ID
     * @return 结果
     */
    @Override
    public int deletePurchaseinvoiceById(Long id)
    {
        return purchaseinvoiceMapper.deletePurchaseinvoiceById(id);
    }


}
