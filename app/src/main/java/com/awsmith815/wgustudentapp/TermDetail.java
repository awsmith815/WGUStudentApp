package com.awsmith815.wgustudentapp;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;

import com.awsmith815.wgustudentapp.database.AppRepository;
import com.awsmith815.wgustudentapp.model.Term;
import com.awsmith815.wgustudentapp.ui.TermListAdapter;
import com.awsmith815.wgustudentapp.viewmodel.TermDetailViewModel;
import com.awsmith815.wgustudentapp.viewmodel.TermEditorViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static com.awsmith815.wgustudentapp.util.Constants.TERM_ID_KEY;

public class TermDetail extends AppCompatActivity {

    private TextView termTitle;
    private TextView termStartDate;
    private TextView termEndDate;

    private boolean mNewTerm;
    private TermDetailViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_term_detail);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        termTitle = findViewById(R.id.termTitleDetail);
        termStartDate = findViewById(R.id.termStartDateDetail);
        termEndDate = findViewById(R.id.termEndDateDetail);
        assert termTitle != null;
        assert termStartDate != null;
        assert termEndDate != null;
        initViewModel();


    }

    private void initViewModel() {

        mViewModel = ViewModelProviders.of(this).get(TermDetailViewModel.class);
        mViewModel.mLiveTerm.observe(this, new Observer<Term>() {
            @Override
            public void onChanged(@Nullable Term term) {
                termTitle.setText(term.getTermName());
                termStartDate.setText(term.getTermStartDate().toString());
                termEndDate.setText(term.getTermEndDate().toString());
            }
        });
        Bundle extras = getIntent().getExtras();
        setTitle("Detail Term");
        int termId = extras.getInt(TERM_ID_KEY);
        mViewModel.loadData(termId);
    }

}
