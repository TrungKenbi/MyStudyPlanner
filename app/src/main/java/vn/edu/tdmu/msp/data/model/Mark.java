package vn.edu.tdmu.msp.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Mark {

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("mPoint")
    @Expose
    private String mPoint;

    @SerializedName("ePoint")
    @Expose
    private String ePoint;

    @SerializedName("avgPoint")
    @Expose
    private String avgPoint;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getmPoint() {
        return mPoint;
    }

    public void setmPoint(String mPoint) {
        this.mPoint = mPoint;
    }

    public String getePoint() {
        return ePoint;
    }

    public void setePoint(String ePoint) {
        this.ePoint = ePoint;
    }

    public String getAvgPoint() {
        return avgPoint;
    }

    public void setAvgPoint(String avgPoint) {
        this.avgPoint = avgPoint;
    }

}
