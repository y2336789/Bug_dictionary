package com.forfarmers.myapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.forfarmers.myapplication.R;

import java.util.ArrayList;

public class VirusAdapter extends RecyclerView.Adapter{
    String virusKey = null;
    ArrayList<Virus> viruses;
    Context context;

    public VirusAdapter(ArrayList<Virus> items, Context context) {
        this.viruses = items;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView= LayoutInflater.from(context).inflate(R.layout.recycler_virus,parent,false);
        VH vh= new VH(itemView);
        return vh;
    }
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        VH vh= (VH)holder;

        //현재번째(position) 아이템 얻어오기
        Virus virus= viruses.get(position);
        vh.sickName.setText(virus.getName());
        vh.sickCropName.setText("피해작물 : "+virus.getTarget());
        virusKey=virus.getVirusKey();

        //이미지는 없을 수도 있음.
        if(virus.getImgUrl()==null){
            vh.sickIv.setVisibility(View.GONE);
        }else{
            vh.sickIv.setVisibility(View.VISIBLE);
            Glide.with(context).load(virus.getImgUrl()).into(vh.sickIv);
        }
    }

    @Override
    public int getItemCount() {
        return viruses.size();
    }

    class VH extends RecyclerView.ViewHolder{

        TextView sickName, sickCropName;
        ImageView sickIv;

        public VH(@NonNull View itemView) {
            super(itemView);

            sickName=itemView.findViewById(R.id.sickName);
            sickCropName=itemView.findViewById(R.id.sickCropName);
            sickIv=itemView.findViewById(R.id.sickIv);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String virusKey = viruses.get(getLayoutPosition()).getVirusKey();

                    Intent intent = new Intent(context, VirusItemActivity.class);
                    intent.putExtra("VirusKey", virusKey);
                    context.startActivity(intent);
                }
            });

        }
    }
}
