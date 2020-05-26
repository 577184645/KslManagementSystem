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
import com.ruoyi.system.domain.Kslcusromeruser;
import com.ruoyi.system.service.IKslcusromeruserService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 经办人列表Controller
 * 
 * @author ruoyi
 * @date 2020-05-19
 */
@Controller
@RequestMapping("/system/kslcusromeruser")
public class KslcusromeruserController extends BaseController
{
    private String prefix = "system/kslcusromeruser";


   


    @Autowired
    private IKslcusromeruserService kslcusromeruserService;

    @RequiresPermissions("system:kslcusromeruser:view")
    @GetMapping()
    public String kslcusromeruser()
    {
        return prefix + "/kslcusromeruser";
    }

    /**
     * 查询经办人列表列表
     */
    @RequiresPermissions("system:kslcusromeruser:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Kslcusromeruser kslcusromeruser)
    {
        startPage();
        List<Kslcusromeruser> list = kslcusromeruserService.selectKslcusromeruserList(kslcusromeruser);
        return getDataTable(list);
    }

    /**
     * 导出经办人列表列表
     */
    @RequiresPermissions("system:kslcusromeruser:export")
    @Log(title = "经办人列表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Kslcusromeruser kslcusromeruser)
    {
        List<Kslcusromeruser> list = kslcusromeruserService.selectKslcusromeruserList(kslcusromeruser);
        ExcelUtil<Kslcusromeruser> util = new ExcelUtil<Kslcusromeruser>(Kslcusromeruser.class);
        return util.exportExcel(list, "kslcusromeruser");
    }

    /**
     * 新增经办人列表
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存经办人列表
     */
    @RequiresPermissions("system:kslcusromeruser:add")
    @Log(title = "经办人列表", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Kslcusromeruser kslcusromeruser)
    {
        return toAjax(kslcusromeruserService.insertKslcusromeruser(kslcusromeruser));
    }

    /**
     * 修改经办人列表
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        Kslcusromeruser kslcusromeruser = kslcusromeruserService.selectKslcusromeruserById(id);
        mmap.put("kslcusromeruser", kslcusromeruser);
        return prefix + "/edit";
    }

    /**
     * 修改保存经办人列表
     */
    @RequiresPermissions("system:kslcusromeruser:edit")
    @Log(title = "经办人列表", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Kslcusromeruser kslcusromeruser)
    {
        return toAjax(kslcusromeruserService.updateKslcusromeruser(kslcusromeruser));
    }

    /**
     * 删除经办人列表
     */
    @RequiresPermissions("system:kslcusromeruser:remove")
    @Log(title = "经办人列表", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(kslcusromeruserService.deleteKslcusromeruserByIds(ids));
    }
}
