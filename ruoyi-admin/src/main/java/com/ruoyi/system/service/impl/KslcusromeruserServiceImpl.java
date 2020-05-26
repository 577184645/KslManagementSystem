package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.KslcusromeruserMapper;
import com.ruoyi.system.domain.Kslcusromeruser;
import com.ruoyi.system.service.IKslcusromeruserService;
import com.ruoyi.common.core.text.Convert;

/**
 * 经办人列表Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-05-19
 */
@Service
public class KslcusromeruserServiceImpl implements IKslcusromeruserService 
{
    @Autowired
    private KslcusromeruserMapper kslcusromeruserMapper;

    /**
     * 查询经办人列表
     * 
     * @param id 经办人列表ID
     * @return 经办人列表
     */
    @Override
    public Kslcusromeruser selectKslcusromeruserById(Long id)
    {
        return kslcusromeruserMapper.selectKslcusromeruserById(id);
    }

    /**
     * 查询经办人列表列表
     * 
     * @param kslcusromeruser 经办人列表
     * @return 经办人列表
     */
    @Override
    public List<Kslcusromeruser> selectKslcusromeruserList(Kslcusromeruser kslcusromeruser)
    {
        return kslcusromeruserMapper.selectKslcusromeruserList(kslcusromeruser);
    }

    /**
     * 新增经办人列表
     * 
     * @param kslcusromeruser 经办人列表
     * @return 结果
     */
    @Override
    public int insertKslcusromeruser(Kslcusromeruser kslcusromeruser)
    {
        kslcusromeruser.setCreateTime(DateUtils.getNowDate());
        return kslcusromeruserMapper.insertKslcusromeruser(kslcusromeruser);
    }

    /**
     * 修改经办人列表
     * 
     * @param kslcusromeruser 经办人列表
     * @return 结果
     */
    @Override
    public int updateKslcusromeruser(Kslcusromeruser kslcusromeruser)
    {
        return kslcusromeruserMapper.updateKslcusromeruser(kslcusromeruser);
    }

    /**
     * 删除经办人列表对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteKslcusromeruserByIds(String ids)
    {
        return kslcusromeruserMapper.deleteKslcusromeruserByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除经办人列表信息
     * 
     * @param id 经办人列表ID
     * @return 结果
     */
    @Override
    public int deleteKslcusromeruserById(Long id)
    {
        return kslcusromeruserMapper.deleteKslcusromeruserById(id);
    }
}
