package domain;

/**
 * Created by Cloudqht on 2018/3/23.
 */
public class forumInfo {
    private blogInfo blogInfo;
    private userInfo userInfo;
    private String  imgUrl;

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public domain.blogInfo getBlogInfo() {
        return blogInfo;
    }

    public void setBlogInfo(domain.blogInfo blogInfo) {
        this.blogInfo = blogInfo;
    }

    public domain.userInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(domain.userInfo userInfo) {
        this.userInfo = userInfo;
    }
}
