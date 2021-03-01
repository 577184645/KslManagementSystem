package com.ruoyi.system.controller;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ruoyi.system.service.ISellDetailService;
import com.ruoyi.system.utils.dateUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.Invoice;
import com.ruoyi.system.service.IInvoiceService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 发票Controller
 * 
 * @author ruoyi
 * @date 2020-07-09
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
     * 查询发票列表
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
     * 导出发票列表
     */
    @RequiresPermissions("system:invoice:export")
    @Log(title = "发票", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Invoice invoice)
    {
        List<Invoice> list = invoiceService.selectInvoiceList(invoice);
        ExcelUtil<Invoice> util = new ExcelUtil<Invoice>(Invoice.class);
        return util.exportExcel(list, "invoice");
    }

    /**
     * 新增发票
     */

    @GetMapping("/add/{id}/{salescontractId}")
    public String add(ModelMap map, @PathVariable("id") String ids,@PathVariable("salescontractId") String salescontractId)
    {
        BigDecimal sum=new BigDecimal("0");
        String[] split = ids.split(",");
        for (int i=0;i<split.length;i++){
             sum=sum.add(new BigDecimal(String.valueOf(sellDetailService.selectSellDetailById(Long.valueOf(split[i])).getMoney())));
        }
        map.put("sum",sum);
        map.put("ids",ids);
        map.put("salescontractId",salescontractId);
        return prefix + "/add";
    }

    /**
     * 新增保存发票
     */
    @RequiresPermissions("system:invoice:add")
    @Log(title = "发票", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@RequestParam("salescontractId") Long salescontractId,@RequestParam("selldetailids") String selldetailids, Invoice invoice)
    {

        return toAjax(invoiceService.insertInvoice(salescontractId,selldetailids,invoice));
    }

    /**
     * 修改发票
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {


            Invoice invoice = invoiceService.selectInvoiceById(id);
            mmap.put("invoice", invoice);
            return prefix + "/edit";

    }

    /**
     * 修改保存发票
     */
    @RequiresPermissions("system:invoice:edit")
    @Log(title = "发票", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Invoice invoice)
    {
        return toAjax(invoiceService.updateInvoice(invoice));
    }

    /**
     * 删除发票
     */
    @RequiresPermissions("system:invoice:remove")
    @Log(title = "发票", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(invoiceService.deleteInvoiceByIds(ids));
    }



}
