package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class DetailActivity extends AppCompatActivity {

    private Intent intent;
    private String dist, link;
    TextView tview;
    ImageButton imagbtn;
    Context context;
    Document doc = null;
    LinearLayout layout;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weather);

        tview = (TextView)findViewById(R.id.textView);
        imagbtn = (ImageButton)findViewById(R.id.imagebtn);
        layout = (LinearLayout)findViewById(R.id.layout);
        context = this;

        intent= getIntent();
        dist = intent.getStringExtra("code");
        link = "https://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=" + dist;

        Integer[] cropID = {R.drawable.crop0, R.drawable.crop1, R.drawable.crop2, R.drawable.crop3,
                R.drawable.crop4, R.drawable.crop5, R.drawable.crop6, R.drawable.crop7, R.drawable.crop8,
                R.drawable.crop9, R.drawable.crop10, R.drawable.crop11, R.drawable.crop12, R.drawable.crop13,
                R.drawable.crop14, R.drawable.crop15, R.drawable.crop16};
        Integer[] ID={-1};

        int i;
        for(i=0;i<7;i++){
            ImageButton img = new ImageButton(context);

            img.setLayoutParams(new ViewGroup.LayoutParams(350,220));
            img.setScaleType(ImageView.ScaleType.FIT_CENTER);
            img.setPadding(20,20,20,20);
            img.setBackgroundColor(Color.argb(0,0,0,0));
            img.setImageResource(cropID[i]);
            layout.addView(img);
        }


        //충북
        if(dist.indexOf("43") == 0){
            ImageButton img = new ImageButton(context);

            img.setLayoutParams(new ViewGroup.LayoutParams(350,220));
            img.setScaleType(ImageView.ScaleType.FIT_CENTER);
            img.setPadding(20,20,20,20);
            img.setBackgroundColor(Color.argb(0,0,0,0));
            img.setImageResource(cropID[8]);
            layout.addView(img);
        }

        //충남
        else if(dist.indexOf("44") == 0){
            for(i=7;i<12;i++){
                ImageButton img = new ImageButton(context);

                img.setLayoutParams(new ViewGroup.LayoutParams(350,220));
                img.setScaleType(ImageView.ScaleType.FIT_CENTER);
                img.setPadding(20,20,20,20);
                img.setBackgroundColor(Color.argb(0,0,0,0));
                img.setImageResource(cropID[i]);
                layout.addView(img);
            }

        }

        //대전
        else if(dist.indexOf("30")==0){
            for(i=12;i<16;i++){
                ImageButton img = new ImageButton(context);

                img.setLayoutParams(new ViewGroup.LayoutParams(350,220));
                img.setScaleType(ImageView.ScaleType.FIT_CENTER);
                img.setPadding(20,20,20,20);
                img.setBackgroundColor(Color.argb(0,0,0,0));
                img.setImageResource(cropID[i]);
                layout.addView(img);
            }

        }

        //세종
        else if(dist.indexOf("36")==0){
            for(i=15;i<17;i++){
                ImageButton img = new ImageButton(context);

                img.setLayoutParams(new ViewGroup.LayoutParams(350,220));
                img.setScaleType(ImageView.ScaleType.FIT_CENTER);
                img.setPadding(20,20,20,20);
                img.setBackgroundColor(Color.argb(0,0,0,0));
                img.setImageResource(cropID[i]);
                layout.addView(img);
            }
        }
    }

    public void MyonClick(View view){
        GetXMLTask1 task = new GetXMLTask1();
        task.execute(link);
    }
    private class GetXMLTask1 extends AsyncTask<String, Void, Document> {

        @Override
        protected Document doInBackground(String... urls) {
            URL url;
            try {
                url = new URL(urls[0]);
                DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                DocumentBuilder db = dbf.newDocumentBuilder(); //XML문서 빌더 객체를 생성
                doc = db.parse(new InputSource(url.openStream())); //XML문서를 파싱한다.
                doc.getDocumentElement().normalize();

            } catch (Exception e) {
                Toast.makeText(getBaseContext(), "Parsing Error", Toast.LENGTH_SHORT).show();
            }
            return doc;
        }


        @Override
        protected void onPostExecute(Document doc) {

            String s = "";
            //data태그가 있는 노드를 찾아서 리스트 형태로 만들어서 반환
            NodeList nodeList = doc.getElementsByTagName("data");
            //data 태그를 가지는 노드를 찾음, 계층적인 노드 구조를 반환

            //날씨 데이터를 추출
            s += ""+ " ";

            Node node = nodeList.item(0); //data엘리먼트 노드
            Element fstElmnt = (Element) node;

            NodeList tempList = fstElmnt.getElementsByTagName("temp");
            s += "기온 : " + tempList.item(0).getChildNodes().item(0).getNodeValue() +"도 \n";

            NodeList websiteList = fstElmnt.getElementsByTagName("wfKor");
            s += "날씨 = "+  websiteList.item(0).getChildNodes().item(0).getNodeValue() +"\n";
            switch (websiteList.item(0).getChildNodes().item(0).getNodeValue()){
                case "맑음" :
                    imagbtn.setImageResource(R.drawable.sunny);
                    break;
                case "구름 조금" :
                    imagbtn.setImageResource(R.drawable.cloudy);
                    break;
                case "구름 많음" :
                    imagbtn.setImageResource(R.drawable.littlecloud);
                    break;
                case "흐림" :
                    imagbtn.setImageResource(R.drawable.cloud);
                    break;
                case "비":
                    imagbtn.setImageResource(R.drawable.rain);
                    break;
                case "눈" :
                    imagbtn.setImageResource(R.drawable.snow);
                    break;
                case "눈/비" :
                    imagbtn.setImageResource(R.drawable.snowrain);
                    break;
            }
            NodeList moistList = fstElmnt.getElementsByTagName("reh");
            s += "습도 = "+  moistList.item(0).getChildNodes().item(0).getNodeValue() +"% \n";

            NodeList percentList = fstElmnt.getElementsByTagName("pop");
            s += "강수확률 = "+  percentList.item(0).getChildNodes().item(0).getNodeValue() +"% \n";

            tview.setText(s);

            super.onPostExecute(doc);
        }
    }
}
