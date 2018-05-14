package com.ryandro.ryndroapp.ui.activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.ryandro.ryndroapp.BaseActivity;
import com.ryandro.ryndroapp.R;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ContentProviderActivity extends BaseActivity {
    @Nullable
    @BindView(R.id.btnShare)
    Button btnShare;
    @Nullable
    @BindView(R.id.iv_ReceivedImage)
    ImageView iv_ReceivedImage;
    @Nullable
    @BindView(R.id.tv_recivedText)
    TextView tv_recivedText;
    private String strTextValue = "Simple Text We Are Sending For Testing";
    private Uri imageURI;

    @Override
    public void initialize() {
        inflater.inflate(R.layout.activity_content_provider, flBody, true);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String type = intent.getType();
        String action = intent.getAction();

        if (Intent.ACTION_SEND.equalsIgnoreCase(action) && type != null) {
            if ("text/plain".equalsIgnoreCase(type)) {
                handleIntendText(intent);
            } else if (type.startsWith("image/")) {
                handleIntentImage(intent);
            }

        }
/*FOr sent Text from our app to Another app in the form of passing simple text*/
       /* btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent shareIntent = new Intent();
                shareIntent.setType("text/plain");
                shareIntent.setAction(Intent.ACTION_SEND);
                shareIntent.putExtra(Intent.EXTRA_TEXT, strTextValue);
                shareIntent.addFlags(Intent.FLAG_GRANT_PERSISTABLE_URI_PERMISSION);
                startActivity(Intent.createChooser(shareIntent, "Select app for share data"));
            }
        });*/

       /*FOr sent image from our app to Another app in the form of passing URI*/
        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent shareIntent = new Intent();
                shareIntent.setType("image/jpeg");
                shareIntent.setAction(Intent.ACTION_SEND);
                shareIntent.putExtra(Intent.EXTRA_STREAM, imageURI);
                shareIntent.addFlags(Intent.FLAG_GRANT_PERSISTABLE_URI_PERMISSION);
                startActivity(Intent.createChooser(shareIntent, "Select app for share data"));
            }
        });

    }

    private void handleIntentImage(Intent intent) {
        Uri imageUri = (Uri) intent.getParcelableExtra(Intent.EXTRA_STREAM);
        if (imageUri != null) {
            /*iv_ReceivedImage.setImageURI(null);
            iv_ReceivedImage.setImageURI(Uri.parse(imageUri.toString()));*/
            imageURI = imageUri;
            Bitmap bitmap = loadBitmap(imageUri.toString());
            iv_ReceivedImage.setImageBitmap(bitmap);
        }

    }

    private void handleIntendText(Intent intent) {
        String strValue = intent.getStringExtra(Intent.EXTRA_TEXT);
        if (strValue != null) {
            tv_recivedText.setText("Received Text : " + strValue);
        }
    }

    public Bitmap loadBitmap(String url) {
        Bitmap bm = null;
        InputStream is = null;
        BufferedInputStream bis = null;
        try {
            URLConnection conn = new URL(url).openConnection();
            conn.connect();
            is = conn.getInputStream();
            bis = new BufferedInputStream(is, 8192);
            bm = BitmapFactory.decodeStream(bis);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return bm;
    }
}
