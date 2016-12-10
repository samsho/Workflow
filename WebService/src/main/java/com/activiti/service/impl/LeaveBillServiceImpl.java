package com.activiti.service.impl;

import com.activiti.dao.BaseDao;
import com.activiti.entity.ActLeaveBill;
import com.activiti.entity.BillStatus;
import com.activiti.service.LeaveBillService;
import com.activiti.service.WorkFlowService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * ClassName: LeaveBillServiceImpl
 * Description:
 * Date: 2016/7/18 21:17
 *
 * @author SAM SHO
 * @version V1.0
 */
@Service(value = "leaveBillService")
@Transactional(rollbackFor = Exception.class)
public class LeaveBillServiceImpl extends AbstractServiceImpl<ActLeaveBill> implements LeaveBillService {
    @Resource
    private BaseDao<ActLeaveBill> baseDao;

    @Resource
    private WorkFlowService workFlowService;

    @Override
    public BaseDao<ActLeaveBill> getDAO() {
        return baseDao;
    }

    @Override
    public void startBill(String billId, String userName) {
        ActLeaveBill leaveBill = baseDao.get(Integer.parseInt(billId));
        leaveBill.setStatus(BillStatus.APPROVE);
        workFlowService.startProcess(leaveBill.getPdKey(), leaveBill.getId(), userName);
    }
}
