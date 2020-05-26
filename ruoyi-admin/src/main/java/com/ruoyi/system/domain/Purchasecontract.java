package com.ruoyi.system.domain;

import java.util.Date;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 采购合同对象 purchasecontract
 * 
 * @author ruoyi
 * @date 2020-05-22
 */
public class Purchasecontract extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 采购合同号 */
    @Excel(name = "采购合同号")
    private String purchasecontractid;



    /** 合同金额 */
    @Excel(name = "合同金额")
    private Double purchasesamount;

    /** 乙方 */
    @Excel(name = "乙方")
    private String partyb;

    /** 签订日期 */
    @Excel(name = "签订日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date signingtime;

    /** 付款方式 */
    @Excel(name = "付款方式")
    private String payway;

    /** 备注 */
    @Excel(name = "备注")
    private String remarks;

    /** 所属销售合同号 */
    @Excel(name = "所属销售合同号")
    private String contractid;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setPurchasecontractid(String purchasecontractid) 
    {
        this.purchasecontractid = purchasecontractid;
    }

    public String getPurchasecontractid() 
    {
        return purchasecontractid;
    }
    public void setPurchasesamount(Double purchasesamount) 
    {
        this.purchasesamount = purchasesamount;
    }

    public Double getPurchasesamount() 
    {
        return purchasesamount;
    }
    public void setPartyb(String partyb) 
    {
        this.partyb = partyb;
    }

    public String getPartyb() 
    {
        return partyb;
    }
    public void setSigningtime(Date signingtime) 
    {
        this.signingtime = signingtime;
    }

    public Date getSigningtime() 
    {
        return signingtime;
    }
    public void setPayway(String payway) 
    {
        this.payway = payway;
    }

    public String getPayway() 
    {
        return payway;
    }
    public void setRemarks(String remarks) 
    {
        this.remarks = remarks;
    }

    public String getRemarks() 
    {
        return remarks;
    }
    public void setContractid(String contractid) 
    {
        this.contractid = contractid;
    }

    public String getContractid() 
    {
        return contractid;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("purchasecontractid", getPurchasecontractid())
            .append("purchasesamount", getPurchasesamount())
            .append("partyb", getPartyb())
            .append("signingtime", getSigningtime())
            .append("payway", getPayway())
            .append("remarks", getRemarks())
            .append("contractid", getContractid())
            .append("createTime", getCreateTime())
            .toString();
    }
}
