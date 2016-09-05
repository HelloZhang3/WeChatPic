package com.demo.zyd.wechatpic;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    public static String IMG_URL = "http://img5.imgtn.bdimg.com/it/u=858436735,1112745538&fm=21&gp=0.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.lv);

        List<String> urlList = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            urlList.add(IMG_URL);
        }

        MyAdapter myAdapter = new MyAdapter(urlList, this);
        listView.setAdapter(myAdapter);
    }

    class MyAdapter extends BaseAdapter {
        private List<String> dataList;
        private Context mContext;

        public MyAdapter(List<String> dataList, Context context) {
            this.dataList = dataList;
            this.mContext = context;
        }

        @Override
        public int getCount() {
            return dataList.size();
        }

        @Override
        public Object getItem(int position) {
            return getItem(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null) {
                holder = new ViewHolder();
                convertView = LayoutInflater.from(mContext).inflate(R.layout.grid_item, null);
                holder.gridView = (GridViewEx) convertView.findViewById(R.id.grid);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            List<String> urlList = new ArrayList<>();

            for (int i = 0; i < 5; i++) {
                urlList.add(IMG_URL);
            }

            ImgAdapter myAdapter = new ImgAdapter(urlList, mContext);
            holder.gridView.setAdapter(myAdapter);


            return convertView;
        }

        class ViewHolder {
            GridViewEx gridView;
        }
    }

    class ImgAdapter extends BaseAdapter {
        private List<String> dataList = new ArrayList<>();

        private Context mContext;

        public ImgAdapter(List<String> dataList, Context context) {
            this.dataList = dataList;
            this.mContext = context;
        }

        @Override
        public int getCount() {
            return dataList.size();
        }

        @Override
        public Object getItem(int position) {
            return getItem(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null) {
                holder = new ViewHolder();
                convertView = LayoutInflater.from(mContext).inflate(R.layout.img_item, null);
                holder.imageView = (ImageView) convertView.findViewById(R.id.iv);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            x.image().bind(holder.imageView, dataList.get(position));

            holder.imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext, position + "", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(mContext, ImagePagerActivity.class);
                    intent.putStringArrayListExtra(ImagePagerActivity.EXTRA_IMAGE_URLS, (ArrayList<String>) dataList);
                    intent.putExtra(ImagePagerActivity.EXTRA_IMAGE_INDEX, position);
                    mContext.startActivity(intent);
                }
            });

            return convertView;
        }

        class ViewHolder {
            ImageView imageView;
        }
    }
}
