package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 销售订单列表对象 sell_detail
 * 
 * @author ruoyi
 * @date 2020-05-20
 */
public class SellDetail extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 商品名称 */
    @Excel(name = "商品名称")
    private String productname;



    /** 单位 */
    @Excel(name = "单位")
    private String unit;

    /** 型号 */
    @Excel(name = "型号")
    private String specifications;

    /** 商品类型 */
    @Excel(name = "商品类型")
    private String producttype;


    /** 甲方 */
    @Excel(name = "供应商")
    private String supplier;
    /** 数量 */
    @Excel(name = "数量")
    private Long productnum;

    /** 单价 */
    @Excel(name = "单价")
    private Float price;

    /** 总价 */
    @Excel(name = "总价")
    private Float money;

    /** 所属销售合同 */
    @Excel(name = "所属销售合同",type = Excel.Type.EXPORT)
    private String contractid;

    /** 发票状态 */
    @Excel(name = "发票状态",type = Excel.Type.EXPORT)
    private Long invoicestatus;

    /** 采购状态 */
    @Excel(name = "采购状态",type = Excel.Type.EXPORT)
    private Long purchasestatus;






    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
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

    public void setContractid(String contractid)
    {
        this.contractid = contractid;
    }

    public String getContractid() 
    {
        return contractid;
    }
    public void setInvoicestatus(Long invoicestatus) 
    {
        this.invoicestatus = invoicestatus;
    }

    public Long getInvoicestatus() 
    {
        return invoicestatus;
    }
    public void setPurchasestatus(Long purchasestatus) 
    {
        this.purchasestatus = purchasestatus;
    }

    public Long getPurchasestatus() 
    {
        return purchasestatus;
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
            .append("contractid", getContractid())
            .append("invoicestatus", getInvoicestatus())
            .append("purchasestatus", getPurchasestatus())
            .append("createTime", getCreateTime())
                .append("supplier", getSupplier())
            .toString();
    }
}
