package com.awsmith815.wgustudentapp.ui;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.awsmith815.wgustudentapp.R;
import com.awsmith815.wgustudentapp.TermDetail;
import com.awsmith815.wgustudentapp.TermEditor;
import com.awsmith815.wgustudentapp.model.Term;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import static com.awsmith815.wgustudentapp.util.Constants.TERM_ID_KEY;

public class TermListAdapter extends RecyclerView.Adapter<TermListAdapter.ViewHolder> {

    private final List<Term> mTerms;
    private final Context mContext;

    public TermListAdapter(List<Term> mTerms, Context mContext) {
        this.mTerms = mTerms;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflator = LayoutInflater.from(parent.getContext());
        View view = inflator.inflate(R.layout.term_list_item,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Term term = mTerms.get(position);
        holder.mTextView.setText(term.getTermName());

        holder.mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, TermDetail.class);
                intent.putExtra(TERM_ID_KEY, term.getTermId());
                mContext.startActivity(intent);
            }
        });
        holder.mFabEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, TermEditor.class);
                intent.putExtra(TERM_ID_KEY, term.getTermId());
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mTerms.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView mTextView;
        FloatingActionButton mFab;
        FloatingActionButton mFabEdit;
        FloatingActionButton mFabCourse;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextView = itemView.findViewById(R.id.txtTerm);
            mFab = itemView.findViewById(R.id.fabDetailedViewTermList);
            mFabEdit = itemView.findViewById(R.id.fabEditTermList);

        }
    }
}
