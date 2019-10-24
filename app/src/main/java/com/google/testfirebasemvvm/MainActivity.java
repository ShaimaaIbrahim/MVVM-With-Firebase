package com.google.testfirebasemvvm;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import com.google.testfirebasemvvm.Model.NameModel;
import com.google.testfirebasemvvm.databinding.ActivityMainBinding;
import com.google.testfirebasemvvm.viewModel.NameViewModel;
import java.util.List;



public class MainActivity extends AppCompatActivity implements DataLLoadInterface{

    private NameViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        final ActivityMainBinding binding= DataBindingUtil.
                setContentView(MainActivity.this , R.layout.activity_main);

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));

        viewModel= ViewModelProviders.of(this).get(NameViewModel.class);

        viewModel.init(this);
        viewModel.getNames().observe(this, new Observer<List<NameModel>>() {
            @Override
            public void onChanged(@Nullable List<NameModel> nameModels) {

                binding.recyclerView.
                        setAdapter(new MyAdapter(nameModels));
            }
        });


    }

    @Override
    public void onLoadNames() {

    }
}
