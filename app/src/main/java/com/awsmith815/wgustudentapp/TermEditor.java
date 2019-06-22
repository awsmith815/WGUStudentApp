package com.awsmith815.wgustudentapp;

import android.content.Intent;
import android.os.Bundle;

import com.awsmith815.wgustudentapp.model.Term;
import com.awsmith815.wgustudentapp.viewmodel.TermEditorViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.view.View;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.awsmith815.wgustudentapp.util.Constants.TERM_ID_KEY;

public class TermEditor extends AppCompatActivity {

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

        FloatingActionButton fabSave = findViewById(R.id.fabSaveEditTerm);
        fabSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent termIntent = new Intent(getApplicationContext(), TermList.class);
                try {
                    saveAndReturn();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                startActivity(termIntent);
            }
        });

        FloatingActionButton fabDelete = findViewById(R.id.fabDeleteTerm);
        fabDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent termIntent = new Intent(getApplicationContext(), TermList.class);
                deleteAndReturn();
                startActivity(termIntent);
            }
        });

        editTermTitle = findViewById(R.id.editTermTitle);
        editTermStartDate = findViewById(R.id.editTermStartDate);
        editTermEndDate = findViewById(R.id.editTermEndDate);
        assert editTermTitle != null;
        assert editTermStartDate != null;
        assert editTermEndDate != null;
        initViewModel();


    }

    private void initViewModel() {
        mViewModel = ViewModelProviders.of(this).get(TermEditorViewModel.class);
        mViewModel.mLiveTerm.observe(this, new Observer<Term>() {
            @Override
            public void onChanged(@Nullable Term term) {
                DateFormat dateFormat = new SimpleDateFormat("MM/dd/YYYY");
                editTermTitle.setText(term.getTermName());
                editTermStartDate.setText(dateFormat.format(term.getTermStartDate()));
                editTermEndDate.setText(dateFormat.format(term.getTermEndDate()));
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

    private void saveAndReturn() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/YYYY");
        Date dateStart = dateFormat.parse(editTermStartDate.getText().toString());
        Date dateEnd = dateFormat.parse(editTermEndDate.getText().toString());
        mViewModel.saveTerm(editTermTitle.getText().toString(),dateStart, dateEnd);
        finish();
    }
    private void deleteAndReturn(){
        mViewModel.deleteTerm();
        finish();
    }

}
