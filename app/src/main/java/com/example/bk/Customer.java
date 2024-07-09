package com.example.bk;

import android.content.Context;
import android.widget.Toast;

import java.time.LocalDate;
import java.util.Map;

import lombok.Data;

@Data
public class Customer {
    private String name;
    private String index;
    private LocalDate bDate;
    private int course;
    private Context context;
    private String password;
    private Map<String, Integer> subjects;
    public Customer(String name, String index, LocalDate bDate, int course, String password) {
        if(name!=null||name.length()<1){
            this.name = name;
        }else{
            Toast toast = Toast.makeText(context, "Name is uncorrect!",Toast.LENGTH_LONG);
            toast.show();
        }
        if(index!=null){
            this.index = index;
        }else{
            Toast toast = Toast.makeText(context, "Index is uncorrect!",Toast.LENGTH_LONG);
            toast.show();
        }
        if(bDate!=null){
            this.bDate = bDate;
        }else{
            Toast toast = Toast.makeText(context, "Date is uncorrect!",Toast.LENGTH_LONG);
            toast.show();
        }
        if(course!=0){
            this.course = course;
        }else{
            Toast toast = Toast.makeText(context, "Number of course is uncorrect!",Toast.LENGTH_LONG);
            toast.show();
        }
        if(password.length()>=4){
            this.password=password;
        }else{
            Toast toast = Toast.makeText(context, "Number of course is uncorrect!",Toast.LENGTH_LONG);
            toast.show();
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public LocalDate getbDate() {
        return bDate;
    }

    public void setbDate(LocalDate bDate) {
        this.bDate = bDate;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public void setSubjects(Map<String, Integer> subjects) {
        this.subjects = subjects;
    }

    public Map<String, Integer> getSubjects() {
        return subjects;
    }
}
