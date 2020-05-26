package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 供应商列表对象 supplier
 * 
 * @author ruoyi
 * @date 2020-05-19
 */
public class Supplier extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 名称 */
    @Excel(name = "名称")
    private String name;

    /** 电话 */
    @Excel(name = "电话")
    private String tel;

    /** 单位地址 */
    @Excel(name = "单位地址")
    private String address;

    /** 法定代表人 */
    @Excel(name = "法定代表人")
    private String legalrepresentativename;

    /** 委托代理人 */
    @Excel(name = "委托代理人")
    private String agentname;

    /** 传真 */
    @Excel(name = "传真")
    private String fax;

    /** 电子邮箱 */
    @Excel(name = "电子邮箱")
    private String email;

    /** 开户银行 */
    @Excel(name = "开户银行")
    private String openingbank;

    /** 账号 */
    @Excel(name = "账号")
    private String accountnumber;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setTel(String tel) 
    {
        this.tel = tel;
    }

    public String getTel() 
    {
        return tel;
    }
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
    }
    public void setLegalrepresentativename(String legalrepresentativename) 
    {
        this.legalrepresentativename = legalrepresentativename;
    }

    public String getLegalrepresentativename() 
    {
        return legalrepresentativename;
    }
    public void setAgentname(String agentname) 
    {
        this.agentname = agentname;
    }

    public String getAgentname() 
    {
        return agentname;
    }
    public void setFax(String fax) 
    {
        this.fax = fax;
    }

    public String getFax() 
    {
        return fax;
    }
    public void setEmail(String email) 
    {
        this.email = email;
    }

    public String getEmail() 
    {
        return email;
    }
    public void setOpeningbank(String openingbank) 
    {
        this.openingbank = openingbank;
    }

    public String getOpeningbank() 
    {
        return openingbank;
    }
    public void setAccountnumber(String accountnumber) 
    {
        this.accountnumber = accountnumber;
    }

    public String getAccountnumber() 
    {
        return accountnumber;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("tel", getTel())
            .append("address", getAddress())
            .append("legalrepresentativename", getLegalrepresentativename())
            .append("agentname", getAgentname())
            .append("fax", getFax())
            .append("email", getEmail())
            .append("openingbank", getOpeningbank())
            .append("accountnumber", getAccountnumber())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
