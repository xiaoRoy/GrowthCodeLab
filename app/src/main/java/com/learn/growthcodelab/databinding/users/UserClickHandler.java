package com.learn.growthcodelab.databinding.users;


import com.learn.growthcodelab.databinding.model.User;

public interface UserClickHandler {
    void onShowMessageClicked(User user);

    void changUserName(User user);
}
