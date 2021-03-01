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
    public List<SellDetail>  selectSellDetailByContractId(Long contractId);


    public List<SellDetail>  selectSellDetailByInContractId( String [] contracts);

    /**
     * 查询销售订单列表列表
     * 
     * @param sellDetail 销售订单列表
     * @return 销售订单列表集合
     */
    public List<SellDetail> selectSellDetailList(SellDetail sellDetail);



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

    /**
     * 根据发票号码把发票号改为空
     *
     * @param invoiceId 销售订单列表
     * @return 结果
     */
    public int updateInvoiceIdNullByInvoiceId(String invoiceId);








    /**
     * 根据id修改当前商品的发票状态为已采购
     * @param id
     * @return
     */
    public int updatePurchaseStatusById(Long id);





    /**
     * 批量删除销售订单列表
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSellDetailByIds(String[] ids);








}
