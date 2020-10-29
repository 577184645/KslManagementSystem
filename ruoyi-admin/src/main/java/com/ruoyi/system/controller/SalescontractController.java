package com.ruoyi.system.controller;

import java.text.SimpleDateFormat;
import java.util.*;

import com.ruoyi.system.domain.*;
import com.ruoyi.system.mapper.InvoiceMapper;
import com.ruoyi.system.service.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.servlet.ModelAndView;

/**
 * 销售合同列表Controller
 * 
 * @author ruoyi
 * @date 2020-05-20
 */
@Controller
@RequestMapping("/system/salescontract")
public class SalescontractController extends BaseController
{
    private String prefix = "system/salescontract";

    @Autowired
    private ISalescontractService salescontractService;

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IKslcusromeruserService kslcusromeruserService;

    @Autowired
    private IPurchasecontractService purchasecontractService;

    @Autowired
    private IInvoiceService invoiceService;

    @Autowired
    private ISellDetailService sellDetailService;
    @Autowired
    private IPurchaseinvoiceService purchaseinvoiceService;
    @Autowired
    private IPurchasedetailService purchasedetailService;
    @Autowired
    private ISparepartService  iSparepartService;



    @RequiresPermissions("system:salescontract:view")
    @GetMapping()
    public ModelAndView salescontract(ModelAndView model)
    {
        model.addObject("salescontractList",salescontractService.selectSalescontractList(null));
        model.addObject("customerList",customerService.findList());
        model.addObject("kslcusromeruserList",kslcusromeruserService.selectKslcusromeruserList(null));
        model.setViewName(prefix + "/salescontract");
        return model;
    }

    @GetMapping("account")
    public ModelAndView account(ModelAndView model)
    {

        model.addObject("salescontractList",salescontractService.selectSalescontractList(null));
        model.addObject("customerList",customerService.findList());
        model.addObject("kslcusromeruserList",kslcusromeruserService.selectKslcusromeruserList(null));
        model.setViewName("system/account/salescontract");
        return model;
    }


    @RequestMapping("/findSalescontract/{operator}")
    @ResponseBody
    public List<Salescontract> findSalescontract(@PathVariable("operator") String operator){
       Salescontract salescontract=new Salescontract();
       salescontract.setOperator(operator);
        salescontract.setIslookstatus(true);
        return     salescontractService.selectSalescontractList(salescontract);
    }

    @RequestMapping("/findSalescontractInfo/{contractid}")
    @ResponseBody
    public Map<String,Object> findsupplierInfo(@PathVariable("contractid") String contractid){
        Map<String,Object> map=new HashMap<>();
        Salescontract salescontract=new Salescontract();
        salescontract.setContractid(contractid);
        List<Salescontract> salescontracts = salescontractService.selectSalescontractList(salescontract);
        List<Purchasecontract> purchasecontracts = purchasecontractService.selectPurchasecontractByContractId(contractid);
        List<Invoice> invoices = invoiceService.selectInvoiceListbycontractid(contractid);
        List<Purchaseinvoice> purchaseinvoice = purchaseinvoiceService.selectPurchaseinvoiceByContractid(contractid);
        String suppliers="";
        String purchasecontractids="";
         String invoicess="";
        String purcharsemoneys="";
        String purchaseinvoices="";

        for (Purchaseinvoice purchaseinvoice1:
                purchaseinvoice) {
            purchaseinvoices+=purchaseinvoice1.getPurchaseinvoiceid()+",";
        }
        for (Invoice invoice:
                invoices) {
            invoicess+=invoice.getInvoiceid()+",";
        }






        for (Purchasecontract purchasecontract:
                purchasecontracts) {
            suppliers+=purchasecontract.getPartyb()+",";
            purchasecontractids+=purchasecontract.getPurchasecontractid()+",";
            purcharsemoneys+=purchasecontract.getPurchasesamount()+",";
        }



        if (suppliers.indexOf(",")!=-1){
            suppliers= suppliers.substring(0,suppliers.length()-1);
            purchasecontractids=purchasecontractids.substring(0,purchasecontractids.length()-1);
            purcharsemoneys=purcharsemoneys.substring(0,purcharsemoneys.length()-1);


        }
        if (invoicess.indexOf(",")!=-1){
            invoicess= invoicess.substring(0,invoicess.length()-1);
        }
        if (purchaseinvoices.indexOf(",")!=-1){
            purchaseinvoices= purchaseinvoices.substring(0,purchaseinvoices.length()-1);
        }
        Float purchasesamount=purchasecontractService.selectPurchasesamountsumByContractId(salescontract.getContractid())!=null?purchasecontractService.selectPurchasesamountsumByContractId(salescontract.getContractid()):0;
        map.put("purchasesamount", purchasesamount);
        map.put("purchaseinvoices", purchaseinvoices);
        map.put("purcharsemoneys",purcharsemoneys);
        map.put("purchasecontractids",purchasecontractids);
        map.put("invoices",invoicess);
        map.put("suppliers",suppliers);
        map.put("salescontracts",salescontracts);

        return    map;
    }


