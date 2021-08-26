package com.bliss.csc.myapplication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Html;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class VirusItemActivity extends AppCompatActivity {

    private String name, dmg, prev, tag_url;
    private String key = "20218f5922b84a6b4691db8472132ececb19";
    private int count = 0;
    private int photoCount = 0;
    private int p_count = 0;
    private List<String> images = new ArrayList<>();
    private ImageView img;
    private Bitmap bitmap;
    private Button left, right;
    private LinearLayout container, container2, container3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dynamic_virus_tiem);

        container = (LinearLayout) findViewById(R.id.parent);
        container2 = (LinearLayout) findViewById(R.id.second);
        container3 = (LinearLayout) findViewById(R.id.UpTitle);

        Intent intent = getIntent();
        String keynum = intent.getStringExtra("VirusKey");
        img = findViewById(R.id.v_img);
        left = findViewById(R.id.v_left);
        right = findViewById(R.id.v_right);

        try {
            URL url = new URL("http://ncpms.rda.go.kr/npmsAPI/service?cropName=&apiKey="
                    + key + "&serviceCode=SVC05&serviceType=AA001&sickKey=" + keynum);
            XmlFeedTask task = new XmlFeedTask();
            task.execute(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    class XmlFeedTask extends AsyncTask<URL, String, String> {
        private String[] arrays = null;
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
                            if(tagName.equals("sickNameKor")) {
                                xpp.next();
                                name = stripHtml(xpp.getText());
                            }else if (tagName.equals("preventionMethod")) {
                                xpp.next();
                                prev = stripHtml(xpp.getText());
                            }else if(tagName.equals("image")){
                                xpp.next();
                                tag_url = xpp.getText(); count++;
                                images.add(tag_url);
                            }else if(tagName.equals("symptoms")){
                                xpp.next();
                                dmg = stripHtml(xpp.getText());
                            }
                        case XmlPullParser.TEXT:
                            break;
                        case XmlPullParser.END_TAG:
                            tagName = xpp.getName();
                            if (tagName.equals("sickNameEng")) {
                                xpp.next();
                                break;
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
            arrays = images.toArray(new String[images.size()]);
            new LoadImage().execute(arrays[0]);
            p_count = arrays.length - 1;

            right.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(photoCount == p_count) {
                        Toast.makeText(VirusItemActivity.this, "마지막 사진입니다", Toast.LENGTH_SHORT).show();
                    } else {
                        photoCount++;
                        new LoadImage().execute(arrays[photoCount]);
                    }
                }
            });
            left.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(photoCount == 0) {
                        Toast.makeText(VirusItemActivity.this, "첫번째 사진입니다", Toast.LENGTH_SHORT).show();
                    } else {
                        photoCount--;
                        new LoadImage().execute(arrays[photoCount]);
                    }
                }
            });
            publishProgress(name,dmg,prev);
            return null;
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
            CreateTextView_T(values[0]);
            WhatIs();
            sub();
            CreateTextView_What_Dmg();
            if(values[1]!=null)
                CreateTextView(values[1]);
            else
                CreateTextView_Non_Dmg();
            CreateTextView_How_Prev();
            if(values[2]!=null)
                CreateTextView2(values[2]);
            else
                CreateTextView_Non_Prev();
            What_Pesticides();
            from();
        }
    }

    class LoadImage extends AsyncTask<String, String, Bitmap> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        protected Bitmap doInBackground(String... args){
            try {
                bitmap = BitmapFactory.decodeStream((InputStream) new URL(args[0]).getContent());
            } catch (Exception e) {
                e.printStackTrace();
            }
            return bitmap;
        }

        protected void onPostExecute(Bitmap image) {
            if(image != null){
                img.setImageBitmap(image);
            } else {
                Toast.makeText(VirusItemActivity.this, "이미지가 존재하지 않거나 네트워크 오류 발생", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public String stripHtml(String html) {
        return Html.fromHtml(html).toString();
    }
    private void CreateTextView_T(String a) {
        TextView view = new TextView(this);
        view.setText(a);
        view.setTextSize(20);
        view.setTextColor(Color.BLACK);

        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        lp.gravity = Gravity.CENTER;
        lp.topMargin = 25;
        lp.leftMargin = 35;
        lp.rightMargin = 25;
        view.setLayoutParams(lp);
        container3.addView(view);
    }
    private void WhatIs() {
        TextView view = new TextView(this);
        view.setText("어떤 병인가요?");
        view.setTextSize(15);
        view.setTextColor(Color.GRAY);

        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        lp.gravity = Gravity.CENTER;
        lp.topMargin = 25;
        view.setLayoutParams(lp);
        container3.addView(view);
    }
    private void sub() {
        TextView view = new TextView(this);
        view.setText("작물별 피해증상, 예방방법을 확인하세요");
        view.setTextSize(12);
        view.setTextColor(Color.GRAY);

        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        lp.leftMargin = 35;
        lp.bottomMargin = 50;
        view.setLayoutParams(lp);
        container.addView(view);

    }
    private void CreateTextView_What_Dmg() {
        TextView view = new TextView(this);
        view.setText("I. 어떤 피해를 발생시키나요??");
        view.setTextSize(14);
        view.setTextColor(Color.BLACK);

        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        lp.gravity = Gravity.CENTER;
        view.setLayoutParams(lp);
        lp.topMargin=20;
        lp.bottomMargin=30;
        container.addView(view);
    }
    private void CreateTextView(String a) {
        TextView view = new TextView(this);
        view.setText(a);
        view.setTextSize(12);
        view.setTextColor(Color.BLACK);
        view.setLineSpacing(0, 1.2f);

        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        lp.leftMargin=30;
        lp.rightMargin=30;
        view.setLayoutParams(lp);
        container.addView(view);
    }
    private void CreateTextView_How_Prev() {
        TextView view = new TextView(this);
        view.setText("Ⅱ. 어떻게 예방하나요??");
        view.setTextSize(14);
        view.setTextColor(Color.BLACK);

        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        lp.gravity = Gravity.CENTER;
        view.setLayoutParams(lp);
        lp.bottomMargin=30;
        container2.addView(view);
    }
    private void CreateTextView2(String a) {
        TextView view = new TextView(this);
        view.setText(a);
        view.setTextSize(12);
        view.setTextColor(Color.BLACK);
        view.setLineSpacing(0, 1.2f);

        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        lp.leftMargin=30;
        lp.rightMargin=30;
        lp.bottomMargin=50;
        view.setLayoutParams(lp);
        container2.addView(view);
    }
    private void CreateTextView_Non_Dmg() {
        TextView view = new TextView(this);
        view.setText("정확한 피해 현상이 없습니다.");
        view.setTextSize(12);
        view.setTextColor(Color.BLACK);

        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        lp.gravity = Gravity.CENTER;
        view.setLayoutParams(lp);
        container2.addView(view);
    }
    private void CreateTextView_Non_Prev() {
        TextView view = new TextView(this);
        view.setText("정확한 예방 정보가 없습니다.");
        view.setTextSize(12);
        view.setTextColor(Color.BLACK);

        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        lp.gravity = Gravity.CENTER;
        view.setLayoutParams(lp);
        container2.addView(view);
    }
    private void What_Pesticides(){
        TextView view = new TextView(this);
        view.setText("Ⅲ. 어떤 약을 써야하나요?");
        view.setTextSize(15);
        view.setTextColor(Color.BLACK);

        TextView view1 = new TextView(this);
        view1.setText("준비 중입니다..");
        view1.setTextSize(12);
        view1.setTextColor(Color.BLACK);

        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        lp.gravity = Gravity.CENTER;
        lp.bottomMargin=50;
        view.setLayoutParams(lp);
        view1.setLayoutParams(lp);
        container2.addView(view);
        container2.addView(view1);
    }
    private void from(){
        TextView view = new TextView(this);
        view.setText("출처 : 농촌진흥청");
        view.setTextSize(12);
        view.setTextColor(Color.BLACK);

        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        lp.gravity = Gravity.END;
        view.setLayoutParams(lp);
        container2.addView(view);
    }
}


