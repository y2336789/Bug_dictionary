package com.bliss.csc.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.AsyncTask;
import android.os.Bundle;
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
    RecyclerView recyclerView;
    ArrayList<Bug> bugs = new ArrayList<>();
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler);

        adapter = new MyAdapter(bugs, this);
        recyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        readRss();
    }

    void readRss() {
        try {
            URL url = new URL("http://ncpms.rda.go.kr/npmsAPI/service?cropName=%EC%82%AC%EA%B3%BC&insectKorName=&apiKey="
                    + key + "&serviceCode=SVC03&serviceCodeDetail=SVC07&displayCount=50&insectKey=");
            RssFeedTask task = new RssFeedTask();
            task.execute(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
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
                            }else if(tagName.equals("oriImg")){
                                xpp.next();
                                if(bug!=null) bug.setImgUrl(xpp.getText());
                            }else if(tagName.equals("speciesName")){
                                xpp.next();
                                if(bug!=null) bug.setSpecies(xpp.getText());
                            }else if(tagName.equals("cropName")){
                                xpp.next();
                                if(bug!=null) bug.setCropName(xpp.getText());
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
                                bugs.add(bug);
                                bug=null;
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
            adapter.notifyItemInserted(bugs.size());
        }
        @Override
        protected void onPostExecute(String s) { //매개 변수 s에 들어오는 값음 doIBackground()의 return 값이다.
            super.onPostExecute(s);

            //리사이클러에서 보여주는 데이터를 가진
            //아답터에게 데이터가 변경되었다고 공지
//            adapter.notifyDataSetChanged();
            //이 메소드 안에서는 UI변경 작업 가능
            Toast.makeText(MainActivity.this, s+":"+bugs.size(), Toast.LENGTH_SHORT).show();
        }

    }
}