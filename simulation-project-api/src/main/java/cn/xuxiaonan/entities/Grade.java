/**
 * FileName: Grade
 * Author:   dinggc
 * Date:     2019/6/24 21:12
 * Description: 年级类
 * History:
 * <author>  <version>   <desc>
 * dinggc     1.0         描述
 */
package cn.xuxiaonan.entities;

/**
 * 〈一句话功能简述〉<br> 
 * 〈年级类〉
 *
 * @author dinggc
 * @create 2019/6/24
 * @since 1.0.0
 */
public class Grade extends Base{
    /*
    年级名称
     */
    private String grade;
    /*
    年级班级数
     */
    private int total;

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}