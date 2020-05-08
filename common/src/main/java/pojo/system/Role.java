package pojo.system;

import java.util.Date;

//系统管理员  角色表
public class Role {

    private Integer id;
    private boolean statusId;//状态(1:正常，0:禁用)
    private String roleName;//名称(英文)
    private String remark;//备注(中文名称)
    private Date gmtCreate;//创建时间
    private Date gmtModified;//修改时间

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isStatusId() {
        return statusId;
    }

    public void setStatusId(boolean statusId) {
        this.statusId = statusId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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
