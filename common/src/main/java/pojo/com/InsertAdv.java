package pojo.com;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 广告信息(Adv)实体类
 */
@ApiModel(value = "广告信息(Adv)实体类" , description = "广告信息(Adv)实体类")
public class InsertAdv implements Serializable {

    //广告标题
    @ApiModelProperty("广告标题")
    private String advTitle;

    //广告链接
    @ApiModelProperty("广告链接")
    private String advUrl;

    //广告跳转方式
    @ApiModelProperty("广告跳转方式")
    private String advTarget;

    //排序
    @ApiModelProperty("排序")
    private Integer sort;

    //开始时间
    @ApiModelProperty("开始时间")
    private Date beginTime;

    //结束时间
    @ApiModelProperty("结束时间")
    private Date endTime;

    public String getAdvTitle() {
        return advTitle;
    }

    public void setAdvTitle(String advTitle) {
        this.advTitle = advTitle;
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

    public Object getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
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
}