package com.forfarmers.myapplication;

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

import com.forfarmers.myapplication.R;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class BugItemActivity extends AppCompatActivity {
    public String name, gen, spe, fam, ord, dmg, eco, tag_url, prevent, keynum;
    public String key = "20218f5922b84a6b4691db8472132ececb19";
    public int count = 0;
    public int photoCount = 0;
    public int p_count = 0;
    public List<String> images = new ArrayList<>();
    public ImageView img;
    public Bitmap bitmap;
    public Button left, right;
    private LinearLayout container, container2, container3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bug);

        container = (LinearLayout) findViewById(R.id.p_parent);
        container2 = (LinearLayout) findViewById(R.id.p_second);
        container3 = (LinearLayout) findViewById(R.id.p_UpTitle);

        Intent intent = getIntent();
        keynum = intent.getStringExtra("InsectKey");
        img=findViewById(R.id.p_img);
        left=findViewById(R.id.p_left);
        right=findViewById(R.id.p_right);

        try {
            URL url=new URL("http://ncpms.rda.go.kr/npmsAPI/service?cropName=&insectKorName=&apiKey="
            + key + "&serviceCode=SVC07&serviceCodeDetail=SVC07&displayCount=10&startPoint=1&insectKey=" + keynum);
            XmlFeedTask task= new XmlFeedTask();
            task.execute(url);
        } catch (MalformedURLException e) { e.printStackTrace();}
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
                            if (tagName.equals("insectSpeciesKor")) {
                                xpp.next();
                                name = stripHtml(xpp.getText());
                            }else if (tagName.equals("insectFamily")) {
                                xpp.next();
                                fam = xpp.getText();
                            }else if(tagName.equals("insectGenus")){
                                xpp.next();
                                gen = xpp.getText();
                            }else if(tagName.equals("ecologyInfo")){
                                xpp.next();
                                if(xpp.getText() == null){
                                    break;
                                }else {
                                    eco = stripHtml(xpp.getText());
                                }
                            }else if(tagName.equals("image")){
                                xpp.next();
                                if(xpp.getText() == null){
                                    break;
                                }
                                tag_url = stripHtml(xpp.getText());
                                count++;
                                images.add(tag_url);
                            }else if(tagName.equals("insectFamily")){
                                xpp.next();
                            }else if(tagName.equals("preventMethod")){
                                xpp.next();
                                if(xpp.getText() == null){
                                    break;
                                }else {
                                    prevent = stripHtml(xpp.getText());
                                }
                            }else if (tagName.equals("insectOrder")) {
                                xpp.next();
                                if(xpp.getText() == null){
                                    break;
                                }else {
                                    ord = stripHtml(xpp.getText());
                                }
                            }else if (tagName.equals("cropName")) {
                                xpp.next();
                            }else if (tagName.equals("insectSpecies")) {
                                xpp.next();
                                if(xpp.getText() == null){
                                    break;
                                }else {
                                    spe = stripHtml(xpp.getText());
                                }
                            }
                            else if(tagName.equals("damageInfo")) {
                                xpp.next();
                                if(xpp.getText() == null){
                                    break;
                                }else {
                                    dmg = stripHtml(xpp.getText());
                                }
                            }
                            break;
                        case XmlPullParser.TEXT:
                            break;
                        case XmlPullParser.END_TAG:
                            tagName = xpp.getName();
                            if (tagName.equals("insectSpecies")) {
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

            right.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(photoCount == p_count) {
                        Toast.makeText(BugItemActivity.this, "????????? ???????????????", Toast.LENGTH_SHORT).show();
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
                        Toast.makeText(BugItemActivity.this, "????????? ???????????????", Toast.LENGTH_SHORT).show();
                    } else {
                        photoCount--;
                        new LoadImage().execute(arrays[photoCount]);
                    }
                }
            });

            publishProgress(name, gen, spe, fam, ord, dmg, eco, prevent);

            if(!name.equals("???????????????????????????")){
                arrays = images.toArray(new String[images.size()]);
                new LoadImage().execute(arrays[0]);
                p_count = arrays.length - 1;
            }
            return null;
        }
        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);

            // api??? ????????? ??????????????? ?????? ?????????
            if(name.equals("???????????????????????????")){
                new LoadImage().execute("https://www.forest.go.kr/newkfsweb/cmm/fms/getImage.do?atchFileId=FILE_000000000366698&fileSn=1&thumbYn=Y");
                p_count = 0;
            }

