package com.example.helloworld;

import android.bluetooth.le.ScanResult;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.List;

public class ADapterlist extends BaseAdapter {


    Context context;
    LayoutInflater inflater;
    List<ScanResult> wifiList;

    public ADapterlist(Context context,List<ScanResult> wifiList)
    {
        this.context=context;
        this.wifiList=wifiList;
        inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return wifiList.size();
    }

    @Override
    public Object getItem(int position) {
        return wifiList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder;
        View view=convertView;
        if(view==null)
        {
            view=inflater.inflate(R.layout.listview,null);
            holder=new Holder();
            holder.tvDetails=(TextView)view.findViewById(R.id.textView3);
            view.setTag(holder);
        }
        else
        {
            holder=(Holder)view.getTag();
        }
        return null;
    }
    class Holder
    {
        TextView tvDetails;
    }
}
