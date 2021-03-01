package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Settlement;

/**
 * 结算Mapper接口
 * 
 * @author ruoyi
 * @date 2020-07-17
 */
public interface SettlementMapper 
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


    public String selectSettlementMaxSerialNumber();

    /**
     * 新增结算
     * 
     * @param settlement 结算
     * @return 结果
     */
    public int insertSettlement(Settlement settlement);

    /**
     * 修改结算
     * 
     * @param settlement 结算
     * @return 结果
     */
    public int updateSettlement(Settlement settlement);

    /**
     * 删除结算
     * 
     * @param id 结算ID
     * @return 结果
     */
    public int deleteSettlementById(Long id);


}
