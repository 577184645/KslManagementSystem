package com.ruoyi.common.constant;

/**
 * @author: qincan
 * @create: 2021-02-26 14:05
 * @description:
 * @version: 1.0
 */

public class AdminConstants {

    public interface  Salescontract{
        //发票未开
        public static final Integer INVOICESTATUS_NOOPEN=1;
        //发票未开全
        public static final Integer INVOICESTATUS_INCOMPLATE=2;
        //开票已开
        public static final Integer INVOICESTATUS_OPEN=3;

    }

    public interface Saletype{
        public static final String COMPANY_CONTRAC_SINGLE="公司垫本销售合同明细单";
        public static final String FIELD_PERSONNEL_CONTRAC_SINGLE="外勤垫本销售合同明细单";
        public static final String ON_LINE_CONTRAC_SINGLE="线上销售合同明细单";
    }

    public interface Settlementtype{
        public static final Integer  SETTLEMENT_NO=0;
        public static final Integer SETTLEMENT_YES=1;
    }

}
