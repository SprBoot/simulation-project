/**
 * FileName: EsConstant
 * Author:   dinggc
 * Date:     2019/6/25 17:04
 * Description: 高亮枚举类
 * History:
 * <author>  <version>   <desc>
 * dinggc     1.0         描述
 */
package cn.xuxiaonan.enums;

/**
 * 〈一句话功能简述〉<br> 
 * 〈高亮枚举类〉
 *
 * @author dinggc
 * @create 2019/6/25
 * @since 1.0.0
 */
public enum  EsConstant {
    STARTTAG("<em>"),
    ENDTAG("</em>");
    private String tagName;
    /**
     * @Author dinggc
     * @Description //单参构造函数
     * @Date 10:35 2019/5/28
     * @Param [tagName]
     * @return
     **/
    EsConstant(String tagName) {
        this.tagName = tagName;
    }
    /**
     * @Author dinggc
     * @Description //获取当前的关键字
     * @Date 10:35 2019/5/28
     * @Param []
     * @return java.lang.String
     **/
    public String getTagName() {
        return tagName;
    }
    /**
     * @Author dinggc
     * @Description //无参构造函数
     * @Date 10:36 2019/5/28
     * @Param []
     * @return
     **/
    EsConstant() {
    }
}