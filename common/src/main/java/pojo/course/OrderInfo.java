package pojo.course;

import java.util.Date;
import java.io.Serializable;

/**
 * 订单信息表(OrderInfo)实体类
 */
public class OrderInfo {
    /**
    * 主键
    */
    private Long id;
    /**
    * 讲师用户编号
    */
    private Long lecturerUserNo;
    /**
    * 讲师名称
    */
    private String lecturerName;
    /**
    * 用户编号
    */
    private Long userNo;
    /**
    * 用户电话
    */
    private String mobile;
    /**
    * 订单号
    */
    private Long orderNo;
    /**
    * 课程ID
    */
    private Long courseId;
    /**
    * 课程名称
    */
    private String courseName;
    /**
    * 应付金额
    */
    private Double pricePayable;
    /**
    * 优惠金额
    */
    private Double priceDiscount;
    /**
    * 实付金额
    */
    private Double pricePaid;
    /**
    * 平台收入
    */
    private Double platformProfit;
    /**
    * 讲师收入
    */
    private Double lecturerProfit;
    /**
    * 支付方式（关联字典表）
    */
    private Integer payType;

    //交易订单号
    private String payNo;

    /**
    * 订单状态(关联字典表)
    */
    private Integer orderStatus;

    /**
     * 订单状态(关联字典表)
     */
    private Integer orderType;
    /**
    * 客户备注
    */
    private String remarkCus;
    /**
    * 后台备注
    */
    private String remark;
    /**
    * 支付时间
    */
    private Date payTime;
    /**
    * 创建时间
    */
    private Date gmtCreate;
    /**
    * 修改时间
    */
    private Date gmtModified;


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

    public String getLecturerName() {
        return lecturerName;
    }

    public void setLecturerName(String lecturerName) {
        this.lecturerName = lecturerName;
    }

    public Long getUserNo() {
        return userNo;
    }

    public void setUserNo(Long userNo) {
        this.userNo = userNo;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Long getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Long orderNo) {
        this.orderNo = orderNo;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Double getPricePayable() {
        return pricePayable;
    }

    public void setPricePayable(Double pricePayable) {
        this.pricePayable = pricePayable;
    }

    public Double getPriceDiscount() {
        return priceDiscount;
    }

    public void setPriceDiscount(Double priceDiscount) {
        this.priceDiscount = priceDiscount;
    }

    public Double getPricePaid() {
        return pricePaid;
    }

    public void setPricePaid(Double pricePaid) {
        this.pricePaid = pricePaid;
    }

    public Double getPlatformProfit() {
        return platformProfit;
    }

    public void setPlatformProfit(Double platformProfit) {
        this.platformProfit = platformProfit;
    }

    public Double getLecturerProfit() {
        return lecturerProfit;
    }

    public void setLecturerProfit(Double lecturerProfit) {
        this.lecturerProfit = lecturerProfit;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getRemarkCus() {
        return remarkCus;
    }

    public void setRemarkCus(String remarkCus) {
        this.remarkCus = remarkCus;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public String getPayNo() {
        return payNo;
    }

    public void setPayNo(String payNo) {
        this.payNo = payNo;
    }

    @Override
    public String toString() {
        return "OrderInfo{" +
                "id=" + id +
                ", lecturerUserNo=" + lecturerUserNo +
                ", lecturerName='" + lecturerName + '\'' +
                ", userNo=" + userNo +
                ", mobile='" + mobile + '\'' +
                ", orderNo=" + orderNo +
                ", courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", pricePayable=" + pricePayable +
                ", priceDiscount=" + priceDiscount +
                ", pricePaid=" + pricePaid +
                ", platformProfit=" + platformProfit +
                ", lecturerProfit=" + lecturerProfit +
                ", payType=" + payType +
                ", payNo=" + payNo +
                ", orderStatus=" + orderStatus +
                ", remarkCus='" + remarkCus + '\'' +
                ", remark='" + remark + '\'' +
                ", payTime=" + payTime +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                '}';
    }
}