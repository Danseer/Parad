package com.example.parad;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;

import java.io.FileNotFoundException;
import java.io.InputStream;

import static android.R.attr.data;

public class AddActivity extends AppCompatActivity {

    private static final int REQUEST_CAMERA = 1;
    private static final int REQUEST_GALLERY = 2;
    private static final int REQUEST = 3;
    private ImageView iv;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_filter:

                    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                    tab1Start catFragment = new tab1Start();
                    ft.replace(R.id.container, catFragment);
                    ft.commit();
                    return true;

                case R.id.navigation_plus:

                   // intent = new Intent(MainActivity.this,AddActivity.class);
                   // startActivity(intent);
                    return true;

                case R.id.navigation_person:

                    // intent = new Intent(MainActivity.this, LoginActivity.class);
                    // startActivity(intent);

                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
iv=(ImageView)findViewById(R.id.iv_addactivity);

       // Intent photoPickerIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
       // Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
       // photoPickerIntent.setType("image/*");
       // startActivityForResult(photoPickerIntent, REQUEST_GALLERY);
selectImage();
    }

    private void selectImage(){
        final CharSequence[] options = {"Take Photo", "Choose From Gallery","Cancel"};

       AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(AddActivity.this);

        builder.setTitle("Select Option");

        builder.setItems(options, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                if (options[item].equals("Choose From Gallery")) {
                    dialog.dismiss();
                   // Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
                    photoPickerIntent.setType("image/*");
                  //  startActivityForResult(intent, PICK_IMAGE_CAMERA);
                    startActivityForResult(photoPickerIntent, REQUEST_GALLERY);
                }

                else if (options[item].equals("Take Photo")) {
                    dialog.dismiss();
                   // Intent pickPhoto = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    Intent photoPickerIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                   // startActivityForResult(pickPhoto, PICK_IMAGE_GALLERY);
                    startActivityForResult(photoPickerIntent, REQUEST_CAMERA);

                }

                else if (options[item].equals("Cancel")) {
                    dialog.dismiss();
                }
            }
        });
        builder.show();
    }
/*
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);

        switch(requestCode) {
            case REQUEST_GALLERY:

                 if(resultCode == RESULT_OK){
                    Uri selectedImage = imageReturnedIntent.getData();
                   InputStream imageStream = null;
                    try {
                        imageStream = getContentResolver().openInputStream(selectedImage);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    Bitmap yourSelectedImage = BitmapFactory.decodeStream(imageStream);
                    iv.setImageBitmap(yourSelectedImage);
                }
break;

            case REQUEST_CAMERA:

                    Bitmap yourSelectedImage = (Bitmap) imageReturnedIntent.getExtras().get("data");
                   iv.setImageBitmap(yourSelectedImage);
break;
        }
    }*/



protected void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {
    super.onActivityResult(requestCode, resultCode, imageReturnedIntent);
    switch(requestCode) {
        case REQUEST_GALLERY:
            if(resultCode == RESULT_OK){
            Uri selectedImage = imageReturnedIntent.getData();
            iv.setImageURI(selectedImage);
        } break;

        case REQUEST_CAMERA:
            if(resultCode == RESULT_OK){
                Bitmap yourSelectedImage = (Bitmap) imageReturnedIntent.getExtras().get("data");

                iv.setImageBitmap(yourSelectedImage);}
            break; }
}

}


