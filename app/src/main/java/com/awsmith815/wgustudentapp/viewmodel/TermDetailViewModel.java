package com.awsmith815.wgustudentapp.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.awsmith815.wgustudentapp.database.AppRepository;
import com.awsmith815.wgustudentapp.model.Term;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class TermDetailViewModel extends AndroidViewModel {

    public MutableLiveData<Term> mLiveTerm = new MutableLiveData<>();
    private AppRepository mRepo;
    private Executor executor = Executors.newSingleThreadExecutor();

    public TermDetailViewModel(@NonNull Application application) {
        super(application);
        mRepo = AppRepository.getInstance(getApplication());
    }

    public void loadData(final int termId) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                Term term = mRepo.getTermById(termId);
                mLiveTerm.postValue(term);
            }
        });
    }

}
