package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 采购订单列表对象 purchasedetail
 * 
 * @author ruoyi
 * @date 2020-05-25
 */
public class Purchasedetail extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 商品名称 */
    @Excel(name = "商品名称")
    private String productname;






    /** 单价 */
    @Excel(name = "单价")
    private Float price;

    /** 单位 */
    @Excel(name = "单位")
    private String unit;

    /** 型号 */
    @Excel(name = "型号")
    private String specifications;

    /** 所属采购合同号 */
    @Excel(name = "所属采购合同号")
    private String purchasecontractid;

    /** 商品类型 */
    @Excel(name = "商品类型")
    private String producttype;

    /** 商品数量 */
    @Excel(name = "商品数量")
    private Float productnum;

    /** 金额 */
    @Excel(name = "金额")
    private Float money;
   //采购发票编号
    private Long  purchaseinvoiceId;

    /** 所属销售订单号 */
    private Long selldetailid;

    /**
     * 扩展字段
     * @param id
     */
    //发票号码
    private Long purchaseinvoiceNumber;
    //供应商
    private String supplier;

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public Long getPurchaseinvoiceNumber() {
        return purchaseinvoiceNumber;
    }

    public void setPurchaseinvoiceNumber(Long purchaseinvoiceNumber) {
        this.purchaseinvoiceNumber = purchaseinvoiceNumber;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public Long getPurchaseinvoiceId() {
        return purchaseinvoiceId;
    }

    public void setPurchaseinvoiceId(Long purchaseinvoiceId) {
        this.purchaseinvoiceId = purchaseinvoiceId;
    }

    public void setProductname(String productname)
    {
        this.productname = productname;
    }

    public String getProductname() 
    {
        return productname;
    }

    public void setUnit(String unit) 
    {
        this.unit = unit;
    }

    public String getUnit() 
    {
        return unit;
    }
    public void setSpecifications(String specifications) 
    {
        this.specifications = specifications;
    }

    public String getSpecifications() 
    {
        return specifications;
    }
    public void setPurchasecontractid(String purchasecontractid) 
    {
        this.purchasecontractid = purchasecontractid;
    }

    public String getPurchasecontractid() 
    {
        return purchasecontractid;
    }
    public void setProducttype(String producttype) 
    {
        this.producttype = producttype;
    }

    public String getProducttype() 
    {
        return producttype;
    }

    public Float getProductnum() {
        return productnum;
    }

    public void setProductnum(Float productnum) {
        this.productnum = productnum;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Float getMoney() {
        return money;
    }

    public void setMoney(Float money) {
        this.money = money;
    }


    public void setSelldetailid(Long selldetailid) 
    {
        this.selldetailid = selldetailid;
    }

    public Long getSelldetailid() 
    {
        return selldetailid;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("productname", getProductname())
            .append("price", getPrice())
            .append("unit", getUnit())
            .append("specifications", getSpecifications())
            .append("purchasecontractid", getPurchasecontractid())
            .append("producttype", getProducttype())
            .append("productnum", getProductnum())
            .append("money", getMoney())
            .append("selldetailid", getSelldetailid())
            .append("createTime", getCreateTime())
            .toString();
    }
}
