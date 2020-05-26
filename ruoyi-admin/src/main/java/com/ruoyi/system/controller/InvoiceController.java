package com.ruoyi.system.controller;

import java.util.List;

import com.ruoyi.system.domain.SellDetail;
import com.ruoyi.system.service.ISellDetailService;
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
import com.ruoyi.system.domain.Invoice;
import com.ruoyi.system.service.IInvoiceService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 销售发票列表Controller
 * 
 * @author ruoyi
 * @date 2020-05-21
 */
@Controller
@RequestMapping("/system/invoice")
public class InvoiceController extends BaseController
{
    private String prefix = "system/invoice";

    @Autowired
    private IInvoiceService invoiceService;
    @Autowired
    private ISellDetailService sellDetailService;

    @RequiresPermissions("system:invoice:view")
    @GetMapping()
    public String invoice()
    {
        return prefix + "/invoice";
    }

    /**
     * 查询销售发票列表列表
     */
    @RequiresPermissions("system:invoice:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Invoice invoice)
    {
        startPage();
        List<Invoice> list = invoiceService.selectInvoiceList(invoice);
        return getDataTable(list);
    }

    /**
     * 导出销售发票列表列表
     */
    @RequiresPermissions("system:invoice:export")
    @Log(title = "销售发票列表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Invoice invoice)
    {
        List<Invoice> list = invoiceService.selectInvoiceList(invoice);
        ExcelUtil<Invoice> util = new ExcelUtil<Invoice>(Invoice.class);
        return util.exportExcel(list, "invoice");
    }

    /**
     * 新增销售发票列表
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存销售发票列表
     */
    @RequiresPermissions("system:invoice:add")
    @Log(title = "销售发票列表", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Invoice invoice)
    {
        return toAjax(invoiceService.insertInvoice(invoice));
    }


    /**
     *
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        Invoice invoice = invoiceService.selectInvoiceById(id);
        mmap.put("invoice", invoice);
        return prefix + "/edit";
    }

    /**
     * 修改销售发票列表
     */
    @GetMapping("/makeinvoice/{id}")
    public String makeinvoice(@PathVariable("id") Long id, ModelMap mmap)
    {
        SellDetail sellDetail = sellDetailService.selectSellDetailById(id);
        Invoice invoice=new Invoice();
        invoice.setSelldetailid(sellDetail.getId());
        invoice.setBuyer(sellDetail.getSupplier());
        invoice.setContractid(sellDetail.getContractid());
        invoice.setMoney(sellDetail.getMoney());
        mmap.put("invoice", invoice);
        return prefix + "/makeinvoice";
    }

    /**
     * 修改保存销售发票列表
     */

    @Log(title = "销售开票", businessType = BusinessType.INSERT)
    @PostMapping("/makeinvoice")
    @ResponseBody
    public AjaxResult makeinvoiceSave(Invoice invoice)
    {
        return toAjax(invoiceService.insertInvoice(invoice));
    }

    /**
     * 修改保存销售发票列表
     */
    @RequiresPermissions("system:invoice:edit")
    @Log(title = "销售发票列表", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Invoice invoice)
    {
        return toAjax(invoiceService.updateInvoice(invoice));
    }

    /**
     * 删除销售发票列表
     */
    @RequiresPermissions("system:invoice:remove")
    @Log(title = "销售发票列表", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(invoiceService.deleteInvoiceByIds(ids));
    }
}
