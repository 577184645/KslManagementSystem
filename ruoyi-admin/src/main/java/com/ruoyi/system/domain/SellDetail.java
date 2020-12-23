package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.beans.Transient;
import java.util.List;

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

    /** 数量 */
    @Excel(name = "数量")
    private Integer productnum;

    /** 单价 */
    @Excel(name = "单价")
    private Double price;

    /** 总价 */
    @Excel(name = "总价")
    private Double money;

    /** 所属销售合同 */
    @Excel(name = "所属销售合同",type = Excel.Type.EXPORT)
    private String contractid;

    /** 发票状态 */
    @Excel(name = "发票号码",type = Excel.Type.EXPORT)
    private Long invoiceId;

    /** 采购状态 */
    @Excel(name = "采购状态",type = Excel.Type.EXPORT)
    private Integer purchasestatus;



    /**
     * 扩展字段
     */

    //销售合同号
    private Long invoiceNumber;
   //采购合同号
    private  String purchasecontractid;
   //采购金额
    private  Double   purchasemoney;
   //采购发票号
    private Long purchaseinvoiceId;
    //客户
    private String customer;
    //采购单价
    private  Double purchaseprice ;
    //采购数量
    private  Double   purchaseproductnum;

    public Double getPurchaseprice() {
        return purchaseprice;
    }

    public void setPurchaseprice(Double purchaseprice) {
        this.purchaseprice = purchaseprice;
    }

    public Double getPurchaseproductnum() {
        return purchaseproductnum;
    }

    public void setPurchaseproductnum(Double purchaseproductnum) {
        this.purchaseproductnum = purchaseproductnum;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public Long getPurchaseinvoiceId() {
        return purchaseinvoiceId;
    }

    public void setPurchaseinvoiceId(Long purchaseinvoiceId) {
        this.purchaseinvoiceId = purchaseinvoiceId;
    }

    public Long getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(Long invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public Long getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Long invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getPurchasecontractid() {
        return purchasecontractid;
    }

    public void setPurchasecontractid(String purchasecontractid) {
        this.purchasecontractid = purchasecontractid;
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


    public Double getPurchasemoney() {
        return purchasemoney;
    }

    public void setPurchasemoney(Double purchasemoney) {
        this.purchasemoney = purchasemoney;
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

    public Integer getProductnum() {
        return productnum;
    }

    public void setProductnum(Integer productnum) {
        this.productnum = productnum;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
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

    public Integer getPurchasestatus() {
        return purchasestatus;
    }

    public void setPurchasestatus(Integer purchasestatus) {
        this.purchasestatus = purchasestatus;
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
            .append("purchasestatus", getPurchasestatus())
            .append("createTime", getCreateTime())

            .toString();
    }
}
