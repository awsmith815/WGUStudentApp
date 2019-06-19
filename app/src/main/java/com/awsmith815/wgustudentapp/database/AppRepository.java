package com.awsmith815.wgustudentapp.database;

import android.content.Context;

import com.awsmith815.wgustudentapp.model.Term;
import com.awsmith815.wgustudentapp.util.SampleTermData;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class AppRepository {

    private static AppRepository ourInstance;

    public List<Term> mTerms;
    private AppDatabase mDb;
    private Executor executor = Executors.newSingleThreadExecutor();

    public static AppRepository getInstance(Context context) {
        if(ourInstance == null){
            ourInstance = new AppRepository(context);
        }

        return ourInstance;
    }

    private AppRepository(Context context) {
        mTerms = SampleTermData.getTerms();
        mDb = AppDatabase.getInstance(context);
    }

    public void addSampleData() {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                mDb.termDAO().insertAll(SampleTermData.getTerms());
            }
        });
    }
}
