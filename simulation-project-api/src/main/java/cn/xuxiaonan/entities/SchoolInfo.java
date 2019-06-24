/**
 * FileName: SchoolInfo
 * Author:   dinggc
 * Date:     2019/6/24 21:20
 * Description: 学校信息类
 * History:
 * <author>  <version>   <desc>
 * dinggc     1.0         描述
 */
package cn.xuxiaonan.entities;

/**
 * 〈一句话功能简述〉<br> 
 * 〈学校信息类〉
 *
 * @author dinggc
 * @create 2019/6/24
 * @since 1.0.0
 */
public class SchoolInfo extends Base{
    /*
    学校名称
     */
    private String schoolName;
    /*
    学校地址
     */
    private String address;
    /*
    学校标签
     */
    private String label;
    /*
    学校简介
     */
    private String introduction;

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
}