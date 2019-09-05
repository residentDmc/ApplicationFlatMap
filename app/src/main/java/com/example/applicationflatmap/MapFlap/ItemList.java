package com.example.applicationflatmap.MapFlap;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ItemList {

    @SerializedName("Id")
    @Expose
    private Integer id;
    @SerializedName("ParentId")
    @Expose
    private Integer parentId;
    @SerializedName("Title")
    @Expose
    private String title;
    @SerializedName("RegionType")
    @Expose
    private Integer regionType;
    @SerializedName("CreatorId")
    @Expose
    private Integer creatorId;
    @SerializedName("OrderPlace")
    @Expose
    private Integer orderPlace;
    @SerializedName("PrivacyText")
    @Expose
    private String privacyText;
    @SerializedName("PrivacyLevel")
    @Expose
    private Integer privacyLevel;
    @SerializedName("VerificationText")
    @Expose
    private String verificationText;
    @SerializedName("Verification")
    @Expose
    private Integer verification;
    @SerializedName("Body")
    @Expose
    private String body;
    @SerializedName("Visit")
    @Expose
    private Integer visit;
    @SerializedName("Rate")
    @Expose
    private Rate rate;
    @SerializedName("IsDeleted")
    @Expose
    private Boolean isDeleted;
    @SerializedName("CreateDate")
    @Expose
    private String createDate;
    @SerializedName("CreateDateFa")
    @Expose
    private String createDateFa;
    @SerializedName("Thumbnail")
    @Expose
    private String thumbnail;
    @SerializedName("SavedFilesName")
    @Expose
    private String savedFilesName;
    @SerializedName("ShowFiles")
    @Expose
    private List<Object> showFiles = null;

    private List<ItemList> itemLists;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getRegionType() {
        return regionType;
    }

    public void setRegionType(Integer regionType) {
        this.regionType = regionType;
    }

    public Integer getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
    }

    public Integer getOrderPlace() {
        return orderPlace;
    }

    public void setOrderPlace(Integer orderPlace) {
        this.orderPlace = orderPlace;
    }

    public String getPrivacyText() {
        return privacyText;
    }

    public void setPrivacyText(String privacyText) {
        this.privacyText = privacyText;
    }

    public Integer getPrivacyLevel() {
        return privacyLevel;
    }

    public void setPrivacyLevel(Integer privacyLevel) {
        this.privacyLevel = privacyLevel;
    }

    public String getVerificationText() {
        return verificationText;
    }

    public void setVerificationText(String verificationText) {
        this.verificationText = verificationText;
    }

    public Integer getVerification() {
        return verification;
    }

    public void setVerification(Integer verification) {
        this.verification = verification;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Integer getVisit() {
        return visit;
    }

    public void setVisit(Integer visit) {
        this.visit = visit;
    }

    public Rate getRate() {
        return rate;
    }

    public void setRate(Rate rate) {
        this.rate = rate;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getCreateDateFa() {
        return createDateFa;
    }

    public void setCreateDateFa(String createDateFa) {
        this.createDateFa = createDateFa;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getSavedFilesName() {
        return savedFilesName;
    }

    public void setSavedFilesName(String savedFilesName) {
        this.savedFilesName = savedFilesName;
    }

    public List<Object> getShowFiles() {
        return showFiles;
    }

    public void setShowFiles(List<Object> showFiles) {
        this.showFiles = showFiles;
    }

    public List<ItemList> getItemLists() {
        return itemLists;
    }

    public void setItemLists(List<ItemList> itemLists) {
        this.itemLists = itemLists;
    }
}

