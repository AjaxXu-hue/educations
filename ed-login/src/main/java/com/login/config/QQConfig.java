package com.login.config;


import org.springframework.context.annotation.Configuration;

@Configuration
public class QQConfig {

    private String app_ID = "1110443787";
    private String app_KEY = "UfcNkvVb4C2AQ2GN";
    private String redirect_URI = "http://*******/afterlogin.do";
    private String scope = "get_user_info,add_topic,add_one_blog,add_album,upload_pic,list_album,add_share,check_page_fans,add_t,add_pic_t,del_t,get_repost_list,get_info,get_other_info,get_fanslist,get_idollist,add_idol,del_ido,get_tenpay_addr";
    private String baseURL = "https://graph.qq.com/";
    private String getUserInfoURL = "https://graph.qq.com/user/get_user_info";
    private String accessTokenURL = "https://graph.qq.com/oauth2.0/token";
    private String authorizeURL = "https://graph.qq.com/oauth2.0/authorize";
    private String getOpenIDURL = "https://graph.qq.com/oauth2.0/me";
    private String addTopicURL = "https://graph.qq.com/shuoshuo/add_topic";
    private String addBlogURL = "https://graph.qq.com/blog/add_one_blog";
    private String addAlbumURL = "https://graph.qq.com/photo/add_album";
    private String uploadPicURL = "https://graph.qq.com/photo/upload_pic";
    private String listAlbumURL = "https://graph.qq.com/photo/list_album";
    private String addShareURL = "https://graph.qq.com/share/add_share";
    private String checkPageFansURL = "https://graph.qq.com/user/check_page_fans";
    private String addTURL = "https://graph.qq.com/t/add_t";
    private String addPicTURL = "https://graph.qq.com/t/add_pic_t";
    private String delTURL = "https://graph.qq.com/t/del_t";
    private String getWeiboUserInfoURL = "https://graph.qq.com/user/get_info";
    private String getWeiboOtherUserInfoURL = "https://graph.qq.com/user/get_other_info";
    private String getFansListURL = "https://graph.qq.com/relation/get_fanslist";
    private String getIdolsListURL = "https://graph.qq.com/relation/get_idollist";
    private String addIdolURL = "https://graph.qq.com/relation/add_idol";
    private String delIdolURL = "https://graph.qq.com/relation/del_idol";
    private String getTenpayAddrURL = "https://graph.qq.com/cft_info/get_tenpay_addr";
    private String getRepostListURL = "https://graph.qq.com/t/get_repost_list";
    private String version = "1.0";

    public String getApp_ID() {
        return app_ID;
    }

    public void setApp_ID(String app_ID) {
        this.app_ID = app_ID;
    }

    public String getApp_KEY() {
        return app_KEY;
    }

    public void setApp_KEY(String app_KEY) {
        this.app_KEY = app_KEY;
    }

    public String getRedirect_URI() {
        return redirect_URI;
    }

    public void setRedirect_URI(String redirect_URI) {
        this.redirect_URI = redirect_URI;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getBaseURL() {
        return baseURL;
    }

    public void setBaseURL(String baseURL) {
        this.baseURL = baseURL;
    }

    public String getGetUserInfoURL() {
        return getUserInfoURL;
    }

    public void setGetUserInfoURL(String getUserInfoURL) {
        this.getUserInfoURL = getUserInfoURL;
    }

    public String getAccessTokenURL() {
        return accessTokenURL;
    }

    public void setAccessTokenURL(String accessTokenURL) {
        this.accessTokenURL = accessTokenURL;
    }

    public String getAuthorizeURL() {
        return authorizeURL;
    }

    public void setAuthorizeURL(String authorizeURL) {
        this.authorizeURL = authorizeURL;
    }

    public String getGetOpenIDURL() {
        return getOpenIDURL;
    }

    public void setGetOpenIDURL(String getOpenIDURL) {
        this.getOpenIDURL = getOpenIDURL;
    }

    public String getAddTopicURL() {
        return addTopicURL;
    }

    public void setAddTopicURL(String addTopicURL) {
        this.addTopicURL = addTopicURL;
    }

    public String getAddBlogURL() {
        return addBlogURL;
    }

    public void setAddBlogURL(String addBlogURL) {
        this.addBlogURL = addBlogURL;
    }

    public String getAddAlbumURL() {
        return addAlbumURL;
    }

    public void setAddAlbumURL(String addAlbumURL) {
        this.addAlbumURL = addAlbumURL;
    }

    public String getUploadPicURL() {
        return uploadPicURL;
    }

    public void setUploadPicURL(String uploadPicURL) {
        this.uploadPicURL = uploadPicURL;
    }

    public String getListAlbumURL() {
        return listAlbumURL;
    }

    public void setListAlbumURL(String listAlbumURL) {
        this.listAlbumURL = listAlbumURL;
    }

    public String getAddShareURL() {
        return addShareURL;
    }

    public void setAddShareURL(String addShareURL) {
        this.addShareURL = addShareURL;
    }

    public String getCheckPageFansURL() {
        return checkPageFansURL;
    }

    public void setCheckPageFansURL(String checkPageFansURL) {
        this.checkPageFansURL = checkPageFansURL;
    }

    public String getAddTURL() {
        return addTURL;
    }

    public void setAddTURL(String addTURL) {
        this.addTURL = addTURL;
    }

    public String getAddPicTURL() {
        return addPicTURL;
    }

    public void setAddPicTURL(String addPicTURL) {
        this.addPicTURL = addPicTURL;
    }

    public String getDelTURL() {
        return delTURL;
    }

    public void setDelTURL(String delTURL) {
        this.delTURL = delTURL;
    }

    public String getGetWeiboUserInfoURL() {
        return getWeiboUserInfoURL;
    }

    public void setGetWeiboUserInfoURL(String getWeiboUserInfoURL) {
        this.getWeiboUserInfoURL = getWeiboUserInfoURL;
    }

    public String getGetWeiboOtherUserInfoURL() {
        return getWeiboOtherUserInfoURL;
    }

    public void setGetWeiboOtherUserInfoURL(String getWeiboOtherUserInfoURL) {
        this.getWeiboOtherUserInfoURL = getWeiboOtherUserInfoURL;
    }

    public String getGetFansListURL() {
        return getFansListURL;
    }

    public void setGetFansListURL(String getFansListURL) {
        this.getFansListURL = getFansListURL;
    }

    public String getGetIdolsListURL() {
        return getIdolsListURL;
    }

    public void setGetIdolsListURL(String getIdolsListURL) {
        this.getIdolsListURL = getIdolsListURL;
    }

    public String getAddIdolURL() {
        return addIdolURL;
    }

    public void setAddIdolURL(String addIdolURL) {
        this.addIdolURL = addIdolURL;
    }

    public String getDelIdolURL() {
        return delIdolURL;
    }

    public void setDelIdolURL(String delIdolURL) {
        this.delIdolURL = delIdolURL;
    }

    public String getGetTenpayAddrURL() {
        return getTenpayAddrURL;
    }

    public void setGetTenpayAddrURL(String getTenpayAddrURL) {
        this.getTenpayAddrURL = getTenpayAddrURL;
    }

    public String getGetRepostListURL() {
        return getRepostListURL;
    }

    public void setGetRepostListURL(String getRepostListURL) {
        this.getRepostListURL = getRepostListURL;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