    @GetMapping("/accountsum")
    public String accountsum(ModelMap mmap)
    {
        mmap.put("kslcusromeruserList",kslcusromeruserService.selectKslcusromeruserList(null));
        return  "system/accountsum/print";
    }

    @GetMapping("/print/{id}")
    public String print(@PathVariable("id") Long id, ModelMap mmap)
    {

        Salescontract salescontract = salescontractService.selectSalescontractById(id);
     if (salescontract.getContractid().substring(2,3).equals("G")){
         mmap.put("saletype", "公司垫本销售合同明细单");
     }else if(salescontract.getContractid().substring(2,3).equals("Z")){
         mmap.put("saletype", "外勤垫本销售合同明细单");
     }else{
         mmap.put("saletype", "线上销售合同明细单");
     }
        List<SellDetail> sellDetails = sellDetailService.selectSellDetailByContractId(salescontract.getContractid());
        List<Invoice> invoices = invoiceService.findList();
        List<Purchasecontract> purchasecontracts = purchasecontractService.selectPurchasecontractByContractId(salescontract.getContractid());
        List<Purchasedetail> purchasedetails = purchasedetailService.selectPurchasedetailList(null);

        List<Purchaseinvoice> purchaseinvoices = purchaseinvoiceService.selectPurchaseinvoiceByScontract(salescontract.getContractid());



        if(sellDetails.size()>0) {
            for (SellDetail selldeatail : sellDetails) {
                if(selldeatail.getSpecifications()!=null&&selldeatail.getSpecifications().length() > 20) {
                        selldeatail.setSpecifications(selldeatail.getSpecifications().substring(0, 20));
                }
            }
        }


        mmap.put("purchasecontracts", purchasecontracts);
        Float purchasesamount=purchasecontractService.selectPurchasesamountsumByContractId(salescontract.getContractid())!=null?purchasecontractService.selectPurchasesamountsumByContractId(salescontract.getContractid()):0;
        mmap.put("salescontract", salescontract);
        mmap.put("purchasesamount", purchasesamount);
        mmap.put("sellDetails", sellDetails);
        mmap.put("purchasedetails", purchasedetails);
        mmap.put("invoices", invoices);
        mmap.put("purchaseinvoices", purchaseinvoices);

        return  "system/account/print";
    }

    @PostMapping(value = "salesamountBymonth")
    @ResponseBody
    public Map<String, Object> SalesamountBymonth(@RequestParam("newdate") String newdate) {
        Map<String, Object> queryMap = new HashMap<String, Object>();

        queryMap.put("result", salescontractService.selectSalesamountBmonth(newdate));

        return  queryMap;
    }

    @PostMapping(value = "salesamountByday")
    @ResponseBody
    public Map<String, Object> salesamountByday(@RequestParam("newyear") String newyear,@RequestParam("newmonth") String newmonth) {
        Map<String, Object> queryMap = new HashMap<String, Object>();
        queryMap.put("result", salescontractService.selectSalesamountByday(newyear,newmonth));

        return  queryMap;
    }




