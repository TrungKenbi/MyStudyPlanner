package vn.edu.tdmu.msp.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class News {
    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("desc")
    @Expose
    private String desc;

    @SerializedName("img")
    @Expose
    private String img;

    @SerializedName("link")
    @Expose
    private String link;

    @SerializedName("time")
    @Expose
    private String time;

    @SerializedName("view")
    @Expose
    private String view;

    @SerializedName("cat_name")
    @Expose
    private String catName;

    @SerializedName("id_name")
    @Expose
    private String idName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public String getIdName() {
        return idName;
    }

    public void setIdName(String idName) {
        this.idName = idName;
    }

}
