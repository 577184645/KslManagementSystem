package com.ruoyi.system.domain;

import java.util.Date;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 发票对象 invoice
 *
 * @author ruoyi
 * @date 2020-12-02
 */
@Data
public class Invoice extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 发票编号 */
    @Excel(name = "发票编号")
    private Long invoiceid;

    /** 发票金额 */
    @Excel(name = "发票金额")
    private Double money;

    /** 开票时间 */
    @Excel(name = "开票时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date invoicetime;


}
