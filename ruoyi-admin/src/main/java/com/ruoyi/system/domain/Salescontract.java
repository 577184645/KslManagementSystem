package com.ruoyi.system.domain;

import java.util.Date;

import lombok.Data;
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
@Data
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
    private Double salesamount;

    /** 甲方 */
    @Excel(name = "甲方")
    private String firstparty;

    /** 签订时间 */
    @Excel(name = "签订时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date signingtime;

    /** 备注 */
    @Excel(name = "备注")
    private String remarks;

    private Integer invoiceStatus;

    private Boolean islookstatus;

    /**
     * 扩展字段
     */
    //采购金额
   private Double purchasesamount;





}
