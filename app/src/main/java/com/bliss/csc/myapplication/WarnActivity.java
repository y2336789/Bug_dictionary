package com.bliss.csc.myapplication;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class WarnActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    MyAdapter adapter;

    ArrayList<Bug> bugs = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_warn);

        recyclerView = findViewById(R.id.warn_recycler);

        adapter = new MyAdapter(bugs, this);
        recyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        addItem("열대거세거미나방", "옥수수","Spodoptera",
                "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/spcs/&imageFileName=열거세미나방 성충 사진_숫컷[20190710132552364]_wm.jpg",
                "H00000651");
        addItem("혹명나방", "논벼","Cnaphalocrocis",
                "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/spcs/&imageFileName=ZR1EL0063M001[20110106120000000]_wm.jpg",
                "H00000463");

    }
    private void addItem(String Name, String CropName, String Sepecies, String ImgUrl, String InsectKey){
        Bug bug = new Bug();

        bug.setName(Name);
        bug.setCropName(CropName);
        bug.setSpecies(Sepecies);
        bug.setImgUrl(ImgUrl);
        bug.setInsectKey(InsectKey);
        bugs.add(bug);
    }
}