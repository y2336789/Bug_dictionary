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

public class VirusActivity extends AppCompatActivity {

    public String key = "20218f5922b84a6b4691db8472132ececb19";
    RecyclerView recyclerView;
    ArrayList<Virus> viruses = new ArrayList<>();
    VirusAdapter adapter;
    String this_name;
    String[] crop_names = {"사과","배","복숭아","밤","포도","참다래(키위,다래)","무화과","블루베리"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        recyclerView = findViewById(R.id.s_recycler);
        adapter = new VirusAdapter(viruses, this);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        Spinner spinner =findViewById(R.id.s_select_crop);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_dropdown_item, crop_names);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                readRss(crop_names[position]);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

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
        }else if(cropName.equals("블루베리")){
            this_name = cropName;
            if(viruses != null) {
                viruses.clear();
                adapter.notifyDataSetChanged();
                try {
                    URL url = new URL("http://ncpms.rda.go.kr/npmsAPI/service?cropName=%EB%B8%94%EB%A3%A8%EB%B2%A0%EB%A6%AC&insectKorName=&apiKey="
                            + key + "&serviceCode=SVC01&serviceType=AA001&sickKey=");
                    RssFeedTask task = new RssFeedTask();
                    task.execute(url);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        }else if(cropName.equals("참다래(키위,다래)")){
            this_name = cropName;
            if(viruses != null) {
                viruses.clear();
                adapter.notifyDataSetChanged();
                try {
                    URL url = new URL("http://ncpms.rda.go.kr/npmsAPI/service?cropName=%EC%B0%B8%EB%8B%A4%EB%9E%98&insectKorName=&apiKey="
                            + key + "&serviceCode=SVC01&serviceType=AA001&sickKey=");
                    RssFeedTask task = new RssFeedTask();
                    task.execute(url);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        }else if(cropName.equals("무화과")){
            this_name = cropName;
            if(viruses != null) {
                viruses.clear();
                adapter.notifyDataSetChanged();
                try {
                    URL url = new URL("http://ncpms.rda.go.kr/npmsAPI/service?cropName=%EB%AC%B4%ED%99%94%EA%B3%BC&insectKorName=&apiKey="
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
                            } else if (tagName.equals("thumbImg")) {
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
            Toast.makeText(VirusActivity.this, s + ":" + viruses.size(), Toast.LENGTH_SHORT).show();
        }
    }
}
