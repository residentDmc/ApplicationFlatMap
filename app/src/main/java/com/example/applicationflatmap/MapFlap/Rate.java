package com.example.applicationflatmap.MapFlap;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Rate {

@SerializedName("ContentId")
@Expose
private Integer contentId;
@SerializedName("Like")
@Expose
private Integer like;
@SerializedName("DisLike")
@Expose
private Integer disLike;
@SerializedName("Sum")
@Expose
private Integer sum;
@SerializedName("Average")
@Expose
private Double average;

public Integer getContentId() {
return contentId;
}

public void setContentId(Integer contentId) {
this.contentId = contentId;
}

public Integer getLike() {
return like;
}

public void setLike(Integer like) {
this.like = like;
}

public Integer getDisLike() {
return disLike;
}

public void setDisLike(Integer disLike) {
this.disLike = disLike;
}

public Integer getSum() {
return sum;
}

public void setSum(Integer sum) {
this.sum = sum;
}

public Double getAverage() {
return average;
}

public void setAverage(Double average) {
this.average = average;
}

}
