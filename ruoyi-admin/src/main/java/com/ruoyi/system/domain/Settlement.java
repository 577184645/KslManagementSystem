package com.ruoyi.system.domain;

import java.util.Date;

import lombok.Data;
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
@Data
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


}
