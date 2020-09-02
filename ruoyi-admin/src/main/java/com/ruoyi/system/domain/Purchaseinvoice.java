package com.ruoyi.system.domain;

import java.util.Date;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 采购发票对象 purchaseinvoice
 * 
 * @author ruoyi
 * @date 2020-07-09
 */
public class Purchaseinvoice extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 发票编号 */
    @Excel(name = "发票编号")
    private String purchaseinvoiceid;



    @Excel(name = "采购合同号")
    private String purchasecontractid;

    @Excel(name = "供应商")
    private String supplier;

    /** 发票金额 */
    @Excel(name = "发票金额")
    private Float money;

    /** 商品数量 */
    @Excel(name = "商品数量")
    private Float productnum;

    /** 开票时间 */
    @Excel(name = "开票时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date purchaseinvoicetime;



  private  String  purchasedetailids;

    /** 采购订单号 */
    private String purchasedetailid;

    private String spurchasecontractid;
    private String ssupplier;

    public String getSpurchasecontractid() {
        return spurchasecontractid;
    }

    public String getPurchasedetailids() {
        return purchasedetailids;
    }

    public void setPurchasedetailids(String purchasedetailids) {
        this.purchasedetailids = purchasedetailids;
    }

    public void setSpurchasecontractid(String spurchasecontractid) {
        this.spurchasecontractid = spurchasecontractid;
    }

    public void setId(Long id)
    {
        this.id = id;
    }



    public String getPurchasecontractid() {
        return purchasecontractid;
    }

    public void setPurchasecontractid(String purchasecontractid) {
        this.purchasecontractid = purchasecontractid;
    }

    public Long getId()
    {
        return id;
    }
    public void setPurchaseinvoiceid(String purchaseinvoiceid) 
    {
        this.purchaseinvoiceid = purchaseinvoiceid;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public void setPurchaseinvoicetime(Date purchaseinvoicetime)
    {
        this.purchaseinvoicetime = purchaseinvoicetime;
    }

    public Date getPurchaseinvoicetime() 
    {
        return purchaseinvoicetime;
    }

    public String getPurchaseinvoiceid() {
        return purchaseinvoiceid;
    }

    public Float getMoney() {
        return money;
    }

    public void setMoney(Float money) {
        this.money = money;
    }

    public Float getProductnum() {
        return productnum;
    }

    public void setProductnum(Float productnum) {
        this.productnum = productnum;
    }


    public String getPurchasedetailid() {
        return purchasedetailid;
    }

    public void setPurchasedetailid(String purchasedetailid) {
        this.purchasedetailid = purchasedetailid;
    }

    public String getSsupplier() {
        return ssupplier;
    }

    public void setSsupplier(String ssupplier) {
        this.ssupplier = ssupplier;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("purchaseinvoiceid", getPurchaseinvoiceid())
            .append("money", getMoney())
            .append("productnum", getProductnum())
            .append("purchaseinvoicetime", getPurchaseinvoicetime())
            .append("purchasedetailid", getPurchasedetailid())
            .append("createTime", getCreateTime())
            .toString();
    }
}
