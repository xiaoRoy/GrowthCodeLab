package com.learn.growthcodelab.databinding.notes;


import com.learn.growthcodelab.databinding.model.Note;

public interface NotesContracts {

    interface View{
        void navigateToAddNewNotePage();

        void displayNotes(Note note);
    }

    interface Presenter{
        void addNewNote();

        void viewNotes();
    }
}
