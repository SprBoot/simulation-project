/**
 * FileName: StudentInfo
 * Author:   dinggc
 * Date:     2019/6/24 21:31
 * Description: 学生信息类
 * History:
 * <author>  <version>   <desc>
 * dinggc     1.0         描述
 */
package cn.xuxiaonan.entities;

import java.util.Date;

/**
 * 〈一句话功能简述〉<br> 
 * 〈学生信息类〉
 *
 * @author dinggc
 * @create 2019/6/24
 * @since 1.0.0
 */
public class StudentInfo extends Base{
    /*
    头像图片id
     */
    private String picId;
    /*
    学生用户名
     */
    private String username;
    /*
    邮箱
     */
    private String email;
    /*
    手机号
     */
    private String phone;
    /*
    真实姓名
     */
    private String name;
    /*
    性别
     */
    private int sex;
    /*
    生日
     */
    private Date birth;
    /*
    身份证号
     */
    private String PID;
    /*
    学校
     */
    private String school;
    /*
    学历
     */
    private String education;
    /*
    个人简介
     */
    private String introduction;

    public String getPicId() {
        return picId;
    }

    public void setPicId(String picId) {
        this.picId = picId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getPID() {
        return PID;
    }

    public void setPID(String PID) {
        this.PID = PID;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
}