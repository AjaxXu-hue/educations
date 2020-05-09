package pojo.system;

import java.util.Date;

//系统管理员  角色表
public class Role {

    private Integer id;
    private Integer dictinfoID;//状态(关联字典明细表)
    private String role_name;//名称(英文)
    private String remark;//备注(中文名称)
    private Date gmt_create;//创建时间
    private Date gmt_modified;//修改时间

    private String typeNamezh;//类型名称(中文)
    private String info;//配置项名称

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", dictinfoID=" + dictinfoID +
                ", role_name='" + role_name + '\'' +
                ", remark='" + remark + '\'' +
                ", gmt_create=" + gmt_create +
                ", gmt_modified=" + gmt_modified +
                ", typeNamezh='" + typeNamezh + '\'' +
                ", info='" + info + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDictinfoID() {
        return dictinfoID;
    }

    public void setDictinfoID(Integer dictinfoID) {
        this.dictinfoID = dictinfoID;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getGmt_create() {
        return gmt_create;
    }

    public void setGmt_create(Date gmt_create) {
        this.gmt_create = gmt_create;
    }

    public Date getGmt_modified() {
        return gmt_modified;
    }

    public void setGmt_modified(Date gmt_modified) {
        this.gmt_modified = gmt_modified;
    }

    public String getTypeNamezh() {
        return typeNamezh;
    }

    public void setTypeNamezh(String typeNamezh) {
        this.typeNamezh = typeNamezh;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
