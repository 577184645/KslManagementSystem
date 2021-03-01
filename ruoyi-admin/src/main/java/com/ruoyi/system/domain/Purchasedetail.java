package com.ruoyi.system.domain;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.List;

/**
 * 采购订单列表对象 purchasedetail
 * 
 * @author ruoyi
 * @date 2020-05-25
 */
@Data
public class Purchasedetail extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 商品名称 */
    @Excel(name = "商品名称")
    private String productname;


    /** 单价 */
    @Excel(name = "单价")
    private Double price;

    /** 单位 */
    @Excel(name = "单位")
    private String unit;

    /** 型号 */
    @Excel(name = "型号")
    private String specifications;

    /** 所属采购合同号 */
    @Excel(name = "所属采购合同号")
    private Long purchasecontractId;

    /** 商品类型 */
    @Excel(name = "商品类型")
    private String producttype;

    /** 商品数量 */
    @Excel(name = "商品数量")
    private Integer productnum;

    /** 金额 */
    @Excel(name = "金额")
    private Double money;
   //采购发票编号
    private Long  purchaseinvoiceId;

    /** 所属销售订单号 */
    private Long selldetailId;

    /**
     * 扩展字段
     * @param id
     */
    //发票号码
    private Long purchaseinvoiceNumber;
    //供应商
    private String supplier;
    //采购合同号
    private String purchasecontractNumber;
   //采购子列表
    private List<PurchasedetailChild> purchasedetailChildList;
}
