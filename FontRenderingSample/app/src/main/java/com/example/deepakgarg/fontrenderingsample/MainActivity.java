package com.example.deepakgarg.fontrenderingsample;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    EditText sampleTextView;
    ImageView sampleImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sampleTextView = (EditText) findViewById(R.id.sample_text);
        sampleImage = (ImageView) findViewById(R.id.sample_image);
    }

    public void applyFontToText(View view) {
        float density = getResources().getDisplayMetrics().density;
        Typeface font = Typeface.createFromAsset(this.getAssets(), "font/HelveticaNeue.ttf");
        sampleTextView.setTypeface(font);

        int textSize = 50;
        Rect bounds = new Rect();
        Paint paint = new Paint();
        Path textPath = new Path();

        paint.setAntiAlias(true);
        paint.setSubpixelText(true);
        paint.setTextSize(textSize * density);

        paint.setTypeface(font);
        String text = sampleTextView.getText().toString();
        paint.getTextBounds(text, 0, text.length(), bounds);

        paint.getTextPath(text, 0, text.length(), 0, bounds.height(), textPath);
        Bitmap bitmap = Bitmap.createBitmap(bounds.width() + textSize, bounds.height() + textSize, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        canvas.drawPath(textPath, paint);
        sampleImage.setImageBitmap(bitmap);
    }
}
