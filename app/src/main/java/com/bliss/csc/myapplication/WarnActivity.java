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

    private RecyclerView recyclerView, recyclerView2, recyclerView3;
    private MyAdapter adapter, adapter2, adapter3;
    private VirusAdapter virusAdapter, virusAdapter2, virusAdapter3;
    private Button button, button1;

    private int num = 0;

    private ArrayList<Bug> bugs = new ArrayList<>();
    private ArrayList<Bug> bugs_2 = new ArrayList<>();
    private ArrayList<Bug> bugs_3 = new ArrayList<>();
    private ArrayList<Virus> virus_1 = new ArrayList<>();
    private ArrayList<Virus> virus_2 = new ArrayList<>();
    private ArrayList<Virus> virus_3 = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_warn);

        button = findViewById(R.id.warning_old);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(WarnActivity.this, );
//                startActivity(intent);
            }
        });

        button1 = findViewById(R.id.w_change);
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

        // 채소
        recyclerView2 = findViewById(R.id.warning_recycler_2);

        adapter2 = new MyAdapter(bugs_2, this);
        recyclerView2.setAdapter(adapter2);

        LinearLayoutManager layoutManager2 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView2.setLayoutManager(layoutManager2);

        addItem2("꽃노랑총채벌레", "가지", "occidentalis",
                "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/hlsct/&imageFileName=ZK1AG0034E039[20161109111707631]_tmb.jpg",
                "H00000278");
        addItem2("꽃노랑총채벌레", "고추", "occidentalis",
                "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/hlsct/&imageFileName=고추-해충-총채벌레-과실[20210113153738207]_tmb.jpg",
                "H00000270");
        addItem2("담배나방", "고추", "assulta",
                "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/hlsct/&imageFileName=담배나방 유충이 고추 속에서 갉아 먹은 피해[20191202094643834]_tmb.jpg",
                "H00000411");
        addItem2("파밤나방", "고추", "exigua",
                "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/hlsct/&imageFileName=고추-해충-파밤나방-잎3[20210113161115037]_tmb.jpg",
                "H00000433");
        addItem2("꽃노랑총채벌레", "오이", "occidentalis",
                "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/hlsct/&imageFileName=ZK1AG0034E027[20161117104603012]_tmb.jpg",
                "H00000271");

        // 과수
        recyclerView3 = findViewById(R.id.warning_recycler_3);

        adapter3 = new MyAdapter(bugs_3, this);
        recyclerView3.setAdapter(adapter3);

        LinearLayoutManager layoutManager3 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView3.setLayoutManager(layoutManager3);

        addItem3("갈색날개매미충", "감", "speculum",
                "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/hlsct/&imageFileName=갈색날개매미충 산란피해 가지[20161007152838834]_tmb.jpg",
                "H00000608");
        addItem3("미국선녀벌레", "감", "pruinosa",
                "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/hlsct/&imageFileName=미국선녀벌레_감피해[20161007161616740]_tmb.jpg",
                "H00000609");
        addItem3("갈색날개노린재", "감귤","stali",
                "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/hlsct/&imageFileName=노린재류-1-1[20161110162609442]_tmb.jpg",
                "H00000005");
        addItem3("점박이응애", "감귤", "urticae",
                "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/hlsct/&imageFileName=점박이응애 유자 피해[20161111152416146]_tmb.jpg",
                "H00000532");
        addItem3("갈색날개매미충", "배", "speculum",
                "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/hlsct/&imageFileName=갈색날개매미충_여러 식물들에 발생한 난괴 배나무 잎[20190109180151424]_tmb.jpg",
                "H00000649");
        addItem3("미국선녀벌레", "배", "pruinosa",
                "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/hlsct/&imageFileName=미국선녀벌레_배피해[20161007162713953]_tmb.jpg",
                "H00000612");
        addItem3("점박이응애", "배", "urticae",
                "http://ncpms.rda.go.kr/images/common/noImg.gif",
                "H00000140");
        addItem3("갈색날개매미충", "복숭아", "speculum",
                "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/hlsct/&imageFileName=갈색날개매미충_여러 식물들에 발생한 난괴 복숭아[20190109175539781]_tmb.jpg",
                "H00000646");
        addItem3("썩덩나무노린재", "복숭아", "halys",
                "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/hlsct/&imageFileName=복숭아_해충_썩덩나무노린재_열매_1[20210114113416239]_tmb.jpg",
                "H00000818");
        addItem3("갈색날개매미충", "블루베리", "speculum",
                "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/hlsct/&imageFileName=갈색날개매미충피해증상1[20131230133735275]_tmb.jpg",
                "H00000568");
        addItem3("갈색날개노린재", "사과", "stali",
                "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/hlsct/&imageFileName=갈색날개노린재 과실피해_10월[20170524181127449]_tmb.jpg",
                "H00000618");
        addItem3("갈색날개매미충", "사과", "speculum",
                "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/hlsct/&imageFileName=갈색날개매미충 산란가지_8월[20170525133553199]_tmb.jpg",
                "H00000619");
        addItem3("썩덩나무노린재", "사과", "halys",
                "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/hlsct/&imageFileName=노린재 피해 초기_1[20180403105947026]_tmb.jpg",
                "H00000627");
        addItem3("점박이응애", "사과", "urticae",
                "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/hlsct/&imageFileName=점박이응애 조피틈 월동[20170524091428478]_tmb.jpg",
                "H00000246");
        addItem3("꽃매미", "포도", "delicatula",
                "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/hlsct/&imageFileName=08 꽃매미피해 포도 그을음 증상[20161114163739209]_tmb.jpg",
                "H00000361");
        addItem3("미국선녀벌레", "포도", "pruinosa",
                "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/hlsct/&imageFileName=미국선녀벌레_산림피해[20161007162431976]_tmb.jpg",
                "H00000610");
        addItem3("점박이응애", "포도", "urticae",
                "http://ncpms.rda.go.kr/images/common/noImg.gif",
                "H00000873");
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
    private void addItem2(String Name, String CropName, String Sepecies, String ImgUrl, String InsectKey){
        Bug bug = new Bug();

        bug.setName(Name);
        bug.setCropName(CropName);
        bug.setSpecies(Sepecies);
        bug.setImgUrl(ImgUrl);
        bug.setInsectKey(InsectKey);
        bugs_2.add(bug);
    }
    private void addItem3(String Name, String CropName, String Sepecies, String ImgUrl, String InsectKey){
        Bug bug = new Bug();

        bug.setName(Name);
        bug.setCropName(CropName);
        bug.setSpecies(Sepecies);
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

        v_addItem1("잎집무늬마름병",
                "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/sickns/&imageFileName=D00000813002[201010190000000]_tmb.jpg",
                "논벼","D00000813");
        v_addItem1("흰잎마름병",
                "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/sickns/&imageFileName=D00000744005[201010190000000]_tmb.jpg",
                "논벼", "D00000744");
        v_addItem1("잎짚무늬마름병",
                "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/sickns/&imageFileName=수수_잎집무늬마름병1[20180416101559225]_tmb.jpg",
                "수수", "D00004255");
        v_addItem1("잎짚무늬마름병",
                "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/sickns/&imageFileName=D00001199002[201010190000000]_tmb.jpg",
                "옥수수", "D00001199");

        // 채 소
        virusAdapter2 = new VirusAdapter(virus_2, this);
        recyclerView2.setAdapter(virusAdapter2);

        LinearLayoutManager layoutManager2 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView2.setLayoutManager(layoutManager2);

        v_addItem2("무름병",
                "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/sickns/&imageFileName=D00000563003[201010190000000]_tmb.jpg",
                "무","D00000563");
        v_addItem2("뿌리혹병, 무사마귀병",
                "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/sickns/&imageFileName=D00000576003[201010190000000]_tmb.jpg",
                "무", "D00000576");
        v_addItem2("무름병",
                "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/sickns/&imageFileName=img_0924_47[20161026143018587]_tmb.jpg",
                "배추", "D00000702");
        v_addItem2("뿌리혹병, 무사마귀병",
                "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/sickns/&imageFileName=D00000718002[201010190000000]_tmb.jpg",
                "배추", "D00000718");
        // 과수
        virusAdapter3 = new VirusAdapter(virus_3, this);
        recyclerView3.setAdapter(virusAdapter3);

        LinearLayoutManager layoutManager3 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView3.setLayoutManager(layoutManager3);

        v_addItem3("갈색무늬병",
                "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/sickns/&imageFileName=사과-곰팡이병-갈색무늬병[20210113143915745]_tmb.jpg",
                "사과", "D00000888");
        v_addItem3("점무늬낙엽병",
                "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/sickns/&imageFileName=D00000882001[201010190000000]_tmb.jpg",
                "사과", "D00000882");
        v_addItem3("갈색무늬병",
                "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/sickns/&imageFileName=포도_병_갈색무늬병_잎_피해증상_8[20210112175426039]_tmb.jpg",
                "포도", "D00004205");
    }
    private void originalView(){
        adapter = new MyAdapter(bugs, this);
        recyclerView.setAdapter(adapter);

        adapter2 = new MyAdapter(bugs_2, this);
        recyclerView2.setAdapter(adapter2);

        adapter3 = new MyAdapter(bugs_3, this);
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