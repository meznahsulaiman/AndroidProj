package com.example.meznahsulaiman.androidproj;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import android.widget.TextView;
import android.content.Context;
/**
 * Created by meznahSulaiman on 3/30/15.
 */
public class Display extends Activity

{




    protected void onCreate(Bundle savedInstanceState) {
        
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display);


    }

  public Cursor display(View v)
  {


      
      db.open();
      Cursor c = ob.getAllRecords();
      if (c.moveToFirst())
      {
          do {
              DisplayRecord(c);
          } while (c.moveToNext());
      }
      ob.close();

      return c;
  }

    public void DisplayRecord(Cursor c)
    {
        Toast.makeText(this,
                "id: " + c.getString(0) + "\n" +
                        "Title: " + c.getString(1) + "\n" +
                        "Due Date: " + c.getString(2),
                Toast.LENGTH_SHORT).show();
    }






}
