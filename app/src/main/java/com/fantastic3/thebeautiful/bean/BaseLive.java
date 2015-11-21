package com.fantastic3.thebeautiful.bean;

/**
 * TheBeautiful
 * Created by meluo
 * on 2015/11/11.
 */

import java.util.List;

/**
 * 直播的实体
 */
public class BaseLive {
    /**
     * _id : 3218aedc-f873-433b-9578-e377e677a77b
     * applicantNum : 1250
     * beginTime : 1447070400
     * commentCount : 0
     * content : 黑头草莓鼻……这些让大家恨得牙痒痒，现在家弘老师就帮你干掉它们。
     * createTime : 1446806868
     * disable : 0
     * duration : 0
     * endTime : 1447156800
     * flower : 0
     * hasApplied : 0
     * hasfinished : 0
     * isBanner : 0
     * isTop : 0
     * keyTag : video_3218aedc-f873-433b-9578-e377e677a77b
     * liveId : fd6d602cf49740a1b2a07a0ca6a29374
     * liveNum : 77352015
     * nowViewers : 0
     * pic : group1/M00/08/74/CgpFY1ZAP7-ABwT2AAEW1Ezercs102.jpg
     * playPassword : 12345678
     * playStatus : 0
     * provider : 1
     * publishTime : 1447027200
     * shit : 0
     * sortNo : 0
     * tags : ["护肤达人","护肤"]
     * tapeId :
     * timerTag : timer_3218aedc-f873-433b-9578-e377e677a77b
     * title : 就此告别黑头君和草莓鼻
     * type : 5
     * uid : 62c97fbd-ad26-47d4-a19c-881efc6e300e
     * updateTime : 1447051200
     * userInfo : {"age":"1","birthday":"2015/04/23","city":"1","country":"中国","create_time":"1429763277","description":"祛痘达人，问题肌肤专家","district":"1","experience":"1","gold":"1","head_img_url":"group1/M00/08/46/CgpFY1Y8MdWALGYMAAJPanaS3hQ946.jpg","isAdmin":0,"isQukHost":"1","is_master":"1","jfNo":"1","level":"12","nickname":"家弘","open_video":"0","province":"台湾","qukHostSort":"0","sex":"1","uid":"62c97fbd-ad26-47d4-a19c-881efc6e300e","update_time":"1446785493"}
     * videoType : 1
     * watchNum : 1248
     */

    private String _id;
    private int applicantNum;
    private int beginTime;
    private int commentCount;
    private String content;
    private int createTime;
    private int disable;
    private int duration;
    private int endTime;
    private int flower;
    private int hasApplied;
    private int hasfinished;
    private int isBanner;
    private int isTop;
    private String keyTag;
    private String liveId;
    private String liveNum;
    private int nowViewers;
    private String pic;
    private String playPassword;
    private int playStatus;
    private int provider;
    private int publishTime;
    private int shit;
    private int sortNo;
    private String tapeId;
    private String timerTag;
    private String title;
    private int type;
    private String uid;
    private int updateTime;
    /**
     * age : 1
     * birthday : 2015/04/23
     * city : 1
     * country : 中国
     * create_time : 1429763277
     * description : 祛痘达人，问题肌肤专家
     * district : 1
     * experience : 1
     * gold : 1
     * head_img_url : group1/M00/08/46/CgpFY1Y8MdWALGYMAAJPanaS3hQ946.jpg
     * isAdmin : 0
     * isQukHost : 1
     * is_master : 1
     * jfNo : 1
     * level : 12
     * nickname : 家弘
     * open_video : 0
     * province : 台湾
     * qukHostSort : 0
     * sex : 1
     * uid : 62c97fbd-ad26-47d4-a19c-881efc6e300e
     * update_time : 1446785493
     */

    private UserInfoEntity userInfo;
    private int videoType;
    private int watchNum;
    private List<String> tags;

    public void set_id(String _id) {
        this._id = _id;
    }

    public void setApplicantNum(int applicantNum) {
        this.applicantNum = applicantNum;
    }

