package com.ruoyi.system.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.SellDetail;
import com.ruoyi.system.service.ISellDetailService;
import com.ruoyi.system.util.dateUtil;
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



    @GetMapping(value = "sumMoneyGYear")
    @ResponseBody
    public Map<String, Object> sumMoneyGYear() throws Exception{
        Map<String, Object> queryMap = new HashMap<String, Object>();
        String yyyy = dateUtil.dataToString("yyyy", new Date());
        Double summoney = invoiceService.sumMoneyGYear(yyyy);
        queryMap.put("summoney",summoney);
        return  queryMap;
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

    @GetMapping("/add/{id}")
    public String add(ModelMap map, @PathVariable("id") String ids)
    {

        String[] split = ids.split(",");
        if (split.length==1) {
            SellDetail sellDetail = sellDetailService.selectSellDetailById(Long.valueOf(split[0]));
            map.put("sellDetail",sellDetail);
            return prefix + "/add";
        }else{
            Double sum=0.0;
            for (int i=0;i<split.length;i++){
                sum+=sellDetailService.selectSellDetailById(Long.valueOf(split[i])).getMoney();
            }

            map.put("sum",sum);
            map.put("ids",ids);
            return prefix + "/adds";

        }

    }

    /**
     * 新增保存发票
     */
    @RequiresPermissions("system:invoice:add")
    @Log(title = "发票", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@RequestParam("selldetailids") String selldetailids, Invoice invoice)
    {

        return toAjax(invoiceService.insertInvoice(selldetailids,invoice));
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
