package com.example.move_in_sync.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.move_in_sync.MainActivity;
import com.example.move_in_sync.R;
import com.example.move_in_sync.student;

import java.util.ArrayList;

public class adapter extends BaseAdapter {

    Context context;
    ArrayList<student> arrayList;

    public adapter (Context context,ArrayList<student> arrayList)
    {
        this.context=context;
        this.arrayList=arrayList;
    }

    @Override
    public int getCount() {
        return this.arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.single_item,null);
        CheckBox c = (CheckBox) convertView.findViewById(R.id.checkbox);
        TextView t1 = (TextView) convertView.findViewById(R.id.id);
        TextView t2 = (TextView) convertView.findViewById(R.id.name);
        TextView t3 = (TextView) convertView.findViewById(R.id.Marks);
        TextView t4 = (TextView) convertView.findViewById(R.id.myclass);

       // c.setOnCheckedChangeListener((MainActivity) context);

        student student = arrayList.get(position);

        t1.setText(String.valueOf(student.getId()));
        t2.setText(student.getName());
        t3.setText(student.getMarks());
        t4.setText(student.getStudent_class());
        c.setChecked(student.isSelected());
        c.setTag(student);

        return convertView;

    }
}
