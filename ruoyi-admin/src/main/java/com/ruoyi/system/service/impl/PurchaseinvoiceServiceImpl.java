package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.Purchasedetail;
import com.ruoyi.system.mapper.PurchasedetailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.PurchaseinvoiceMapper;
import com.ruoyi.system.domain.Purchaseinvoice;
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
public class PurchaseinvoiceServiceImpl implements IPurchaseinvoiceService 
{
    @Autowired
    private PurchaseinvoiceMapper purchaseinvoiceMapper;
    @Autowired
    private PurchasedetailMapper purchasedetailMapper;

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

    @Override
    public List<Purchaseinvoice> selectPurchaseinvoiceByContractid(String contractid) {
        return purchaseinvoiceMapper.selectPurchaseinvoiceByContractid(contractid);
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
    @Transactional
    public int insertPurchaseinvoice(Purchaseinvoice purchaseinvoice,String purchasedetailids) {

        String[] ids = purchasedetailids.split(",");
         if(purchaseinvoiceMapper.selectPurchaseinvoiceByPurchaseinvoiceid(purchaseinvoice.getPurchaseinvoiceid())!=null) {
           purchaseinvoiceMapper.updatePurchaseinvoiceByPurchaseinvoiceid(purchaseinvoice.getMoney(),purchaseinvoiceMapper.selectPurchaseinvoiceByPurchaseinvoiceid(purchaseinvoice.getPurchaseinvoiceid()).getId());
             for (String id : ids) {
                 Purchasedetail purchasedetail=new Purchasedetail();
                 purchasedetail.setPurchaseinvoiceId(purchaseinvoiceMapper.selectPurchaseinvoiceByPurchaseinvoiceid(purchaseinvoice.getPurchaseinvoiceid()).getId());
                 purchasedetail.setId(Long.valueOf(id));
                 purchasedetailMapper.updatePurchaseinvoiceId(purchasedetail);
             }

         }else {
             if(purchaseinvoiceMapper.insertPurchaseinvoice(purchaseinvoice)>0){
                 for (String id : ids) {
                     Purchasedetail purchasedetail=new Purchasedetail();
                     purchasedetail.setPurchaseinvoiceId(purchaseinvoice.getId());
                     purchasedetail.setId(Long.valueOf(id));
                     purchasedetailMapper.updatePurchaseinvoiceId(purchasedetail);
                 }
             }

         }




        return 1;


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
     * 删除采购发票对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    @Transactional
    public int deletePurchaseinvoiceByIds(String ids)
    {
        String[] idarray = ids.split(",");
        for (String id : idarray) {
            purchasedetailMapper.updatePurchasedetailByPurchaseinvoiceId(Long.valueOf(id));
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
    @Override
    public List<Purchaseinvoice> selectPurchaseinvoiceByScontract(String Saleconract) {
        return purchaseinvoiceMapper.selectPurchaseinvoiceByScontract(Saleconract);
    }
}
