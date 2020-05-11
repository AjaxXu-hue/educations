package pojo.system;

import java.util.Date;
import java.io.Serializable;

/**
 * 头部导航(WebsiteBar)实体类
 */
public class WebsiteBar implements Serializable {
    private static final long serialVersionUID = -41530042540629744L;
    /**
    * 主键
    */
    private Long id;
    /**
    * 导航标题
    */
    private String navTitle;
    /**
    * 导航url
    */
    private String navUrl;
    /**
    * 跳转方式
    */
    private String target;
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


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNavTitle() {
        return navTitle;
    }

    public void setNavTitle(String navTitle) {
        this.navTitle = navTitle;
    }

    public String getNavUrl() {
        return navUrl;
    }

    public void setNavUrl(String navUrl) {
        this.navUrl = navUrl;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
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