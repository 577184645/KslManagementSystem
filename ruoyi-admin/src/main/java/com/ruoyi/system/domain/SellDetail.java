package com.ruoyi.system.domain;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.beans.Transient;
import java.util.List;

/**
 * 销售订单列表对象 sell_detail
 * 
 * @author ruoyi
 * @date 2020-05-20
 */
@Data
public class SellDetail extends BaseEntity
{
    private static final long serialVersionUID = 1L;
    /** id */
    private Long id;

    /** 商品名称 */
    @Excel(name = "商品名称")
    private String productname;

    /** 单位 */
    @Excel(name = "单位")
    private String unit;

    /** 型号 */
    @Excel(name = "型号")
    private String specifications;

    /** 商品类型 */
    @Excel(name = "商品类型")
    private String producttype;

    /** 数量 */
    @Excel(name = "数量")
    private Integer productnum;

    /** 单价 */
    @Excel(name = "单价")
    private Double price;

    /** 总价 */
    @Excel(name = "总价")
    private Double money;

    /** 所属销售合同 */
    @Excel(name = "所属销售合同",type = Excel.Type.EXPORT)
    private Long contractId;

    /** 发票状态 */
    @Excel(name = "发票号码",type = Excel.Type.EXPORT)
    private Long invoiceId;

    /** 采购状态 */
    @Excel(name = "采购状态",type = Excel.Type.EXPORT)
    private Integer purchasestatus;


    /**
     * 扩展字段
     */

    //销售合同号
    private Long invoiceNumber;
   //采购合同号
    private  String purchasecontractid;
   //采购金额
    private  Double   purchasemoney;
   //采购发票号
    private Long purchaseinvoiceId;
    //客户
    private String customer;
    //采购单价
    private  Double purchaseprice ;
    //采购数量
    private  Double   purchaseproductnum;
    //销售合同号
    private  String contractnumber;


}
