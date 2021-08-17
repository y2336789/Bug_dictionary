package com.bliss.csc.myapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter {

    String insectKey = null;
    ArrayList<Bug> bugs;
    Context context;

    public MyAdapter(ArrayList<Bug> items, Context context) {
        this.bugs = items;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView= LayoutInflater.from(context).inflate(R.layout.recycler_bug,parent,false);
        VH vh= new VH(itemView);
        return vh;
    }
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        VH vh= (VH)holder;

        //현재번째(position) 아이템 얻어오기
        Bug bug= bugs.get(position);
        vh.name.setText(bug.getName());
        vh.species.setText(bug.getSpecies());
        vh.cropName.setText("피해작물 : "+bug.getCropName());
        insectKey=bug.getInsectKey();

        //이미지는 없을 수도 있음.
        if(bug.getImgUrl()==null){
            vh.iv.setVisibility(View.GONE);
        }else{
            vh.iv.setVisibility(View.VISIBLE);
            //네트워크에 있는 이미지를 보여주려면
            //별도의 Thread가 필요한데 이를 편하게
            //해주는 Library사용(Glide library)

            Glide.with(context).load(bug.getImgUrl()).into(vh.iv);
        }
    }
    @Override
    public int getItemCount() {
        return bugs.size();
    }

    //이너클래스
    class VH extends RecyclerView.ViewHolder{

        TextView name, species, cropName;
        ImageView iv;

        public VH(@NonNull View itemView) {
            super(itemView);

            name=itemView.findViewById(R.id.name);
            species=itemView.findViewById(R.id.species);
            cropName=itemView.findViewById(R.id.cropName);
            iv=itemView.findViewById(R.id.iv);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String insectKey = bugs.get(getLayoutPosition()).getInsectKey();

                    Intent intent = new Intent(context, ItemActivity.class);
                    intent.putExtra("InsectKey", insectKey);
                    context.startActivity(intent);
                }
            });

        }
    }
}