package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class OldCautionActivity extends AppCompatActivity {

    RecyclerView recyclerView, recyclerView2, recyclerView3;
    BugAdapter adapter, adapter2, adapter3;
    VirusAdapter virusAdapter, virusAdapter2, virusAdapter3;

    ArrayList<Bug> bugs = new ArrayList<>();
    ArrayList<Bug> bugs_2 = new ArrayList<>();
    ArrayList<Bug> bugs_3 = new ArrayList<>();
    ArrayList<Virus> virus_1 = new ArrayList<>();
    ArrayList<Virus> virus_2 = new ArrayList<>();
    ArrayList<Virus> virus_3 = new ArrayList<>();

    int num = 0;
    Button button1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_old_caution);

        button1 = findViewById(R.id.old_change);
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
        showList();
//        Spinner spinner =findViewById(R.id.year_select);
//
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
//                this, android.R.layout.simple_spinner_dropdown_item, year_list);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinner.setAdapter(adapter);
//
//        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                readYear(year_list[position]);
//            }
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });
    }
    void showList() {
        bugs.clear();
        bugs_2.clear();
        bugs_3.clear();

        // 식량작물
        recyclerView = findViewById(R.id.year_recycler);

        adapter = new BugAdapter(bugs, this);
        recyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);

        addItem("먹노린재", "논벼", "Scotinophara",
                "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/spcs/&imageFileName=ZL1BX0069M001[20110106120000000]_wm.jpg",
                "H00000293");
        addItem("벼멸구", "논벼","Nilaparvata",
                "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/spcs/&imageFileName=ZM1AZ0035M006[20110106120000000]_wm.jpg",
                "H00000350");
       addItem("흰등멸구","논벼","furcifera",
        "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/hlsct/&imageFileName=ZM1AZ0041E001[20110113150000000]_tmb.jpg</thumbImg>",
               "H00000351");
        addItem("멸강나방","논벼","separata",
                "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/hlsct/&imageFileName=ZR1DS0188E001[20110113150000000]_tmb.jpg",
                "H00000418");
        addItem("멸강나방", "옥수수", "separata",
                "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/hlsct/&imageFileName=멸강나방 옥수수 피해[20161110132307344]_tmb.jpg",
                "H00000419");
        addItem("혹명나방", "논벼","Cnaphalocrocis",
                "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/spcs/&imageFileName=ZR1EL0063M001[20110106120000000]_wm.jpg",
                "H00000463");
        addItem("열대거세거미나방", "옥수수","Spodoptera",
                "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/spcs/&imageFileName=열거세미나방 성충 사진_숫컷[20190710132552364]_wm.jpg",
                "H00000651");

        // 채 소
        recyclerView2 = findViewById(R.id.year_recycler_2);

        adapter2 = new BugAdapter(bugs_2, this);
        recyclerView2.setAdapter(adapter2);

        LinearLayoutManager layoutManager2 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView2.setLayoutManager(layoutManager2);

        addItem2("꽃노랑총채벌레", "오이", "occidentalis",
                "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/hlsct/&imageFileName=ZK1AG0034E027[20161117104603012]_tmb.jpg",
                "H00000271");
        addItem2("온실가루이","오이","vaporariorum",
                "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/hlsct/&imageFileName=온실가루이 오이 피해2[20161117112426957]_tmb.jpg",
                "H00000299");
        addItem2("담배가루이", "오이", "tabaci",
                "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/hlsct/&imageFileName=ZM1AG0007E001[20110113150000000]_tmb.jpg",
                "H00000305");
        addItem2("담배나방", "고추", "Helicoverpa",
                "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/spcs/&imageFileName=ZR1DS0057M001[201101   06120000000]_wm.jpg",
                "H00000411");
        addItem2("목화진딧물", "고추", "gossypii",
                "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/hlsct/&imageFileName=고추 목화진딧물 신초 피해[20161017090828972]_tmb.jpg",
                "H00000614");
        // 과 수
        recyclerView3 = findViewById(R.id.year_recycler_3);

        adapter3 = new BugAdapter(bugs_3, this);
        recyclerView3.setAdapter(adapter3);

        LinearLayoutManager layoutManager3 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView3.setLayoutManager(layoutManager3);


        addItem3("복숭아심식나방", "사과", "sasakii",
                "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/hlsct/&imageFileName=ZR1AY0002E001[201010210000000]_tmb.jpg",
                "H00000242");
        addItem3("점박이응애", "사과", "urticae",
                "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/hlsct/&imageFileName=점박이응애 조피틈 월동[20170524091428478]_tmb.jpg",
                "H00000246");
        addItem3("꽃매미", "포도", "Lycorma",
                "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/spcs/&imageFileName=ZM1BI0002M001[20110106120000000]_wm.jpg",
                "H00000361");
        addItem3("복숭아심식나방", "복숭아", "Carposina",
                "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/spcs/&imageFileName=ZR1AY0002M001[201010210000000]_wm.jpg",
                "H00000386");
        addItem3("복숭아순나방", "복숭아", "Grapholita",
                "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/spcs/&imageFileName=ZR1FF0131M001[201010210000000]_wm.jpg",
                "H00000477");
        addItem3("미국선녀벌레", "포도", "pruinosa",
                "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/hlsct/&imageFileName=미국선녀벌레_산림피해[20161007162431976]_tmb.jpg",
                "H00000610");
        addItem3("갈색날개매미충", "포도", "speculum",
                "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/hlsct/&imageFileName=약충밀납에 의한 피해[20161007163313622]_tmb.jpg",
                "H00000613");
        addItem3("갈색날개노린재", "사과", "stali",
                "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/hlsct/&imageFileName=갈색날개노린재 과실피해_10월[20170524181127449]_tmb.jpg",
                "H00000618");
        addItem3("갈색날개매미충", "사과", "speculum",
                "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/hlsct/&imageFileName=갈색날개매미충 산란가지_8월[20170525133553199]_tmb.jpg",
                "H00000619");
        addItem3("썩덩나무노린재", "사과", "halys",
                "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/hlsct/&imageFileName=노린재 피해 초기_1[20180403105947026]_tmb.jpg",
                "H00000627");
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

        v_addItem1("흰잎마름병", "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/sickns/&imageFileName=D00000744005[201010190000000]_tmb.jpg",
                "논벼", "D00000744");
        v_addItem1("잎집무늬마름병","http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/sickns/&imageFileName=D00000813002[201010190000000]_tmb.jpg",
                "논벼", "D00000813");
        v_addItem1("도열병", "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/sickns/&imageFileName=img_0923_01[20161108141737344]_tmb.jpg",
                "논벼", "D00004234");


        // 채 소
        virusAdapter2 = new VirusAdapter(virus_2, this);
        recyclerView2.setAdapter(virusAdapter2);

        LinearLayoutManager layoutManager2 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView2.setLayoutManager(layoutManager2);

        v_addItem2("역병", "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/sickns/&imageFileName=D00000198003[201010190000000]_tmb.jpg",
                "고추", "D00000198");
        v_addItem2("탄저병", "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/sickns/&imageFileName=고추_병_탄저병_열매_피해증상_4[20210111164102868]_tmb.jpg",
                "고추", "D00000195");
        v_addItem2("무름병", "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/sickns/&imageFileName=D00000563003[201010190000000]_tmb.jpg",
                "무","D00000563");
        v_addItem2("뿌리혹병, 무사마귀병", "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/sickns/&imageFileName=D00000576003[201010190000000]_tmb.jpg",
                "무", "D00000576");
        v_addItem2("무름병", "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/sickns/&imageFileName=img_0924_47[20161026143018587]_tmb.jpg",
                "배추","D00000702");
        v_addItem2("뿌리혹병, 무사마귀병", "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/sickns/&imageFileName=D00000718002[201010190000000]_tmb.jpg",
                "배추","D00000718");

        // 과수
        virusAdapter3 = new VirusAdapter(virus_3, this);
        recyclerView3.setAdapter(virusAdapter3);

        LinearLayoutManager layoutManager3 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView3.setLayoutManager(layoutManager3);

        v_addItem3("과수화상병","http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/sickns/&imageFileName=화상병_가지[20161013105850274]_tmb.jpg",
                "배","D00000678");
        v_addItem3("점무늬낙엽병", "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/sickns/&imageFileName=D00000882001[201010190000000]_tmb.jpg",
                "사과", "D00000882");
        v_addItem3("탄저병","http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/sickns/&imageFileName=사과-곰팡이병-탄저병-과실5[20210113145720311]_tmb.jpg",
                "사과","D00000884");
        v_addItem3("갈색무늬병","http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/sickns/&imageFileName=사과-곰팡이병-갈색무늬병[20210113143915745]_tmb.jpg",
                "사과","D00000888");
        v_addItem3("과수화상병","http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/sickns/&imageFileName=화상병가지병징1[20180502182014096]_tmb.jpg",
                "사과","D00000924");
        v_addItem3("가지검은마름병","http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/sickns/&imageFileName=사과_가지검은마름병_개화직후의 증상[20151112120215254]_tmb.jpg",
                "사과","D00004075");
        v_addItem3("탄저병","http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/sickns/&imageFileName=복숭아-곰팡이병-탄저병-과실6[20210113142841092]_tmb.jpg",
                "복숭아", "D00004192");
        v_addItem3("탄저병", "http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/sickns/&imageFileName=포도_병_탄저병_열매_피해증상_4[20210113103203287]_tmb.jpg",
                "포도","D00004218");
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
