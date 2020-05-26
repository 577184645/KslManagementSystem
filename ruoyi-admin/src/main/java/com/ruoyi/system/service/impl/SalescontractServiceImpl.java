package com.ruoyi.system.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SalescontractMapper;
import com.ruoyi.system.domain.Salescontract;
import com.ruoyi.system.service.ISalescontractService;
import com.ruoyi.common.core.text.Convert;

/**
 * 销售合同列表Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-05-20
 */
@Service
public class SalescontractServiceImpl implements ISalescontractService 
{
    @Autowired
    private SalescontractMapper salescontractMapper;

    /**
     * 查询销售合同列表
     * 
     * @param id 销售合同列表ID
     * @return 销售合同列表
     */
    @Override
    public Salescontract selectSalescontractById(Long id)
    {
        return salescontractMapper.selectSalescontractById(id);
    }

    /**
     * 查询销售合同列表列表
     * 
     * @param salescontract 销售合同列表
     * @return 销售合同列表
     */
    @Override
    public List<Salescontract> selectSalescontractList(Salescontract salescontract)
    {
        return salescontractMapper.selectSalescontractList(salescontract);
    }

    /**
     * 新增销售合同列表
     * 
     * @param salescontract 销售合同列表
     * @return 结果
     */
    @Override
    public int insertSalescontract(Salescontract salescontract)
    {
        salescontract.setCreateTime(DateUtils.getNowDate());
        return salescontractMapper.insertSalescontract(salescontract);
    }

    /**
     * 修改销售合同列表
     * 
     * @param salescontract 销售合同列表
     * @return 结果
     */
    @Override
    public int updateSalescontract(Salescontract salescontract)
    {
        return salescontractMapper.updateSalescontract(salescontract);
    }

    /**
     * 删除销售合同列表对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSalescontractByIds(String ids)
    {
        return salescontractMapper.deleteSalescontractByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除销售合同列表信息
     * 
     * @param id 销售合同列表ID
     * @return 结果
     */
    @Override
    public int deleteSalescontractById(Long id)
    {
        return salescontractMapper.deleteSalescontractById(id);
    }

    @Override
    public String getContractid(String type) {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy");
        String data = format.format(date);
        data = data.substring(2, data.length());
        List<String> list = salescontractMapper.maxContractid(type,data);

        String contractid = data;
        int index = 0;
        int number = 0;
        if (list.size() == 0 && type.equals("G")) {
            contractid = contractid + "G" + "0001";
        } else if (list.size() == 0 && type.equals("Z")) {
            contractid = contractid + "Z" + "0001";
        }else if (list.size() == 0 && type.equals("X")) {
            contractid = contractid + "X" + "0001";
        }

        else if (type.equals("G")) {
            for (int i = 0; i < list.size(); i++) {
                contractid = list.get(i);
                index = contractid.indexOf("G");
                if (number < Integer.valueOf(contractid.substring(index + 1, contractid.length()))) {
                    number = Integer.valueOf(contractid.substring(index + 1, contractid.length()));
                }

            }
            number++;

            String numbers = String.valueOf(number);
            if (numbers.length() == 1) {
                numbers = "000" + numbers;
            } else if (numbers.length() == 2) {
                numbers = "00" + numbers;
            } else if (numbers.length() == 3) {
                numbers = "0" + numbers;
            }
            contractid = data + "G" + numbers;
        } else if (type.equals("Z")) {
            for (int i = 0; i < list.size(); i++) {
                contractid = list.get(i);
                index = contractid.indexOf("Z");
                if (number < Integer.valueOf(contractid.substring(index + 1, contractid.length()))) {
                    number = Integer.valueOf(contractid.substring(index + 1, contractid.length()));
                }

            }
            number++;

            String numbers = String.valueOf(number);
            if (numbers.length() == 1) {
                numbers = "000" + numbers;
            } else if (numbers.length() == 2) {
                numbers = "00" + numbers;
            } else if (numbers.length() == 3) {
                numbers = "0" + numbers;
            }

            contractid = data + "Z" + numbers;

        }
        else if (type.equals("X")) {
            for (int i = 0; i < list.size(); i++) {
                contractid = list.get(i);
                index = contractid.indexOf("X");
                if (number < Integer.valueOf(contractid.substring(index + 1, contractid.length()))) {
                    number = Integer.valueOf(contractid.substring(index + 1, contractid.length()));
                }

            }
            number++;

            String numbers = String.valueOf(number);
            if (numbers.length() == 1) {
                numbers = "000" + numbers;
            } else if (numbers.length() == 2) {
                numbers = "00" + numbers;
            } else if (numbers.length() == 3) {
                numbers = "0" + numbers;
            }

            contractid = data + "Z" + numbers;

        }

        return contractid;
    }
}
