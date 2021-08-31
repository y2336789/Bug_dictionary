package com.bliss.csc.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class WarnActivity extends AppCompatActivity {

    RecyclerView recyclerView, recyclerView2, recyclerView3;
    MyAdapter adapter, adapter2, adapter3;
    VirusAdapter virusAdapter, virusAdapter2, virusAdapter3;
    Button button, button1;

    int num = 0;

    ArrayList<Bug> bugs = new ArrayList<>();
    ArrayList<Bug> bugs_2 = new ArrayList<>();
    ArrayList<Bug> bugs_3 = new ArrayList<>();
    ArrayList<Virus> virus_1 = new ArrayList<>();
    ArrayList<Virus> virus_2 = new ArrayList<>();
    ArrayList<Virus> virus_3 = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_warn);

        button = findViewById(R.id.warning_old);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent3 = new Intent(WarnActivity.this, );
//                startActivity(intent3);
            }
        });

        button1 = findViewById(R.id.w_change);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(num==0){
                    num = 1;
//                    changeView();
                    button1.setText("해충 리스트로 전환");
                }else if(num ==1){
                    num = 0;
//                    originalView();
                    button1.setText("병 리스트로 전환");
                }

            }
        });
        // 식량작물
        recyclerView = findViewById(R.id.warning_recycler);

        adapter = new MyAdapter(bugs, this);
        recyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);

        addItem("먹노린재", "논벼", "lurida",
                "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/hlsct/&imageFileName=ZL1BX0069E001[20110113150000000]_tmb.jpg",
                "H00000293");
        addItem("벼멸구", "논벼", "lugens",
                "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/hlsct/&imageFileName=벼멸구[20161110104656353]_tmb.jpg",
                "H00000350");
        addItem("혹명나방", "논벼", "medinalis",
                "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/hlsct/&imageFileName=ZR1EL0063E001[20110113150000000]_tmb.jpg",
                "H00000463");
        addItem("흰등멸구", "논벼", "furcifera",
                "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/hlsct/&imageFileName=ZM1AZ0041E001[20110113150000000]_tmb.jpg",
                "H00000351");
        addItem("열대거세미나방", "옥수수", "frugiperda",
                "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/hlsct/&imageFileName=열대거세미나방 피해 2[20190710135438567]_tmb.jpg",
                "H00000651");


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