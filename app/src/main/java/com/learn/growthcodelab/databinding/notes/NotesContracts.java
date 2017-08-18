package com.learn.growthcodelab.databinding.notes;


public interface NotesContracts {

    interface View{
        void navigateToAddNewNotePage();
    }

    interface Presenter{
        void addNewNote();
    }
}
