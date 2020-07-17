package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SellDetail;
import com.ruoyi.system.domain.Supplier;
import org.apache.ibatis.annotations.Param;

/**
 * 销售订单列表Mapper接口
 * 
 * @author ruoyi
 * @date 2020-05-20
 */
public interface SellDetailMapper 
{
    /**
     * 查询销售订单列表
     * 
     * @param id 销售订单列表ID
     * @return 销售订单列表
     */
    public SellDetail selectSellDetailById(Long id);

    /**
     * 查询销售订单列表
     *
     * @param contractId 销售订单列表ID
     * @return 销售订单列表
     */
    public List<SellDetail>  selectSellDetailByContractId(String contractId);


    public List<SellDetail>  selectSellDetailByInContractId( String [] contracts);

    /**
     * 查询销售订单列表列表
     * 
     * @param sellDetail 销售订单列表
     * @return 销售订单列表集合
     */
    public List<SellDetail> selectSellDetailList(SellDetail sellDetail);

    public List<SellDetail> selectSellDetailListAndInvoice(@Param("contractid") String contractid);


    /**
     * 新增销售订单列表
     * 
     * @param sellDetail 销售订单列表
     * @return 结果
     */
    public int insertSellDetail(SellDetail sellDetail);

    /**
     * 修改销售订单列表
     * 
     * @param sellDetail 销售订单列表
     * @return 结果
     */
    public int updateSellDetail(SellDetail sellDetail);


    public int updatePurchasestatusAndPurchasecontractid(SellDetail sellDetail);



    /**
     * 删除销售订单列表
     * 
     * @param id 销售订单列表ID
     * @return 结果
     */
    public int deleteSellDetailById(Long id);

    /**
     * 批量删除销售订单列表
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSellDetailByIds(String[] ids);








}
