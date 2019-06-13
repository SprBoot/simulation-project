package cn.xuxiaonan.entities;

import java.util.Date;

/**
 * 用户实体类
 */
public class User extends Base{
    /**
    * 姓名
    */
    private String name;
    /**
     * 单位
     */
    private String dw;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 更新日期
     */
    private Date gxdate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDw() {
        return dw;
    }

    public void setDw(String dw) {
        this.dw = dw;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getGxdate() {
        return gxdate;
    }

    public void setGxdate(Date gxdate) {
        this.gxdate = gxdate;
    }
}
