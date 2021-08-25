package com.bliss.csc.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CautionActivity extends AppCompatActivity {

    RecyclerView recyclerView, recyclerView2, recyclerView3;
    MyAdapter adapter, adapter2, adapter3;
    Button button;

    ArrayList<Bug> bugs = new ArrayList<>();
    ArrayList<Bug> bugs_2 = new ArrayList<>();
    ArrayList<Bug> bugs_3 = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caution);

        button = findViewById(R.id.caution_old);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(CautionActivity.this, OldCautionActivity.class);
                startActivity(intent3);
            }
        });
        // 식량작물
        recyclerView = findViewById(R.id.caution_recycler);

        adapter = new MyAdapter(bugs, this);
        recyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);

        addItem("열대거세거미나방", "옥수수","Spodoptera",
                "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/spcs/&imageFileName=열거세미나방 성충 사진_숫컷[20190710132552364]_wm.jpg",
                "H00000651");
        addItem("멸강나방", "옥수수","Pseudaletia",
                "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/spcs/&imageFileName=ZR1DS0188M001[20110106120000000]_wm.jpg",
                "H00000419");
        addItem("먹노린재", "논벼", "Scotinophara",
                "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/spcs/&imageFileName=ZL1BX0069M001[20110106120000000]_wm.jpg",
                "H00000293");
        // 채 소
        recyclerView2 = findViewById(R.id.caution_recycler_2);

        adapter2 = new MyAdapter(bugs_2, this);
        recyclerView2.setAdapter(adapter2);

        LinearLayoutManager layoutManager2 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView2.setLayoutManager(layoutManager2);

        addItem2("담배나방", "고추", "Helicoverpa",
                "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/spcs/&imageFileName=ZR1DS0057M001[20110106120000000]_wm.jpg",
                "H00000411");
        // 과 수
        recyclerView3 = findViewById(R.id.caution_recycler_3);

        adapter3 = new MyAdapter(bugs_3, this);
        recyclerView3.setAdapter(adapter3);

        LinearLayoutManager layoutManager3 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView3.setLayoutManager(layoutManager3);

        addItem3("복숭아심식나방", "복숭아", "Carposina",
                "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/spcs/&imageFileName=ZR1AY0002M001[201010210000000]_wm.jpg",
                "H00000386");
        addItem3("복숭아순나방", "복숭아", "Grapholita",
                "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/spcs/&imageFileName=ZR1FF0131M001[201010210000000]_wm.jpg",
                "H00000477");
        addItem3("갈색날개매미충", "복숭아", "Ricania",
                "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/spcs/&imageFileName=갈색날개매미충 성충_9월1[20170525131100977]_wm.jpg",
                "H00000646");
        addItem3("미국선녀벌레", "감", "Metcalfa",
                "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/spcs/&imageFileName=미국선녀벌레 성충_8월1[20170525163825037]_wm.jpg",
                "H00000609");
        addItem3("꽃매미", "포도", "Lycorma",
                "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/spcs/&imageFileName=ZM1BI0002M001[20110106120000000]_wm.jpg",
                "H00000361");

   }
    private void addItem(String Name, String CropName, String species, String ImgUrl, String InsectKey){
        Bug bug = new Bug();

        bug.setName(Name);
        bug.setCropName(CropName);
        bug.setSpecies(species);
        bug.setImgUrl(ImgUrl);
        bug.setInsectKey(InsectKey);
        bugs.add(bug);
    }
    private void addItem2(String Name, String CropName, String species, String ImgUrl, String InsectKey){
        Bug bug = new Bug();

        bug.setName(Name);
        bug.setCropName(CropName);
        bug.setSpecies(species);
        bug.setImgUrl(ImgUrl);
        bug.setInsectKey(InsectKey);
        bugs_2.add(bug);
    }
    private void addItem3(String Name, String CropName, String species, String ImgUrl, String InsectKey){
        Bug bug = new Bug();

        bug.setName(Name);
        bug.setCropName(CropName);
        bug.setSpecies(species);
        bug.setImgUrl(ImgUrl);
        bug.setInsectKey(InsectKey);
        bugs_3.add(bug);
    }
}
