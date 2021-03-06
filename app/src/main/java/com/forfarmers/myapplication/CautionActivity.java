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
                    button1.setText("?????? ???????????? ??????");
                }else if(num ==1){
                    num = 0;
                    originalView();
                    button1.setText("??? ???????????? ??????");
                }

            }
        });
        // ????????????
        recyclerView = findViewById(R.id.caution_recycler);

        adapter = new BugAdapter(bugs, this);
        recyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);

//        addItem("????????????????????????", "?????????","Spodoptera",
//                "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/spcs/&imageFileName=?????????????????? ?????? ??????_??????[20190710132552364]_wm.jpg",
//                "H00000651");
//        addItem("????????????", "?????????","Pseudaletia",
//                "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/spcs/&imageFileName=ZR1DS0188M001[20110106120000000]_wm.jpg",
//                "H00000419");
//        addItem("????????????", "??????", "Scotinophara",
//                "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/spcs/&imageFileName=ZL1BX0069M001[20110106120000000]_wm.jpg",
//                "H00000293");

        // ??? ???
        recyclerView2 = findViewById(R.id.caution_recycler_2);

        adapter2 = new BugAdapter(bugs_2, this);
        recyclerView2.setAdapter(adapter2);

        LinearLayoutManager layoutManager2 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView2.setLayoutManager(layoutManager2);

        // ??? ???
        recyclerView3 = findViewById(R.id.caution_recycler_3);

        adapter3 = new BugAdapter(bugs_3, this);
        recyclerView3.setAdapter(adapter3);

        LinearLayoutManager layoutManager3 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView3.setLayoutManager(layoutManager3);

        addItem3("?????????????????????", "?????????", "Carposina",
                "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/spcs/&imageFileName=ZR1AY0002M001[201010210000000]_wm.jpg",
                "H00000386");
        addItem3("??????????????????", "?????????", "Grapholita",
                "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/spcs/&imageFileName=ZR1FF0131M001[201010210000000]_wm.jpg",
                "H00000477");
        addItem3("?????????????????????", "??????", "Carposina",
                "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/spcs/&imageFileName=ZR1AY0002M001[201010210000000]_wm.jpg",
                "H00000242");
        addItem3("??????????????????", "??????", "Grapholita",
                "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/spcs/&imageFileName=ZR1FF0131M001[201010210000000]_wm.jpg",
                "H00000233");
        addItem3("?????????????????????", "?????????", "Ricania",
                "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/spcs/&imageFileName=????????????????????? ??????_9???1[20170525131100977]_wm.jpg",
                "H00000646");
        addItem3("??????????????????", "???", "Metcalfa",
                "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/spcs/&imageFileName=?????????????????? ??????_8???1[20170525163825037]_wm.jpg",
                "H00000609");
        addItem3("?????????", "??????", "Lycorma",
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
        // ????????????
        virusAdapter = new VirusAdapter(virus_1, this);
        recyclerView.setAdapter(virusAdapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);

//        v_addItem1()

        // ??? ???
        virusAdapter2 = new VirusAdapter(virus_2, this);
        recyclerView2.setAdapter(virusAdapter2);

        LinearLayoutManager layoutManager2 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView2.setLayoutManager(layoutManager2);

        v_addItem2("??????", "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/sickns/&imageFileName=D00000018003[201010190000000]_tmb.jpg",
                "??????","D00000018");
        v_addItem2("??????", "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/sickns/&imageFileName=D00000198003[201010190000000]_tmb.jpg",
                "??????", "D00000198");
        v_addItem2("?????????", "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/sickns/&imageFileName=??????_???_?????????_??????_????????????_4[20210111164102868]_tmb.jpg",
                "??????", "D00000195");
        v_addItem2("??????", "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/sickns/&imageFileName=img_0925_222[20160805153144502]_tmb.jpg",
                "??????", "D00000452");
        v_addItem2("??????", "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/sickns/&imageFileName=D00000717002[201010190000000]_tmb.jpg",
                "??????", "D00000717");
        v_addItem2("??????", "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/sickns/&imageFileName=img_0925_214[20160805160142478]_tmb.jpg",
                "?????????", "D00001055");
        v_addItem2("???????????????", "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/sickns/&imageFileName=D00001152004[201010190000000]_tmb.jpg",
                "??????", "D00001152");
        v_addItem2("??????","http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/sickns/&imageFileName=D00001165002[201010190000000]_tmb.jpg",
                "??????","D00001165");
        v_addItem2("????????????????????????","http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/sickns/&imageFileName=?????????_????????? ?????? ?????? ??????_1[20180404133301218]_tmb.jpg",
                "?????????", "D00004251");

        // ??????
        virusAdapter3 = new VirusAdapter(virus_3, this);
        recyclerView3.setAdapter(virusAdapter3);

        LinearLayoutManager layoutManager3 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView3.setLayoutManager(layoutManager3);

        v_addItem3("?????????", "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/sickns/&imageFileName=img_5001_01[20161025173500308]_tmb.jpg",
                "???", "D00004161");
        v_addItem3("?????????", "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/sickns/&imageFileName=D00000042001[201010190000000]_tmb.jpg",
                "??????", "D00000042");
        v_addItem3("???????????????", "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/sickns/&imageFileName=?????????_??????[20161013105850274]_tmb.jpg",
                "???","D00000678");
        v_addItem3("?????????", "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/sickns/&imageFileName=D00000711002[201010190000000]_tmb.jpg",
                "???", "D00000664");
        v_addItem3("?????????", "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/sickns/&imageFileName=?????????-????????????-?????????-??????6[20210113142841092]_tmb.jpg",
                "?????????", "D00004192");
        v_addItem3("?????????", "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/sickns/&imageFileName=????????????_????????? ????????? ????????? ??????[20190109135733710]_tmb.jpg",
                "????????????", "D00004276");
        v_addItem3("?????????????????????", "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/sickns/&imageFileName=??????_?????????????????????_??????????????? ??????[20151112120215254]_tmb.jpg",
                "??????", "D00004075");
        v_addItem3("???????????????", "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/sickns/&imageFileName=?????????????????????1[20180502182014096]_tmb.jpg",
                "??????", "D00000924");
        v_addItem3("?????????", "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/sickns/&imageFileName=??????-????????????-?????????-??????5[20210113145720311]_tmb.jpg",
                "??????","D00000884");
        v_addItem3("?????????", "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/sickns/&imageFileName=??????_???_?????????_??????_????????????_4[20210113103203287]_tmb.jpg",
                "??????", "D00004218");
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