    @GetMapping(value = "sumMoneyGYear")
    @ResponseBody
    public Map<String, Object> sumMoneyGYear() throws Exception{
        Map<String, Object> queryMap = new HashMap<String, Object>();
        Date date=new Date();
        SimpleDateFormat format=new SimpleDateFormat("yyyy");
        String format1 = format.format(date);
        queryMap.put("summoney", salescontractService.sumMoneyGYear(format1)!=null?salescontractService.sumMoneyGYear(format1):0);
        return  queryMap;
    }


    @RequestMapping(value = { "/getContractid" }, method = { RequestMethod.POST })
    @ResponseBody
    public Map<String, String> getContractid(
            @RequestParam(value = "type", required = false, defaultValue = "") String type) {
        Map<String, String> map = new HashMap<String, String>();
        if ( type.length() == 0) {

        } else {
            map.put("contractid", salescontractService.getContractid(type));
        }
        return map;
    }

    /**
     * 查询销售合同列表列表
     */
    @RequiresPermissions("system:salescontract:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Salescontract salescontract)
    {
        startPage();
        List<Salescontract> list = salescontractService.selectSalescontractList(salescontract);
        return getDataTable(list);
    }

    /**
     * 导出销售合同列表列表
     */
    @RequiresPermissions("system:salescontract:export")
    @Log(title = "销售合同列表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Salescontract salescontract)
    {
        List<Salescontract> list = salescontractService.selectSalescontractList(salescontract);
        ExcelUtil<Salescontract> util = new ExcelUtil<Salescontract>(Salescontract.class);
        return util.exportExcel(list, "salescontract");
    }

    /**
     * 新增销售合同列表
     */
    @GetMapping("/add")
    public ModelAndView add(ModelAndView model)
    {
        model.addObject("customerList",customerService.findList());
        model.addObject("kslcusromeruserList",kslcusromeruserService.selectKslcusromeruserList(null));
        model.setViewName(prefix + "/add");
        return model;
    }

    /**
     * 新增保存销售合同列表
     */
    @RequiresPermissions("system:salescontract:add")
    @Log(title = "销售合同列表", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(String salescontractList,Salescontract salescontract)
    {
        return toAjax(salescontractService.insertSalescontractAndSelldetail(salescontractList,salescontract));
    }

    /**
     * 修改销售合同列表
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        mmap.put("customerList",customerService.findList());
        mmap.put("kslcusromeruserList",kslcusromeruserService.selectKslcusromeruserList(null));
        Salescontract salescontract = salescontractService.selectSalescontractById(id);
        mmap.put("salescontract", salescontract);
        return prefix + "/edit";
    }

    /**
     * 修改保存销售合同列表
     */
    @RequiresPermissions("system:salescontract:edit")
    @Log(title = "销售合同列表", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Salescontract salescontract)
    {
        return toAjax(salescontractService.updateSalescontract(salescontract));
    }

    /**
     * 删除销售合同列表
     */
    @RequiresPermissions("system:salescontract:remove")
    @Log(title = "销售合同列表", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        String contractid = salescontractService.selectSalescontractById(Long.valueOf(ids)).getContractid();
        if(sellDetailService.selectSellDetailByContractId(contractid)!=null&&sellDetailService.selectSellDetailByContractId(contractid).size()>0) {
            return AjaxResult.error("操作失败,销售合同下有订单信息!");
        }
        if(purchasecontractService.selectPurchasecontractByContractId(contractid)!=null&&purchasecontractService.selectPurchasecontractByContractId(contractid).size()>0){
            return AjaxResult.error("操作失败,销售合同下有采购合同!");
        }
        return toAjax(salescontractService.deleteSalescontractByIds(ids));
    }



    /**
     * 查看合同信息
     */
    @RequiresPermissions("system:salescontract:saleinfo")
    @GetMapping("/saleInfo/{id}")
    public String saleInfo(@PathVariable("id") Long id, ModelMap mmap)
    {
        Salescontract salescontract = salescontractService.selectSalescontractById(id);
         Float purchasesamount=purchasecontractService.selectPurchasesamountsumByContractId(salescontract.getContractid())!=null?purchasecontractService.selectPurchasesamountsumByContractId(salescontract.getContractid()):0;
        mmap.put("salescontract", salescontract);
        mmap.put("purchasesamount", purchasesamount);
        return prefix + "/saleinfo";
    }
}
