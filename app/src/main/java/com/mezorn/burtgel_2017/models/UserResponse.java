package com.mezorn.burtgel_2017.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by manlai on 5/28/17.
 */

public class UserResponse {
      /* {
        "id": 2010101001101,
            "code": 39534608,
            "role": 1,
            "aimag": "архангай",
            "sumduureg": "батцэнгэл",
            "bagkhoroo": "1-р баг, улаанчулуу",
            "heseg_id": 11,
            "heseg_name": "11-р хэсэг",
            "heseg_in_bagkhoroo": 1,
            "fullname": "",
            "phone": "",
            "token": "c68d3f3b7a81cf0e8b92df9bc27c88158626bc2d"
    }*/

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("code")
    @Expose
    private String code;

    @SerializedName("role")
    @Expose
    private String role;

    @SerializedName("aimag")
    @Expose
    private String aimag;

    @SerializedName("sumduureg")
    @Expose
    private String sumduureg;

    @SerializedName("bagkhoroo")
    @Expose
    private String bagkhoroo;

    @SerializedName("heseg_id")
    @Expose
    private String heseg_id;

    @SerializedName("heseg_name")
    @Expose
    private String heseg_name;

    @SerializedName("heseg_in_bagkhoroo")
    private String heseg_in_bagkhoroo;

    @SerializedName("fullname")
    private String fullname;

    @SerializedName("phone")
    private String phone;

    @SerializedName("token")
    private String token;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getAimag() {
        return aimag;
    }

    public void setAimag(String aimag) {
        this.aimag = aimag;
    }

    public String getSumduureg() {
        return sumduureg;
    }

    public void setSumduureg(String sumduureg) {
        this.sumduureg = sumduureg;
    }

    public String getBagkhoroo() {
        return bagkhoroo;
    }

    public void setBagkhoroo(String bagkhoroo) {
        this.bagkhoroo = bagkhoroo;
    }

    public String getHeseg_id() {
        return heseg_id;
    }

    public void setHeseg_id(String heseg_id) {
        this.heseg_id = heseg_id;
    }

    public String getHeseg_name() {
        return heseg_name;
    }

    public void setHeseg_name(String heseg_name) {
        this.heseg_name = heseg_name;
    }

    public String getHeseg_in_bagkhoroo() {
        return heseg_in_bagkhoroo;
    }

    public void setHeseg_in_bagkhoroo(String heseg_in_bagkhoroo) {
        this.heseg_in_bagkhoroo = heseg_in_bagkhoroo;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
