/**
 * FileName: ExperimentGrade
 * Author:   dinggc
 * Date:     2019/6/24 21:02
 * Description: 实验成绩类
 * History:
 * <author>  <version>   <desc>
 * dinggc     1.0         描述
 */
package cn.xuxiaonan.entities;

/**
 * 〈一句话功能简述〉<br> 
 * 〈实验成绩类〉
 *
 * @author dinggc
 * @create 2019/6/24
 * @since 1.0.0
 */
public class ExperimentGrade extends Base{
    /*
    实验得分
     */
    private int score;
    /*
    实验教师评语
     */
    private String comment;
    /*
    实验完成状态
     */
    private int status;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}