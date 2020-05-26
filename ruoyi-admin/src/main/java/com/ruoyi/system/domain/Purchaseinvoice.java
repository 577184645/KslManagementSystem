package com.ruoyi.system.domain;

import java.util.Date;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 采购发票列表对象 purchaseinvoice
 * 
 * @author ruoyi
 * @date 2020-05-25
 */
public class Purchaseinvoice extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 发票编号 */
    @Excel(name = "发票编号")
    private String purchaseinvoiceid;

    /** 所属销售合同 */
    @Excel(name = "所属销售合同")
    private String purchasecontractid;

    /** 采购方 */
    @Excel(name = "采购方")
    private String buyer;

    /** 发票金额 */
    @Excel(name = "发票金额")
    private Double money;

    /** 开票时间 */
    @Excel(name = "开票时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date purchaseinvoicetime;

    /** 采购订单号 */
    private Long purchasedetailid;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setPurchaseinvoiceid(String purchaseinvoiceid) 
    {
        this.purchaseinvoiceid = purchaseinvoiceid;
    }

    public String getPurchaseinvoiceid() 
    {
        return purchaseinvoiceid;
    }
    public void setPurchasecontractid(String purchasecontractid) 
    {
        this.purchasecontractid = purchasecontractid;
    }

    public String getPurchasecontractid() 
    {
        return purchasecontractid;
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
    public void setPurchaseinvoicetime(Date purchaseinvoicetime) 
    {
        this.purchaseinvoicetime = purchaseinvoicetime;
    }

    public Date getPurchaseinvoicetime() 
    {
        return purchaseinvoicetime;
    }
    public void setPurchasedetailid(Long purchasedetailid) 
    {
        this.purchasedetailid = purchasedetailid;
    }

    public Long getPurchasedetailid() 
    {
        return purchasedetailid;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("purchaseinvoiceid", getPurchaseinvoiceid())
            .append("purchasecontractid", getPurchasecontractid())
            .append("buyer", getBuyer())
            .append("money", getMoney())
            .append("purchaseinvoicetime", getPurchaseinvoicetime())
            .append("purchasedetailid", getPurchasedetailid())
            .append("createTime", getCreateTime())
            .toString();
    }
}
