package com.awsmith815.wgustudentapp;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import androidx.room.Room;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.runner.AndroidJUnit4;

import com.awsmith815.wgustudentapp.database.AppDatabase;
import com.awsmith815.wgustudentapp.database.TermDAO;
import com.awsmith815.wgustudentapp.model.Term;
import com.awsmith815.wgustudentapp.util.SampleTermData;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class DatabaseTest {

    public static final String TAG = "Junit";
    private AppDatabase mDb;
    private TermDAO mDao;


    @Before
    public void createDb(){
        Context context = InstrumentationRegistry.getInstrumentation().getTargetContext();
        mDb = Room.inMemoryDatabaseBuilder(context, AppDatabase.class).build();
        mDao = mDb.termDAO();
        Log.i(TAG, "createDb");
    }

    @After
    public void closeDb(){
        mDb.close();
        Log.i(TAG, "closeDb");
    }

    @Test
    public void createAndRetrieveNotes(){
        mDao.insertAll(SampleTermData.getTerms());
        int count = mDao.getCountTerms();
        Log.i(TAG, "createAndRetrieveNotes: count= " + count);
        assertEquals(SampleTermData.getTerms().size(), count);
    }

    @Test
    public void compareStrings(){
        mDao.insertAll(SampleTermData.getTerms());
        Term original = SampleTermData.getTerms().get(0);
        Term fromDb = mDao.getTermById(1);
        assertEquals(original.getTermName(), fromDb.getTermName());
        assertEquals(1, fromDb.getTermId());

    }



}
