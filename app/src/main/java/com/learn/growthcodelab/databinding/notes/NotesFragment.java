package com.learn.growthcodelab.databinding.notes;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.learn.growthcodelab.fragment.BaseFragment;


public class NotesFragment extends BaseFragment implements NotesContracts.View {

    private NotesPresenter mNotesPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mNotesPresenter = new NotesPresenter(this);
    }

    @Override
    public void navigateToAddNewNotePage() {
    }


}
