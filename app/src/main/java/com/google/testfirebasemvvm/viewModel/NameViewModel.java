package com.google.testfirebasemvvm.viewModel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;

import com.google.testfirebasemvvm.Model.NameModel;
import com.google.testfirebasemvvm.Repository.Repo;

import java.util.List;

public class NameViewModel extends ViewModel {


    public MutableLiveData<List<NameModel>>mutableLiveData;



    public void init(Context context){
        if (mutableLiveData !=null){
            return;
        }
        mutableLiveData= Repo.getInstance(context).getNames();

    }

    public LiveData<List<NameModel>>getNames(){

        return mutableLiveData;
    }
}
