package com.Holiday_Card;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;




import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends Activity {

    
	Button mBtn1;

	EditText eT_ToName;

	EditText eT_FromName;

	EditText eT_WhyShort;

	EditText eT_WhyLong;

	EditText eT_Date;


	Bitmap src;

	ImageView iv;

	Canvas ivCanvas;

	Bitmap ourNewBitmap;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);  
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		
		mBtn1 = (Button) findViewById(R.id.button1);

		mBtn1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent share = new Intent(Intent.ACTION_SEND);
				share.setType("image/*");
				ByteArrayOutputStream bytes = new ByteArrayOutputStream();
				ourNewBitmap.compress(Bitmap.CompressFormat.JPEG, 90, bytes);
				File f = new File(Environment.getExternalStorageDirectory()
						+ "/certificate.jpg");
				try {
					f.createNewFile();
					FileOutputStream fo = new FileOutputStream(f);
					fo.write(bytes.toByteArray());
					fo.close();
					bytes.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				share.putExtra(Intent.EXTRA_STREAM,
						Uri.parse("file:///sdcard/certificate.jpg"));
				startActivity(Intent.createChooser(share, "Share Image"));
			}
		});

			
		eT_ToName = (EditText) findViewById(R.id.editText_ToName);

		eT_FromName = (EditText) findViewById(R.id.editText_FromName);

		eT_WhyShort = (EditText) findViewById(R.id.editText_ForShort);

		eT_WhyLong = (EditText) findViewById(R.id.editText_ForLong);

	
		iv = (ImageView) findViewById(R.id.imageView1);

		src = BitmapFactory.decodeResource(getResources(),
				(R.drawable.certtemplate));

		ourNewBitmap = Bitmap.createBitmap(src.getWidth(), src.getHeight(),
				Bitmap.Config.ARGB_8888);
		ivCanvas = new Canvas(ourNewBitmap);

		eT_ToName.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				// TODO Auto-generated method stub

			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub

			}

			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				updateCanvas();
			}
		});

		eT_FromName.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				// TODO Auto-generated method stub

			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub

			}

			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				updateCanvas();
			}
		});

		eT_WhyShort.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				// TODO Auto-generated method stub

			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub

			}

			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				updateCanvas();
			}
		});

		eT_WhyLong.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				// TODO Auto-generated method stub

			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub

			}

			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				updateCanvas();
			}
		});

		eT_Date.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				// TODO Auto-generated method stub

			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub

			}

			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				updateCanvas();
			}
		});
		
		Paint paint = new Paint();
		ivCanvas.drawBitmap(src, 0, 0, paint);
	}

	
	//Edit the section below to change text location, color and size 
	public void updateCanvas() {
		Paint paint = new Paint();
		ivCanvas.drawBitmap(src, 0, 0, paint);
		paint.setColor(Color.GREEN);
		paint.setTextSize(18);
		paint.setTextAlign(Align.CENTER);
		
		
		float vertshort = 0.35f;
		paint.setTextSize(40);		
		ivCanvas.drawText(eT_WhyShort.getText().toString(), (ivCanvas.getWidth()/2), (ivCanvas.getHeight()*vertshort), paint);

		float vertlong = 0.50f;
		paint.setColor(Color.GREEN);
		paint.setTextSize(25);
		ivCanvas.drawText(eT_WhyLong.getText().toString(), (ivCanvas.getWidth()/2), (ivCanvas.getHeight()*vertlong), paint);

		
		paint.setTextSize(18);

		float twentyfive = .25f; 
		float vertdatenfrom = 0.73f;
		paint.setColor(Color.RED);
		paint.setTextSize(20);
		ivCanvas.drawText(eT_ToName.getText().toString(), (ivCanvas.getWidth() * twentyfive), (ivCanvas.getHeight()*vertdatenfrom), paint);

		float pointsevenfive = 0.75f;
		paint.setColor(Color.GREEN);
		paint.setTextSize(18);
		float vertfromlabel = 0.68f;
		ivCanvas.drawText("Seasons's Greetings,", (ivCanvas.getWidth()*pointsevenfive), (ivCanvas.getHeight()*vertfromlabel), paint);		
		
		paint.setColor(Color.RED);
		paint.setTextSize(20);
		ivCanvas.drawText(eT_FromName.getText().toString(), (ivCanvas.getWidth()*pointsevenfive), (ivCanvas.getHeight()*vertdatenfrom), paint);

		
		// Everything has been drawn to bmp, so we can set that here, now.
		iv.setImageBitmap(ourNewBitmap);

	}

}