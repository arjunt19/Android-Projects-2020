package com.example.recyclerview;

public class TestObject {
    private int number;
    private String text;
    public TestObject(int number, String text){
        this.number = number;
        this.text = text;
    }
    public String getText(){
        return text;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setText(String text) {
        this.text = text;
    }
}
