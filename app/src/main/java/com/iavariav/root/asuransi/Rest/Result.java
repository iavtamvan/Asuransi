package com.iavariav.root.asuransi.Rest;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by LENOVO on 26/10/2017.
 */

public class Result {

    @SerializedName("result")
    @Expose
    private String result;

    public String getResult(){
        return  result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
