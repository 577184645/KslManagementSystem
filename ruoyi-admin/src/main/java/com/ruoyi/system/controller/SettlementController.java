package com.ruoyi.system.controller;

import java.util.List;

import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.Settlementchild;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.service.ISettlementchildService;
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
import com.ruoyi.system.domain.Settlement;
import com.ruoyi.system.service.ISettlementService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 结算Controller
 * 
 * @author ruoyi
 * @date 2020-07-17
 */
@Controller
@RequestMapping("/system/settlement")
public class SettlementController extends BaseController
{
    private String prefix = "system/settlement";

    @Autowired
    private ISettlementService settlementService;
    @Autowired
    private ISettlementchildService settlementchildService;

    @RequiresPermissions("system:settlement:view")
    @GetMapping()
    public String settlement()
    {
        return prefix + "/settlement";
    }

    /**
     * 查询结算列表
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Settlement settlement)
    {
        startPage();
        List<Settlement> list = settlementService.selectSettlementList(settlement);
        return getDataTable(list);
    }

    @GetMapping("/print/{id}")
    public String print(@PathVariable("id") Long id, ModelMap mmap)
    {

        SysUser user = ShiroUtils.getSysUser();

        Settlement settlement = settlementService.selectSettlementById(id);
        Settlementchild settlementchild=new Settlementchild();
        settlementchild.setSerialnumber(settlement.getSerialnumber());
        List<Settlementchild> settlementchildren = settlementchildService.selectSettlementchildList(settlementchild);
        mmap.put("settlementchildren",settlementchildren);

        mmap.put("settlement",settlement);
        mmap.put("username", user.getUserName());
        return prefix + "/print";
    }
    /**
     * 导出结算列表
     */
    @RequiresPermissions("system:settlement:export")
    @Log(title = "结算", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Settlement settlement)
    {
        List<Settlement> list = settlementService.selectSettlementList(settlement);
        ExcelUtil<Settlement> util = new ExcelUtil<Settlement>(Settlement.class);
        return util.exportExcel(list, "settlement");
    }

    /**
     * 新增结算
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存结算
     */
    @RequiresPermissions("system:settlement:add")
    @Log(title = "结算", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(String settlementList,Settlement settlement)
    {
        return toAjax(settlementService.add(settlementList,settlement));
    }

    /**
     * 修改结算
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        Settlement settlement = settlementService.selectSettlementById(id);
        mmap.put("settlement", settlement);
        return prefix + "/edit";
    }

    /**
     * 修改保存结算
     */
    @RequiresPermissions("system:settlement:edit")
    @Log(title = "结算", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Settlement settlement)
    {
        return toAjax(settlementService.updateSettlement(settlement));
    }

    /**
     * 删除结算
     */
    @RequiresPermissions("system:settlement:remove")
    @Log(title = "结算", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(settlementService.deleteSettlementByIds(ids));
    }
}
