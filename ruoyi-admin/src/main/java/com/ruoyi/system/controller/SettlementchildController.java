package com.ruoyi.system.controller;

import java.util.List;
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
import com.ruoyi.system.domain.Settlementchild;
import com.ruoyi.system.service.ISettlementchildService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 【请填写功能名称】Controller
 * 
 * @author ruoyi
 * @date 2020-07-17
 */
@Controller
@RequestMapping("/system/settlementchild")
public class SettlementchildController extends BaseController
{
    private String prefix = "system/settlementchild";

    @Autowired
    private ISettlementchildService settlementchildService;

    @RequiresPermissions("system:settlementchild:view")
    @GetMapping()
    public String settlementchild()
    {
        return prefix + "/settlementchild";
    }

    /**
     * 查询【请填写功能名称】列表
     */
    @RequiresPermissions("system:settlementchild:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Settlementchild settlementchild)
    {
        startPage();
        List<Settlementchild> list = settlementchildService.selectSettlementchildList(settlementchild);
        for (Settlementchild settlementchild1 : list) {
            if (settlementchild1.getInvoiceid()!=null){
                settlementchild1.setInvoiceid(settlementchild1.getInvoiceid().replace(",","<br>,"));
            }
            settlementchild1.setPurchasecontractids(settlementchild1.getPurchasecontractids().replace(",","<br>,"));
            settlementchild1.setSuppliers(settlementchild1.getSuppliers().replace(",","<br>,"));
            if(settlementchild1.getPurchaseinvoiceid()!=null) {
                settlementchild1.setPurchaseinvoiceid(settlementchild1.getPurchaseinvoiceid().replace(",", "<br>,"));
            }
            if(settlementchild1.getPurchasemoney()!=null) {
                String[] split = settlementchild1.getPurchasemoney().split(",");
                Float sum=0f;
                for (String s : split) {
                    sum+=Float.valueOf(s);
                }
                settlementchild1.setPurchasesamount(sum);
                settlementchild1.setPurchasemoney(settlementchild1.getPurchasemoney().replace(",", "<br>,"));
            }
            }
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @RequiresPermissions("system:settlementchild:export")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export/{id}")
    @ResponseBody
    public AjaxResult export(@PathVariable("id") String id,Settlementchild settlementchild)
    {
        System.out.println(id);
        List<Settlementchild> list = settlementchildService.selectSettlementchildList(settlementchild);
        ExcelUtil<Settlementchild> util = new ExcelUtil<Settlementchild>(Settlementchild.class);
        return util.exportExcel(list, "settlementchild");
    }

    /**
     * 新增【请填写功能名称】
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存【请填写功能名称】
     */
    @RequiresPermissions("system:settlementchild:add")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Settlementchild settlementchild)
    {
        return toAjax(settlementchildService.insertSettlementchild(settlementchild));
    }

    /**
     * 修改【请填写功能名称】
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        Settlementchild settlementchild = settlementchildService.selectSettlementchildById(id);
        mmap.put("settlementchild", settlementchild);
        return prefix + "/edit";
    }

    /**
     * 修改保存【请填写功能名称】
     */
    @RequiresPermissions("system:settlementchild:edit")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Settlementchild settlementchild)
    {
        return toAjax(settlementchildService.updateSettlementchild(settlementchild));
    }

    /**
     * 删除【请填写功能名称】
     */
    @RequiresPermissions("system:settlementchild:remove")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(settlementchildService.deleteSettlementchildByIds(ids));
    }
}
