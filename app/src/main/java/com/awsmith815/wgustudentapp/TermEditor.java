package com.awsmith815.wgustudentapp;

import android.os.Bundle;

import com.awsmith815.wgustudentapp.model.Term;
import com.awsmith815.wgustudentapp.viewmodel.TermEditorViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.view.View;
import android.widget.TextView;

public class TermEditor extends AppCompatActivity {

    private static final String TERM_ID_KEY = ;
    private TextView editTermTitle;
    private TextView editTermStartDate;
    private TextView editTermEndDate;

    private TermEditorViewModel mViewModel;
    private boolean mNewTerm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_term_editor);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fabEditTerm);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        editTermTitle = findViewById(R.id.editTermTitle);
        assert editTermTitle != null;

        /*
        termList = findViewById(R.id.recyclerViewTermList);
        assert termList != null;
        initTermList(termList);
        */

        initViewModel();
    }

    private void initViewModel() {
        mViewModel = ViewModelProviders.of(this).get(TermEditorViewModel.class);
        mViewModel.mLiveTerm.observe(this, new Observer<Term>() {
            @Override
            public void onChanged(Term term) {
                editTermTitle.setText(term.getTermName());
            }
        });

        Bundle extras = getIntent().getExtras();
        if(extras==null){
            setTitle("New Term");
            mNewTerm = true;
        }else{
            setTitle("Edit Term");
            int termId = extras.getInt(TERM_ID_KEY);
            mViewModel.loadData(termId);
        }
    }

}
