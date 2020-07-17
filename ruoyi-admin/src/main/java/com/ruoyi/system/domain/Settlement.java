package com.ruoyi.system.domain;

import java.util.Date;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 结算对象 settlement
 * 
 * @author ruoyi
 * @date 2020-07-17
 */
public class Settlement extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 经办人 */
    @Excel(name = "经办人")
    private String operator;

    /** 个人所得 */
    @Excel(name = "个人所得")
    private Float personalincome;

    /** 结算时间 */
    @Excel(name = "结算时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date settlementtime;

    /** 序号 */
    @Excel(name = "序号")
    private String serialnumber;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setOperator(String operator) 
    {
        this.operator = operator;
    }

    public String getOperator() 
    {
        return operator;
    }

    public Float getPersonalincome() {
        return personalincome;
    }

    public void setPersonalincome(Float personalincome) {
        this.personalincome = personalincome;
    }

    public void setSettlementtime(Date settlementtime)
    {
        this.settlementtime = settlementtime;
    }

    public Date getSettlementtime() 
    {
        return settlementtime;
    }
    public void setSerialnumber(String serialnumber) 
    {
        this.serialnumber = serialnumber;
    }

    public String getSerialnumber() 
    {
        return serialnumber;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("operator", getOperator())
            .append("personalincome", getPersonalincome())
            .append("settlementtime", getSettlementtime())
            .append("serialnumber", getSerialnumber())
            .toString();
    }
}
