package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Kslcusromeruser;

/**
 * 经办人列表Mapper接口
 * 
 * @author ruoyi
 * @date 2020-05-19
 */
public interface KslcusromeruserMapper 
{
    /**
     * 查询经办人列表
     * 
     * @param id 经办人列表ID
     * @return 经办人列表
     */
    public Kslcusromeruser selectKslcusromeruserById(Long id);

    /**
     * 查询经办人列表列表
     * 
     * @param kslcusromeruser 经办人列表
     * @return 经办人列表集合
     */
    public List<Kslcusromeruser> selectKslcusromeruserList(Kslcusromeruser kslcusromeruser);

    /**
     * 新增经办人列表
     * 
     * @param kslcusromeruser 经办人列表
     * @return 结果
     */
    public int insertKslcusromeruser(Kslcusromeruser kslcusromeruser);

    /**
     * 修改经办人列表
     * 
     * @param kslcusromeruser 经办人列表
     * @return 结果
     */
    public int updateKslcusromeruser(Kslcusromeruser kslcusromeruser);

    /**
     * 删除经办人列表
     * 
     * @param id 经办人列表ID
     * @return 结果
     */
    public int deleteKslcusromeruserById(Long id);

    /**
     * 批量删除经办人列表
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteKslcusromeruserByIds(String[] ids);
}
