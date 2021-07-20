package com.koreait.xmlapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.koreait.xmlapp.domain.MemberHandler;

import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class MainActivity extends AppCompatActivity {
    SAXParserFactory factory;
    SAXParser saxParser;
    MemberHandler memberHandler;
    ListView listView;
    MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 프로그램이 가동되자 마자, 리스트뷰와 어댑터가 연결되어 있게 처리
        listView = findViewById(R.id.listView);
        myAdapter = new MyAdapter(this);
        listView.setAdapter(myAdapter); // 연결
    }

    public void loadData(View view){
        factory = SAXParserFactory.newInstance();
        InputStream is = null;

        // 파싱 수행
        try {
            saxParser = factory.newSAXParser();
            AssetManager assetManager = this.getResources().getAssets();
            is = assetManager.open("members.xml");
            saxParser.parse(is, memberHandler = new MemberHandler()); // 파싱 시작
            //파싱이 완료되면, list가 채워져 있을 것이고, 이 list를 MyAdapter가 보유한 list대신에 대입하자.
            myAdapter.list=memberHandler.list;//대체
            listView.invalidate();//리스트뷰 refresh



        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if(is!=null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}