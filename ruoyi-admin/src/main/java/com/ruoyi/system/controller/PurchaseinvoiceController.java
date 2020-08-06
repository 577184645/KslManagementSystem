package com.ruoyi.system.controller;

import java.util.List;

import com.ruoyi.system.domain.Purchasedetail;
import com.ruoyi.system.service.IPurchasedetailService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.Purchaseinvoice;
import com.ruoyi.system.service.IPurchaseinvoiceService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 采购发票Controller
 * 
 * @author ruoyi
 * @date 2020-07-09
 */
@Controller
@RequestMapping("/system/purchaseinvoice")
public class PurchaseinvoiceController extends BaseController
{
    private String prefix = "system/purchaseinvoice";

    @Autowired
    private IPurchaseinvoiceService purchaseinvoiceService;
    @Autowired
    private IPurchasedetailService purchasedetailService;

    @RequiresPermissions("system:purchaseinvoice:view")
    @GetMapping()
    public String purchaseinvoice()
    {
        return prefix + "/purchaseinvoice";
    }

    /**
     * 查询采购发票列表
     */
    @RequiresPermissions("system:purchaseinvoice:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Purchaseinvoice purchaseinvoice)
    {
        startPage();
        List<Purchaseinvoice> list = purchaseinvoiceService.selectPurchaseinvoiceList(purchaseinvoice);
        return getDataTable(list);
    }

    /**
     * 导出采购发票列表
     */
    @RequiresPermissions("system:purchaseinvoice:export")
    @Log(title = "采购发票", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Purchaseinvoice purchaseinvoice)
    {
        List<Purchaseinvoice> list = purchaseinvoiceService.selectPurchaseinvoiceList(purchaseinvoice);
        ExcelUtil<Purchaseinvoice> util = new ExcelUtil<Purchaseinvoice>(Purchaseinvoice.class);
        return util.exportExcel(list, "purchaseinvoice");
    }


    /**
     * 新增采购发票
     */
    @GetMapping("/add/{id}")
    public String add(ModelMap map, @PathVariable("id") String ids)
    {
        String[] split = ids.split(",");
        if (split.length==1) {
            Purchasedetail purchasedetail = purchasedetailService.selectPurchasedetailById(Long.valueOf(split[0]));
            map.put("purchasedetail", purchasedetail);
            return prefix + "/add";
        }else {
            Purchasedetail purchasedetail = purchasedetailService.selectPurchasedetailById(Long.valueOf(split[0]));

            Float sum=0f;
            for (int i=0;i<split.length;i++){
                sum+=purchasedetailService.selectPurchasedetailById(Long.valueOf(split[i])).getMoney();
            }
            map.put("purchasecontractid", purchasedetail.getPurchasecontractid());
            map.put("sum",sum);
            map.put("ids",ids);
            return prefix + "/adds";
        }

    }

    /**
     * 新增保存采购发票
     */
    @RequiresPermissions("system:purchaseinvoice:add")
    @Log(title = "采购发票", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Purchaseinvoice purchaseinvoice)
    {
        return toAjax(purchaseinvoiceService.insertPurchaseinvoice(purchaseinvoice));
    }

    /**
     * 修改采购发票
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        Purchaseinvoice purchaseinvoice = purchaseinvoiceService.selectPurchaseinvoiceById(id);
        mmap.put("purchaseinvoice", purchaseinvoice);
        return prefix + "/edit";
    }

    /**
     * 修改保存采购发票
     */
    @RequiresPermissions("system:purchaseinvoice:edit")
    @Log(title = "采购发票", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Purchaseinvoice purchaseinvoice)
    {
        return toAjax(purchaseinvoiceService.updatePurchaseinvoice(purchaseinvoice));
    }

    /**
     * 删除采购发票
     */
    @RequiresPermissions("system:purchaseinvoice:remove")
    @Log(title = "采购发票", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String purchaseinvoiceid,String purchasecontractid)
    {
        return toAjax(purchaseinvoiceService.deletePurchaseinvoiceByIds(purchaseinvoiceid,purchasecontractid));
    }
}
