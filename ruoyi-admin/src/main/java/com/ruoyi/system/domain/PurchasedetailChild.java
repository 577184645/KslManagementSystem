package com.ruoyi.system.domain;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 采购订单子对象 purchasedetail_child
 * 
 * @author ruoyi
 * @date 2020-05-26
 */
@Data
public class PurchasedetailChild extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 商品名称 */
    @Excel(name = "商品名称")
    private String productname;

    /** 单价 */
    @Excel(name = "单价")
    private Float price;

    /** 单位 */
    @Excel(name = "单位")
    private String unit;

    /** 型号 */
    @Excel(name = "型号")
    private String specifications;

    /** 商品类型 */
    @Excel(name = "商品类型")
    private String producttype;

    /** 商品数量 */
    @Excel(name = "商品数量")
    private Integer productnum;

    /** 金额 */
    @Excel(name = "金额")
    private Double money;


    /** 所属采购订单号 */
    @Excel(name = "所属采购订单号")
    private Long purchasedetailId;




}