//            if((name.equals("???????????????") & (keynum.equals("H00000686")))){
//                new LoadImage().execute("http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/hlsct/&imageFileName=?????? ?????? ??????[20191130104611752]_tmb.jpg");
//                p_count = 0;
//            }
            CreateTextView_T(values[0]);
            WhatIs();
            sub();
            CreateTextView_subTitle("I. ?????????");
            CreateTextView_type(" -  " + values[1] + " / " + values[2]);
            CreateTextView_subTitle("???. ?????????");
            CreateTextView_type(" -  " + values[3] + " / " + values[4]);
            CreateTextView_subTitle("???. ?????? ????????? ?????????????");
            if(dmg != null)
                CreateTextView(" -  " + values[5]);
            else
                CreateTextView_Non_Dmg();
            LooksLike();
            CreateTextView_subTitle2("???. ??????????????? ????????? ??????????");
            if(eco != null)
                CreateTextView2(" -  " + values[6]);
            else
                CreateTextView_Non_info();
            CreateTextView_subTitle2("???. ????????? ????????????????");
            if(prevent != null)
                CreateTextView2(" -  " + values[7]);
            else
                CreateTextView_Non_prevent();
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
                Toast.makeText(BugItemActivity.this, "???????????? ???????????? ????????? ???????????? ?????? ??????", Toast.LENGTH_SHORT).show();
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
        view.setText("?????? ????????????????");
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
        view.setText("????????? ??????, ????????????, ?????? ????????? ???????????????");
        view.setTextSize(12);
        view.setTextColor(Color.GRAY);

        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        lp.leftMargin = 35;
        lp.bottomMargin = 50;
        view.setLayoutParams(lp);
        container.addView(view);
    }
    private void CreateTextView_type(String a){
        TextView view = new TextView(this);
        view.setText(a);
        view.setTextSize(17);
        view.setTextColor(Color.BLACK);

        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(lp);
        lp.topMargin=20;
        lp.bottomMargin=130;
        lp.leftMargin=50;
        container2.addView(view);
    }
    private void CreateTextView_subTitle(String a) {
        TextView view = new TextView(this);
        view.setText(a);
        view.setTextSize(20);
        view.setTextColor(Color.BLACK);

        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(lp);
        lp.topMargin=20;
        lp.bottomMargin=10;
        lp.leftMargin=35;
        container2.addView(view);
    }
    private void CreateTextView(String a) {
        TextView view = new TextView(this);
        view.setText(a);
        view.setTextSize(15);
        view.setTextColor(Color.BLACK);
        view.setLineSpacing(0, 1.5f);

        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        lp.topMargin=40;
        lp.leftMargin=50;
        lp.bottomMargin=100;
        lp.rightMargin=30;
        view.setLayoutParams(lp);
        container2.addView(view);
    }
    private void LooksLike() {
        TextView view = new TextView(this);
        view.setText("?????? ????????? ????????? ????????????!");
        view.setTextSize(17);
        view.setTextColor(Color.BLACK);

        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        lp.gravity = Gravity.CENTER;
        lp.topMargin = 10;
        view.setLayoutParams(lp);
        container.addView(view);

    }
    private void CreateTextView_subTitle2(String a) {
        TextView view = new TextView(this);
        view.setText(a);
        view.setTextSize(20);
        view.setTextColor(Color.BLACK);

        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(lp);
        lp.topMargin=40;
        lp.bottomMargin=30;
        lp.leftMargin=35;
        container2.addView(view);
    }
    private void CreateTextView2(String a) {
        TextView view = new TextView(this);
        view.setText(a);
        view.setTextSize(15);
        view.setTextColor(Color.BLACK);
        view.setLineSpacing(0, 1.5f);

        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        lp.leftMargin=30;
        lp.bottomMargin=70;
        lp.rightMargin=30;
        view.setLayoutParams(lp);
        container2.addView(view);
    }
    private void What_Pesticides(){
        TextView view = new TextView(this);
        view.setText("???. ?????? ?????? ????????????????");
        view.setTextSize(20);
        view.setTextColor(Color.BLACK);

        TextView view1 = new TextView(this);
        view1.setText(" -  " + "?????? ????????????..");
        view1.setTextSize(15);
        view1.setTextColor(Color.BLACK);

        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        lp.topMargin=10;
        lp.bottomMargin=30;
        lp.leftMargin=35;
        view.setLayoutParams(lp);
        view1.setLayoutParams(lp);
        container2.addView(view);
        container2.addView(view1);
    }
    private void from(){
        TextView view = new TextView(this);
        view.setText("?????? : ???????????????");
        view.setTextSize(15);
        view.setTextColor(Color.BLACK);

        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        lp.gravity = Gravity.END;
        view.setLayoutParams(lp);
        container2.addView(view);
    }
    private void CreateTextView_Non_Dmg() {
        TextView view = new TextView(this);
        view.setText("- ????????? ?????? ????????? ????????????.");
        view.setTextSize(16);
        view.setTextColor(Color.BLACK);

        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        lp.topMargin=10;
        lp.leftMargin = 50;
        lp.bottomMargin = 80;
        view.setLayoutParams(lp);
        container2.addView(view);
    }
    private void CreateTextView_Non_info() {
        TextView view = new TextView(this);
        view.setText("- ????????? ?????? ????????? ????????????..");
        view.setTextSize(16);
        view.setTextColor(Color.BLACK);

        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        lp.leftMargin = 50;
        lp.bottomMargin = 80;
        view.setLayoutParams(lp);
        container2.addView(view);
    }
    private void CreateTextView_Non_prevent() {
        TextView view = new TextView(this);
        view.setText("- ????????? ?????? ????????? ????????????..");
        view.setTextSize(16);
        view.setTextColor(Color.BLACK);

        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        lp.topMargin=10;
        lp.bottomMargin=80;
        lp.leftMargin=35;
        view.setLayoutParams(lp);
        container2.addView(view);
    }
}