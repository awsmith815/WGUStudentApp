package com.awsmith815.wgustudentapp.database;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;

import com.awsmith815.wgustudentapp.model.Course;
import com.awsmith815.wgustudentapp.model.Term;
import com.awsmith815.wgustudentapp.util.SampleTermData;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class AppRepository {

    private static AppRepository ourInstance;

    public LiveData<List<Term>> mTerms;
    private AppDatabase mDb;
    private Executor executor = Executors.newSingleThreadExecutor();

    public static AppRepository getInstance(Context context) {
        if(ourInstance == null){
            ourInstance = new AppRepository(context);
        }

        return ourInstance;
    }

    private AppRepository(Context context) {
        mDb = AppDatabase.getInstance(context);
        mTerms = getAllTerms();
    }

    public void addSampleData() {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                mDb.termDAO().insertAll(SampleTermData.getTerms());
            }
        });
    }
    private LiveData<List<Term>> getAllTerms(){
        return mDb.termDAO().getAllTerms();
    }

    public void deleteAllTerms() {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                mDb.termDAO().deleteAllTerms();
            }
        });
    }

    public Term getTermById(int termId) {
        return mDb.termDAO().getTermById(termId);
    }

    public void insertTerm(final Term term) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                mDb.termDAO().insertTerm(term);
            }
        });
    }

    public void deleteTerm(final Term term) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                mDb.termDAO().deleteTerm(term);
            }
        });
    }

    public Course getCourseByTermId(int courseTermId) {
        return mDb.courseDAO().getCourseByTermId(courseTermId);
    }
}
