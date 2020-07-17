package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Settlementchild;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2020-07-17
 */
public interface ISettlementchildService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public Settlementchild selectSettlementchildById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param settlementchild 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<Settlementchild> selectSettlementchildList(Settlementchild settlementchild);

    /**
     * 新增【请填写功能名称】
     * 
     * @param settlementchild 【请填写功能名称】
     * @return 结果
     */
    public int insertSettlementchild(Settlementchild settlementchild);

    /**
     * 修改【请填写功能名称】
     * 
     * @param settlementchild 【请填写功能名称】
     * @return 结果
     */
    public int updateSettlementchild(Settlementchild settlementchild);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSettlementchildByIds(String ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteSettlementchildById(Long id);
}
