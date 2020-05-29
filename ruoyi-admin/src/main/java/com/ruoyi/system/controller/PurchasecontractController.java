package com.ruoyi.system.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ruoyi.system.domain.Salescontract;
import com.ruoyi.system.domain.Supplier;
import com.ruoyi.system.service.IPurchasedetailService;
import com.ruoyi.system.service.ISalescontractService;
import com.ruoyi.system.service.ISupplierService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.Purchasecontract;
import com.ruoyi.system.service.IPurchasecontractService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 采购合同Controller
 * 
 * @author ruoyi
 * @date 2020-05-22
 */
@Controller
@RequestMapping("/system/purchasecontract")
public class PurchasecontractController extends BaseController
{
    private String prefix = "system/purchasecontract";

    @Autowired
    private IPurchasecontractService purchasecontractService;
    @Autowired
    private ISalescontractService salescontractService;
    @Autowired
    private ISupplierService supplierService;
    @Autowired
    private IPurchasedetailService purchasedetailService;



    @PostMapping(value = "PurchasesamountBymonth")
    @ResponseBody
    public Map<String, Object> PurchasesamountBymonth(@RequestParam("newdate") String newdate) {
        Map<String, Object> queryMap = new HashMap<String, Object>();

        queryMap.put("result", purchasecontractService.selectPurchasesamountByMonth(newdate));

        return  queryMap;
    }

    @PostMapping(value = "PurchasesamountByday")
    @ResponseBody
    public Map<String, Object> PurchasesamountByday(@RequestParam("newyear") String newyear,@RequestParam("newmonth") String newmonth) {
        Map<String, Object> queryMap = new HashMap<String, Object>();
        queryMap.put("result", purchasecontractService.selectPurchasesamountByday(newyear,newmonth));

        return  queryMap;
    }




    @RequiresPermissions("system:purchasecontract:view")
    @GetMapping()
    public String purchasecontract()
    {
        return prefix + "/purchasecontract";
    }

    /**
     * 查询采购合同列表
     */
    @RequiresPermissions("system:purchasecontract:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Purchasecontract purchasecontract)
    {
        startPage();
        List<Purchasecontract> list = purchasecontractService.selectPurchasecontractList(purchasecontract);
        return getDataTable(list);
    }

    /**
     * 导出采购合同列表
     */
    @RequiresPermissions("system:purchasecontract:export")
    @Log(title = "采购合同", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Purchasecontract purchasecontract)
    {
        List<Purchasecontract> list = purchasecontractService.selectPurchasecontractList(purchasecontract);
        ExcelUtil<Purchasecontract> util = new ExcelUtil<Purchasecontract>(Purchasecontract.class);
        return util.exportExcel(list, "purchasecontract");
    }


    // 生成合同编号
    @RequestMapping(value = { "/getPurchaseContractid" }, method = { RequestMethod.POST })
    @ResponseBody
    public Map<String, String> getContractid(
            @RequestParam(value = "contractid", required = false, defaultValue = "") String contractid) {
        Map<String, String> map = new HashMap<String, String>();
        if (null != contractid && contractid.length() == 0) {

        } else {
            map.put("purchasecontractid", purchasecontractService.findcontractid(contractid));
        }
        return map;
    }

    /**
     * 新增采购合同
     */
    @GetMapping("/add")
    public String add(ModelMap mmap)
    {
        List<Salescontract> salescontractsList = salescontractService.selectSalescontractList(null);
        List<Supplier> suppliersList = supplierService.findList();
        mmap.put("suppliersList", suppliersList);
        mmap.put("salescontractsList", salescontractsList);
        return prefix + "/add";
    }

    /**
     * 新增保存采购合同
     */
    @RequiresPermissions("system:purchasecontract:add")
    @Log(title = "采购合同", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Purchasecontract purchasecontract)
    {
        return toAjax(purchasecontractService.insertPurchasecontract(purchasecontract));
    }

    /**
     * 修改采购合同
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        Purchasecontract purchasecontract = purchasecontractService.selectPurchasecontractById(id);
        mmap.put("purchasecontract", purchasecontract);
        return prefix + "/edit";
    }

    /**
     * 修改保存采购合同
     */
    @RequiresPermissions("system:purchasecontract:edit")
    @Log(title = "采购合同", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Purchasecontract purchasecontract)
    {
        return toAjax(purchasecontractService.updatePurchasecontract(purchasecontract));
    }

    /**
     * 删除采购合同
     */
    @RequiresPermissions("system:purchasecontract:remove")
    @Log(title = "采购合同", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        String purchasecontractid = purchasecontractService.selectPurchasecontractById(Long.valueOf(ids)).getPurchasecontractid();
        if(purchasedetailService.selectPurchasedetailListByPurchasecontractId(purchasecontractid)!=null&&purchasedetailService.selectPurchasedetailListByPurchasecontractId(purchasecontractid).size()>0) {
            return AjaxResult.error("操作失败,采购合同下有订单信息!");
        }
        return toAjax(purchasecontractService.deletePurchasecontractByIds(ids));
    }


    /**
     * 查看合同信息
     */
    @RequiresPermissions("system:purchasecontract:purchaseinfo")
    @GetMapping("/purchaseInfo/{id}")
    public String purchaseInfo(@PathVariable("id") Long id, ModelMap mmap)
    {
        Purchasecontract purchasecontract = purchasecontractService.selectPurchasecontractById(id);
        mmap.put("purchasecontract", purchasecontract);
        return prefix + "/purchaseinfo";
    }
}
