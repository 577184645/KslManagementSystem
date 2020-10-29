package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Settlement;

/**
 * 结算Service接口
 * 
 * @author ruoyi
 * @date 2020-07-17
 */
public interface ISettlementService 
{




    /**
     * 查询结算
     * 
     * @param id 结算ID
     * @return 结算
     */
    public Settlement selectSettlementById(Long id);

    /**
     * 查询结算列表
     * 
     * @param settlement 结算
     * @return 结算集合
     */
    public List<Settlement> selectSettlementList(Settlement settlement);

    /**
     * 新增结算
     * 
     * @param settlement 结算
     * @return 结果
     */
    public int add(String settlementList,Settlement settlement);

    /**
     * 修改结算
     * 
     * @param settlement 结算
     * @return 结果
     */
    public int updateSettlement(Settlement settlement);


    public int editSettlement(Settlement settlement,String settlementList);

    /**
     * 批量删除结算
     * 
     * @param serialnumber 需要删除的数据ID
     * @return 结果
     */
    public int deleteSettlementBySerialNumber(String serialnumber);

    /**
     * 删除结算信息
     * 
     * @param id 结算ID
     * @return 结果
     */
    public int deleteSettlementById(Long id);
}
