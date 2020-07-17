package com.ruoyi.system.domain;

import java.util.Date;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 销售合同列表对象 salescontract
 * 
 * @author ruoyi
 * @date 2020-05-20
 */
public class Salescontract extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 销售合同号 */
    @Excel(name = "销售合同号")
    private String contractid;



private Integer settlementstatus;




    /** 经办人 */
    @Excel(name = "经办人")
    private String operator;

    /** 付款方式 */
    @Excel(name = "付款方式")
    private String payway;

    /** 合同金额 */
    @Excel(name = "合同金额")
    private Float salesamount;

    /** 甲方 */
    @Excel(name = "甲方")
    private String firstparty;

    /** 签订时间 */
    @Excel(name = "签订时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date signingtime;

    /** 备注 */
    @Excel(name = "备注")
    private String remarks;

    private Boolean islookstatus;

    public Boolean getIslookstatus() {
        return islookstatus;
    }

    public void setIslookstatus(Boolean islookstatus) {
        this.islookstatus = islookstatus;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Integer getSettlementstatus() {
        return settlementstatus;
    }

    public void setSettlementstatus(Integer settlementstatus) {
        this.settlementstatus = settlementstatus;
    }

    public Long getId()
    {
        return id;
    }
    public void setContractid(String contractid) 
    {
        this.contractid = contractid;
    }

    public String getContractid() 
    {
        return contractid;
    }
    public void setOperator(String operator) 
    {
        this.operator = operator;
    }

    public String getOperator() 
    {
        return operator;
    }
    public void setPayway(String payway) 
    {
        this.payway = payway;
    }

    public String getPayway() 
    {
        return payway;
    }

    public Float getSalesamount() {
        return salesamount;
    }

    public void setSalesamount(Float salesamount) {
        this.salesamount = salesamount;
    }

    public void setFirstparty(String firstparty)
    {
        this.firstparty = firstparty;
    }

    public String getFirstparty() 
    {
        return firstparty;
    }
    public void setSigningtime(Date signingtime) 
    {
        this.signingtime = signingtime;
    }

    public Date getSigningtime() 
    {
        return signingtime;
    }
    public void setRemarks(String remarks) 
    {
        this.remarks = remarks;
    }

    public String getRemarks() 
    {
        return remarks;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("contractid", getContractid())
            .append("operator", getOperator())
            .append("payway", getPayway())
            .append("salesamount", getSalesamount())
            .append("firstparty", getFirstparty())
            .append("signingtime", getSigningtime())
            .append("remarks", getRemarks())
            .append("createTime", getCreateTime())
            .toString();
    }
}
