package com.open.capacity.security.model;

/**
 * @DBTable file_info
 * @id String 文件md5
 */
public class FileInfo extends BaseEntity<String> {

    private static final long serialVersionUID = -5761547882766615438L;

    private String contentType;
    private long size;
    /**
     * 物理路径
     */
    private String path;
    private String url;
    private Integer type;

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    /**
     * 物理路径
     *
     * @return
     */
    public String getPath() {
        return path;
    }

    /**
     * 物理路径
     *
     * @param path
     */
    public void setPath(String path) {
        this.path = path;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
