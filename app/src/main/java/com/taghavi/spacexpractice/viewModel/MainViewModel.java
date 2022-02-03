package com.taghavi.spacexpractice.viewModel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.taghavi.spacexpractice.model.LaunchModel;
import com.taghavi.spacexpractice.network.NetworkService;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@HiltViewModel
public class MainViewModel extends ViewModel {
    private final NetworkService service;
    public MutableLiveData<LaunchModel> launchModelLiveData = new MutableLiveData();

    @Inject
    MainViewModel(NetworkService service) {
        this.service = service;
        abd();
    }

    void abd() {
        service.getLatest().enqueue(new Callback<LaunchModel>() {
            @Override
            public void onResponse(Call<LaunchModel> call, Response<LaunchModel> response) {
                launchModelLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<LaunchModel> call, Throwable t) {
                Log.i("TAGTAG", t.toString());
            }
        });
    }
}
