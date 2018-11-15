package com.example.mvpdemo.mvedemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.DataViewHolder> {

    NetResponse response;
    Context context;

    public void setResponse(NetResponse response) {
        this.response = response;
        notifyDataSetChanged();
    }

    public DataAdapter(NetResponse response, Context context) {
        this.response = response;
        this.context = context;
    }

    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.data_adapter_item, parent, false);
        DataViewHolder viewHolder = new DataViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DataViewHolder holder, int position) {
        List<NetResponse.ResultBean> resultBeansList = response.getResult();
        if (holder != null && resultBeansList != null && resultBeansList.size() > 0) {
            NetResponse.ResultBean resultBean = resultBeansList.get(position);
            if (resultBean != null) {
                holder.tvName.setText(resultBean.getName());
                String imgNet = resultBean.getPic_s210();
                if(!TextUtils.isEmpty( imgNet )) {
                    Glide.with(context)
                            .load(imgNet)
                            .into(holder.imageView);
                }
                List<NetResponse.ResultBean.ContentBean> contentBeanList = resultBean.getContent();
                if (contentBeanList != null && contentBeanList.size() > 0) {
                    NetResponse.ResultBean.ContentBean start1 = contentBeanList.get(0);
                    if (start1 != null) {
                        holder.tvStart1.setText(start1.getAuthor());
                    }
                    NetResponse.ResultBean.ContentBean start2 = contentBeanList.get(1);
                    if (start2 != null) {
                        holder.tvStart2.setText(start2.getAuthor());
                    }
                    NetResponse.ResultBean.ContentBean start3 = contentBeanList.get(2);
                    if (start3 != null) {
                        holder.tvStart3.setText(start3.getAuthor());
                    }
                    NetResponse.ResultBean.ContentBean start4 = contentBeanList.get(3);
                    if (start4 != null) {
                        holder.tvStart4.setText(start4.getAuthor());
                    }

                }

            }
        }
    }

    @Deprecated
    private Bitmap getImg(String imgNet) {
        Bitmap bitmap = null;
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(imgNet).openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream inputStream = connection.getInputStream();
            bitmap = BitmapFactory.decodeStream(inputStream);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bitmap;
    }

    @Override
    public int getItemCount() {
        List<NetResponse.ResultBean> resultBeansList = response.getResult();
        if (resultBeansList == null) return 0;
        return resultBeansList.size();
    }

    class DataViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvStart1, tvStart2, tvStart3, tvStart4, tvTitle1, tvTitle2, tvTitle3, tvTitle4;
        ImageView imageView;

        public DataViewHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);
            imageView = itemView.findViewById(R.id.img);
            tvStart1 = itemView.findViewById(R.id.tv_start1);
            tvStart2 = itemView.findViewById(R.id.tv_start2);
            tvStart3 = itemView.findViewById(R.id.tv_start3);
            tvStart4 = itemView.findViewById(R.id.tv_start4);
            tvTitle1 = itemView.findViewById(R.id.tv_title1);
            tvTitle2 = itemView.findViewById(R.id.tv_title2);
            tvTitle3 = itemView.findViewById(R.id.tv_title3);
            tvTitle4 = itemView.findViewById(R.id.tv_title4);
        }
    }
}
