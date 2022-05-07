package ru.netology.javacore;

import java.util.*;


public class Todos {
    private List<String> list = new ArrayList<>();
    private String type;
    private String task;

    public String getType(){
        return type;
    }

    public String getTask() {
        return task;
    }

    public List<String> getList(){
        return list;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public void addTask(String task) {
        list.add(task);
    }

    public void removeTask(String task) {
        list.remove(task);
    }

    public String getAllTasks() {
        //...
        StringBuilder builder = new StringBuilder();
        Collections.sort(list);
        for (String task : list) {
            builder.append(task + " ");
        }
        return builder.toString();
    }


}
