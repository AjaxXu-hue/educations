package pojo.course;

import java.util.Date;
import java.io.Serializable;

/**
 * 课程介绍信息-审核(CourseIntroduceAudit)实体类
 */
public class CourseIntroduceAudit{
    /**
    * 主键
    */
    private Long id;
    /**
    * 课程简介
    */
    private String introduce;
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

    public Object getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
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
        return "CourseIntroduceAudit{" +
                "id=" + id +
                ", introduce='" + introduce + '\'' +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                '}';
    }
}