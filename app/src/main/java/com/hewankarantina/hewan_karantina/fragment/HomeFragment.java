package com.hewankarantina.hewan_karantina.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.DefaultSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.hewankarantina.hewan_karantina.FormPengisian;
import com.hewankarantina.hewan_karantina.GridLayout;
import com.hewankarantina.hewan_karantina.PetListActivity;
import com.hewankarantina.hewan_karantina.PlaceDetailActivity;
import com.hewankarantina.hewan_karantina.R;

import java.util.HashMap;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    // widget
    private SliderLayout sliderLayout;
    private Button btnAdopt, btnTempat, btnForm;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // initialitation
        btnAdopt = (Button) view.findViewById(R.id.btn_adopt);
        sliderLayout = (SliderLayout) view.findViewById(R.id.home_image_slider);
        btnTempat = (Button) view.findViewById(R.id.btn_tempat);
        btnForm = (Button) view.findViewById(R.id.btn_form);

        btnAdopt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), GridLayout.class));
            }
        });

        btnTempat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), PlaceDetailActivity.class));
            }
        });

        btnForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), FormPengisian.class));
            }
        });

        HashMap<String, Integer> file_maps = new HashMap<String, Integer>();
        file_maps.put("slide1", R.drawable.slide1);
        file_maps.put("slide2", R.drawable.slide2);
        file_maps.put("slide3", R.drawable.slide3);
        file_maps.put("slide4", R.drawable.slide4);

        for (String name : file_maps.keySet()) {
            TextSliderView textSliderView = new TextSliderView(getActivity());
            // initialize a slider layout
            textSliderView
                    .image(file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit);

            sliderLayout.addSlider(textSliderView);
        }

        return view;
    }

    @Override
    public void onStop() {
        sliderLayout.stopAutoCycle();
        super.onStop();
    }
}
