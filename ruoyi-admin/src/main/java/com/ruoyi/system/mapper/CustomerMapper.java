package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Customer;

/**
 * 客户列表Mapper接口
 * 
 * @author ruoyi
 * @date 2020-05-19
 */
public interface CustomerMapper 
{
    /**
     * 查询客户列表
     * 
     * @param id 客户列表ID
     * @return 客户列表
     */
    public Customer selectCustomerById(Long id);

    /**
     * 查询客户列表列表
     * 
     * @param customer 客户列表
     * @return 客户列表集合
     */
    public List<Customer> selectCustomerList(Customer customer);

    /**
     * 新增客户列表
     * 
     * @param customer 客户列表
     * @return 结果
     */
    public int insertCustomer(Customer customer);

    /**
     * 修改客户列表
     * 
     * @param customer 客户列表
     * @return 结果
     */
    public int updateCustomer(Customer customer);

    /**
     * 删除客户列表
     * 
     * @param id 客户列表ID
     * @return 结果
     */
    public int deleteCustomerById(Long id);

    /**
     * 批量删除客户列表
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCustomerByIds(String[] ids);

    /**
     * 查询所有客户
     * @return
     */
    public List<Customer> findList();

}
