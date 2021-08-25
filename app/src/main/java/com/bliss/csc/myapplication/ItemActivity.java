package com.bliss.csc.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ItemActivity extends AppCompatActivity {

    public TextView t1, t2, t3, t4, t5;
    public String gen, spe, fam, ord, dmg, eco;
    public String key = "20218f5922b84a6b4691db8472132ececb19";
    public String tag_url = null;
    public int count = 0;
    public List<String> images = new ArrayList<>();
    public ImageView img;
    public Bitmap bitmap;
    public Button left;
    public Button right;
    public int photocount = 0;
    public int p_count = 0;

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
        img=findViewById(R.id.img);
        left=findViewById(R.id.left);
        right=findViewById(R.id.right);

        try {
            URL url=new URL("http://ncpms.rda.go.kr/npmsAPI/service?cropName=%EC%82%AC%EA%B3%BC&insectKorName=&apiKey="
            + key + "&serviceCode=SVC07&serviceCodeDetail=SVC07&displayCount=10&startPoint=1&insectKey=" + keynum);

            //스트림 역할하여 데이터 읽어오기 : 인터넷 작업은 반드시 퍼미션 작성해야함.
            //별도의 Thread 객체 생성
            XmlFeedTask task= new XmlFeedTask();
            task.execute(url);
            //doInBackground()메소드가 발동[thread의 start()와 같은 역할]
        } catch (MalformedURLException e) { e.printStackTrace();}

        t4.setMovementMethod(new ScrollingMovementMethod());
        t5.setMovementMethod(new ScrollingMovementMethod());

}
    class XmlFeedTask extends AsyncTask<URL, Void, String> {
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
                            }else if(tagName.equals("image")){
                                xpp.next();
                                tag_url = xpp.getText(); count++;
                                images.add(tag_url);
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
                            }else if (tagName.equals("insectSpecies")) {
                                xpp.next();
                                spe = xpp.getText();
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
                }// while

                //파싱 작업 끝
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
                t5.setText("정확한 생태 정보가 없습니다.");
            }
            arrays = images.toArray(new String[images.size()]);
            new LoadImage().execute(arrays[0]);
            p_count = arrays.length - 1;

            right.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(photocount == p_count) {
                        Toast.makeText(ItemActivity.this, "마지막 사진입니다", Toast.LENGTH_SHORT).show();
                    } else {
                        photocount++;
                        new LoadImage().execute(arrays[photocount]);
                    }
                }
            });
            left.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(photocount == 0) {
                        Toast.makeText(ItemActivity.this, "마지막 사진입니다", Toast.LENGTH_SHORT).show();
                    } else {
                        photocount--;
                        new LoadImage().execute(arrays[photocount]);
                    }
                }
            });

            return "파싱 완료";
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
                Toast.makeText(ItemActivity.this, "이미지가 존재하지 않거나 네트워크 오류 발생", Toast.LENGTH_SHORT).show();
            }
        }
    }



    public String stripHtml(String html) {
        return Html.fromHtml(html).toString();
    }
}