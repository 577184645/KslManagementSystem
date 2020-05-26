package com.ruoyi.system.domain;

import java.util.Date;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 销售发票列表对象 invoice
 * 
 * @author ruoyi
 * @date 2020-05-21
 */
public class Invoice extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 发票编号 */
    @Excel(name = "发票编号")
    private String invoiceid;

    /** 所属销售合同 */
    @Excel(name = "所属销售合同")
    private String contractid;

    /** 采购方 */
    @Excel(name = "采购方")
    private String buyer;

    /** 发票金额 */
    @Excel(name = "发票金额")
    private Double money;

    /** 开票时间 */
    @Excel(name = "开票时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date invoicetime;

    /** 销售订单号 */
    private Long selldetailid;

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
    public void setContractid(String contractid) 
    {
        this.contractid = contractid;
    }

    public String getContractid() 
    {
        return contractid;
    }
    public void setBuyer(String buyer) 
    {
        this.buyer = buyer;
    }

    public String getBuyer() 
    {
        return buyer;
    }
    public void setMoney(Double money) 
    {
        this.money = money;
    }

    public Double getMoney() 
    {
        return money;
    }
    public void setInvoicetime(Date invoicetime) 
    {
        this.invoicetime = invoicetime;
    }

    public Date getInvoicetime() 
    {
        return invoicetime;
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
            .append("invoiceid", getInvoiceid())
            .append("contractid", getContractid())
            .append("buyer", getBuyer())
            .append("money", getMoney())
            .append("invoicetime", getInvoicetime())
            .append("selldetailid", getSelldetailid())
            .append("createTime", getCreateTime())
            .toString();
    }
}
