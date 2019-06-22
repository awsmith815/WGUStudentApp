package com.awsmith815.wgustudentapp.viewmodel;

import android.app.Application;
import android.text.TextUtils;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.awsmith815.wgustudentapp.database.AppRepository;
import com.awsmith815.wgustudentapp.model.Term;

import java.util.Date;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class TermEditorViewModel extends AndroidViewModel {

    public MutableLiveData<Term> mLiveTerm = new MutableLiveData<>();
    private AppRepository mRepo;
    private Executor executor = Executors.newSingleThreadExecutor();

    public TermEditorViewModel(@NonNull Application application) {
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

    public void saveTerm(String termTitle, Date termStartDate, Date termEndDate) {
        Term term = mLiveTerm.getValue();
        if(term == null){
            if(TextUtils.isEmpty(termTitle.trim())){
                return;
            }
            term = new Term(termTitle.trim(),termStartDate,termEndDate);

        }else{
            term.setTermName(termTitle.trim());
            term.setTermStartDate(termStartDate);
            term.setTermEndDate(termEndDate);
        }
        mRepo.insertTerm(term);
    }

    public void deleteTerm() {
        mRepo.deleteTerm(mLiveTerm.getValue());
    }
}
