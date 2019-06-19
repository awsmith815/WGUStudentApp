package com.awsmith815.wgustudentapp.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.awsmith815.wgustudentapp.database.AppRepo;
import com.awsmith815.wgustudentapp.model.Term;
import com.awsmith815.wgustudentapp.util.SampleTermData;

import java.util.List;

public class TermViewModel extends AndroidViewModel {

    public List<Term> mTerms;
    private AppRepo mRepo;


    public TermViewModel(@NonNull Application application) {
        super(application);

        mRepo = AppRepo.getInstance();
        mTerms = mRepo.mTerms;
    }
}
