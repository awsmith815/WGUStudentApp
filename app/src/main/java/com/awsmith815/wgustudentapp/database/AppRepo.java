package com.awsmith815.wgustudentapp.database;

import com.awsmith815.wgustudentapp.model.Term;
import com.awsmith815.wgustudentapp.util.SampleTermData;

import java.util.List;

public class AppRepo {

    private static final AppRepo ourInstance = new AppRepo();

    public List<Term> mTerms;

    public static AppRepo getInstance() {
        return ourInstance;
    }

    private AppRepo() {
        mTerms = SampleTermData.getTerms();
    }
}
