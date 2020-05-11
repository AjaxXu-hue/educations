package pojo.system;

import java.util.Date;
import java.io.Serializable;

/**
 * 站点导航文章(WebsiteNavArticle)实体类
 */
public class WebsiteNavArticle implements Serializable {
    /**
    * 主键
    */
    private Long id;
    /**
    * 导航ID
    */
    private Long navId;
    /**
    * 文章标题
    */
    private String artTitle;
    /**
    * 文章图片
    */
    private String artPic;
    /**
    * 文章描述
    */
    private String artDesc;
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

    public Long getNavId() {
        return navId;
    }

    public void setNavId(Long navId) {
        this.navId = navId;
    }

    public String getArtTitle() {
        return artTitle;
    }

    public void setArtTitle(String artTitle) {
        this.artTitle = artTitle;
    }

    public String getArtPic() {
        return artPic;
    }

    public void setArtPic(String artPic) {
        this.artPic = artPic;
    }

    public String getArtDesc() {
        return artDesc;
    }

    public void setArtDesc(String artDesc) {
        this.artDesc = artDesc;
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

}