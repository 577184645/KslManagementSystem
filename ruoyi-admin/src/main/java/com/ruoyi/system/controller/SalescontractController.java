package com.ruoyi.system.controller;

import java.text.SimpleDateFormat;
import java.util.*;

import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.*;
import com.ruoyi.system.mapper.InvoiceMapper;
import com.ruoyi.system.service.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.servlet.ModelAndView;

/**
 * 销售合同列表Controller
 * 
 * @author ruoyi
 * @date 2020-05-20
 */
@Controller
@RequestMapping("/system/salescontract")
public class SalescontractController extends BaseController
{
    private String prefix = "system/salescontract";

    @Autowired
    private ISalescontractService salescontractService;

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IKslcusromeruserService kslcusromeruserService;

    @Autowired
    private ISellDetailService sellDetailService;



    @RequiresPermissions("system:salescontract:view")
    @GetMapping()
    public String salescontract(ModelMap mmap)
    {
        mmap.put("kslcusromeruserList", kslcusromeruserService.selectKslcusromeruserList(null));
        mmap.put("customerList", customerService.selectCustomerList(null));
        return prefix + "/salescontract";
    }




    @RequestMapping("/findSalescontract/{operator}")
    @ResponseBody
    public List<Salescontract> findSalescontract(@PathVariable("operator") String operator){
       Salescontract salescontract=new Salescontract();
       salescontract.setOperator(operator);
        salescontract.setIslookstatus(true);
        return     salescontractService.selectSalescontractList(salescontract);
    }

    @RequestMapping("/findSalescontractInfo/{id}")
    @ResponseBody
    public Map<String,Object> findSalescontractInfo(@PathVariable("id") String id){
        Map<String, Object> salescontractInfo = salescontractService.findSalescontractInfo(Long.valueOf(id));
        return    salescontractService.findSalescontractInfo(Long.valueOf(id));
    }




    @RequestMapping("/print/{id}")
    public String print(@PathVariable("id") Long id, Map<String,Object> map)
    {
        map.put("data",sellDetailService.print(id));
        return  prefix+"/print";
    }











    @RequestMapping(value = { "/getContractid" }, method = { RequestMethod.POST })
    @ResponseBody
    public Map<String, String> getContractid(
            @RequestParam(value = "type") String type,@RequestParam(value = "year") String year) {
        Map<String, String> map = new HashMap<String, String>();
        if (StringUtils.isNotBlank(type)&& StringUtils.isNotBlank(year)) {
            map.put("contractid", salescontractService.getContractid(type,year.substring(2,4)));
            return map;
        }
        return map;
    }

    /**
     * 查询销售合同列表列表
     */
    @RequiresPermissions("system:salescontract:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Salescontract salescontract)
    {
        startPage();
        List<Salescontract> list = salescontractService.selectSalescontractList(salescontract);
        return getDataTable(list);
    }

    /**
     * 导出销售合同列表列表
     */
    @RequiresPermissions("system:salescontract:export")
    @Log(title = "销售合同列表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Salescontract salescontract)
    {
        List<Salescontract> list = salescontractService.selectSalescontractList(salescontract);
        ExcelUtil<Salescontract> util = new ExcelUtil<Salescontract>(Salescontract.class);
        return util.exportExcel(list, "salescontract");
    }

    /**
     * 新增销售合同列表
     */
    @GetMapping("/add")
    public ModelAndView add(ModelAndView model)
    {
        model.addObject("customerList",customerService.findList());
        model.addObject("kslcusromeruserList",kslcusromeruserService.selectKslcusromeruserList(null));
        model.setViewName(prefix + "/add");
        return model;
    }

    /**
     * 新增保存销售合同列表
     */
    @RequiresPermissions("system:salescontract:add")
    @Log(title = "销售合同列表", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(String salescontractList,Salescontract salescontract)
    {
        return toAjax(salescontractService.insertSalescontractAndSelldetail(salescontractList,salescontract));
    }

    /**
     * 修改销售合同列表
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        mmap.put("customerList",customerService.findList());
        mmap.put("kslcusromeruserList",kslcusromeruserService.selectKslcusromeruserList(null));
        Salescontract salescontract = salescontractService.selectSalescontractById(id);
        mmap.put("salescontract", salescontract);
        return prefix + "/edit";
    }

    /**
     * 修改保存销售合同列表
     */
    @RequiresPermissions("system:salescontract:edit")
    @Log(title = "销售合同列表", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Salescontract salescontract)
    {
        return toAjax(salescontractService.updateSalescontract(salescontract));
    }

    /**
     * 删除销售合同列表
     */
    @RequiresPermissions("system:salescontract:remove")
    @Log(title = "销售合同列表", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(Long ids)
    {
        return salescontractService.deleteSalescontractById(ids);
    }



    /**
     * 查看合同信息
     */
    @RequiresPermissions("system:salescontract:saleinfo")
    @GetMapping("/saleInfo/{id}")
    public String saleInfo(@PathVariable("id") Long id, ModelMap mmap)
    {
        Salescontract salescontract = salescontractService.selectSalescontractById(id);
        mmap.put("salescontract", salescontract);
        return prefix + "/saleinfo";
    }
}
