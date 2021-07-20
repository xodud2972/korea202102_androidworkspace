package com.koreait.xmlapp;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.koreait.xmlapp.domain.Member;

import java.util.ArrayList;
import java.util.List;

// 보여줄 데이터가 단순 String이 아닌, 보다 복합적인  경우엔, 데이텁뷰에 보여줄
// 데이터를 커스텀할 수 있는 어댑터 클래스 재정의
public class MyAdapter extends BaseAdapter {
    String TAG = this.getClass().getName();
    List<Member> list = new ArrayList<Member>();

    LayoutInflater layoutInflater;
    Context context;

    public MyAdapter(Context context){
        this.context=context;
    }

    @Override
    public int getCount() {
        Log.d(TAG, "핸들러로부터 넘겨받은 List의 사이즈는 " + list.size());
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
