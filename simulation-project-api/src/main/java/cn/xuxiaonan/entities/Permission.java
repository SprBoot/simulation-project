package cn.xuxiaonan.entities;

import java.util.Date;

/***
* @Description: 权限实体类
* @Author: dinggc
* @Date: 2019/6/4
*/
public class Permission extends Base{
    /**
     * 权限
     */
    private String permission;
    /**
     * 描述
     */
    private String description;
    /**
     * 更新日期
     */
    private Date gxdate;

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getGxdate() {
        return gxdate;
    }

    public void setGxdate(Date gxdate) {
        this.gxdate = gxdate;
    }
}
