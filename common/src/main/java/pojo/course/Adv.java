package pojo.course;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.io.Serializable;

/**
 * 广告信息(Adv)实体类
 */
@ApiModel(value = "广告信息(Adv)实体类" , description = "广告信息(Adv)实体类")
public class Adv implements Serializable {
    //主键
//    @ApiModelProperty("编号")
    private Long id;

    //广告标题
    @ApiModelProperty("广告标题")
    private String advTitle;

    //广告图片
    @ApiModelProperty("广告图片")
    private String advImg;

    //广告链接
    @ApiModelProperty("广告链接")
    private String advUrl;

    //广告跳转方式
    @ApiModelProperty("广告跳转方式")
    private String advTarget;

    //广告位置(1首页轮播)
    @ApiModelProperty("广告位置(1首页轮播)")
    private Object advLocation;

    //状态(关联字典表)
    @ApiModelProperty("状态(关联字典表)")
    private Integer statusId;

    //位置(关联字典表)
    @ApiModelProperty("位置(关联字典表)")
    private Integer platShow;

    //排序
    @ApiModelProperty("排序")
    private Object sort;

    //开始时间
    @ApiModelProperty("开始时间")
    private Date beginTime;

    //结束时间
    @ApiModelProperty("结束时间")
    private Date endTime;

    //创建时间
    @ApiModelProperty("创建时间")
    private Date gmtCreate;

    //修改时间
    @ApiModelProperty("修改时间")
    private Date gmtModified;


    public Object getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAdvTitle() {
        return advTitle;
    }

    public void setAdvTitle(String advTitle) {
        this.advTitle = advTitle;
    }

    public String getAdvImg() {
        return advImg;
    }

    public void setAdvImg(String advImg) {
        this.advImg = advImg;
    }

    public String getAdvUrl() {
        return advUrl;
    }

    public void setAdvUrl(String advUrl) {
        this.advUrl = advUrl;
    }

    public String getAdvTarget() {
        return advTarget;
    }

    public void setAdvTarget(String advTarget) {
        this.advTarget = advTarget;
    }

    public Object getAdvLocation() {
        return advLocation;
    }

    public void setAdvLocation(Object advLocation) {
        this.advLocation = advLocation;
    }

    public Object getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public Integer getPlatShow() {
        return platShow;
    }

    public void setPlatShow(Integer platShow) {
        this.platShow = platShow;
    }

    public Object getSort() {
        return sort;
    }

    public void setSort(Object sort) {
        this.sort = sort;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
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

}