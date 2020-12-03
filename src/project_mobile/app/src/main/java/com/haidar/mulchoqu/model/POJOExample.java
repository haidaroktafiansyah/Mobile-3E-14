
package com.haidar.mulchoqu.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class POJOExample {

    @SerializedName("result")
    private List<POJOResult> mResult;

    public List<POJOResult> getResult() {
        return mResult;
    }

    public void setResult(List<POJOResult> result) {
        mResult = result;
    }

}
