package com.ruoyi.system.controller;

import java.util.ArrayList;
import java.util.List;

import com.ruoyi.system.domain.*;
import com.ruoyi.system.service.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.servlet.ModelAndView;

/**
 * 采购订单列表Controller
 *
 * @author ruoyi
 * @date 2020-05-25
 */
@Controller
@RequestMapping("/system/purchasedetail")
public class PurchasedetailController extends BaseController {
    private String prefix = "system/purchasedetail";

    @Autowired
    private IPurchasedetailService purchasedetailService;



    @RequiresPermissions("system:purchasedetail:view")
    @GetMapping()
    public String purchasedetail() {

        return prefix + "/purchasedetail";
    }

    /**
     * 查询采购订单列表列表
     */
    @RequiresPermissions("system:purchasedetail:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Purchasedetail purchasedetail) {
        startPage();
        List<Purchasedetail> list = purchasedetailService.selectPurchasedetailList(purchasedetail);
        return getDataTable(list);
    }

    /**
     * 导出采购订单列表列表
     */
    @RequiresPermissions("system:purchasedetail:export")
    @Log(title = "采购订单列表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Purchasedetail purchasedetail) {
        List<Purchasedetail> list = purchasedetailService.selectPurchasedetailList(purchasedetail);
        ExcelUtil<Purchasedetail> util = new ExcelUtil<Purchasedetail>(Purchasedetail.class);
        return util.exportExcel(list, "purchasedetail");
    }







    /**
     * 修改采购订单列表
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        Purchasedetail purchasedetail = purchasedetailService.selectPurchasedetailById(id);
        mmap.put("purchasedetail", purchasedetail);
        return prefix + "/edit";
    }

    /**
     * 修改保存采购订单列表
     */
    @RequiresPermissions("system:purchasedetail:edit")
    @Log(title = "采购订单列表", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Purchasedetail purchasedetail) {
        return toAjax(purchasedetailService.updatePurchasedetail(purchasedetail));
    }






    /**
     * 跳转查看发票对应商品
     * @param mmap
     * @return
     */
    @GetMapping("/invoiceinfoview/{purchaseinvoiceId}")
    public String invoiceinfoview(@PathVariable("purchaseinvoiceId") Long purchaseinvoiceId, ModelMap mmap)
    {
        mmap.put("purchaseinvoiceId",purchaseinvoiceId);
        return prefix + "/invoiceinfo";
    }






    /**
 * 删除采购订单列表
     */
    @RequiresPermissions("system:purchasedetail:remove")
    @Log(title = "采购订单列表", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(Long ids) {
        return purchasedetailService.deletePurchasedetailById(ids);
    }
}
