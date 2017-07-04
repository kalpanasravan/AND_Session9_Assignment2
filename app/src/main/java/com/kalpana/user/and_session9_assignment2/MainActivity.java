package com.kalpana.user.and_session9_assignment2;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class MainActivity extends AppCompatActivity {

    String extStorageDirectory;
    Bitmap bm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    //Initializing the button and imageview
        Button buttonSave = (Button)findViewById(R.id.button1);

        ImageView bmImage = (ImageView)findViewById(R.id.imageView1);
     //Setting the image from drwable folder to image view
        bm = BitmapFactory.decodeResource( getResources(), R.drawable.kitkat);
        bmImage.setImageBitmap(bm);

        //String extStorageDirectory = Environment.getExternalStorageDirectory().toString();
        extStorageDirectory = Environment.getExternalStorageDirectory().toString();
        buttonSave.setText("Save to " + extStorageDirectory + "/ic_launcher.PNG");
        buttonSave.setOnClickListener(buttonSaveOnClickListener);
    }


    Button.OnClickListener buttonSaveOnClickListener
            = new Button.OnClickListener(){

        @Override
        public void onClick(View arg0) {
            // TODO Auto-generated method stub
            OutputStream outStream = null;
            File file = new File(extStorageDirectory, "ic_launcher.PNG");
            try {
                outStream = new FileOutputStream(file);
                bm.compress(Bitmap.CompressFormat.PNG, 100, outStream);
                outStream.flush();
                outStream.close();

                Toast.makeText(MainActivity.this, "Saved", Toast.LENGTH_LONG).show();

            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                Toast.makeText(MainActivity.this, e.toString(), Toast.LENGTH_LONG).show();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                Toast.makeText(MainActivity.this, e.toString(), Toast.LENGTH_LONG).show();
            }

        }

    };

}