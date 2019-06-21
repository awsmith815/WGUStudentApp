package com.awsmith815.wgustudentapp.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.awsmith815.wgustudentapp.database.AppRepository;
import com.awsmith815.wgustudentapp.model.Term;

import java.util.List;

public class TermViewModel extends AndroidViewModel {

    public LiveData<List<Term>> mTerms;
    private AppRepository mRepo;


    public TermViewModel(@NonNull Application application) {
        super(application);

        mRepo = AppRepository.getInstance(application.getApplicationContext());
        mTerms = mRepo.mTerms;
    }

    public void addSampleData() {
        mRepo.addSampleData();
    }

    public void deleteAllNotes() {
        mRepo.deleteAllNotes();
    }
}
