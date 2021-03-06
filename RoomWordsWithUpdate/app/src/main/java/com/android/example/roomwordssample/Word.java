/*
 * Copyright (C) 2018 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.example.roomwordssample;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * Entity class that represents a word in the database
 */

@Entity(tableName = "word_table")
public class Word {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @NonNull
    @ColumnInfo(name = "word")
    private String mWord;

    @NonNull
    @ColumnInfo(name = "date")
    private String mDate;
    public Word(@NonNull String word, @NonNull String date) {
        this.mWord = word;
        this.mDate = date;
    }

    /*
    * This constructor is annotated using @Ignore, because Room expects only
    * one constructor by default in an entity class.
    */

    @Ignore
    public Word(int id, @NonNull String word, @NonNull String date) {
        this.id = id;
        this.mWord = word;
        this.mDate = date;
    }

    public String getWord() {
        return this.mWord;
    }

    public String getDate(){
        return mDate;
    }

    public int getId() {return id;}

    public void setId(int id) {
        this.id = id;
    }
}
