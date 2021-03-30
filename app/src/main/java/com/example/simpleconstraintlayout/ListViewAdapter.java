package com.example.simpleconstraintlayout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Collection;
public class ListViewAdapter extends BaseAdapter {

        Context mContext;
        LayoutInflater inflater;
        private ArrayList<ClassNama>arrayList;
        public ListViewAdapter(Context context){
            mContext=context;
            inflater=LayoutInflater.from(mContext);
            this.arrayList=new ArrayList<ClassNama>();
            this.arrayList.addAll(Home_Activity.classNamaArrayList);
        }
        public class ViewHolder{
            TextView name;
        }


    @Override
    public int getCount() {
        return Home_Activity.classNamaArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return Home_Activity.classNamaArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final viewHolder holder;

        if (view == null) {
            holder = new viewHolder();
            view = inflater.inflate(R.layout.item_listview, null);
            holder.name = (TextView) view.findViewById(R.id.tvnama_item);
            view.setTag(holder);
        }else {
            holder=(viewHolder) view.getTag();
        }
        holder.name.setText(Home_Activity.classNamaArrayList.get(i).getName());
        return view;
    }
}
