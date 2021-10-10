package com.example.recyclerview;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder> {
    private ArrayList<TestObject> mWordList;
    private LayoutInflater inflater;
    private Context context;
    public WordListAdapter(Context context, ArrayList<TestObject> wordList){
        this.mWordList = wordList;
        inflater = LayoutInflater.from(context);
        this.context = context;
    }
    public class WordViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public final TextView wordItemView;
        public final TextView numberItemView;
        public final TextView colorItemView;
        final WordListAdapter mAdapter;
        public WordViewHolder(View itemView, WordListAdapter adapter){
            super(itemView);
            wordItemView = itemView.findViewById(R.id.word);
            numberItemView = itemView.findViewById(R.id.number);
            colorItemView = itemView.findViewById(R.id.color);
            this.mAdapter = adapter;
            itemView.setOnClickListener(this);
        }

        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        @Override
        public void onClick(View v) {
            TestObject element = mWordList.get(getLayoutPosition());
            mWordList.get(getLayoutPosition()).setText("Clicked  element: " + element.getNumber());
            mAdapter.notifyDataSetChanged();
            Intent intent  = new Intent(context, ClickedActivity.class);
            intent.putExtra(Intent.EXTRA_COMPONENT_NAME, "Activity for element: "  + element.getNumber());
            context.startActivity(intent, ActivityOptions.makeSceneTransitionAnimation((Activity) context).toBundle());
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
        holder.colorItemView.setText("Example Date " + number + " / " + number);
        int[] colors = context.getResources().getIntArray(R.array.rainbow);
        int rando = new Random().nextInt(colors.length);

      holder.colorItemView.setBackgroundColor(colors[rando]);
      holder.colorItemView.getBackground().setAlpha(126);
    }

    @Override
    public int getItemCount() {
        return mWordList.size();
    }
}
