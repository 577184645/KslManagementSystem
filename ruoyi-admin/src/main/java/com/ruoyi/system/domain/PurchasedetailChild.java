package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 采购订单子对象 purchasedetail_child
 * 
 * @author ruoyi
 * @date 2020-05-26
 */
public class PurchasedetailChild extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 商品名称 */
    @Excel(name = "商品名称")
    private String productname;

    /** 单价 */
    @Excel(name = "单价")
    private Double price;

    /** 单位 */
    @Excel(name = "单位")
    private String unit;

    /** 型号 */
    @Excel(name = "型号")
    private String specifications;

    /** 商品类型 */
    @Excel(name = "商品类型")
    private String producttype;

    /** 商品数量 */
    @Excel(name = "商品数量")
    private Long productnum;

    /** 金额 */
    @Excel(name = "金额")
    private Double money;


    /** 所属采购订单号 */
    @Excel(name = "所属采购订单号")
    private Long purchasedetailid;

    /** 供应商 */
    @Excel(name = "供应商")
    private String supplier;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setProductname(String productname) 
    {
        this.productname = productname;
    }

    public String getProductname() 
    {
        return productname;
    }
    public void setPrice(Double price) 
    {
        this.price = price;
    }

    public Double getPrice() 
    {
        return price;
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
    public void setProducttype(String producttype) 
    {
        this.producttype = producttype;
    }

    public String getProducttype() 
    {
        return producttype;
    }
    public void setProductnum(Long productnum) 
    {
        this.productnum = productnum;
    }

    public Long getProductnum() 
    {
        return productnum;
    }
    public void setMoney(Double money) 
    {
        this.money = money;
    }

    public Double getMoney() 
    {
        return money;
    }

    public void setPurchasedetailid(Long purchasedetailid) 
    {
        this.purchasedetailid = purchasedetailid;
    }

    public Long getPurchasedetailid() 
    {
        return purchasedetailid;
    }
    public void setSupplier(String supplier) 
    {
        this.supplier = supplier;
    }

    public String getSupplier() 
    {
        return supplier;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("productname", getProductname())
            .append("price", getPrice())
            .append("unit", getUnit())
            .append("specifications", getSpecifications())
            .append("producttype", getProducttype())
            .append("productnum", getProductnum())
            .append("money", getMoney())
            .append("purchasedetailid", getPurchasedetailid())
            .append("supplier", getSupplier())
            .append("createTime", getCreateTime())
            .toString();
    }
}
