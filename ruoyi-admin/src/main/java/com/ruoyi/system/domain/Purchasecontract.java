package com.ruoyi.system.domain;

import java.util.Date;

import lombok.Data;
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
@Data
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
    private Long contractId;

    private  Integer invoiceStatus;

    /**
     * 扩展字段
     */
    //销售合同号
    private  String contractNumber;

}
