package com.taghavi.spacexpractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;

import com.bumptech.glide.Glide;
import com.taghavi.spacexpractice.databinding.ActivityMainBinding;
import com.taghavi.spacexpractice.model.LaunchModel;
import com.taghavi.spacexpractice.viewModel.MainViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        MainViewModel viewModel = new ViewModelProvider(this).get(MainViewModel.class);

        viewModel.launchModelLiveData.observe(this, new Observer<LaunchModel>() {
            @Override
            public void onChanged(LaunchModel launchModel) {
                if (launchModel != null) {
                    binding.progressBar.setVisibility(View.GONE);

                    Glide.with(MainActivity.this)
                            .load(launchModel.getLinks().getPatch().getLarge())
                            .into(binding.image);
                    binding.name.setText("Mission Name: " + launchModel.getName());
                    if (launchModel.getSuccess()) {
                        binding.status.setText("Success");
                        binding.status.setTextColor(ContextCompat.getColor(MainActivity.this, android.R.color.holo_green_light));
                    } else {
                        binding.status.setText("Fail");
                        binding.status.setTextColor(ContextCompat.getColor(MainActivity.this, android.R.color.holo_red_light));
                    }
                    binding.flightNumber.setText("Flight Number: " + launchModel.getFlight_number());
                } else {
                    binding.progressBar.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}