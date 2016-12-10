package com.activiti.service;


import com.activiti.entity.ActLeaveBill;

/**
 * ClassName: LogService
 * Description:
 * Date: 2016/5/13 23:11
 *
 * @author SAM SHO
 * @version V1.0
 */
public interface LeaveBillService extends BaseService<ActLeaveBill> {

    void startBill(String billId, String userName);
}
