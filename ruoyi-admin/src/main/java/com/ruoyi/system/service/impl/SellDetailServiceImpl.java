package com.ruoyi.system.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ruoyi.common.constant.AdminConstants;
import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.security.Md5Utils;
import com.ruoyi.system.domain.Salescontract;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.mapper.SalescontractMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SellDetailMapper;
import com.ruoyi.system.domain.SellDetail;
import com.ruoyi.system.service.ISellDetailService;
import com.ruoyi.common.core.text.Convert;
import org.springframework.transaction.annotation.Transactional;

/**
 * 销售订单列表Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-05-20
 */
@Service
@Transactional
public class SellDetailServiceImpl implements ISellDetailService 
{
    @Autowired
    private SellDetailMapper sellDetailMapper;
    @Autowired
    private SalescontractMapper salescontractMapper;

    /**
     * 查询销售订单列表
     * 
     * @param id 销售订单列表ID
     * @return 销售订单列表
     */
    @Override
    public SellDetail selectSellDetailById(Long id)
    {
        return sellDetailMapper.selectSellDetailById(id);
    }

    /**
     * 查询销售订单列表列表
     * 
     * @param sellDetail 销售订单列表
     * @return 销售订单列表
     */
    @Override
    public List<SellDetail> selectSellDetailList(SellDetail sellDetail)
    {
        return sellDetailMapper.selectSellDetailList(sellDetail);
    }



    /**
     * 新增销售订单列表
     * 
     * @param sellDetail 销售订单列表
     * @return 结果
     */
    @Override
    public int insertSellDetail(SellDetail sellDetail)
    {
        sellDetail.setCreateTime(DateUtils.getNowDate());
        int i = sellDetailMapper.insertSellDetail(sellDetail);
        updateSalescontract(sellDetail.getContractId());
        return i;
    }

    /**
     * 修改销售订单列表
     * 
     * @param sellDetail 销售订单列表
     * @return 结果
     */
    @Override
    public int updateSellDetail(SellDetail sellDetail)
    {
        return sellDetailMapper.updateSellDetail(sellDetail);
    }

    @Override
    public Map<String, Object> print(Long contractId) {
        //头部信息
        Map<String,Object> map=new HashMap<>();
        Salescontract salescontract = salescontractMapper.selectSalescontractById(contractId);
        if (salescontract.getContractid().substring(2,3).equals("G")){
            map.put("saletype", AdminConstants.Saletype.COMPANY_CONTRAC_SINGLE);
        }else if(salescontract.getContractid().substring(2,3).equals("Z")){
            map.put("saletype", AdminConstants.Saletype.FIELD_PERSONNEL_CONTRAC_SINGLE);
        }else{
            map.put("saletype", AdminConstants.Saletype.ON_LINE_CONTRAC_SINGLE);
        }
        List<SellDetail> sellDetails = sellDetailMapper.selectSellDetailByContractId(contractId);
        //销售合同基本信息
        map.put("salescontract", salescontract);
        //销售商品基本信息
        map.put("sellDetails", sellDetails);
        return map;
    }





    /**
     * 删除销售订单列表对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSellDetailByIds(String ids)
    {
        SellDetail sellDetail = sellDetailMapper.selectSellDetailById(Long.valueOf(ids));
        int i = sellDetailMapper.deleteSellDetailByIds(Convert.toStrArray(ids));
        updateSalescontract(sellDetail.getContractId());
        return i;
    }
    /**
     * 修改发票状态
     * @param salescontractId
     */
    private void updateSalescontract(Long salescontractId){
        Map map = salescontractMapper.selectSalescontractByInvoiceStatus(salescontractId);
        Salescontract salescontract=new Salescontract();
        salescontract.setId(salescontractId);
        if((long)map.get("icount")==0){
            salescontract.setInvoiceStatus(AdminConstants.Salescontract.INVOICESTATUS_NOOPEN);
        }else if((long)map.get("icount")!=(long)map.get("scount")){
            salescontract.setInvoiceStatus(AdminConstants.Salescontract.INVOICESTATUS_INCOMPLATE);
        }else{
            salescontract.setInvoiceStatus(AdminConstants.Salescontract.INVOICESTATUS_OPEN);
        }
        salescontractMapper.updateSalescontract(salescontract);
    };


    /**
     * 导入用户数据
     *
     * @param  商品数据列表
     * @return 结果
     */
    @Override
    public String importUser(List<SellDetail> sellDetailList)
    {
        if (StringUtils.isNull(sellDetailList) || sellDetailList.size() == 0)
        {
            throw new BusinessException("导入数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (SellDetail sellDetail : sellDetailList)
        {
            try
            {
               
                    successNum++;
            }
            catch (Exception e)
            {
                failureNum++;
            }
        }
        if (failureNum > 0)
        {
            failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
            throw new BusinessException(failureMsg.toString());
        }
        else
        {
            successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        }
        return successMsg.toString();
    }

}
