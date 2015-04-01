package com.example.meznahsulaiman.androidproj;


import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class addassignment extends Activity {

    public DBAdapter db = new DBAdapter(this);

    EditText nameTxt;
    EditText dateTxt;
    EditText courseTxt;
    EditText notesTxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assignment_tracker);

    }
    public void addAssignment(View v)
    {
        Log.d("test", "adding");
        //get data from form
         nameTxt = (EditText)findViewById(R.id.editText);
         dateTxt = (EditText)findViewById(R.id.editText2);
         courseTxt = (EditText)findViewById(R.id.editText3);
         notesTxt = (EditText)findViewById(R.id.editText4);

        db.open();
        long id = db.insertRecord(nameTxt.getText().toString(),
                dateTxt.getText().toString(), courseTxt.getText().toString(),
                notesTxt.getText().toString());
        db.close();

        nameTxt.setText("");
        dateTxt.setText("");
        courseTxt.setText("");
        notesTxt.setText("");
        Toast.makeText(addassignment.this,"Assignment Added",
                Toast.LENGTH_LONG).show();

    }

    public void viewAssignments(View v) {


        Intent i1 = new Intent(this, Display.class);

         startActivity(i1);



    }


}
