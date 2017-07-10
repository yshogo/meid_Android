package com.example.shogoyamada.meid.adapeters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.shogoyamada.meid.R;
import com.example.shogoyamada.meid.common.BaseActivity;
import com.example.shogoyamada.meid.models.ArticleCellModel;

import java.util.List;

/**
 * 記事一覧を管理する
 */
public class UserListViewAdapter extends ArrayAdapter<ArticleCellModel>{

    private int mResource;
    private List<ArticleCellModel> list;
    private LayoutInflater mInflater;

    public UserListViewAdapter(BaseActivity activity, int mResource, List<ArticleCellModel> list){
        super(activity,mResource,list);

        this.list = list;
        mInflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        View v;

        if (convertView != null){
            v = convertView;
        }else{
            v = mInflater.inflate(R.layout.view_listview_cell,null);
        }

        ArticleCellModel item = list.get(position);

        TextView titleText = v.findViewById(R.id.cell_title);
        titleText.setText(item.getTitle());

        TextView dateText = v.findViewById(R.id.cell_date);
        dateText.setText(item.getDate());

        TextView articleText = v.findViewById(R.id.cell_article);
        articleText.setText(item.getArticle());

        return v;
    }
}
