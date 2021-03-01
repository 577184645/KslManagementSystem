package com.ruoyi.system.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.system.domain.Salescontract;
import org.apache.ibatis.annotations.Param;

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
     * @param salescontract  salescontractList 销售合同列表
     * @return 结果
     */



    public int insertSalescontractAndSelldetail(String salescontractList,Salescontract salescontract);

    /**
     * 修改销售合同列表
     * 
     * @param salescontract 销售合同列表
     * @return 结果
     */
    public int updateSalescontract(Salescontract salescontract);

    /**
     * 删除销售合同列表
     * 
     * @param id 需要删除的数据ID
     * @return 结果
     */
    public AjaxResult deleteSalescontractById(Long id);



    /**
     * 生成合同号
     * @param type
     * @return
     */
    String getContractid(String type,String year);





    Map<String,Object> findSalescontractInfo(Long id);



}
