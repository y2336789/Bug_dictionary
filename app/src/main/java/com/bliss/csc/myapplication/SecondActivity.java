package com.bliss.csc.myapplication;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    public String key = "20218f5922b84a6b4691db8472132ececb19";
    RecyclerView recyclerView;
    ArrayList<Virus> viruses = new ArrayList<>();
    VirusAdapter adapter;
    String this_name;
    TextView textView;
    String[] crop_names = {"사과", "복숭아", "배", "포도","밤"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        recyclerView = findViewById(R.id.s_recycler);

        adapter = new VirusAdapter(viruses, this);
        recyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        textView =findViewById(R.id.s_testing);
        Spinner spinner =findViewById(R.id.s_select_crop);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_dropdown_item, crop_names);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                textView.setText(crop_names[position]);
                readRss(crop_names[position]);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                textView.setText("");
            }
        });
    }

    void readRss(String cropName) {
        if(cropName.equals("사과")) {
            this_name = cropName;
            try {
                URL url = new URL("http://ncpms.rda.go.kr/npmsAPI/service?cropName=%EC%82%AC%EA%B3%BC&insectKorName=&apiKey="
                        + key + "&serviceCode=SVC01&serviceType=AA001&sickKey=");
                RssFeedTask task = new RssFeedTask();
                task.execute(url);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }else if(cropName.equals("복숭아")){
            this_name = cropName;
            if(viruses != null) {
                viruses.clear();
                adapter.notifyDataSetChanged();
                try {
                    URL url = new URL("http://ncpms.rda.go.kr/npmsAPI/service?cropName=%EB%B3%B5%EC%88%AD%EC%95%84&insectKorName=&apiKey="
                            + key + "&serviceCode=SVC01&serviceType=AA001&sickKey=");
                    RssFeedTask task = new RssFeedTask();
                    task.execute(url);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        }else if(cropName.equals("배")){
            this_name = cropName;
            if(viruses != null) {
                viruses.clear();
                adapter.notifyDataSetChanged();
                try {
                    URL url = new URL("http://ncpms.rda.go.kr/npmsAPI/service?cropName=%EB%B0%B0&insectKorName=&apiKey="
                            + key + "&serviceCode=SVC01&serviceType=AA001&sickKey=");
                    RssFeedTask task = new RssFeedTask();
                    task.execute(url);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        }else if(cropName.equals("포도")){
            this_name = cropName;
            if(viruses != null) {
                viruses.clear();
                adapter.notifyDataSetChanged();
                try {
                    URL url = new URL("http://ncpms.rda.go.kr/npmsAPI/service?cropName=%ED%8F%AC%EB%8F%84&insectKorName=&apiKey="
                            + key + "&serviceCode=SVC01&serviceType=AA001&sickKey=");
                    RssFeedTask task = new RssFeedTask();
                    task.execute(url);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        }else if(cropName.equals("밤")){
            this_name = cropName;
            if(viruses != null) {
                viruses.clear();
                adapter.notifyDataSetChanged();
                try {
                    URL url = new URL("http://ncpms.rda.go.kr/npmsAPI/service?cropName=%EB%B0%A4&insectKorName=&apiKey="
                            + key + "&serviceCode=SVC01&serviceType=AA001&sickKey=");
                    RssFeedTask task = new RssFeedTask();
                    task.execute(url);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

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

                Virus virus = null;
                String tagName = null;

                while (eventType != XmlPullParser.END_DOCUMENT) {
                    switch (eventType) {
                        case XmlPullParser.START_DOCUMENT:
                            break;
                        case XmlPullParser.START_TAG:
                            tagName = xpp.getName();

                            if (tagName.equals("item")) {
                                virus = new Virus();
                            } else if (tagName.equals("sickNameKor")) {
                                xpp.next();
                                if (virus != null) virus.setName(xpp.getText());
                            } else if (tagName.equals("oriImg")) {
                                xpp.next();
                                if (virus != null) virus.setImgUrl(xpp.getText());
                            } else if (tagName.equals("cropName")) {
                                xpp.next();
                                virus.setTarget(xpp.getText());
                            } else if (tagName.equals("sickKey")) {
                                xpp.next();
                                if (virus != null) virus.setVirusKey(xpp.getText());
                            }
                            break;
                        case XmlPullParser.TEXT:
                            break;
                        case XmlPullParser.END_TAG:
                            tagName = xpp.getName();
                            if (tagName.equals("item")) {
                                if (virus.getTarget().equals(this_name)) {
                                    viruses.add(virus);
                                    virus = null;
                                }
                                // Recycler Apdater에 데이터가 변경되었다고 통지
                                publishProgress();
                            }
                            break;
                    }
                    eventType = xpp.next();
                }// while

                //파싱 작업이 완료되었다!!
                //테스트로 Toast로 보여주기, 단 별도 스레드는
                //UI작업이 불가! 그래서 runOnUiThread()를 이용했었음.
                //이 UI작업을 하는 별도의 메소드로
                //결과를 리턴하는 방식을 사용

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
            adapter.notifyItemInserted(viruses.size());
        }

        @Override
        protected void onPostExecute(String s) { //매개 변수 s에 들어오는 값음 doIBackground()의 return 값이다.
            super.onPostExecute(s);

            //리사이클러에서 보여주는 데이터를 가진
            //아답터에게 데이터가 변경되었다고 공지
//            adapter.notifyDataSetChanged();
            //이 메소드 안에서는 UI변경 작업 가능
            Toast.makeText(SecondActivity.this, s + ":" + viruses.size(), Toast.LENGTH_SHORT).show();
        }
    }
}
