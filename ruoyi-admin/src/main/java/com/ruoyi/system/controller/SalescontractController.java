package com.ruoyi.system.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ruoyi.system.service.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.Salescontract;
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
    private IPurchasecontractService purchasecontractService;



    @Autowired
    private ISellDetailService sellDetailService;

    @RequiresPermissions("system:salescontract:view")
    @GetMapping()
    public ModelAndView salescontract(ModelAndView model)
    {
        model.addObject("salescontractList",salescontractService.selectSalescontractList(null));
        model.addObject("customerList",customerService.findList());
        model.addObject("kslcusromeruserList",kslcusromeruserService.selectKslcusromeruserList(null));
        model.setViewName(prefix + "/salescontract");
        return model;
    }



    @PostMapping(value = "salesamountBymonth")
    @ResponseBody
    public Map<String, Object> SalesamountBymonth(@RequestParam("newdate") String newdate) {
        Map<String, Object> queryMap = new HashMap<String, Object>();

        queryMap.put("result", salescontractService.selectSalesamountBmonth(newdate));

        return  queryMap;
    }

    @PostMapping(value = "salesamountByday")
    @ResponseBody
    public Map<String, Object> salesamountByday(@RequestParam("newyear") String newyear,@RequestParam("newmonth") String newmonth) {
        Map<String, Object> queryMap = new HashMap<String, Object>();
        queryMap.put("result", salescontractService.selectSalesamountByday(newyear,newmonth));

        return  queryMap;
    }




    @GetMapping(value = "sumMoneyGYear")
    @ResponseBody
    public Map<String, Object> sumMoneyGYear() throws Exception{
        Map<String, Object> queryMap = new HashMap<String, Object>();
        Date date=new Date();
        SimpleDateFormat format=new SimpleDateFormat("yyyy");
        String format1 = format.format(date);
        queryMap.put("summoney", salescontractService.sumMoneyGYear(format1)!=null?salescontractService.sumMoneyGYear(format1):0);
        return  queryMap;
    }


    @RequestMapping(value = { "/getContractid" }, method = { RequestMethod.POST })
    @ResponseBody
    public Map<String, String> getContractid(
            @RequestParam(value = "type", required = false, defaultValue = "") String type) {
        Map<String, String> map = new HashMap<String, String>();
        if (null != type && type.length() == 0) {

        } else {
            map.put("contractid", salescontractService.getContractid(type));
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
    public AjaxResult remove(String ids)
    {
        String contractid = salescontractService.selectSalescontractById(Long.valueOf(ids)).getContractid();
        if(sellDetailService.selectSellDetailByContractId(contractid)!=null&&sellDetailService.selectSellDetailByContractId(contractid).size()>0) {
            return AjaxResult.error("操作失败,销售合同下有订单信息!");
        }
        if(purchasecontractService.selectPurchasecontractByContractId(contractid)!=null&&purchasecontractService.selectPurchasecontractByContractId(contractid).size()>0){
            return AjaxResult.error("操作失败,销售合同下有采购合同!");
        }
        return toAjax(salescontractService.deleteSalescontractByIds(ids));
    }



    /**
     * 查看合同信息
     */
    @RequiresPermissions("system:salescontract:saleinfo")
    @GetMapping("/saleInfo/{id}")
    public String saleInfo(@PathVariable("id") Long id, ModelMap mmap)
    {
        Salescontract salescontract = salescontractService.selectSalescontractById(id);
         Double purchasesamount=purchasecontractService.selectPurchasesamountsumByContractId(salescontract.getContractid())!=null?purchasecontractService.selectPurchasesamountsumByContractId(salescontract.getContractid()):0;
        mmap.put("salescontract", salescontract);
        mmap.put("purchasesamount", purchasesamount);
        return prefix + "/saleinfo";
    }
}
