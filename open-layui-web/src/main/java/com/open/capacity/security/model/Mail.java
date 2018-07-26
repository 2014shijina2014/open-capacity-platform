package com.open.capacity.security.model;


/**
 * 发送邮件表
 *
 * @DBTable t_mail
 */
public class Mail extends BaseEntity<Long> {

    private static final long serialVersionUID = 5613231124043303948L;

    //发送人
    private Long userId;
    //接收人
    private String toUsers;
    //标题
    private String subject;
    //正文
    private String content;

    /**
     * 发送人
     *
     * @return
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 发送人
     *
     * @param userId
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 接收人
     *
     * @return
     */
    public String getToUsers() {
        return toUsers;
    }

    /**
     * 接收人
     *
     * @param toUsers
     */
    public void setToUsers(String toUsers) {
        this.toUsers = toUsers;
    }

    /**
     * 标题
     *
     * @return
     */
    public String getSubject() {
        return subject;
    }

    /**
     * 标题
     *
     * @param subject
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * 正文
     *
     * @return
     */
    public String getContent() {
        return content;
    }

    /**
     * 正文
     *
     * @param content
     */
    public void setContent(String content) {
        this.content = content;
    }

}
