package com.awsmith815.wgustudentapp.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.awsmith815.wgustudentapp.model.Term;

import java.util.List;

@Dao
public interface TermDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertTerm(Term terms);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Term> termsList);

    @Delete
    void deleteTerm(Term terms);

    @Query("SELECT * FROM Term WHERE termId = :id")
    Term getTermById(int id);

    @Query("SELECT * FROM term ORDER BY termStartDate DESC")
    LiveData<List<Term>> getAllTerms();

    @Query("DELETE FROM term")
    int deleteAllTerms();

    @Query("SELECT COUNT(*) FROM term")
    int getCountTerms();

}
