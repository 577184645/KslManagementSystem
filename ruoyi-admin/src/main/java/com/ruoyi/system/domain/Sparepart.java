package com.ruoyi.system.domain;

import java.util.Date;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 sparepart
 * 
 * @author ruoyi
 * @date 2020-09-01
 */
public class Sparepart extends BaseEntity
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

    private String uuid;

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
    private Double productnum;

    /** 金额 */
    @Excel(name = "金额")
    private Double money;

    /** 发票状态 */
    @Excel(name = "发票状态")
    private Long purchaseinvoicestatus;

    /** 供应商 */
    @Excel(name = "供应商")
    private String supplier;

    /** 创建时间 */
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date cTime;

    /** 修改时间 */
    @Excel(name = "修改时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date uTime;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

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
    public void setProductnum(Double productnum) 
    {
        this.productnum = productnum;
    }

    public Double getProductnum() 
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
    public void setPurchaseinvoicestatus(Long purchaseinvoicestatus) 
    {
        this.purchaseinvoicestatus = purchaseinvoicestatus;
    }

    public Long getPurchaseinvoicestatus() 
    {
        return purchaseinvoicestatus;
    }
    public void setSupplier(String supplier) 
    {
        this.supplier = supplier;
    }

    public String getSupplier() 
    {
        return supplier;
    }
    public void setcTime(Date cTime) 
    {
        this.cTime = cTime;
    }

    public Date getcTime() 
    {
        return cTime;
    }
    public void setuTime(Date uTime) 
    {
        this.uTime = uTime;
    }

    public Date getuTime() 
    {
        return uTime;
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
            .append("purchaseinvoicestatus", getPurchaseinvoicestatus())
            .append("supplier", getSupplier())
            .append("cTime", getcTime())
            .append("uTime", getuTime())
            .toString();
    }
}
