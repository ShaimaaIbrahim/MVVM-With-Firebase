package com.google.testfirebasemvvm.Repository;

import android.arch.lifecycle.MutableLiveData;
import android.content.Context;

import com.google.testfirebasemvvm.DataLLoadInterface;
import com.google.testfirebasemvvm.Model.NameModel;

import java.util.List;

public class Repo {

    static Repo instance;

    private List<NameModel> nameModelList;

   public static   Context Context;
    static DataLLoadInterface dataLLoadInterface;

    public static Repo getInstance(Context mContext){
       Context=mContext;

        if (instance==null){

            instance=new Repo();
        }

        // to get copy from DataLoadInterface
        dataLLoadInterface=(DataLLoadInterface) mContext;
        return instance;
    }


    public MutableLiveData<List<NameModel>>getNames (){

        loadNames();
        MutableLiveData<List<NameModel>>names=new MutableLiveData<>();
        names.setValue(nameModelList);

        return names;
    }


    private void loadNames() {

        // read from RealTimeDataBase and here dataBase reference   and get SnapShot

        //nameModelList.add(snapShot.getValue(NameModel.class));

        /*
        after we close loop for snapShot we call this
      //    dataLLoadInterface.onLoadNames();
         */


    }
}
