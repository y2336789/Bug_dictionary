package com.bliss.csc.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class OldCautionActivity extends AppCompatActivity {

    RecyclerView recyclerView, recyclerView2, recyclerView3;
    MyAdapter adapter, adapter2, adapter3;

    ArrayList<Bug> bugs = new ArrayList<>();
    ArrayList<Bug> bugs_2 = new ArrayList<>();
    ArrayList<Bug> bugs_3 = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_old_caution);

        String[] year_list = {"2020","2019"};

        Spinner spinner =findViewById(R.id.year_select);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_dropdown_item, year_list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                readYear(year_list[position]);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }
    void readYear(String year) {
        bugs.clear();
        bugs_2.clear();
        bugs_3.clear();
        if (year.equals("2020")) {
            // 식량작물
            recyclerView = findViewById(R.id.year_recycler);

            adapter = new MyAdapter(bugs, this);
            recyclerView.setAdapter(adapter);

            LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
            recyclerView.setLayoutManager(layoutManager);

            addItem("벼멸구", "논벼","Nilaparvata",
                    "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/spcs/&imageFileName=ZM1AZ0035M006[20110106120000000]_wm.jpg",
                    "H00000350");
            addItem("흰등멸구", "논벼","Sogatella",
                    "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/spcs/&imageFileName=흰등멸구 성충[20161128103908286]_wm.jpg",
                    "H00000351");
            addItem("열대거세거미나방", "옥수수","Spodoptera",
                    "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/spcs/&imageFileName=열거세미나방 성충 사진_숫컷[20190710132552364]_wm.jpg",
                    "H00000651");
            addItem("혹명나방", "논벼","Cnaphalocrocis",
                    "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/spcs/&imageFileName=ZR1EL0063M001[20110106120000000]_wm.jpg",
                    "H00000463");
            addItem("먹노린재", "논벼", "Scotinophara",
                    "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/spcs/&imageFileName=ZL1BX0069M001[20110106120000000]_wm.jpg",
                    "H00000293");
            // 채 소
            recyclerView2 = findViewById(R.id.year_recycler_2);

            adapter2 = new MyAdapter(bugs_2, this);
            recyclerView2.setAdapter(adapter2);

            LinearLayoutManager layoutManager2 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
            recyclerView2.setLayoutManager(layoutManager2);

            addItem2("담배나방", "고추", "Helicoverpa",
                    "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/spcs/&imageFileName=ZR1DS0057M001[20110106120000000]_wm.jpg",
                    "H00000411");

            // 과 수
            recyclerView3 = findViewById(R.id.year_recycler_3);

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
        } else if(year.equals("2019")){
            recyclerView = findViewById(R.id.year_recycler);

            adapter = new MyAdapter(bugs, this);
            recyclerView.setAdapter(adapter);

            LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
            recyclerView.setLayoutManager(layoutManager);

            addItem("먹노린재", "논벼", "Scotinophara",
                    "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/spcs/&imageFileName=ZL1BX0069M001[20110106120000000]_wm.jpg",
                    "H00000293");
            recyclerView2 = findViewById(R.id.year_recycler_2);

            adapter2 = new MyAdapter(bugs_2, this);
            recyclerView2.setAdapter(adapter2);

            LinearLayoutManager layoutManager2 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
            recyclerView2.setLayoutManager(layoutManager2);

            // 여기에 addItem2 작성

            recyclerView3 = findViewById(R.id.year_recycler_3);

            adapter3 = new MyAdapter(bugs_3, this);
            recyclerView3.setAdapter(adapter3);

            LinearLayoutManager layoutManager3 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
            recyclerView3.setLayoutManager(layoutManager3);

            // 여기에 addItem3 작성
        }
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
