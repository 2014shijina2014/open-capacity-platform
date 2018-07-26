package com.open.capacity.security.model;

/**
 * 邮件收件人表
 *
 * @DBTable t_mail
 */
public class MailTo extends BaseEntity<Long> {

    private static final long serialVersionUID = -8238779033956731073L;

    //邮件id
    private Long mailId;
    //收件人邮箱
    private String toUser;
    //邮件投递状态 1成功，0失败
    private Boolean status;

    /**
     * 邮件id
     *
     * @return
     */
    public Long getMailId() {
        return mailId;
    }

    /**
     * 邮件id
     *
     * @param mailId
     */
    public void setMailId(Long mailId) {
        this.mailId = mailId;
    }

    /**
     * 收件人邮箱
     *
     * @return
     */
    public String getToUser() {
        return toUser;
    }

    /**
     * 收件人邮箱
     *
     * @param toUser
     */
    public void setToUser(String toUser) {
        this.toUser = toUser;
    }

    /**
     * 邮件投递状态 1成功，0失败
     *
     * @return
     */
    public Boolean getStatus() {
        return status;
    }

    /**
     * 邮件投递状态 1成功，0失败
     *
     * @param status
     */
    public void setStatus(Boolean status) {
        this.status = status;
    }
}
