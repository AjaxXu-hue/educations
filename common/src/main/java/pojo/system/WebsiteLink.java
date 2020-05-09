package pojo.system;

import java.util.Date;
import java.io.Serializable;

/**
 * 站点友情链接(WebsiteLink)实体类
 */
public class WebsiteLink implements Serializable {
    /**
    * 主键
    */
    private Long id;
    /**
    * 名称
    */
    private String linkName;
    /**
    * 链接
    */
    private String linkUrl;
    /**
    * 跳转方式(_blank，_self)
    */
    private String linkTarget;
    /**
    * 状态(关联字典明细表)
    */
    private Integer statusId;
    /**
    * 排序
    */
    private Integer sort;
    /**
    * 创建时间
    */
    private Date gmtCreate;
    /**
    * 修改时间
    */
    private Date gmtModified;

    @Override
    public String toString() {
        return "WebsiteLink{" +
                "id=" + id +
                ", linkName='" + linkName + '\'' +
                ", linkUrl='" + linkUrl + '\'' +
                ", linkTarget='" + linkTarget + '\'' +
                ", statusId=" + statusId +
                ", sort=" + sort +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLinkName() {
        return linkName;
    }

    public void setLinkName(String linkName) {
        this.linkName = linkName;
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }

    public String getLinkTarget() {
        return linkTarget;
    }

    public void setLinkTarget(String linkTarget) {
        this.linkTarget = linkTarget;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
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