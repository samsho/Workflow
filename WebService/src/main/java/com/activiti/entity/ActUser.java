package com.activiti.entity;

import com.activiti.bean.base.User;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * ClassName: ActUser
 * Description: 用户表
 * Date: 2016/7/18 20:02
 *
 * @author SAM SHO
 * @version V1.0
 */
@Entity
@Table(name = "web_act_user")
public class ActUser implements Serializable {

    private static final long serialVersionUID = -3291939325046529147L;

    private Integer id;
    private String username;
    private String password;
    private String jobNumber;
    private Sex sex;
    private Date createTime;

    private ActUser manager;

    public ActUser() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = true)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "jobNumber")
    public String getJobNumber() {
        return jobNumber;
    }

    public void setJobNumber(String jobNumber) {
        this.jobNumber = jobNumber;
    }

    @Enumerated(value = EnumType.ORDINAL)
    @Column(name = "sex")
    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "createTime")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @OneToOne()
    @JoinColumn(name = "managerId")
//    @Transient
    public ActUser getManager() {
        return manager;
    }

    public void setManager(ActUser manager) {
        this.manager = manager;
    }

    public ActUser bilud(User user) {
        this.id = (int) user.getId();
        this.username = user.getUsername();
        this.jobNumber = user.getJobNumber();
        return this;
    }
}
