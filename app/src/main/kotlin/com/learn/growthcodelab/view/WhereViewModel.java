package com.learn.growthcodelab.view;

import com.learn.growthcodelab.BR;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;


public class WhereViewModel extends BaseObservable {

    private boolean isTopChoice;


    @Bindable
    public boolean isTopChoice() {
        return isTopChoice;
    }

    public void setTopChoice(boolean topChoice) {
        isTopChoice = topChoice;
        notifyPropertyChanged(BR.topChoice);
    }

    private String where;


    @Bindable
    public String getWhere() {
        return where;
    }

    public void setWhere(String where) {
        this.where = where;
        notifyPropertyChanged(BR.where);
    }
}
