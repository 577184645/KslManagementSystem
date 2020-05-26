package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Salescontract;

/**
 * 销售合同列表Service接口
 * 
 * @author ruoyi
 * @date 2020-05-20
 */
public interface ISalescontractService 
{
    /**
     * 查询销售合同列表
     * 
     * @param id 销售合同列表ID
     * @return 销售合同列表
     */
    public Salescontract selectSalescontractById(Long id);

    /**
     * 查询销售合同列表列表
     * 
     * @param salescontract 销售合同列表
     * @return 销售合同列表集合
     */
    public List<Salescontract> selectSalescontractList(Salescontract salescontract);

    /**
     * 新增销售合同列表
     * 
     * @param salescontract 销售合同列表
     * @return 结果
     */
    public int insertSalescontract(Salescontract salescontract);

    /**
     * 修改销售合同列表
     * 
     * @param salescontract 销售合同列表
     * @return 结果
     */
    public int updateSalescontract(Salescontract salescontract);

    /**
     * 批量删除销售合同列表
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSalescontractByIds(String ids);

    /**
     * 删除销售合同列表信息
     * 
     * @param id 销售合同列表ID
     * @return 结果
     */
    public int deleteSalescontractById(Long id);

    /**
     * 生成合同号
     * @param type
     * @return
     */
    String getContractid(String type);

}
