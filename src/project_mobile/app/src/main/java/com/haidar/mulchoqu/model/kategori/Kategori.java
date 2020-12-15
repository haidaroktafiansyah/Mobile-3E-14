
package com.haidar.mulchoqu.model.kategori;

import java.util.List;
import com.google.gson.annotations.SerializedName;


public class Kategori {

    @SerializedName("trivia_categories")
    private List<TriviaCategoryModel> mTriviaCategories;

    public List<TriviaCategoryModel> getTriviaCategories() {
        return mTriviaCategories;
    }

    public void setTriviaCategories(List<TriviaCategoryModel> triviaCategories) {
        mTriviaCategories = triviaCategories;
    }

}
