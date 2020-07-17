package com.ruoyi.system.domain;

import java.util.Date;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 发票对象 invoice
 * 
 * @author ruoyi
 * @date 2020-07-09
 */
public class Invoice extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 发票编号 */
    @Excel(name = "发票编号")
    private String invoiceid;

    /** 销售合同号 */
    @Excel(name = "销售合同号")
    private String contractid;

    @Excel(name = "客户")
    private String customer;

    /** 商品数量 */
    @Excel(name = "商品数量")
    private Float productnum;

    /** 发票金额 */
    @Excel(name = "发票金额")
    private Float money;

    /** 开票时间 */
    @Excel(name = "开票时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date invoicetime;

    /** 销售订单号 */

    private Long selldetailid;



    private String selldetailids;

    public String getContractid() {
        return contractid;
    }

    public void setContractid(String contractid) {
        this.contractid = contractid;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setInvoiceid(String invoiceid) 
    {
        this.invoiceid = invoiceid;
    }

    public String getInvoiceid() 
    {
        return invoiceid;
    }

    public String getSelldetailids() {
        return selldetailids;
    }

    public void setSelldetailids(String selldetailids) {
        this.selldetailids = selldetailids;
    }

    public Float getProductnum() {
        return productnum;
    }

    public void setProductnum(Float productnum) {
        this.productnum = productnum;
    }

    public Float getMoney() {
        return money;
    }

    public void setMoney(Float money) {
        this.money = money;
    }

    public void setInvoicetime(Date invoicetime)
    {
        this.invoicetime = invoicetime;
    }

    public Date getInvoicetime() 
    {
        return invoicetime;
    }


    public Long getSelldetailid() {
        return selldetailid;
    }

    public void setSelldetailid(Long selldetailid) {
        this.selldetailid = selldetailid;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("invoiceid", getInvoiceid())
            .append("productnum", getProductnum())
            .append("money", getMoney())
            .append("invoicetime", getInvoicetime())
            .append("selldetailid", getSelldetailid())
            .append("createTime", getCreateTime())
            .toString();
    }
}
