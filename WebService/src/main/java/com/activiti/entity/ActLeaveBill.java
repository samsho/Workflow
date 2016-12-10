package com.activiti.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * ClassName: ActLeaveBill
 * Description: 请假单
 * Date: 2016/7/18 21:13
 *
 * @author SAM SHO
 * @version V1.0
 */
@Entity
@Table(name = "web_act_leave_bill")
public class ActLeaveBill implements Serializable {
    private static final long serialVersionUID = -9031551272287263714L;

    private Integer id;
    private Integer days;
    private String content;
    private Date leaveDate;
    private String remark;
    private ActUser user;
    private BillStatus status = BillStatus.INIT;
    private String pdKey;//流程定义的key



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "days")
    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @DateTimeFormat( pattern = "yyyy-MM-dd" ) //mvc Date 注释
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "leaveDate")
    public Date getLeaveDate() {
        return leaveDate;
    }

    public void setLeaveDate(Date leaveDate) {
        this.leaveDate = leaveDate;
    }

    @Column(name = "remark")
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "userId")
    public ActUser getUser() {
        return user;
    }

    public void setUser(ActUser user) {
        this.user = user;
    }

    @Enumerated(value = EnumType.ORDINAL)
    @Column(name = "status")
    public BillStatus getStatus() {
        return status;
    }

    public void setStatus(BillStatus status) {
        this.status = status;
    }

    @Column(name = "pdKey")
    public String getPdKey() {
        return pdKey;
    }

    public void setPdKey(String pdKey) {
        this.pdKey = pdKey;
    }
}
