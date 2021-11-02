package com.forfarmers.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.forfarmers.myapplication.R;

import java.util.ArrayList;

public class CautionActivity extends AppCompatActivity {

    RecyclerView recyclerView, recyclerView2, recyclerView3;
    BugAdapter adapter, adapter2, adapter3;
    VirusAdapter virusAdapter, virusAdapter2, virusAdapter3;
    Button button, button1;
    ImageButton btn;
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
        setContentView(R.layout.activity_caution);

        button = findViewById(R.id.caution_old);
        btn=(ImageButton)findViewById(R.id.warning_btn2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(CautionActivity.this, OldCautionActivity.class);
                startActivity(intent3);
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentchange = new Intent(CautionActivity.this, WarnActivity.class);
                startActivity(intentchange);
            }
        });

        button1 = findViewById(R.id.change);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(num==0){
                    num = 1;
                    changeView();
                    button1.setText("해충 리스트로 전환");
                }else if(num ==1){
                    num = 0;
                    originalView();
                    button1.setText("병 리스트로 전환");
                }

            }
        });
        // 식량작물
        recyclerView = findViewById(R.id.caution_recycler);

        adapter = new BugAdapter(bugs, this);
        recyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);

//        addItem("열대거세거미나방", "옥수수","Spodoptera",
//                "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/spcs/&imageFileName=열거세미나방 성충 사진_숫컷[20190710132552364]_wm.jpg",
//                "H00000651");
//        addItem("멸강나방", "옥수수","Pseudaletia",
//                "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/spcs/&imageFileName=ZR1DS0188M001[20110106120000000]_wm.jpg",
//                "H00000419");
//        addItem("먹노린재", "논벼", "Scotinophara",
//                "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/spcs/&imageFileName=ZL1BX0069M001[20110106120000000]_wm.jpg",
//                "H00000293");

        // 채 소
        recyclerView2 = findViewById(R.id.caution_recycler_2);

        adapter2 = new BugAdapter(bugs_2, this);
        recyclerView2.setAdapter(adapter2);

        LinearLayoutManager layoutManager2 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView2.setLayoutManager(layoutManager2);

        // 과 수
        recyclerView3 = findViewById(R.id.caution_recycler_3);

        adapter3 = new BugAdapter(bugs_3, this);
        recyclerView3.setAdapter(adapter3);

        LinearLayoutManager layoutManager3 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView3.setLayoutManager(layoutManager3);

        addItem3("복숭아심식나방", "복숭아", "Carposina",
                "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/spcs/&imageFileName=ZR1AY0002M001[201010210000000]_wm.jpg",
                "H00000386");
        addItem3("복숭아순나방", "복숭아", "Grapholita",
                "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/spcs/&imageFileName=ZR1FF0131M001[201010210000000]_wm.jpg",
                "H00000477");
        addItem3("복숭아심식나방", "사과", "Carposina",
                "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/spcs/&imageFileName=ZR1AY0002M001[201010210000000]_wm.jpg",
                "H00000242");
        addItem3("복숭아순나방", "사과", "Grapholita",
                "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/spcs/&imageFileName=ZR1FF0131M001[201010210000000]_wm.jpg",
                "H00000233");
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
    private void changeView(){
        // 식량작물
        virusAdapter = new VirusAdapter(virus_1, this);
        recyclerView.setAdapter(virusAdapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);

//        v_addItem1()

        // 채 소
        virusAdapter2 = new VirusAdapter(virus_2, this);
        recyclerView2.setAdapter(virusAdapter2);

        LinearLayoutManager layoutManager2 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView2.setLayoutManager(layoutManager2);

        v_addItem2("역병", "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/sickns/&imageFileName=D00000018003[201010190000000]_tmb.jpg",
                "가지","D00000018");
        v_addItem2("역병", "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/sickns/&imageFileName=D00000198003[201010190000000]_tmb.jpg",
                "고추", "D00000198");
        v_addItem2("탄저병", "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/sickns/&imageFileName=고추_병_탄저병_열매_피해증상_4[20210111164102868]_tmb.jpg",
                "고추", "D00000195");
        v_addItem2("역병", "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/sickns/&imageFileName=img_0925_222[20160805153144502]_tmb.jpg",
                "딸기", "D00000452");
        v_addItem2("역병", "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/sickns/&imageFileName=D00000717002[201010190000000]_tmb.jpg",
                "배추", "D00000717");
        v_addItem2("역병", "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/sickns/&imageFileName=img_0925_214[20160805160142478]_tmb.jpg",
                "시금치", "D00001055");
        v_addItem2("모자이크병", "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/sickns/&imageFileName=D00001152004[201010190000000]_tmb.jpg",
                "오이", "D00001152");
        v_addItem2("역병","http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/sickns/&imageFileName=D00001165002[201010190000000]_tmb.jpg",
                "오이","D00001165");
        v_addItem2("반점위조바이러스","http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/sickns/&imageFileName=토마토_토마토 초기 신초 괴사_1[20180404133301218]_tmb.jpg",
                "토마토", "D00004251");

        // 과수
        virusAdapter3 = new VirusAdapter(virus_3, this);
        recyclerView3.setAdapter(virusAdapter3);

        LinearLayoutManager layoutManager3 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView3.setLayoutManager(layoutManager3);

        v_addItem3("탄저병", "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/sickns/&imageFileName=img_5001_01[20161025173500308]_tmb.jpg",
                "감", "D00004161");
        v_addItem3("탄저병", "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/sickns/&imageFileName=D00000042001[201010190000000]_tmb.jpg",
                "감귤", "D00000042");
        v_addItem3("과수화상병", "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/sickns/&imageFileName=화상병_가지[20161013105850274]_tmb.jpg",
                "배","D00000678");
        v_addItem3("탄저병", "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/sickns/&imageFileName=D00000711002[201010190000000]_tmb.jpg",
                "배", "D00000664");
        v_addItem3("탄저병", "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/sickns/&imageFileName=복숭아-곰팡이병-탄저병-과실6[20210113142841092]_tmb.jpg",
                "복숭아", "D00004192");
        v_addItem3("탄저병", "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/sickns/&imageFileName=블루베리_열매에 발생된 탄저병 병징[20190109135733710]_tmb.jpg",
                "블루베리", "D00004276");
        v_addItem3("가지검은마름병", "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/sickns/&imageFileName=사과_가지검은마름병_개화직후의 증상[20151112120215254]_tmb.jpg",
                "사과", "D00004075");
        v_addItem3("과수화상병", "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/sickns/&imageFileName=화상병가지병징1[20180502182014096]_tmb.jpg",
                "사과", "D00000924");
        v_addItem3("탄저병", "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/sickns/&imageFileName=사과-곰팡이병-탄저병-과실5[20210113145720311]_tmb.jpg",
                "사과","D00000884");
        v_addItem3("탄저병", "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/sickns/&imageFileName=포도_병_탄저병_열매_피해증상_4[20210113103203287]_tmb.jpg",
                "포도", "D00004218");
    }
    private void originalView(){
        adapter = new BugAdapter(bugs, this);
        recyclerView.setAdapter(adapter);

        adapter2 = new BugAdapter(bugs_2, this);
        recyclerView2.setAdapter(adapter2);

        adapter3 = new BugAdapter(bugs_3, this);
        recyclerView3.setAdapter(adapter3);

    }
    private void v_addItem1(String name, String imgUrl, String target, String virusKey) {
        Virus virus = new Virus();

        virus.setName(name);
        virus.setImgUrl(imgUrl);
        virus.setTarget(target);
        virus.setVirusKey(virusKey);
        virus_1.add(virus);
    }
    private void v_addItem2(String name, String imgUrl, String target, String virusKey) {
        Virus virus = new Virus();

        virus.setName(name);
        virus.setImgUrl(imgUrl);
        virus.setTarget(target);
        virus.setVirusKey(virusKey);
        virus_2.add(virus);
    }
    private void v_addItem3(String name, String imgUrl, String target, String virusKey) {
        Virus virus = new Virus();

        virus.setName(name);
        virus.setImgUrl(imgUrl);
        virus.setTarget(target);
        virus.setVirusKey(virusKey);
        virus_3.add(virus);
    }
}
