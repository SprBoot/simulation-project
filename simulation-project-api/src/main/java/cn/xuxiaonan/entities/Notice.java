/**
 * FileName: Notice
 * Author:   dinggc
 * Date:     2019/6/24 21:14
 * Description: 通知类
 * History:
 * <author>  <version>   <desc>
 * dinggc     1.0         描述
 */
package cn.xuxiaonan.entities;

/**
 * 〈一句话功能简述〉<br> 
 * 〈通知类〉
 *
 * @author dinggc
 * @create 2019/6/24
 * @since 1.0.0
 */
public class Notice extends Base{
    /*
    通知标题
     */
    private String title;
    /*
    通知内容
     */
    private String context;
    /*
    通知人id
     */
    private String userId;
    /*
    被通知人id
     */
    private String byUserId;
    /*
    是否已读
     */
    private int hasRead;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getByUserId() {
        return byUserId;
    }

    public void setByUserId(String byUserId) {
        this.byUserId = byUserId;
    }

    public int getHasRead() {
        return hasRead;
    }

    public void setHasRead(int hasRead) {
        this.hasRead = hasRead;
    }
}