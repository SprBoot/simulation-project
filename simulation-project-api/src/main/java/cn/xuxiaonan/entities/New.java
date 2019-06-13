/**
 * Copyright (C), 2015-2019
 * FileName: New
 * Author:   A
 * Date:     2019/5/28 11:14
 * Description: 新闻的实体类
 */
package cn.xuxiaonan.entities;

import java.util.Date;

/**
 * 〈新闻的实体类构建器〉
 * @author dinggc
 * @create 2019/5/28
 * @since 1.0.0
 */
public class New extends Base{
    /**
     * 标题
     **/
    private String title;
    /**
     * 新闻内容
     **/
    private String xwnr;
    /**
     * 新闻的封面图片id
     **/
    private String fmtpId;
    /**
     * 发表的机构
     **/
    private String fbjg;
    /**
     * 是否为草稿状态
     **/
    private int sfwcg;
    /**
     * 审核状态
     **/
    private int shzt;
    /**
     * 阅读量
     **/
    private int ydl;
    /**
     * 更新时间
     **/
    private Date gxdate;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getXwnr() {
        return xwnr;
    }

    public void setXwnr(String xwnr) {
        this.xwnr = xwnr;
    }

    public String getFmtpId() {
        return fmtpId;
    }

    public void setFmtpId(String fmtpId) {
        this.fmtpId = fmtpId;
    }

    public String getFbjg() {
        return fbjg;
    }

    public void setFbjg(String fbjg) {
        this.fbjg = fbjg;
    }

    public int getSfwcg() {
        return sfwcg;
    }

    public void setSfwcg(int sfwcg) {
        this.sfwcg = sfwcg;
    }

    public int getShzt() {
        return shzt;
    }

    public void setShzt(int shzt) {
        this.shzt = shzt;
    }

    public int getYdl() {
        return ydl;
    }

    public void setYdl(int ydl) {
        this.ydl = ydl;
    }

    public Date getGxdate() {
        return gxdate;
    }

    public void setGxdate(Date gxdate) {
        this.gxdate = gxdate;
    }
}
