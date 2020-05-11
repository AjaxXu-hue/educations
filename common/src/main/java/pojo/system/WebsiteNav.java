package pojo.system;

import java.util.Date;
import java.io.Serializable;

/**
 * 站点导航(WebsiteNav)实体类
 */
public class WebsiteNav implements Serializable {
    private static final long serialVersionUID = -52267824946206055L;
    /**
    * 主键
    */
    private Long id;
    /**
    * 导航名称
    */
    private String navName;
    /**
    * 父ID
    */
    private Long parentId;
    /**
    * 排序
    */
    private Integer sort;
    /**
    * 状态(关联字典明细表)
    */
    private Integer statusId;
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

    public String getNavName() {
        return navName;
    }

    public void setNavName(String navName) {
        this.navName = navName;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
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

    @Override
    public String toString() {
        return "WebsiteNav{" +
                "id=" + id +
                ", navName='" + navName + '\'' +
                ", parentId=" + parentId +
                ", sort=" + sort +
                ", statusId=" + statusId +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                '}';
    }
}