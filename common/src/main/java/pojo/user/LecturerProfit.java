package pojo.user;

import java.util.Date;
import java.io.Serializable;

/**
 * 讲师提现日志表(LecturerProfit)实体类
 */
public class LecturerProfit implements Serializable {
    //主键
    private Long id;

    // 讲师用户编号
    private Long lecturerUserNo;

    //银行卡号
    private String bankCardNo;

    //银行名称
    private String bankName;

    //银行支行名称
    private String bankBranchName;

    //银行开户名
    private String bankUserName;

    // 银行身份证号
    private String bankIdCardNo;

    //讲师收入
    private Double lecturerProfit;

    //平台收入
    private Double platformProfit;

    //分润状态(关联数据字典表)
    private Integer profitStatus;

    //备注
    private String remark;

    //创建时间
    private String gmtCreate;

    //查询到期实际时间
    private String gmtCreateOver;

    //讲师名称
    private String lecturerName;

    //讲师手机
    private String lecturerMobile;

    //讲师邮箱
    private String lecturerEmail;

    //get/set方法
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLecturerUserNo() {
        return lecturerUserNo;
    }

    public void setLecturerUserNo(Long lecturerUserNo) {
        this.lecturerUserNo = lecturerUserNo;
    }

    public String getBankCardNo() {
        return bankCardNo;
    }

    public void setBankCardNo(String bankCardNo) {
        this.bankCardNo = bankCardNo;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankBranchName() {
        return bankBranchName;
    }

    public void setBankBranchName(String bankBranchName) {
        this.bankBranchName = bankBranchName;
    }

    public String getBankUserName() {
        return bankUserName;
    }

    public void setBankUserName(String bankUserName) {
        this.bankUserName = bankUserName;
    }

    public String getBankIdCardNo() {
        return bankIdCardNo;
    }

    public void setBankIdCardNo(String bankIdCardNo) {
        this.bankIdCardNo = bankIdCardNo;
    }

    public Double getLecturerProfit() {
        return lecturerProfit;
    }

    public void setLecturerProfit(Double lecturerProfit) {
        this.lecturerProfit = lecturerProfit;
    }

    public Double getPlatformProfit() {
        return platformProfit;
    }

    public void setPlatformProfit(Double platformProfit) {
        this.platformProfit = platformProfit;
    }

    public Integer getProfitStatus() {
        return profitStatus;
    }

    public void setProfitStatus(Integer profitStatus) {
        this.profitStatus = profitStatus;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(String gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public String getGmtCreateOver() {
        return gmtCreateOver;
    }

    public void setGmtCreateOver(String gmtCreateOver) {
        this.gmtCreateOver = gmtCreateOver;
    }

    public String getLecturerName() {
        return lecturerName;
    }

    public void setLecturerName(String lecturerName) {
        this.lecturerName = lecturerName;
    }

    public String getLecturerMobile() {
        return lecturerMobile;
    }

    public void setLecturerMobile(String lecturerMobile) {
        this.lecturerMobile = lecturerMobile;
    }

    public String getLecturerEmail() {
        return lecturerEmail;
    }

    public void setLecturerEmail(String lecturerEmail) {
        this.lecturerEmail = lecturerEmail;
    }
}