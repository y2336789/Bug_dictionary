package com.bliss.csc.myapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    public String key = "20218f5922b84a6b4691db8472132ececb19";
    RecyclerView recyclerView;
    ArrayList<Virus> Virus = new ArrayList<>();
    MyAdapter adapter;

    String this_name, parse_name;

    TextView textView;
    String[] crop_names = {"사과", "복숭아", "배", "포도","밤"};
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }
}
