/**
 * FileName: ExperimentStatistics
 * Author:   dinggc
 * Date:     2019/6/24 21:04
 * Description: 实验统计类
 * History:
 * <author>  <version>   <desc>
 * dinggc     1.0         描述
 */
package cn.xuxiaonan.entities;

/**
 * 〈一句话功能简述〉<br> 
 * 〈实验统计类〉
 *
 * @author dinggc
 * @create 2019/6/24
 * @since 1.0.0
 */
public class ExperimentStatistics extends Base{
    /*
    实验总的参加人数
     */
    private int totalNumber;
    /*
    实验的难易程度
     */
    private String difficult;
    /*
    实验的平均完成率
     */
    private int avgComplete;
    /*
    实验的平均成绩
     */
    private int avgGrade;
    /*
    实验的评分
     */
    private int score;

    public int getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(int totalNumber) {
        this.totalNumber = totalNumber;
    }

    public String getDifficult() {
        return difficult;
    }

    public void setDifficult(String difficult) {
        this.difficult = difficult;
    }

    public int getAvgComplete() {
        return avgComplete;
    }

    public void setAvgComplete(int avgComplete) {
        this.avgComplete = avgComplete;
    }

    public int getAvgGrade() {
        return avgGrade;
    }

    public void setAvgGrade(int avgGrade) {
        this.avgGrade = avgGrade;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}