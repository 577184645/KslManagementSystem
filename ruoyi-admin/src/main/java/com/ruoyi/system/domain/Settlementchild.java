package com.ruoyi.system.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.ibatis.jdbc.Null;

/**
 * 结算单子表属性
 * 
 * @author ruoyi
 * @date 2020-07-17
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Settlementchild extends BaseEntity
{

    private static final long serialVersionUID = 1L;
    private Long id;
    private Long settlementId;
    /** 销售合同号 */
    private Long contractid;
    /** 销售单位 */
    private String customers;
    /** 发票号码 */
    private String invoiceid;
    /** 金额 */
    private Double salemoney;
    /** 采购单位 */
    private String suppliers;
    /** 采购合同号 */
    private String purchasecontractids;
    /** 金额 */
    private String purchasemoney;
    /** 发票号码 */
    private String purchaseinvoiceid;
    /** 采购税率 */
    private Double taxrate;
    /** 采购成本 */
    private Double costprice;
    /** 税率 */
    private Double saletaxrate;
    /** 税收 */
    private Double revenue;
    /** 其他费用 */
    private Double discount;
    /** 个人所得 */
    private Double personalincome;


    /**
     * 扩展字段
     */
    //销售合同号
    private  String contractnumber;


}
