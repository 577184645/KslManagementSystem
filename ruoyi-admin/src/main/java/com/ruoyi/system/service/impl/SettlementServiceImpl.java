package com.ruoyi.system.service.impl;

import java.util.Date;
import java.util.List;

import com.ruoyi.common.constant.AdminConstants;
import com.ruoyi.system.domain.Settlementchild;
import com.ruoyi.system.mapper.SalescontractMapper;
import com.ruoyi.system.mapper.SettlementchildMapper;
import com.ruoyi.system.utils.dateUtil;
import com.ruoyi.system.utils.jsonlistUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SettlementMapper;
import com.ruoyi.system.domain.Settlement;
import com.ruoyi.system.service.ISettlementService;
import org.springframework.transaction.annotation.Transactional;

/**
 * 结算Service业务层处理
 *
 * @author ruoyi
 * @date 2020-07-17
 */
@Service
@Transactional
public class SettlementServiceImpl implements ISettlementService {
    @Autowired
    private SettlementMapper settlementMapper;
    @Autowired
    private SettlementchildMapper settlementchildMapper;
    @Autowired
    private SalescontractMapper salescontractMapper;

    /**
     * 查询结算
     *
     * @param id 结算ID
     * @return 结算
     */
    @Override
    public Settlement selectSettlementById(Long id) {
        return settlementMapper.selectSettlementById(id);
    }

    /**
     * 查询结算列表
     *
     * @param settlement 结算
     * @return 结算
     */
    @Override
    public List<Settlement> selectSettlementList(Settlement settlement) {
        return settlementMapper.selectSettlementList(settlement);
    }

    @Override
    public boolean add(String settlementList, Settlement settlement) {
        String yy = dateUtil.dataToString("yy", new Date());
        String maxSerialNumber = settlementMapper.selectSettlementMaxSerialNumber();
        if (maxSerialNumber != null) {
            Integer size = Integer.valueOf(maxSerialNumber.substring(maxSerialNumber.indexOf("-") + 1)) + 1;
            if (size < 10) {
                settlement.setSerialnumber(yy + "JS-00" + (size));
            } else if (size < 100) {
                settlement.setSerialnumber(yy + "JS-0" + (size));
            } else {
                settlement.setSerialnumber(yy + "JS-" + (size));
            }
        } else {
            settlement.setSerialnumber(yy + "JS-001");
        }
        settlementMapper.insertSettlement(settlement);
        List<String[]> jsonList = jsonlistUtil.getJsonList(settlementList, new String[]{"contractid", "firstparty", "invoices", "salesamount", "suppliers", "purchasecontractids", "purchaseinvoices", "purcharsemoneys", "taxrate", "costprice", "saletaxrate", "revenue", "discount", "personalincome", "taxrate"});
        for (int i = 0; i < jsonList.size(); i++) {
            String[] strings = jsonList.get(i);
            Settlementchild settlementchild = new Settlementchild(null, settlement.getId(), Long.valueOf(strings[0]), strings[1], strings[2], Double.valueOf(strings[3]), strings[4], strings[5], strings[6], strings[7], Double.valueOf(strings[8]), Double.valueOf(strings[9]), Double.valueOf(strings[10]), Double.valueOf(strings[11]), Double.valueOf(strings[12]), Double.valueOf(strings[13]), null);
            settlementchildMapper.insertSettlementchild(settlementchild);
            System.out.println(settlementchild.getContractid());
            salescontractMapper.updateSettlementstatus(Long.valueOf(settlementchild.getContractid()), AdminConstants.Settlementtype.SETTLEMENT_YES);
        }
        return true;
    }


    /**
     * 删除 settlementchild子信息并且修改销售合同结算状态
     *
     * @param settlementId
     */
    @Override
    public int deleteSettlementById(Long settlementId) {
        Settlementchild settlementchild = new Settlementchild();
        settlementchild.setSettlementId(settlementId);
        List<Settlementchild> settlementchildren = settlementchildMapper.selectSettlementchildList(settlementchild);
        for (Settlementchild settlementchild1 : settlementchildren) {
            settlementchildMapper.deleteSettlementchildById(settlementchild1.getId());
            salescontractMapper.updateSettlementstatus(Long.valueOf(settlementchild1.getContractid()), AdminConstants.Settlementtype.SETTLEMENT_NO);
        }
        return settlementMapper.deleteSettlementById(settlementId);
    }


}
