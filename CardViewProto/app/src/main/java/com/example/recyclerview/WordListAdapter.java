package com.example.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.LinkedList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder> {
    private LinkedList<TestObject> mWordList;
    private LayoutInflater inflater;
    private Context context;
    private String[] colors = context.getResources().getStringArray(R.array.rainbow);
    public WordListAdapter(Context context, LinkedList<TestObject> wordList){
        this.mWordList = wordList;
        inflater = LayoutInflater.from(context);
        this.context = context;
    }
    public class WordViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public final TextView wordItemView;
        public final TextView numberItemView;
        final WordListAdapter mAdapter;
        public WordViewHolder(View itemView, WordListAdapter adapter){
            super(itemView);
            wordItemView = itemView.findViewById(R.id.word);
            numberItemView = itemView.findViewById(R.id.number);
            this.mAdapter = adapter;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            TestObject element = mWordList.get(getLayoutPosition());
            mWordList.get(getLayoutPosition()).setText("Clicked  element: " + element.getNumber());
            mAdapter.notifyDataSetChanged();
            Intent intent  = new Intent(context, ClickedActivity.class);
            intent.putExtra(Intent.EXTRA_COMPONENT_NAME, "Activity for element: "  + element.getNumber());
            context.startActivity(intent);
        }
    }
    @NonNull
    @Override
    public WordListAdapter.WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = inflater.inflate(R.layout.wordlist_item, parent, false);

        return new WordViewHolder(mItemView, this);

    }

    @Override
    public void onBindViewHolder(@NonNull WordListAdapter.WordViewHolder holder, int position) {
        String mCurrent = mWordList.get(position).getText();
        String number = "" + mWordList.get(position).getNumber();
        holder.wordItemView.setText(mCurrent);
        holder.numberItemView.setText(number);
    }

    @Override
    public int getItemCount() {
        return mWordList.size();
    }
}
