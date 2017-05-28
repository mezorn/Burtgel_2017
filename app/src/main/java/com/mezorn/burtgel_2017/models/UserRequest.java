package com.mezorn.burtgel_2017.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by manlai on 5/28/17.
 */

public class UserRequest {
    @SerializedName("an_manager_code")
    private String an_manager_code;

    public UserRequest(String thiscode){
        this.an_manager_code = thiscode;
    }

    public String getCode() {
        return an_manager_code;
    }

    public void setCode(String code) {
        this.an_manager_code = code;
    }
}
