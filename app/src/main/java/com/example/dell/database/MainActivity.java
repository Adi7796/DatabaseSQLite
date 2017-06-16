package com.example.dell.database;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText name;
    EditText marks;
    Button addbutton;
    EditText subject;
    DbHelper mdb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       name=(EditText)findViewById(R.id.name_edit);
        marks=(EditText)findViewById(R.id.marks_edit);
         subject=(EditText)findViewById(R.id.subject_edit);
         addbutton=(Button)findViewById(R.id.add_button);
        mdb=new DbHelper(this);
        addData();
    }

    public void addData()
    {
        addbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            boolean isInserted= mdb.insertData( name.getText().toString().trim(),subject.getText().toString().trim(),
                    marks.getText().toString().trim() );

                if(isInserted==true)
                    Toast.makeText(MainActivity.this,"Data Inserted",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(MainActivity.this,"Data insertion falied",Toast.LENGTH_LONG).show();
            }
        });
    }
}
