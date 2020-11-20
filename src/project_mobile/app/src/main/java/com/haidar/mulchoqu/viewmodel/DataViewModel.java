package com.haidar.mulchoqu.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DataViewModel extends ViewModel {

    private MutableLiveData<String> mClicked = new MutableLiveData<>();


    public String getClicked() {
        return mClicked.getValue();
    }

    public void setClicked(String clicked) {
        mClicked.setValue(clicked);
    }

}
