package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SettlementchildMapper;
import com.ruoyi.system.domain.Settlementchild;
import com.ruoyi.system.service.ISettlementchildService;
import com.ruoyi.common.core.text.Convert;
import org.springframework.transaction.annotation.Transactional;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-07-17
 */
@Service
@Transactional
public class SettlementchildServiceImpl implements ISettlementchildService 
{
    @Autowired
    private SettlementchildMapper settlementchildMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public Settlementchild selectSettlementchildById(Long id)
    {
        return settlementchildMapper.selectSettlementchildById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param settlementchild 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<Settlementchild> selectSettlementchildList(Settlementchild settlementchild)
    {
        return settlementchildMapper.selectSettlementchildList(settlementchild);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param settlementchild 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertSettlementchild(Settlementchild settlementchild)
    {
        return settlementchildMapper.insertSettlementchild(settlementchild);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param settlementchild 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateSettlementchild(Settlementchild settlementchild)
    {
        return settlementchildMapper.updateSettlementchild(settlementchild);
    }

    /**
     * 删除【请填写功能名称】对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSettlementchildByIds(String ids)
    {
        return settlementchildMapper.deleteSettlementchildByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteSettlementchildById(Long id)
    {
        return settlementchildMapper.deleteSettlementchildById(id);
    }
}
