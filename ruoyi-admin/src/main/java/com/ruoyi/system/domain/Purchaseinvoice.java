package com.ruoyi.system.domain;

import java.util.Date;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 采购发票对象 purchaseinvoice
 * 
 * @author ruoyi
 * @date 2020-07-09
 */
public class Purchaseinvoice extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 发票编号 */
    @Excel(name = "发票编号")
    private String purchaseinvoiceid;

    /** 发票金额 */
    @Excel(name = "发票金额")
    private Double money;

    /** 开票时间 */
    @Excel(name = "开票时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date purchaseinvoicetime;

    /**
     * 扩展字段
     */








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



    public void setPurchaseinvoicetime(Date purchaseinvoicetime)
    {
        this.purchaseinvoicetime = purchaseinvoicetime;
    }

    public Date getPurchaseinvoicetime() 
    {
        return purchaseinvoicetime;
    }

    public String getPurchaseinvoiceid() {
        return purchaseinvoiceid;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("purchaseinvoiceid", getPurchaseinvoiceid())
            .append("money", getMoney())
            .append("purchaseinvoicetime", getPurchaseinvoicetime())
            .append("createTime", getCreateTime())
            .toString();
    }
}
