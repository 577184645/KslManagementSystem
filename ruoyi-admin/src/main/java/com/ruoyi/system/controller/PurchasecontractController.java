package com.ruoyi.system.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.*;
import com.ruoyi.system.service.*;
import com.ruoyi.system.utils.numberUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
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
    public Map<String, String> getContractid(@RequestParam("contractid") Long contractid) {
        Map<String, String> map = new HashMap<String, String>();
        if (contractid!=null) {
            String contractnumber=  salescontractService.selectSalescontractById(contractid).getContractid();
            map.put("purchasecontractid", purchasecontractService.findcontractid(contractid,contractnumber));
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
    public AjaxResult addSave(String purchasecontractList,Purchasecontract purchasecontract)
    {
        return toAjax(purchasecontractService.addPurchasecontract(purchasecontractList,purchasecontract));
    }

    /**
     * 修改采购合同
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        Purchasecontract purchasecontract = purchasecontractService.selectPurchasecontractById(id);
        List<Supplier> suppliersList = supplierService.findList();
        mmap.put("suppliersList", suppliersList);
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
    public AjaxResult remove(Long ids)
    {
        return purchasecontractService.deletePurchasecontractById(ids);
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

    /**
     * 打印合同信息
     */
    @GetMapping("/print/{id}")
    public String print(@PathVariable("id") String id, ModelMap mmap)
    {
        mmap.put("data",purchasecontractService.print(id));
        return prefix + "/print";
    }
}
