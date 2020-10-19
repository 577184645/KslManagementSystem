package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SparepartMapper;
import com.ruoyi.system.domain.Sparepart;
import com.ruoyi.system.service.ISparepartService;
import com.ruoyi.common.core.text.Convert;

/**
 * 备件Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-09-01
 */
@Service
public class SparepartServiceImpl implements ISparepartService 
{
    @Autowired
    private SparepartMapper sparepartMapper;

    /**
     * 查询备件
     * 
     * @param id 备件ID
     * @return 备件
     */
    @Override
    public Sparepart selectSparepartById(Long id)
    {
        return sparepartMapper.selectSparepartById(id);
    }

    @Override
    public Sparepart selectSparepartByUuid(String uuid) {
        return sparepartMapper.selectSparepartByUuid(uuid);
    }

    /**
     * 查询备件列表
     * 
     * @param sparepart 备件
     * @return 备件
     */
    @Override
    public List<Sparepart> selectSparepartList(Sparepart sparepart)
    {
        return sparepartMapper.selectSparepartList(sparepart);
    }

    /**
     * 新增备件
     * 
     * @param sparepart 备件
     * @return 结果
     */
    @Override
    public int insertSparepart(Sparepart sparepart)
    {
        return sparepartMapper.insertSparepart(sparepart);
    }

    /**
     * 修改备件
     * 
     * @param sparepart 备件
     * @return 结果
     */
    @Override
    public int updateSparepart(Sparepart sparepart)
    {
        return sparepartMapper.updateSparepart(sparepart);
    }

    /**
     * 删除备件对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSparepartByIds(String ids)
    {
        return sparepartMapper.deleteSparepartByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除备件信息
     * 
     * @param id 备件ID
     * @return 结果
     */
    @Override
    public int deleteSparepartById(Long id)
    {
        return sparepartMapper.deleteSparepartById(id);
    }
}
