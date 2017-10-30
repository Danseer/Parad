package com.example.parad;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class AddPhotoActivity extends AppCompatActivity {


    private static final int REQUEST_CAMERA = 1;
    private static final int REQUEST_GALLERY = 2;
    private ImageView iv;
    AlertDialog.Builder builder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_photo);
        iv = (ImageView) findViewById(R.id.iv2);

        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                builder.show();
            }
        });

        selectImage();
    }

    private void selectImage() {


        final CharSequence[] options = {"Take Photo", "Choose From Gallery", "Cancel"};
        builder = new android.support.v7.app.AlertDialog.Builder(AddPhotoActivity.this);
        builder.setTitle("Select Option");

        builder.setItems(options, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {

                if (options[item].equals("Choose From Gallery")) {
                    dialog.dismiss();
                    Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
                    photoPickerIntent.setType("image/*");
                    startActivityForResult(photoPickerIntent, REQUEST_GALLERY);
                } else if (options[item].equals("Take Photo")) {
                    dialog.dismiss();
                    Intent photoPickerIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(photoPickerIntent, REQUEST_CAMERA);
                } else if (options[item].equals("Cancel")) {
                    dialog.dismiss();
                }
            }
        });

    }


    protected void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);
        switch (requestCode) {
            case REQUEST_GALLERY:
                if (resultCode == RESULT_OK) {
                    Uri selectedImage = imageReturnedIntent.getData();
                    iv.setImageURI(selectedImage);
                }
                break;

            case REQUEST_CAMERA:
                if (resultCode == RESULT_OK) {
                    Bitmap yourSelectedImage = (Bitmap) imageReturnedIntent.getExtras().get("data");

                    iv.setImageBitmap(yourSelectedImage);
                }
                break;
        }
    }
}
