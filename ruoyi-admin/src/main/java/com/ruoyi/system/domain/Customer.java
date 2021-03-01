package com.ruoyi.system.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 客户列表对象 customer
 * 
 * @author ruoyi
 * @date 2020-05-19
 */
@Data
public class Customer extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 名称 */
    @Excel(name = "名称")
    private String name;

    /** 电话 */
    @Excel(name = "电话")
    private String tel;

    /** 单位地址 */
    @Excel(name = "单位地址")
    private String address;

    /** 法定代表人 */
    @Excel(name = "法定代表人")
    private String legalrepresentativename;

    /** 委托代理人 */
    @Excel(name = "委托代理人")
    private String agentname;

    /** 传真 */
    @Excel(name = "传真")
    private String fax;

    /** 电子邮箱 */
    @Excel(name = "电子邮箱")
    private String email;

    /** 开户银行 */
    @Excel(name = "开户银行")
    private String openingbank;

    /** 账号 */
    @Excel(name = "账号")
    private String accountnumber;


}
