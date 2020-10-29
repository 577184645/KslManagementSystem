package com.ruoyi.system.controller;

import java.util.List;
import java.util.Random;
import java.util.UUID;

import com.ruoyi.system.domain.Purchaseinvoice;
import com.ruoyi.system.domain.Supplier;
import com.ruoyi.system.service.IPurchaseinvoiceService;
import com.ruoyi.system.service.ISupplierService;
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
import com.ruoyi.system.domain.Sparepart;
import com.ruoyi.system.service.ISparepartService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.servlet.ModelAndView;

/**
 * 备件Controller
 * 
 * @author ruoyi
 * @date 2020-09-01
 */
@Controller
@RequestMapping("/system/sparepart")
public class SparepartController extends BaseController
{
    private String prefix = "system/sparepart";

    @Autowired
    private ISparepartService sparepartService;
    @Autowired
    private ISupplierService supplierService;
    @Autowired
    private IPurchaseinvoiceService purchaseinvoiceService;

    @RequiresPermissions("system:sparepart:view")
    @GetMapping()
    public String sparepart()
    {
        return prefix + "/sparepart";
    }

    /**
     * 查询备件列表
     */
    @RequiresPermissions("system:sparepart:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Sparepart sparepart)
    {
        startPage();
        List<Sparepart> list = sparepartService.selectSparepartList(sparepart);
        return getDataTable(list);
    }

    /**
     * 导出备件列表
     */
    @RequiresPermissions("system:sparepart:export")
    @Log(title = "备件", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Sparepart sparepart)
    {
        List<Sparepart> list = sparepartService.selectSparepartList(sparepart);
        ExcelUtil<Sparepart> util = new ExcelUtil<Sparepart>(Sparepart.class);
        return util.exportExcel(list, "sparepart");
    }

    /**
     * 新增备件
     */
    @GetMapping("/add/{purchasecontractid}")
    public ModelAndView add(ModelAndView model, @PathVariable("purchasecontractid") String purchasecontractid) {
        model.addObject("purchasecontractid", purchasecontractid);
        model.addObject("suppliersList", supplierService.findList());
        model.setViewName(prefix + "/add");
        return model;
    }

    /**
     * 新增保存备件
     */
    @RequiresPermissions("system:sparepart:add")
    @Log(title = "备件", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Sparepart sparepart)
    {
        boolean flag=true;
        String uuid=String.valueOf((int) (Math.random() * 1000000000 + 1));
        while (flag){
            if (sparepartService.selectSparepartByUuid(uuid)!=null) {
                uuid=String.valueOf((int) (Math.random() * 1000000000 + 1));
            }else {
                sparepart.setUuid(uuid);
                flag=false;
            }
        }


        return toAjax(sparepartService.insertSparepart(sparepart));
    }




    /**
     * 修改备件
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        Sparepart sparepart = sparepartService.selectSparepartById(id);
        mmap.put("sparepart", sparepart);
        mmap.put("suppliersList", supplierService.findList());
        return prefix + "/edit";
    }

    /**
     * 修改保存备件
     */
    @RequiresPermissions("system:sparepart:edit")
    @Log(title = "备件", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Sparepart sparepart)
    {
        return toAjax(sparepartService.updateSparepart(sparepart));
    }

    /**
     * 删除备件
     */
    @RequiresPermissions("system:sparepart:remove")
    @Log(title = "备件", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
       String id= sparepartService.selectSparepartById(Long.valueOf(ids)).getUuid();
        Purchaseinvoice purchaseinvoice=new Purchaseinvoice();
        purchaseinvoice.setPurchasedetailid(ids);


        return toAjax(sparepartService.deleteSparepartByIds(ids));
    }
}
