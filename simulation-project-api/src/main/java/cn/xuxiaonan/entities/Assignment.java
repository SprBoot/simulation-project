/**
 * FileName: Assignment
 * Author:   dinggc
 * Date:     2019/6/24 20:35
 * Description: 教师发布的作业类
 * History:
 * <author>  <version>   <desc>
 * dinggc     1.0         描述
 */
package cn.xuxiaonan.entities;

import java.util.Date;

/**
 * 〈一句话功能简述〉<br> 
 * 〈教师发布的作业类〉
 *
 * @author dinggc
 * @create 2019/6/24
 * @since 1.0.0
 */
public class Assignment extends Base{
    /*
    作业名称
     */
    private String name;
    /*
    作业题目的数量
     */
    private int number;
    /*
    选择题数量
     */
    private int choiceNumber;
    /*
    选择题每题分数
     */
    private int choiceScore;
    /*
    简答题题目数量
     */
    private int answerNumber;
    /*
    简答题每题分数
     */
    private int answerScore;
    /*
    判断题题目数量
     */
    private int tfNumber;
    /*
    判断题每题分数
     */
    private int tfScore;
    /*
    作业总分数
     */
    private int totalScore;
    /*
    开始时间
     */
    private Date startTime;
    /*
    结束时间
     */
    private Date endTime;
    /*
    状态
     */
    private int status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getChoiceNumber() {
        return choiceNumber;
    }

    public void setChoiceNumber(int choiceNumber) {
        this.choiceNumber = choiceNumber;
    }

    public int getChoiceScore() {
        return choiceScore;
    }

    public void setChoiceScore(int choiceScore) {
        this.choiceScore = choiceScore;
    }

    public int getAnswerNumber() {
        return answerNumber;
    }

    public void setAnswerNumber(int answerNumber) {
        this.answerNumber = answerNumber;
    }

    public int getAnswerScore() {
        return answerScore;
    }

    public void setAnswerScore(int answerScore) {
        this.answerScore = answerScore;
    }

    public int getTfNumber() {
        return tfNumber;
    }

    public void setTfNumber(int tfNumber) {
        this.tfNumber = tfNumber;
    }

    public int getTfScore() {
        return tfScore;
    }

    public void setTfScore(int tfScore) {
        this.tfScore = tfScore;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}