package com.learn.growthcodelab.databinding.notes;

public class NotesPresenter implements NotesContracts.Presenter {

    private final NotesContracts.View mView;

    public NotesPresenter(NotesContracts.View view) {
        mView = view;
    }

    @Override
    public void addNewNote() {
        mView.navigateToAddNewNotePage();
    }
}
