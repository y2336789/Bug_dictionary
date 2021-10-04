package com.bliss.csc.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public String key = "20218f5922b84a6b4691db8472132ececb19";
    private RecyclerView recyclerView;
    private ArrayList<Bug> bugs = new ArrayList<>();
    private MyAdapter adapter;
    private String this_name;
    private String[] crop_names = {"사과","배","복숭아","밤","포도","참다래(키위,다래)","무화과","블루베리","감", "감귤"};
    private String[] food_crops = {"논벼","보리","콩","팥","녹두","옥수수","조","수수","감자","고구마"};
    private String[] food_vegetable = {"수박", "참외", "토마토", "딸기", "메론", "오이", "호박", "가지", "고추", "배추", "양배추", "상추"};
    private Button btn, btn1, btn2, food, fruit, vegetable;
    private int value = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler);
        adapter = new MyAdapter(bugs, this);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        // 스피너 설정 코드
        Spinner spinner =findViewById(R.id.select_crop);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_dropdown_item, food_crops);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                readRss1(food_crops[position]);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // 주의 버튼
        btn = findViewById(R.id.caution_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CautionActivity.class);
                startActivity(intent);
            }
        });
        // 예보 버튼
        btn1 = findViewById(R.id.warning_btn);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MainActivity.this, WarnActivity.class);
                startActivity(intent1);
            }
        });
        // 병 리스트 버튼
        btn2 = findViewById(R.id.go_sick);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(MainActivity.this, VirusActivity.class);
                startActivity(intent2);
            }
        });
        // 식량작물 버튼
        food = findViewById(R.id.food_crop);
        food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(value == 1)
                    return;
                else {
                    value = 1;
                    changeView1();
                }
            }
        });
        // 과수 버튼
        fruit = findViewById(R.id.fruit);
        fruit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(value == 2)
                    return;
                else {
                    value = 2;
                    changeView2();
                }
            }
        });
        // 채소 버튼
        vegetable = findViewById(R.id.vegetable);
        vegetable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(value == 3)
                    return;
                else {
                    value = 3;
                    changeView3();
                }
            }
        });
    }
    void readRss1(String cropName){
        if(cropName.equals("논벼")) {
            this_name = cropName;
            if(bugs != null) {
                bugs.clear();
                adapter.notifyDataSetChanged();
                try {
                    URL url = new URL("http://ncpms.rda.go.kr/npmsAPI/service?cropName=논벼&insectKorName=&apiKey="
                            + key + "&serviceCode=SVC03&serviceCodeDetail=SVC07&displayCount=50&insectKey=");
                    RssFeedTask task = new RssFeedTask();
                    task.execute(url);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        }
        else if(cropName.equals("보리")) {
            this_name = cropName;
            if(bugs != null) {
                bugs.clear();
                adapter.notifyDataSetChanged();
                try {
                    URL url = new URL("http://ncpms.rda.go.kr/npmsAPI/service?cropName=보리&insectKorName=&apiKey="
                            + key + "&serviceCode=SVC03&serviceCodeDetail=SVC07&displayCount=50&insectKey=");
                    RssFeedTask task = new RssFeedTask();
                    task.execute(url);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        }
        else if(cropName.equals("콩")) {
            this_name = cropName;
            if(bugs != null) {
                bugs.clear();
                adapter.notifyDataSetChanged();
                try {
                    URL url = new URL("http://ncpms.rda.go.kr/npmsAPI/service?cropName=콩&insectKorName=&apiKey="
                            + key + "&serviceCode=SVC03&serviceCodeDetail=SVC07&displayCount=50&insectKey=");
                    RssFeedTask task = new RssFeedTask();
                    task.execute(url);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        }
        else if(cropName.equals("팥")) {
            this_name = cropName;
            if(bugs != null) {
                bugs.clear();
                adapter.notifyDataSetChanged();
                try {
                    URL url = new URL("http://ncpms.rda.go.kr/npmsAPI/service?cropName=팥&insectKorName=&apiKey="
                            + key + "&serviceCode=SVC03&serviceCodeDetail=SVC07&displayCount=50&insectKey=");
                    RssFeedTask task = new RssFeedTask();
                    task.execute(url);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        }
        else if(cropName.equals("녹두")) {
            this_name = cropName;
            if(bugs != null) {
                bugs.clear();
                adapter.notifyDataSetChanged();
                try {
                    URL url = new URL("http://ncpms.rda.go.kr/npmsAPI/service?cropName=녹두&insectKorName=&apiKey="
                            + key + "&serviceCode=SVC03&serviceCodeDetail=SVC07&displayCount=50&insectKey=");
                    RssFeedTask task = new RssFeedTask();
                    task.execute(url);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        }
        else if(cropName.equals("옥수수")) {
            this_name = cropName;
            if(bugs != null) {
                bugs.clear();
                adapter.notifyDataSetChanged();
                try {
                    URL url = new URL("http://ncpms.rda.go.kr/npmsAPI/service?cropName=옥수수&insectKorName=&apiKey="
                            + key + "&serviceCode=SVC03&serviceCodeDetail=SVC07&displayCount=50&insectKey=");
                    RssFeedTask task = new RssFeedTask();
                    task.execute(url);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        }
        else if(cropName.equals("조")) {
            this_name = cropName;
            if(bugs != null) {
                bugs.clear();
                adapter.notifyDataSetChanged();
                try {
                    URL url = new URL("http://ncpms.rda.go.kr/npmsAPI/service?cropName=조&insectKorName=&apiKey="
                            + key + "&serviceCode=SVC03&serviceCodeDetail=SVC07&displayCount=50&insectKey=");
                    RssFeedTask task = new RssFeedTask();
                    task.execute(url);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        }
        else if(cropName.equals("수수")) {
            this_name = cropName;
            if(bugs != null) {
                bugs.clear();
                adapter.notifyDataSetChanged();
                try {
                    URL url = new URL("http://ncpms.rda.go.kr/npmsAPI/service?cropName=수수&insectKorName=&apiKey="
                            + key + "&serviceCode=SVC03&serviceCodeDetail=SVC07&displayCount=50&insectKey=");
                    RssFeedTask task = new RssFeedTask();
                    task.execute(url);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        }
        else if(cropName.equals("감자")) {
            this_name = cropName;
            if(bugs != null) {
                bugs.clear();
                adapter.notifyDataSetChanged();
                try {
                    URL url = new URL("http://ncpms.rda.go.kr/npmsAPI/service?cropName=감자&insectKorName=&apiKey="
                            + key + "&serviceCode=SVC03&serviceCodeDetail=SVC07&displayCount=50&insectKey=");
                    RssFeedTask task = new RssFeedTask();
                    task.execute(url);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        }
        else if(cropName.equals("고구마")) {
            this_name = cropName;
            if(bugs != null) {
                bugs.clear();
                adapter.notifyDataSetChanged();
                try {
                    URL url = new URL("http://ncpms.rda.go.kr/npmsAPI/service?cropName=고구마&insectKorName=&apiKey="
                            + key + "&serviceCode=SVC03&serviceCodeDetail=SVC07&displayCount=50&insectKey=");
                    RssFeedTask task = new RssFeedTask();
                    task.execute(url);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    @SuppressLint("NotifyDataSetChanged")

    void readRss2(String cropName) {
        if(cropName.equals("사과")) {
            this_name = cropName;
            if(bugs != null) {
                bugs.clear();
                adapter.notifyDataSetChanged();
                try {
                    URL url = new URL("http://ncpms.rda.go.kr/npmsAPI/service?cropName=%EC%82%AC%EA%B3%BC&insectKorName=&apiKey="
                            + key + "&serviceCode=SVC03&serviceCodeDetail=SVC07&displayCount=50&insectKey=");
                    RssFeedTask task = new RssFeedTask();
                    task.execute(url);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        }else if(cropName.equals("복숭아")){
            this_name = cropName;
            if(bugs != null) {
                bugs.clear();
                adapter.notifyDataSetChanged();
                try {
                    URL url = new URL("http://ncpms.rda.go.kr/npmsAPI/service?cropName=%EB%B3%B5%EC%88%AD%EC%95%84&insectKorName=&apiKey="
                            + key + "&serviceCode=SVC03&serviceCodeDetail=SVC07&displayCount=50&insectKey=");
                    RssFeedTask task = new RssFeedTask();
                    task.execute(url);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        }else if(cropName.equals("배")){
            this_name = cropName;
            if(bugs != null) {
                bugs.clear();
                adapter.notifyDataSetChanged();
                try {
                    URL url = new URL("http://ncpms.rda.go.kr/npmsAPI/service?cropName=%EB%B0%B0&insectKorName=&apiKey="
                            + key + "&serviceCode=SVC03&serviceCodeDetail=SVC07&displayCount=50&insectKey=");
                    RssFeedTask task = new RssFeedTask();
                    task.execute(url);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        }else if(cropName.equals("포도")){
            this_name = cropName;
            if(bugs != null) {
                bugs.clear();
                adapter.notifyDataSetChanged();
                try {
                    URL url = new URL("http://ncpms.rda.go.kr/npmsAPI/service?cropName=%ED%8F%AC%EB%8F%84&insectKorName=&apiKey="
                            + key + "&serviceCode=SVC03&serviceCodeDetail=SVC07&displayCount=50&insectKey=");
                    RssFeedTask task = new RssFeedTask();
                    task.execute(url);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        }else if(cropName.equals("밤")){
            this_name = cropName;
            if(bugs != null) {
                bugs.clear();
                adapter.notifyDataSetChanged();
                try {
                    URL url = new URL("http://ncpms.rda.go.kr/npmsAPI/service?cropName=%EB%B0%A4&insectKorName=&apiKey="
                            + key + "&serviceCode=SVC03&serviceCodeDetail=SVC07&displayCount=50&insectKey=");
                    RssFeedTask task = new RssFeedTask();
                    task.execute(url);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        }else if(cropName.equals("블루베리")){
            this_name = cropName;
            if(bugs != null) {
                bugs.clear();
                adapter.notifyDataSetChanged();
                try {
                    URL url = new URL("http://ncpms.rda.go.kr/npmsAPI/service?cropName=%EB%B8%94%EB%A3%A8%EB%B2%A0%EB%A6%AC&insectKorName=&apiKey="
                            + key + "&serviceCode=SVC03&serviceCodeDetail=SVC07&displayCount=50&insectKey=");
                    RssFeedTask task = new RssFeedTask();
                    task.execute(url);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        }else if(cropName.equals("참다래(키위,다래)")){
            this_name = cropName;
            if(bugs != null) {
                bugs.clear();
                adapter.notifyDataSetChanged();
                try {
                    URL url = new URL("http://ncpms.rda.go.kr/npmsAPI/service?cropName=%EC%B0%B8%EB%8B%A4%EB%9E%98&insectKorName=&apiKey="
                            + key + "&serviceCode=SVC03&serviceCodeDetail=SVC07&displayCount=50&insectKey=");
                    RssFeedTask task = new RssFeedTask();
                    task.execute(url);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        }else if(cropName.equals("무화과")){
            this_name = cropName;
            if(bugs != null) {
                bugs.clear();
                adapter.notifyDataSetChanged();
                try {
                    URL url = new URL("http://ncpms.rda.go.kr/npmsAPI/service?cropName=%EB%AC%B4%ED%99%94%EA%B3%BC&insectKorName=&apiKey="
                            + key + "&serviceCode=SVC03&serviceCodeDetail=SVC07&displayCount=50&insectKey=");
                    RssFeedTask task = new RssFeedTask();
                    task.execute(url);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        }else if(cropName.equals("감")){
            this_name = cropName;
            if(bugs != null) {
                bugs.clear();
                adapter.notifyDataSetChanged();
                try {
                    URL url = new URL("http://ncpms.rda.go.kr/npmsAPI/service?cropName=%EA%B0%90&insectKorName=&apiKey="
                            + key + "&serviceCode=SVC03&serviceCodeDetail=SVC07&displayCount=50&insectKey=");
                    RssFeedTask task = new RssFeedTask();
                    task.execute(url);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        }else if(cropName.equals("감귤")){
            this_name = cropName;
            if(bugs != null) {
                bugs.clear();
                adapter.notifyDataSetChanged();
                try {
                    URL url = new URL("http://ncpms.rda.go.kr/npmsAPI/service?cropName=%EA%B0%90%EA%B7%A4&insectKorName=&apiKey="
                            + key + "&serviceCode=SVC03&serviceCodeDetail=SVC07&displayCount=50&insectKey=");
                    RssFeedTask task = new RssFeedTask();
                    task.execute(url);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    @SuppressLint("NotifyDataSetChanged")

    void readRss3(String cropName){
        if(cropName.equals("수박")) {
            this_name = cropName;
            if(bugs != null) {
                bugs.clear();
                adapter.notifyDataSetChanged();
                try {
                    URL url = new URL("http://ncpms.rda.go.kr/npmsAPI/service?cropName=수박&insectKorName=&apiKey="
                            + key + "&serviceCode=SVC03&serviceCodeDetail=SVC07&displayCount=50&insectKey=");
                    RssFeedTask task = new RssFeedTask();
                    task.execute(url);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        }
        else if(cropName.equals("참외")) {
            this_name = cropName;
            if(bugs != null) {
                bugs.clear();
                adapter.notifyDataSetChanged();
                try {
                    URL url = new URL("http://ncpms.rda.go.kr/npmsAPI/service?cropName=참외&insectKorName=&apiKey="
                            + key + "&serviceCode=SVC03&serviceCodeDetail=SVC07&displayCount=50&insectKey=");
                    RssFeedTask task = new RssFeedTask();
                    task.execute(url);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        }
        else if(cropName.equals("토마토")) {
            this_name = cropName;
            if(bugs != null) {
                bugs.clear();
                adapter.notifyDataSetChanged();
                try {
                    URL url = new URL("http://ncpms.rda.go.kr/npmsAPI/service?cropName=토마토&insectKorName=&apiKey="
                            + key + "&serviceCode=SVC03&serviceCodeDetail=SVC07&displayCount=50&insectKey=");
                    RssFeedTask task = new RssFeedTask();
                    task.execute(url);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        }
        else if(cropName.equals("딸기")) {
            this_name = cropName;
            if(bugs != null) {
                bugs.clear();
                adapter.notifyDataSetChanged();
                try {
                    URL url = new URL("http://ncpms.rda.go.kr/npmsAPI/service?cropName=딸기&insectKorName=&apiKey="
                            + key + "&serviceCode=SVC03&serviceCodeDetail=SVC07&displayCount=50&insectKey=");
                    RssFeedTask task = new RssFeedTask();
                    task.execute(url);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        }
        else if(cropName.equals("메론")) {
            this_name = cropName;
            if(bugs != null) {
                bugs.clear();
                adapter.notifyDataSetChanged();
                try {
                    URL url = new URL("http://ncpms.rda.go.kr/npmsAPI/service?cropName=메론&insectKorName=&apiKey="
                            + key + "&serviceCode=SVC03&serviceCodeDetail=SVC07&displayCount=50&insectKey=");
                    RssFeedTask task = new RssFeedTask();
                    task.execute(url);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        }
        else if(cropName.equals("오이")) {
            this_name = cropName;
            if(bugs != null) {
                bugs.clear();
                adapter.notifyDataSetChanged();
                try {
                    URL url = new URL("http://ncpms.rda.go.kr/npmsAPI/service?cropName=오이&insectKorName=&apiKey="
                            + key + "&serviceCode=SVC03&serviceCodeDetail=SVC07&displayCount=50&insectKey=");
                    RssFeedTask task = new RssFeedTask();
                    task.execute(url);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        }
        else if(cropName.equals("호박")) {
            this_name = cropName;
            if(bugs != null) {
                bugs.clear();
                adapter.notifyDataSetChanged();
                try {
                    URL url = new URL("http://ncpms.rda.go.kr/npmsAPI/service?cropName=호박&insectKorName=&apiKey="
                            + key + "&serviceCode=SVC03&serviceCodeDetail=SVC07&displayCount=50&insectKey=");
                    RssFeedTask task = new RssFeedTask();
                    task.execute(url);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        }
        else if(cropName.equals("가지")) {
            this_name = cropName;
            if(bugs != null) {
                bugs.clear();
                adapter.notifyDataSetChanged();
                try {
                    URL url = new URL("http://ncpms.rda.go.kr/npmsAPI/service?cropName=가지&insectKorName=&apiKey="
                            + key + "&serviceCode=SVC03&serviceCodeDetail=SVC07&displayCount=50&insectKey=");
                    RssFeedTask task = new RssFeedTask();
                    task.execute(url);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        }
        else if(cropName.equals("고추")) {
            this_name = cropName;
            if(bugs != null) {
                bugs.clear();
                adapter.notifyDataSetChanged();
                try {
                    URL url = new URL("http://ncpms.rda.go.kr/npmsAPI/service?cropName=고추C&insectKorName=&apiKey="
                            + key + "&serviceCode=SVC03&serviceCodeDetail=SVC07&displayCount=50&insectKey=");
                    RssFeedTask task = new RssFeedTask();
                    task.execute(url);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        }
        else if(cropName.equals("배추")) {
            this_name = cropName;
            if(bugs != null) {
                bugs.clear();
                adapter.notifyDataSetChanged();
                try {
                    URL url = new URL("http://ncpms.rda.go.kr/npmsAPI/service?cropName=배추&insectKorName=&apiKey="
                            + key + "&serviceCode=SVC03&serviceCodeDetail=SVC07&displayCount=50&insectKey=");
                    RssFeedTask task = new RssFeedTask();
                    task.execute(url);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        }
        else if(cropName.equals("양배추")){
            this_name = cropName;
            if(bugs != null) {
                bugs.clear();
                adapter.notifyDataSetChanged();
                try {
                    URL url = new URL("http://ncpms.rda.go.kr/npmsAPI/service?cropName=양배추&insectKorName=&apiKey="
                            + key + "&serviceCode=SVC03&serviceCodeDetail=SVC07&displayCount=50&insectKey=");
                    RssFeedTask task = new RssFeedTask();
                    task.execute(url);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        }
        else if(cropName.equals("상추")){
            this_name = cropName;
            if(bugs != null) {
                bugs.clear();
                adapter.notifyDataSetChanged();
                try {
                    URL url = new URL("http://ncpms.rda.go.kr/npmsAPI/service?cropName=상추&insectKorName=&apiKey="
                            + key + "&serviceCode=SVC03&serviceCodeDetail=SVC07&displayCount=50&insectKey=");
                    RssFeedTask task = new RssFeedTask();
                    task.execute(url);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    @SuppressLint("NotifyDataSetChanged")

    class RssFeedTask extends AsyncTask<URL, Void, String> {
        @Override
        protected String doInBackground(URL... urls) {
            URL url = urls[0];

            try {
                InputStream is = url.openStream();

                XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
                XmlPullParser xpp = factory.newPullParser();

                xpp.setInput(is, "utf-8");
                int eventType = xpp.getEventType();

                Bug bug = null;
                String tagName = null;

                while (eventType != XmlPullParser.END_DOCUMENT) {
                    switch (eventType) {
                        case XmlPullParser.START_DOCUMENT:
                            break;
                        case XmlPullParser.START_TAG:
                            tagName = xpp.getName();

                            if (tagName.equals("item")) {
                                bug = new Bug();
                            }else if(tagName.equals("insectKorName")){
                                xpp.next();
                                if(bug!=null) bug.setName(xpp.getText());
                            }else if(tagName.equals("thumbImg")){
                                xpp.next();
                                if(bug!=null) bug.setImgUrl(xpp.getText());
                            }else if(tagName.equals("speciesName")){
                                xpp.next();
                                if(bug!=null) bug.setSpecies(xpp.getText());
                            }else if(tagName.equals("cropName")){
                                xpp.next();
                                bug.setCropName(xpp.getText());
                            }else if(tagName.equals("insectKey")){
                                xpp.next();
                                if(bug!=null) bug.setInsectKey(xpp.getText());
                            }
                            break;
                        case XmlPullParser.TEXT:
                            break;
                        case XmlPullParser.END_TAG:
                            tagName=xpp.getName();
                            if(tagName.equals("item")){
                                if(bug.getCropName().equals(this_name)){
                                    bugs.add(bug);
                                    bug=null;
                                }
                                publishProgress();
                            }
                            break;
                    }
                    eventType = xpp.next();
                }

            } catch (IOException e) {
                e.printStackTrace();
            } catch (XmlPullParserException e) {
                e.printStackTrace();
            }
            return "파싱종료";
        }
        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
            adapter.notifyItemInserted(bugs.size());
        }
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Toast.makeText(MainActivity.this, s+":"+bugs.size(), Toast.LENGTH_SHORT).show();
        }
    }
    private void changeView1(){
        Spinner spinner = findViewById(R.id.select_crop);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_dropdown_item, food_crops);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                readRss1(food_crops[position]);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }
    private void changeView2(){
        Spinner spinner = findViewById(R.id.select_crop);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_dropdown_item, crop_names);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                readRss2(crop_names[position]);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }
    private void changeView3(){
        Spinner spinner = findViewById(R.id.select_crop);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_dropdown_item, food_vegetable);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                readRss3(food_vegetable[position]);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }
}