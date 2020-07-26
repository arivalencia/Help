package com.example.help.pojo;

import java.util.ArrayList;

public class CardHelp {
    private String title;
    private String description;
    private ArrayList<String> list = new ArrayList<>();
    private ArrayList<String> text = new ArrayList<>();

    public CardHelp(String title, String description, String[] list, String[] text) {
        this.title = title;
        this.description = description;
        for (String element: list){
            this.list.add(element);
        }
        for (String element: text) {
            this.text.add(element);
        }
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public ArrayList<String> getAllList() {
        return list;
    }

    public ArrayList<String> getAllText() {
        return text;
    }

    public String getOfList(int index) {
        return list.get(index);
    }

    public String getOfText(int index) {
        return text.get(index);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setList(String list) {
        this.list.add(list);
    }

    public void setText(String text) {
        this.text.add(text);
    }
}
