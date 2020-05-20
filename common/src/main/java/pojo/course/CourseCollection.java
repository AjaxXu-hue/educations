package pojo.course;

import java.util.Date;
import java.io.Serializable;

/**
 * (CourseCollection)实体类
 */
public class CourseCollection implements Serializable {
    /**
    * 编号
    */
    private Integer id;
    /**
    * 用户ID
    */
    private Long userid;
    /**
    * 课程ID
    */
    private Long courseid;
    /**
    * 课程名称
    */
    private String coursename;
    /**
    * 创建时间
    */
    private Date createtime;
    /**
    * 修改时间
    */
    private Date updatetime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Long getCourseid() {
        return courseid;
    }

    public void setCourseid(Long courseid) {
        this.courseid = courseid;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

}