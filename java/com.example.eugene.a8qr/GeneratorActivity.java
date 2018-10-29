package com.example.eugene.a8qr;

import android.graphics.Bitmap;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class GeneratorActivity extends AppCompatActivity {

    private TextInputEditText nameTextInput, uidTextInput;
    private Button generateButton;
    private ImageView qrImageView;

    String name, uid;
    String text2Qr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generator);

        nameTextInput = (TextInputEditText) findViewById(R.id.nameTextInput);
        uidTextInput = (TextInputEditText) findViewById(R.id.uidTextInput);
        generateButton = (Button) findViewById(R.id.generateButton);
        qrImageView = (ImageView) findViewById(R.id.qrImageView);

        generateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = nameTextInput.getText().toString().trim();
                uid = uidTextInput.getText().toString().trim();
                text2Qr = "{\"name\"" + ":" + "\"" + name + "\"" + "," + "\"uid\"" + ":" + "\"" + uid + "\"}";

                MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
                try {
                    BitMatrix bitMatrix = multiFormatWriter.encode(text2Qr, BarcodeFormat.QR_CODE,200,200);
                    BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
                    Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
                    qrImageView.setImageBitmap(bitmap);
                }
                catch (WriterException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
