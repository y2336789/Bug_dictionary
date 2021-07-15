package com.bliss.csc.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class ItemActivity extends AppCompatActivity {

    TextView t1, t2, t3, t4, t5;
    String gen, spe, fam, ord, dmg, eco;
    Button btn;

    public String key = "20218f5922b84a6b4691db8472132ececb19";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        Intent intent = getIntent();
        String keynum = intent.getStringExtra("InsectKey");

        t1=findViewById(R.id.target_name);
        t2=findViewById(R.id.species);
        t3=findViewById(R.id.fam_ord);
        t4=findViewById(R.id.what_dmg);
        t5=findViewById(R.id.env);

//        btn.findViewById(R.id.testbtn);
//        btn.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//                Intent intent1 = new Intent();
//            }
//        })
//

        try {
            URL url=new URL("http://ncpms.rda.go.kr/npmsAPI/service?cropName=%EC%82%AC%EA%B3%BC&insectKorName=&apiKey="
            + key + "&serviceCode=SVC07&serviceCodeDetail=SVC07&displayCount=10&startPoint=1&insectKey=" + keynum);

            //스트림역할하여 데이터 읽어오기 : 인터넷 작업은 반드시 퍼미션 작성해야함.
            //Network작업은 반드시 별도의 Thread만 할 수 있다.
            //별도의 Thread 객체 생성
            XmlFeedTask task= new XmlFeedTask();
            task.execute(url); //doInBackground()메소드가 발동[thread의 start()와 같은 역할]
        } catch (MalformedURLException e) { e.printStackTrace();}
        t4.setMovementMethod(new ScrollingMovementMethod());
        t5.setMovementMethod(new ScrollingMovementMethod());
    }

    class XmlFeedTask extends AsyncTask<URL, Void, String> {
        @Override
        protected String doInBackground(URL... urls) {
            URL url = urls[0];

            try {
                InputStream is = url.openStream();

                XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
                XmlPullParser xpp = factory.newPullParser();

                xpp.setInput(is, "utf-8");
                int eventType = xpp.getEventType();

                String tagName = null;

                while (eventType != XmlPullParser.END_DOCUMENT) {
                    switch (eventType) {
                        case XmlPullParser.START_DOCUMENT:
                            break;
                        case XmlPullParser.START_TAG:
                            tagName = xpp.getName();
                            if (tagName.equals("insectSpeciesKor")) {
                                xpp.next();
                                t1.setText(xpp.getText()+ " 어떤 해충인가요?");
                            }else if (tagName.equals("insectFamily")) {
                                xpp.next();
                                fam = xpp.getText();
                            }else if(tagName.equals("insectGenus")){
                                xpp.next();
                                gen = xpp.getText();
                            }else if(tagName.equals("ecologyInfo")){
                                xpp.next();
                                eco = xpp.getText();
                            }else if(tagName.equals("insectFamily")){
                                xpp.next();
                            }else if(tagName.equals("damageInfo")){
                                xpp.next();
                                dmg = xpp.getText();
                            }else if(tagName.equals("preventMethod")){
                                xpp.next();
                            }else if (tagName.equals("insectOrder")) {
                                xpp.next();
                                ord = xpp.getText();
                            }else if (tagName.equals("cropName")) {
                                xpp.next();
//                                insectFamily = xpp.getText();
                            }else if (tagName.equals("insectSpecies")) {
                                xpp.next();
                                //t2.setText(gen + " / " + xpp.getText());
                                spe = xpp.getText();
                            }
                            break;
                        case XmlPullParser.TEXT:
                            break;
                        case XmlPullParser.END_TAG:
                            tagName = xpp.getName();
                            if (tagName.equals("insectSpecies")) {
                                break;
                                // Recycler Apdater에 데이터가 변경되었다고 통지
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
            t2.setText(gen + " / " + spe);
            t3.setText(ord + " / " + fam);
            if(dmg !=null) {
                t4.setText(stripHtml(dmg));
            } else {
                t4.setText("정확한 피해 현상이 없습니다.");
            }
            if(eco!= null) {
                t5.setText(stripHtml(eco));
            } else {
                t5.setText("정확한 생태 정보가 없습니다.");            }

            return "파싱종료";
        }
    }
    public String stripHtml(String html) {
        return Html.fromHtml(html).toString();
    }
}