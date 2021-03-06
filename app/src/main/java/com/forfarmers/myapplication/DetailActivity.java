package com.forfarmers.myapplication;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.forfarmers.myapplication.R;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class DetailActivity extends AppCompatActivity {
    public String key = "20218f5922b84a6b4691db8472132ececb19";
    private Intent intent;
    private String dist, link;
    private String this_name, target_name;
    private BugAdapter adapter;
    private VirusAdapter virusAdapter;
    private ArrayList<Bug> bugs = new ArrayList<>();
    private ArrayList<Virus> viruses = new ArrayList<>();
    ArrayList<Virus> virus = new ArrayList<>();
    private RecyclerView recyclerView;
    private Button change_btn;
    TextView tview, tv00;
    ImageView imagbtn;
    Context context;
    Document doc = null;
    LinearLayout layout;
    int num = 0;
    int change = 0;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weather);
        recyclerView = findViewById(R.id.weather_recycler);
        adapter = new BugAdapter(bugs, this);
        virusAdapter = new VirusAdapter(viruses, this);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        tview = (TextView)findViewById(R.id.textView);
        imagbtn = (ImageView)findViewById(R.id.imagebtn);
        layout = (LinearLayout)findViewById(R.id.layout);
        context = this;
        tv00=(TextView)findViewById(R.id.tv00);

        intent= getIntent();
        dist = intent.getStringExtra("code");
        link = "https://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=" + dist;

        Integer[] cropID = {R.drawable.crop0, R.drawable.crop1, R.drawable.crop2, R.drawable.crop3,
                R.drawable.crop4, R.drawable.crop5, R.drawable.crop6, R.drawable.crop7, R.drawable.crop8,
                R.drawable.crop9, R.drawable.crop10, R.drawable.crop11, R.drawable.crop12, R.drawable.crop13,
                R.drawable.crop14, R.drawable.crop15, R.drawable.crop16};
        Integer[] ID={-1};

        change_btn = findViewById(R.id.weather_change_btn);
        change_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (num == 0) {
                    num = 1;
                    changeView();
                    change_btn.setText("?????? ???????????? ??????");
                } else if (num == 1) {
                    num = 0;
                    originalView();
                    change_btn.setText("??? ???????????? ??????");
                }
            }
        });

        int i;
        for(i=0;i<7;i++) {
            ImageButton img = new ImageButton(context);

            img.setLayoutParams(new ViewGroup.LayoutParams(350, 220));
            img.setScaleType(ImageView.ScaleType.FIT_CENTER);
            img.setPadding(20, 20, 20, 20);
            img.setBackgroundColor(Color.argb(0, 0, 0, 0));
            img.setImageResource(cropID[i]);

            switch (i) {
                case 0:
                    img.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            bugs.clear();
                            viruses.clear();
                            readRss("??????");
                            V_readRss("??????");
                        }
                    });
                    break;
                case 1:
                    img.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            bugs.clear();
                            viruses.clear();
                            readRss("???");
                            V_readRss("???");
                        }
                    });
                    break;
                case 2:
                    img.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            bugs.clear();
                            viruses.clear();
                            readRss("??????");
                            V_readRss("??????");
                        }
                    });
                    break;
                case 3:
                    img.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            bugs.clear();
                            viruses.clear();
                            readRss("???");
                            V_readRss("???");
                        }
                    });
                    break;
                case 4:
                    img.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            bugs.clear();
                            viruses.clear();
                            readRss("??????");
                            V_readRss("??????");
                        }
                    });
                    break;
                case 5:
                    img.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            bugs.clear();
                            viruses.clear();
                            readRss("?????????");
                            V_readRss("?????????");
                        }
                    });
                    break;

                case 6:
                    img.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            bugs.clear();
                            viruses.clear();
                            readRss("??????");
                            V_readRss("??????");
                        }
                    });
                    break;
            }
            layout.addView(img);
        }


        //??????
        if(dist.indexOf("43") == 0){
            tv00.setText("?????? ?????? ??????");

            ImageButton img = new ImageButton(context);

            img.setLayoutParams(new ViewGroup.LayoutParams(350,220));
            img.setScaleType(ImageView.ScaleType.FIT_CENTER);
            img.setPadding(20,20,20,20);
            img.setBackgroundColor(Color.argb(0,0,0,0));
            img.setImageResource(cropID[8]);

            img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    readRss("????????????");
                }
            });

            layout.addView(img);
        }

        //??????
        else if(dist.indexOf("44") == 0){
            tv00.setText("?????? ?????? ??????");

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

        //??????
        else if(dist.indexOf("30")==0){
            tv00.setText("?????? ?????? ??????");

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

        //??????
        else if(dist.indexOf("36")==0){
            tv00.setText("?????? ?????? ??????");

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

        GetXMLTask1 task = new GetXMLTask1();
        task.execute(link);
    }
    void readRss(String cropName) {
        if (cropName.equals("????????????")) {
            this_name = cropName;
            if (bugs != null) {
                bugs.clear();
                adapter.notifyDataSetChanged();
                try {
                    URL url = new URL("http://ncpms.rda.go.kr/npmsAPI/service?cropName=????????????&insectKorName=&apiKey="
                            + key + "&serviceCode=SVC03&serviceCodeDetail=SVC07&displayCount=50&insectKey=");
                    RssFeedTask task = new RssFeedTask();
                    task.execute(url);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        } else if(cropName.equals("??????")) {
            this_name = cropName;
            if(bugs != null) {
                bugs.clear();
                adapter.notifyDataSetChanged();
                try {
                    URL url = new URL("http://ncpms.rda.go.kr/npmsAPI/service?cropName=??????&insectKorName=&apiKey="
                            + key + "&serviceCode=SVC03&serviceCodeDetail=SVC07&displayCount=50&insectKey=");
                    RssFeedTask task = new RssFeedTask();
                    task.execute(url);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        }else if(cropName.equals("???")) {
            this_name = cropName;
            if(bugs != null) {
                bugs.clear();
                adapter.notifyDataSetChanged();
                try {
                    URL url = new URL("http://ncpms.rda.go.kr/npmsAPI/service?cropName=???&insectKorName=&apiKey="
                            + key + "&serviceCode=SVC03&serviceCodeDetail=SVC07&displayCount=50&insectKey=");
                    RssFeedTask task = new RssFeedTask();
                    task.execute(url);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        }else if(cropName.equals("??????")) {
            this_name = cropName;
            if(bugs != null) {
                bugs.clear();
                adapter.notifyDataSetChanged();
                try {
                    URL url = new URL("http://ncpms.rda.go.kr/npmsAPI/service?cropName=??????&insectKorName=&apiKey="
                            + key + "&serviceCode=SVC03&serviceCodeDetail=SVC07&displayCount=50&insectKey=");
                    RssFeedTask task = new RssFeedTask();
                    task.execute(url);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        }else if(cropName.equals("???")) {
            this_name = cropName;
            if(bugs != null) {
                bugs.clear();
                adapter.notifyDataSetChanged();
                try {
                    URL url = new URL("http://ncpms.rda.go.kr/npmsAPI/service?cropName=???&insectKorName=&apiKey="
                            + key + "&serviceCode=SVC03&serviceCodeDetail=SVC07&displayCount=50&insectKey=");
                    RssFeedTask task = new RssFeedTask();
                    task.execute(url);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        }else if(cropName.equals("??????")) {
            this_name = cropName;
            if(bugs != null) {
                bugs.clear();
                adapter.notifyDataSetChanged();
                try {
                    URL url = new URL("http://ncpms.rda.go.kr/npmsAPI/service?cropName=??????&insectKorName=&apiKey="
                            + key + "&serviceCode=SVC03&serviceCodeDetail=SVC07&displayCount=50&insectKey=");
                    RssFeedTask task = new RssFeedTask();
                    task.execute(url);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        }else if(cropName.equals("?????????")) {
            this_name = cropName;
            if(bugs != null) {
                bugs.clear();
                adapter.notifyDataSetChanged();
                try {
                    URL url = new URL("http://ncpms.rda.go.kr/npmsAPI/service?cropName=?????????&insectKorName=&apiKey="
                            + key + "&serviceCode=SVC03&serviceCodeDetail=SVC07&displayCount=50&insectKey=");
                    RssFeedTask task = new RssFeedTask();
                    task.execute(url);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        }else if(cropName.equals("??????")) {
            this_name = cropName;
            if(bugs != null) {
                bugs.clear();
                adapter.notifyDataSetChanged();
                try {
                    URL url = new URL("http://ncpms.rda.go.kr/npmsAPI/service?cropName=??????&insectKorName=&apiKey="
                            + key + "&serviceCode=SVC03&serviceCodeDetail=SVC07&displayCount=50&insectKey=");
                    RssFeedTask task = new RssFeedTask();
                    task.execute(url);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    void V_readRss(String cropName) {
        if (cropName.equals("??????")) {
            this_name = cropName;
            if(viruses != null) {
                viruses.clear();
                virusAdapter.notifyDataSetChanged();
            }
            try {
                URL url = new URL("http://ncpms.rda.go.kr/npmsAPI/service?cropName=??????&insectKorName=&apiKey="
                        + key + "&serviceCode=SVC01&displayCount=50&serviceType=AA001&sickKey=");
               V_RssFeedTask task = new V_RssFeedTask();
                task.execute(url);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }else if (cropName.equals("???")) {
            this_name = cropName;
            if(viruses != null) {
                viruses.clear();
                virusAdapter.notifyDataSetChanged();
            }
            try {
                URL url = new URL("http://ncpms.rda.go.kr/npmsAPI/service?cropName=???&insectKorName=&apiKey="
                        + key + "&serviceCode=SVC01&displayCount=50&serviceType=AA001&sickKey=");
                V_RssFeedTask task = new V_RssFeedTask();
                task.execute(url);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        else if (cropName.equals("??????")) {
            this_name = cropName;
            if(viruses != null) {
                viruses.clear();
                virusAdapter.notifyDataSetChanged();
            }
            try {
                URL url = new URL("http://ncpms.rda.go.kr/npmsAPI/service?cropName=??????&insectKorName=&apiKey="
                        + key + "&serviceCode=SVC01&displayCount=50&serviceType=AA001&sickKey=");
                V_RssFeedTask task = new V_RssFeedTask();
                task.execute(url);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
    }

    private class GetXMLTask1 extends AsyncTask<String, Void, Document> {

        @Override
        protected Document doInBackground(String... urls) {
            URL url;
            try {
                url = new URL(urls[0]);
                DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                DocumentBuilder db = dbf.newDocumentBuilder(); //XML?????? ?????? ????????? ??????
                doc = db.parse(new InputSource(url.openStream())); //XML????????? ????????????.
                doc.getDocumentElement().normalize();

            } catch (Exception e) {
                Toast.makeText(getBaseContext(), "Parsing Error", Toast.LENGTH_SHORT).show();
            }
            return doc;
        }


        @Override
        protected void onPostExecute(Document doc) {

            String s = "";
            //data????????? ?????? ????????? ????????? ????????? ????????? ???????????? ??????
            NodeList nodeList = doc.getElementsByTagName("data");
            //data ????????? ????????? ????????? ??????, ???????????? ?????? ????????? ??????

            //?????? ???????????? ??????
            s += ""+ " ";

            Node node = nodeList.item(0); //data???????????? ??????
            Element fstElmnt = (Element) node;

            NodeList tempList = fstElmnt.getElementsByTagName("temp");
            s += "?????? : " + tempList.item(0).getChildNodes().item(0).getNodeValue() +"??? \n";

            NodeList websiteList = fstElmnt.getElementsByTagName("wfKor");
            s += "?????? = "+  websiteList.item(0).getChildNodes().item(0).getNodeValue() +"\n";
            switch (websiteList.item(0).getChildNodes().item(0).getNodeValue()){
                case "??????" :
                    imagbtn.setImageResource(R.drawable.sunny);
                    break;
                case "?????? ??????" :
                    imagbtn.setImageResource(R.drawable.littlecloud);
                    break;
                case "?????? ??????" :
                    imagbtn.setImageResource(R.drawable.clouds);
                    break;
                case "??????" :
                    imagbtn.setImageResource(R.drawable.cloudy);
                    break;
                case "???":
                    imagbtn.setImageResource(R.drawable.rain);
                    break;
                case "???" :
                    imagbtn.setImageResource(R.drawable.snow);
                    break;
                case "???/???" :
                    imagbtn.setImageResource(R.drawable.snowrain);
                    break;
            }
            NodeList moistList = fstElmnt.getElementsByTagName("reh");
            s += "?????? = "+  moistList.item(0).getChildNodes().item(0).getNodeValue() +"% \n";

            NodeList percentList = fstElmnt.getElementsByTagName("pop");
            s += "???????????? = "+  percentList.item(0).getChildNodes().item(0).getNodeValue() +"% \n";

            tview.setText(s);

            super.onPostExecute(doc);
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
                                if(bug!=null) {
                                    target_name = xpp.getText();
                                    bug.setName(xpp.getText());
                                }
                            }else if(tagName.equals("thumbImg")){
                                xpp.next();
                                if(target_name.equals("???????????????") & (this_name.equals("??????"))){
                                    bug.setImgUrl("http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/spcs/&imageFileName=ZM1AR0080M001[20110106120000000]_wm.jpg");
                                }
                                else if(target_name.equals("????????????????????????") & (this_name.equals("??????"))){
                                    bug.setImgUrl("http://ncpms.rda.go.kr/npmsAPI/thumbnailViewer.mo?uploadSpec=npms&uploadSubDirectory=/photo/spcs/&imageFileName=ZM1AJ0184M001[20110106120000000]_wm.jpg");
                                }
//                                else if(target_name.equals("???????????????") & (this_name.equals("??????"))){
//                                    bug.setImgUrl();
//                                }
                                else if(bug!=null) bug.setImgUrl(xpp.getText());
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
            return "????????????";
        }
        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
            adapter.notifyItemInserted(bugs.size());
        }
    }
    class V_RssFeedTask extends AsyncTask<URL, Void, String> {
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
                                    if(virus.getImgUrl() != null) {
                                        viruses.add(virus);
                                        virus = null;
                                    }
                                }
                                // Recycler Apdater??? ???????????? ?????????????????? ??????
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
            return "????????????";
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
            virusAdapter.notifyItemInserted(viruses.size());
        }
    }
    private void originalView(){
//        adapter = new BugAdapter(bugs, this);
        recyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
    }
    private void changeView(){
        recyclerView.setAdapter(virusAdapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
    }
}
