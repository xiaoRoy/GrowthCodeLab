package com.learn.growthcodelab.databinding.notes;

import com.learn.growthcodelab.databinding.model.Note;

public class NotesPresenter implements NotesContracts.Presenter {

    private final NotesContracts.View mView;

    @Override
    public void viewNotes() {
        Note note = new Note();
        note.setTitle("Sunny");
        note.setDescription("What a day!");
        note.setAdditionalInfo("added");
        mView.displayNotes(note);
    }

    public NotesPresenter(NotesContracts.View view) {
        mView = view;
    }

    @Override
    public void addNewNote() {
        mView.navigateToAddNewNotePage();
    }
}
