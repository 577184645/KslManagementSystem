package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 settlementchild
 * 
 * @author ruoyi
 * @date 2020-07-17
 */
public class Settlementchild extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;



    private float purchasesamount;

    /** 序号 */
    @Excel(name = "序号")
    private String serialnumber;

    /** 销售合同号 */
    @Excel(name = "销售合同号")
    private String contractid;

    /** 销售单位 */
    @Excel(name = "销售单位")
    private String customers;

    /** 发票号码 */
    @Excel(name = "发票号码")
    private String invoiceid;

    /** 金额 */
    @Excel(name = "金额")
    private Float salemoney;

    /** 采购单位 */
    @Excel(name = "采购单位")
    private String suppliers;

    /** 金额 */
    @Excel(name = "金额")
    private String purchasemoney;

    /** 发票号码 */
    @Excel(name = "发票号码")
    private String purchaseinvoiceid;

    /** 采购税率 */
    @Excel(name = "采购税率")
    private Float taxrate;

    /** 采购成本 */
    @Excel(name = "采购成本")
    private Float costprice;

    /** 税率 */
    @Excel(name = "税率")
    private Float saletaxrate;

    /** 税收 */
    @Excel(name = "税收")
    private Float revenue;

    /** 其他费用 */
    @Excel(name = "其他费用")
    private Float discount;

    /** 个人所得 */
    @Excel(name = "个人所得")
    private Float personalincome;

    @Excel(name = "采购合同号")
    private String purchasecontractids;


    public String getPurchasecontractids() {
        return purchasecontractids;
    }

    public void setPurchasecontractids(String purchasecontractids) {
        this.purchasecontractids = purchasecontractids;
    }

    public void setPurchasemoney(String purchasemoney) {
        this.purchasemoney = purchasemoney;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setSerialnumber(String serialnumber) 
    {
        this.serialnumber = serialnumber;
    }

    public String getSerialnumber() 
    {
        return serialnumber;
    }
    public void setContractid(String contractid) 
    {
        this.contractid = contractid;
    }

    public String getContractid() 
    {
        return contractid;
    }
    public void setCustomers(String customers) 
    {
        this.customers = customers;
    }

    public String getCustomers() 
    {
        return customers;
    }
    public void setInvoiceid(String invoiceid) 
    {
        this.invoiceid = invoiceid;
    }

    public String getInvoiceid() 
    {
        return invoiceid;
    }


    public Float getSalemoney() {
        return salemoney;
    }

    public void setSalemoney(Float salemoney) {
        this.salemoney = salemoney;
    }

    public String getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(String suppliers) {
        this.suppliers = suppliers;
    }


    public String getPurchaseinvoiceid() {
        return purchaseinvoiceid;
    }

    public void setPurchaseinvoiceid(String purchaseinvoiceid) {
        this.purchaseinvoiceid = purchaseinvoiceid;
    }

    public float getPurchasesamount() {
        return purchasesamount;
    }

    public void setPurchasesamount(float purchasesamount) {
        this.purchasesamount = purchasesamount;
    }

    public Float getTaxrate() {
        return taxrate;
    }

    public void setTaxrate(Float taxrate) {
        this.taxrate = taxrate;
    }

    public Float getCostprice() {
        return costprice;
    }

    public void setCostprice(Float costprice) {
        this.costprice = costprice;
    }

    public Float getSaletaxrate() {
        return saletaxrate;
    }

    public void setSaletaxrate(Float saletaxrate) {
        this.saletaxrate = saletaxrate;
    }

    public Float getRevenue() {
        return revenue;
    }

    public void setRevenue(Float revenue) {
        this.revenue = revenue;
    }

    public Float getDiscount() {
        return discount;
    }

    public void setDiscount(Float discount) {
        this.discount = discount;
    }

    public Float getPersonalincome() {
        return personalincome;
    }

    public void setPersonalincome(Float personalincome) {
        this.personalincome = personalincome;
    }


    public String getPurchasemoney() {
        return purchasemoney;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("serialnumber", getSerialnumber())
            .append("contractid", getContractid())
            .append("customers", getCustomers())
            .append("invoiceid", getInvoiceid())
            .append("salemoney", getSalemoney())
            .append("suppliers", getSuppliers())
            .append("purchasemoney", getPurchasemoney())
            .append("purchaseinvoiceid", getPurchaseinvoiceid())
            .append("taxrate", getTaxrate())
            .append("costprice", getCostprice())
            .append("saletaxrate", getSaletaxrate())
            .append("revenue", getRevenue())
            .append("discount", getDiscount())
            .append("personalincome", getPersonalincome())
            .toString();
    }
}
