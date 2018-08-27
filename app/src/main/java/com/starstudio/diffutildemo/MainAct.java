package com.starstudio.diffutildemo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
//https://blog.csdn.net/zxt0601/article/details/52562770
public class MainAct extends AppCompatActivity {

    RecyclerView recyclerView;

    MyAdpater adapter;
    List<UserBean> data1 = getData1();
    List<UserBean> data2 = getData2();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.mButton1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DiffUtil.DiffResult diffResult =DiffUtil.calculateDiff(new DiffCalback(adapter.mDatas,data1));
                diffResult.dispatchUpdatesTo(adapter);
                adapter.mDatas.clear();
                adapter.mDatas.addAll(data1);
            }
        });
        findViewById(R.id.mButton2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DiffUtil.DiffResult diffResult =DiffUtil.calculateDiff(new DiffCalback(adapter.mDatas,data2));
                diffResult.dispatchUpdatesTo(adapter);
                adapter.mDatas.clear();
                adapter.mDatas.addAll(data2);
            }
        });

        recyclerView = findViewById(R.id.mRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter = new MyAdpater());
//        adapter.mDatas= data1;
        adapter.mDatas.addAll(data1);
        adapter.notifyDataSetChanged();
    }



    private List<UserBean> getData1(){

        List<UserBean> userBeans =new ArrayList<>();
        userBeans.add(new UserBean(2130+"",321+"",1231+""));
        userBeans.add(new UserBean(2132+"",321+"",1231+""));
        userBeans.add(new UserBean(2131+"",321231+"",11456231+""));
        for(int i=20;i>0;i--){
            userBeans.add(new UserBean(i+"",i+"",i+""));
        }

        return userBeans;
    }

    private List<UserBean> getData2(){

        List<UserBean> userBeans =new ArrayList<>();
        userBeans.add(new UserBean(2130+"",3210+"",1231+""));
        userBeans.add(new UserBean(2132+"",321+"",1231+""));
        userBeans.add(new UserBean(2131+"",321+"",1231+""));
        for(int i=20;i>0;i--){

            userBeans.add(new UserBean(i+"",i+"",i+""));
        }

        return userBeans;
    }


    private class MyAdpater extends RecyclerView.Adapter<MyAdpater.MyViewHolder> {

        private List<UserBean> mDatas =new ArrayList<>();


        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(MainAct.this).inflate(R.layout.item_list,null,false);
            MyViewHolder holder = new MyViewHolder(view);
            return holder;
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
            UserBean userBean = mDatas.get(i);
            myViewHolder.textView.setText(userBean.getAge()+"_"+userBean.getName()+"_"+userBean.getIntro());
        }

        //只针对 改变的数据进行局部刷新
//        @Override
//        public void onBindViewHolder(MyViewHolder holder, int position, List<Object> payloads) {
//            if(payloads.isEmpty()){
//                super.onBindViewHolder(holder, position, payloads);
//            }else{
//                Bundle bundle = (Bundle) payloads.get(0);
//                for(String key:bundle.keySet()){
//                    switch (key){
//                        case "name":
//                            holder.textView.setText(mDatas.get(position).getName());
//                            break;
//                    }
//
//                }
//
//            }
//
//        }

        @Override
        public int getItemCount() {
            return mDatas.size();
        }

        class MyViewHolder extends RecyclerView.ViewHolder {
            TextView textView;
            public MyViewHolder(@NonNull View itemView) {
                super(itemView);
                textView =  itemView.findViewById(R.id.textView);
            }
        }

    }


}
