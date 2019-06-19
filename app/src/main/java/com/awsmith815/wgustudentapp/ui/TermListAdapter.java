package com.awsmith815.wgustudentapp.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.awsmith815.wgustudentapp.R;
import com.awsmith815.wgustudentapp.TermList;
import com.awsmith815.wgustudentapp.model.Term;

import java.util.List;

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
    }

    @Override
    public int getItemCount() {
        return mTerms.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView mTextView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextView = itemView.findViewById(R.id.txtTerm);
        }
    }
}
