package com.awsmith815.wgustudentapp;

import android.content.Intent;
import android.os.Bundle;

import com.awsmith815.wgustudentapp.model.Term;
import com.awsmith815.wgustudentapp.ui.TermListAdapter;
import com.awsmith815.wgustudentapp.util.SampleTermData;
import com.awsmith815.wgustudentapp.viewmodel.TermViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class TermList extends AppCompatActivity {

    private List<Term> termsData = new ArrayList<>();
    private TermListAdapter mAdapter;

    private TermViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_term_list);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        RecyclerView termList = findViewById(R.id.recyclerViewTermList);
        initViewModel();
        assert termList != null;
        initTermList(termList);

        termsData.addAll(mViewModel.mTerms);
        for(Term terms : termsData){
            Log.i("PlainTermsTest", terms.toString());
        }


        FloatingActionButton fab = findViewById(R.id.fabAddTerm);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent termIntent = new Intent(getApplicationContext(), TermEditor.class);
                startActivity(termIntent);

                /**
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                */
            }
        });


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void initViewModel() {
        mViewModel = ViewModelProviders.of(this).get(TermViewModel.class);
    }

    private void initTermList(RecyclerView termList) {
        termList.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        termList.setLayoutManager(layoutManager);

        mAdapter = new TermListAdapter(termsData, this);
        termList.setAdapter(mAdapter);
    }

}
