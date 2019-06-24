/**
 * FileName: Curriculum
 * Author:   dinggc
 * Date:     2019/6/24 20:56
 * Description: 课程表类
 * History:
 * <author>  <version>   <desc>
 * dinggc     1.0         描述
 */
package cn.xuxiaonan.entities;

/**
 * 〈一句话功能简述〉<br> 
 * 〈课程表类〉
 *
 * @author dinggc
 * @create 2019/6/24
 * @since 1.0.0
 */
public class Curriculum extends Base{
    /*
    实验名称
     */
    private String experimentName;
    /*
    教师名称
     */
    private String teacherName;
    /*
    周几
     */
    private String whichDay;
    /*
    实验地点
     */
    private String address;
    /*
    开始周
     */
    private int startWeek;
    /*
    结束周
     */
    private int endWeek;
    /*
    单双周标记
     */
    private int sdwFlag;
    /*
    哪一节课
     */
    private String whichCurriculum;
    /*
    节数
     */
    private int sectionNumber;
    /*
    学期
     */
    private String semester;

    public String getExperimentName() {
        return experimentName;
    }

    public void setExperimentName(String experimentName) {
        this.experimentName = experimentName;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getWhichDay() {
        return whichDay;
    }

    public void setWhichDay(String whichDay) {
        this.whichDay = whichDay;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getStartWeek() {
        return startWeek;
    }

    public void setStartWeek(int startWeek) {
        this.startWeek = startWeek;
    }

    public int getEndWeek() {
        return endWeek;
    }

    public void setEndWeek(int endWeek) {
        this.endWeek = endWeek;
    }

    public int getSdwFlag() {
        return sdwFlag;
    }

    public void setSdwFlag(int sdwFlag) {
        this.sdwFlag = sdwFlag;
    }

    public String getWhichCurriculum() {
        return whichCurriculum;
    }

    public void setWhichCurriculum(String whichCurriculum) {
        this.whichCurriculum = whichCurriculum;
    }

    public int getSectionNumber() {
        return sectionNumber;
    }

    public void setSectionNumber(int sectionNumber) {
        this.sectionNumber = sectionNumber;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }
}