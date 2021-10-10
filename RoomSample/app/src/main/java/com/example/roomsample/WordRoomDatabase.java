package com.example.roomsample;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Word.class}, version = 1, exportSchema = false)
public abstract class WordRoomDatabase extends RoomDatabase {

    private static WordRoomDatabase INSTANCE;

    public static WordRoomDatabase getDatabase(final Context context){
        if(INSTANCE == null){
            synchronized (WordRoomDatabase.class){
                if(INSTANCE == null){
                    Room.databaseBuilder(context.getApplicationContext(), WordRoomDatabase.class, "word_database").fallbackToDestructiveMigration().addCallback(sRoomDatabaseCallback).build();
                }
            }
        }
        return INSTANCE;
    }
    public abstract WordDao wordDao();

    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback(){

        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db){
            super.onOpen((db));
            new PopulateDbAsync(INSTANCE).execute();
        }
    };
    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void>{
        private final WordDao dao;
        String[] words = {"dolphin", "crocodile", "cobra"};

        PopulateDbAsync(WordRoomDatabase db){
            dao = db.wordDao();
        }

        @Override
        protected Void doInBackground(final Void...params) {
            if(dao.getAllWords() == null){
                for(int i =0; i <words.length; i++){
                    dao.insert(new Word(words[i]));
                }
            }
            return null;
        }
    }

}
