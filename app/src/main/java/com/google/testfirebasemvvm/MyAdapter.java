package com.google.testfirebasemvvm;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.testfirebasemvvm.Model.NameModel;
import com.google.testfirebasemvvm.databinding.ItemBinding;

import java.util.List;
import java.util.jar.Attributes;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyAdapterHolder> {


    private List<NameModel> nameModelList;

    public MyAdapter(List<NameModel> nameModelList) {
        this.nameModelList = nameModelList;
    }

    @NonNull
    @Override
    public MyAdapterHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater layoutInflater=LayoutInflater.from(viewGroup.getContext());

        ItemBinding itemBinding= DataBindingUtil.inflate(layoutInflater , R.layout.item, viewGroup
        ,false);

        return new MyAdapterHolder(itemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapterHolder myAdapterHolder, int i) {

        NameModel nameModel=nameModelList.get(i);
       myAdapterHolder.setBinding(nameModel);
    }

    @Override
    public int getItemCount() {

      return nameModelList.size();
    }


    public class MyAdapterHolder  extends RecyclerView.ViewHolder{

        ItemBinding itemBinding;

        public MyAdapterHolder(@NonNull ItemBinding itemBinding) {

            super(itemBinding.getRoot());
             this.itemBinding=itemBinding;
        }

        public void setBinding(NameModel nameModel) {
            itemBinding.setName(nameModel);
        }
    }
}
