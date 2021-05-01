package com.example.move_in_sync;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class selected_data extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_data);
        Bundle extra = getIntent().getExtras();
        String id = extra.getString("id");
        String name = extra.getString("name");
        String marks = extra.getString("marks");
        String student_class = extra.getString("student_class");

        TextView t1 = (TextView) findViewById(R.id.id);
        TextView t2 = (TextView) findViewById(R.id.name);
        TextView t3 = (TextView) findViewById(R.id.Marks);
        TextView t4 = (TextView) findViewById(R.id.myclass);

        t1.setText(id);
        t2.setText(name);
        t3.setText(marks);
        t4.setText(student_class);
    }
}