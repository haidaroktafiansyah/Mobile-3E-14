
package com.haidar.mulchoqu.model.soal;

import java.util.List;
import com.google.gson.annotations.SerializedName;


public class SoalModel {

    @SerializedName("response_code")
    private Long mResponseCode;
    @SerializedName("results")
    private List<SoalResult> mResults;

    public Long getResponseCode() {
        return mResponseCode;
    }

    public void setResponseCode(Long responseCode) {
        mResponseCode = responseCode;
    }

    public List<SoalResult> getResults() {
        return mResults;
    }

    public void setResults(List<SoalResult> results) {
        mResults = results;
    }

}
