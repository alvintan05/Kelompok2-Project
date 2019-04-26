package com.hewankarantina.hewan_karantina;

import android.app.Dialog;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.DefaultSliderView;

import java.util.HashMap;

public class PlaceDetailActivity extends AppCompatActivity {

    // widget
    private SliderLayout sliderLayout;
    private Button btnDonasi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_detail);

        // inisialisasi
        sliderLayout = (SliderLayout) findViewById(R.id.detail_image_slider);
        btnDonasi = (Button) findViewById(R.id.btn_donasi);

        HashMap<String, Integer> file_maps = new HashMap<String, Integer>();
        file_maps.put("slide1", R.drawable.slide1);
        file_maps.put("slide2", R.drawable.slide2);
        file_maps.put("slide3", R.drawable.slide3);
        file_maps.put("slide4", R.drawable.slide4);

        sliderLayout.stopAutoCycle();

        for (String name : file_maps.keySet()) {
            DefaultSliderView defaultSliderView = new DefaultSliderView(this);
            // initialize a slider layout
            defaultSliderView
                    .image(file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit);

            sliderLayout.addSlider(defaultSliderView);
        }

        btnDonasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                donate();
            }
        });
    }

    @Override
    protected void onStop() {
        sliderLayout.stopAutoCycle();
        super.onStop();
    }

    private void donate() {
        final Dialog dialog = new Dialog(this);

        LayoutInflater inflater = LayoutInflater.from(this);
        View v = inflater.inflate(R.layout.item_dialog_box, null);

        ImageView imageView = (ImageView) v.findViewById(R.id.close_btn);
        RelativeLayout relativeLayout = (RelativeLayout) v.findViewById(R.id.relative_layout);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(PlaceDetailActivity.this, "close", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.setContentView(v);
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        dialog.setCanceledOnTouchOutside(true);
        dialog.show();
    }
}
