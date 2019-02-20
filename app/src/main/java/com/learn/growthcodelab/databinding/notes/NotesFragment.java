package com.learn.growthcodelab.databinding.notes;

import androidx.databinding.DataBindingUtil;
import android.os.Bundle;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.learn.growthcodelab.R;
import com.learn.growthcodelab.databinding.FragmentNotesBinding;
import com.learn.growthcodelab.databinding.model.Note;
import com.learn.growthcodelab.fragment.BaseFragment;


public class NotesFragment extends BaseFragment implements NotesContracts.View {

    private FragmentNotesBinding mFragmentNotesBinding;

    private NotesPresenter mNotesPresenter;

    public static NotesFragment newInstance(){
        return new NotesFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mNotesPresenter = new NotesPresenter(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mFragmentNotesBinding = DataBindingUtil.inflate(inflater, getLayoutRes(), container, false);
        return mFragmentNotesBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mFragmentNotesBinding.setNotesPresenter(mNotesPresenter);
        mNotesPresenter.viewNotes();
    }

    @Override
    public void navigateToAddNewNotePage() {
        Toast.makeText(getActivity(), R.string.s_add_new_note, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void displayNotes(Note note) {
        mFragmentNotesBinding.setNote(note);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.fragment_notes;
    }
}