    public void setBeginTime(int beginTime) {
        this.beginTime = beginTime;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setCreateTime(int createTime) {
        this.createTime = createTime;
    }

    public void setDisable(int disable) {
        this.disable = disable;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public void setFlower(int flower) {
        this.flower = flower;
    }

    public void setHasApplied(int hasApplied) {
        this.hasApplied = hasApplied;
    }

    public void setHasfinished(int hasfinished) {
        this.hasfinished = hasfinished;
    }

    public void setIsBanner(int isBanner) {
        this.isBanner = isBanner;
    }

    public void setIsTop(int isTop) {
        this.isTop = isTop;
    }

    public void setKeyTag(String keyTag) {
        this.keyTag = keyTag;
    }

    public void setLiveId(String liveId) {
        this.liveId = liveId;
    }

    public void setLiveNum(String liveNum) {
        this.liveNum = liveNum;
    }

    public void setNowViewers(int nowViewers) {
        this.nowViewers = nowViewers;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public void setPlayPassword(String playPassword) {
        this.playPassword = playPassword;
    }

    public void setPlayStatus(int playStatus) {
        this.playStatus = playStatus;
    }

    public void setProvider(int provider) {
        this.provider = provider;
    }

    public void setPublishTime(int publishTime) {
        this.publishTime = publishTime;
    }

    public void setShit(int shit) {
        this.shit = shit;
    }

    public void setSortNo(int sortNo) {
        this.sortNo = sortNo;
    }

    public void setTapeId(String tapeId) {
        this.tapeId = tapeId;
    }

    public void setTimerTag(String timerTag) {
        this.timerTag = timerTag;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public void setUpdateTime(int updateTime) {
        this.updateTime = updateTime;
    }

    public void setUserInfo(UserInfoEntity userInfo) {
        this.userInfo = userInfo;
    }

    public void setVideoType(int videoType) {
        this.videoType = videoType;
    }

    public void setWatchNum(int watchNum) {
        this.watchNum = watchNum;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String get_id() {
        return _id;
    }

    public int getApplicantNum() {
        return applicantNum;
    }

    public int getBeginTime() {
        return beginTime;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public String getContent() {
        return content;
    }

    public int getCreateTime() {
        return createTime;
    }

    public int getDisable() {
        return disable;
    }

    public int getDuration() {
        return duration;
    }

    public int getEndTime() {
        return endTime;
    }

    public int getFlower() {
        return flower;
    }

    public int getHasApplied() {
        return hasApplied;
    }

    public int getHasfinished() {
        return hasfinished;
    }

    public int getIsBanner() {
        return isBanner;
    }

    public int getIsTop() {
        return isTop;
    }

    public String getKeyTag() {
        return keyTag;
    }

    public String getLiveId() {
        return liveId;
    }

    public String getLiveNum() {
        return liveNum;
    }

    public int getNowViewers() {
        return nowViewers;
    }

    public String getPic() {
        return pic;
    }

    public String getPlayPassword() {
        return playPassword;
    }

    public int getPlayStatus() {
        return playStatus;
    }

    public int getProvider() {
        return provider;
    }

    public int getPublishTime() {
        return publishTime;
    }

    public int getShit() {
        return shit;
    }

    public int getSortNo() {
        return sortNo;
    }

    public String getTapeId() {
        return tapeId;
    }

    public String getTimerTag() {
        return timerTag;
    }

    public String getTitle() {
        return title;
    }

    public int getType() {
        return type;
    }

    public String getUid() {
        return uid;
    }

    public int getUpdateTime() {
        return updateTime;
    }

    public UserInfoEntity getUserInfo() {
        return userInfo;
    }

    public int getVideoType() {
        return videoType;
    }

    public int getWatchNum() {
        return watchNum;
    }

    public List<String> getTags() {
        return tags;
    }

    private int livetype=0;//设置类别

    public int getLivetype() {
        return livetype;
    }

    public void setLivetype(int livetype) {
        this.livetype = livetype;
    }

    public static class UserInfoEntity {
        private String age;
        private String birthday;
        private String city;
        private String country;
        private String create_time;
        private String description;
        private String district;
        private String experience;
        private String gold;
        private String head_img_url;
        private int isAdmin;
        private String isQukHost;
        private String is_master;
        private String jfNo;
        private String level;
        private String nickname;
        private String open_video;
        private String province;
        private String qukHostSort;
        private String sex;
        private String uid;
        private String update_time;

        public void setAge(String age) {
            this.age = age;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public void setCreate_time(String create_time) {
            this.create_time = create_time;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public void setDistrict(String district) {
            this.district = district;
        }

        public void setExperience(String experience) {
            this.experience = experience;
        }

        public void setGold(String gold) {
            this.gold = gold;
        }

        public void setHead_img_url(String head_img_url) {
            this.head_img_url = head_img_url;
        }

        public void setIsAdmin(int isAdmin) {
            this.isAdmin = isAdmin;
        }

        public void setIsQukHost(String isQukHost) {
            this.isQukHost = isQukHost;
        }

        public void setIs_master(String is_master) {
            this.is_master = is_master;
        }

        public void setJfNo(String jfNo) {
            this.jfNo = jfNo;
        }

        public void setLevel(String level) {
            this.level = level;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public void setOpen_video(String open_video) {
            this.open_video = open_video;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public void setQukHostSort(String qukHostSort) {
            this.qukHostSort = qukHostSort;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public void setUpdate_time(String update_time) {
            this.update_time = update_time;
        }

        public String getAge() {
            return age;
        }

        public String getBirthday() {
            return birthday;
        }

        public String getCity() {
            return city;
        }

        public String getCountry() {
            return country;
        }

        public String getCreate_time() {
            return create_time;
        }

        public String getDescription() {
            return description;
        }

        public String getDistrict() {
            return district;
        }

        public String getExperience() {
            return experience;
        }

        public String getGold() {
            return gold;
        }

        public String getHead_img_url() {
            return head_img_url;
        }

        public int getIsAdmin() {
            return isAdmin;
        }

        public String getIsQukHost() {
            return isQukHost;
        }

        public String getIs_master() {
            return is_master;
        }

        public String getJfNo() {
            return jfNo;
        }

        public String getLevel() {
            return level;
        }

        public String getNickname() {
            return nickname;
        }

        public String getOpen_video() {
            return open_video;
        }

        public String getProvince() {
            return province;
        }

        public String getQukHostSort() {
            return qukHostSort;
        }

        public String getSex() {
            return sex;
        }

        public String getUid() {
            return uid;
        }

        public String getUpdate_time() {
            return update_time;
        }
    }
}
