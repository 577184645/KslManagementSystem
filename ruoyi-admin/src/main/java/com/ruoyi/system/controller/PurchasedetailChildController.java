package com.ruoyi.system.controller;

import java.util.List;

import com.ruoyi.system.domain.Supplier;
import com.ruoyi.system.service.ISupplierService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.PurchasedetailChild;
import com.ruoyi.system.service.IPurchasedetailChildService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 采购订单子Controller
 * 
 * @author ruoyi
 * @date 2020-05-26
 */
@Controller
@RequestMapping("/system/child")
public class PurchasedetailChildController extends BaseController
{
    private String prefix = "system/child";

    @Autowired
    private IPurchasedetailChildService purchasedetailChildService;
    @Autowired
    private ISupplierService supplierService;

    @RequiresPermissions("system:child:view")
    @GetMapping()
    public String child()
    {
        return prefix + "/child";
    }

    /**
     * 查询采购订单子列表
     */
    @RequiresPermissions("system:child:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(PurchasedetailChild purchasedetailChild)
    {
        startPage();
        List<PurchasedetailChild> list = purchasedetailChildService.selectPurchasedetailChildList(purchasedetailChild);
        return getDataTable(list);
    }




    /**
     * 导出采购订单子列表
     */
    @RequiresPermissions("system:child:export")
    @Log(title = "采购订单子", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(PurchasedetailChild purchasedetailChild)
    {
        List<PurchasedetailChild> list = purchasedetailChildService.selectPurchasedetailChildList(purchasedetailChild);
        ExcelUtil<PurchasedetailChild> util = new ExcelUtil<PurchasedetailChild>(PurchasedetailChild.class);
        return util.exportExcel(list, "child");
    }

    /**
     * 新增采购订单子
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存采购订单子
     */
    @RequiresPermissions("system:child:add")
    @Log(title = "采购订单子", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(PurchasedetailChild purchasedetailChild)
    {
        return toAjax(purchasedetailChildService.insertPurchasedetailChild(purchasedetailChild));
    }

    /**
     * 修改采购订单子
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        PurchasedetailChild purchasedetailChild = purchasedetailChildService.selectPurchasedetailChildById(id);
        List<Supplier> suppliersList = supplierService.findList();
        mmap.put("suppliersList", suppliersList);
        mmap.put("purchasedetailChild", purchasedetailChild);
        return prefix + "/edit";
    }

    /**
     * 修改保存采购订单子
     */
   // @RequiresPermissions("system:child:edit")
    @Log(title = "采购订单子", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(PurchasedetailChild purchasedetailChild)
    {
        return toAjax(purchasedetailChildService.updatePurchasedetailChild(purchasedetailChild));
    }

    /**
     * 删除采购订单子
     */
   // @RequiresPermissions("system:child:remove")
    @Log(title = "采购订单子", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(purchasedetailChildService.deletePurchasedetailChildByIds(ids));
    }
}
