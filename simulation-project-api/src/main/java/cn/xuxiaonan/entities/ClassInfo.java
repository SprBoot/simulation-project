/**
 * FileName: ClassInfo
 * Author:   dinggc
 * Date:     2019/6/24 20:49
 * Description: 班级类
 * History:
 * <author>  <version>   <desc>
 * dinggc     1.0         描述
 */
package cn.xuxiaonan.entities;

/**
 * 〈一句话功能简述〉<br> 
 * 〈班级类〉
 *
 * @author dinggc
 * @create 2019/6/24
 * @since 1.0.0
 */
public class ClassInfo extends Base{
    /*
    班级名称
     */
    private String className;
    /*
    班级总人数
     */
    private int number;
    /*
    所在年级
     */
    private String grade;
    /*
    所在系
     */
    private String department;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}