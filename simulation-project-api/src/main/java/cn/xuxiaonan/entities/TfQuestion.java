/**
 * FileName: TfQuestion
 * Author:   dinggc
 * Date:     2019/6/24 21:36
 * Description: 判断题类
 * History:
 * <author>  <version>   <desc>
 * dinggc     1.0         描述
 */
package cn.xuxiaonan.entities;

/**
 * 〈一句话功能简述〉<br> 
 * 〈判断题类〉
 *
 * @author dinggc
 * @create 2019/6/24
 * @since 1.0.0
 */
public class TfQuestion extends Base{
    /*
    题目
     */
    private String topic;
    /*
    正确答案
     */
    private int correctAnswer;

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(int correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}