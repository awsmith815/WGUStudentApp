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
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class TermList extends AppCompatActivity {

    private List<Term> termsData = new ArrayList<>();
    private TermListAdapter mAdapter;

    private TermViewModel mViewModel;
    private RecyclerView termList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_term_list);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        termList = findViewById(R.id.recyclerViewTermList);
        assert termList != null;
        initTermList(termList);
        initViewModel();


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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_add_sample_data) {
            addSampleData();
            return true;
        }else if(id == R.id.action_delete_all){
            deleteAllNotes();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void deleteAllNotes() {
        mViewModel.deleteAllNotes();
    }

    private void initViewModel() {
        final Observer<List<Term>> termObserver = new Observer<List<Term>>() {
            @Override
            public void onChanged(List<Term> terms) {
                termsData.clear();
                termsData.addAll(terms);

                if(mAdapter==null){
                    mAdapter = new TermListAdapter(termsData, TermList.this);
                    termList.setAdapter(mAdapter);
                }else{
                    mAdapter.notifyDataSetChanged();
                }

            }
        };

        mViewModel = ViewModelProviders.of(this).get(TermViewModel.class);
        mViewModel.mTerms.observe(this, termObserver);
    }

    private void initTermList(RecyclerView termList) {
        termList.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        termList.setLayoutManager(layoutManager);

        mAdapter = new TermListAdapter(termsData, this);
        termList.setAdapter(mAdapter);
    }

    private void addSampleData(){
        mViewModel.addSampleData();
        for(Term terms : termsData){
            Log.i("SQLTerms", terms.toString());
        }
    }

}
