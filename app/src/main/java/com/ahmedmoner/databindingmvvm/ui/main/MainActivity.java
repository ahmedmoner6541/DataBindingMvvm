package com.ahmedmoner.databindingmvvm.ui.main;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ahmedmoner.databindingmvvm.R;
import com.ahmedmoner.databindingmvvm.pojo.PostModel;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    ArrayList<PostModel> list = new ArrayList<>();

    PostViewModel postViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        postViewModel = new ViewModelProvider(this).get(PostViewModel.class);
        postViewModel.getPosts();
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        final PostAdapter adapter = new PostAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        postViewModel.postmutablelivedata.observe(this, new Observer<List<PostModel>>() {
            @Override
            public void onChanged(List<PostModel> postModels) {
                adapter.setList((ArrayList<PostModel>) postModels);

            }
        });

        //      ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
//
//
//        viewModel = new ViewModelProvider(this).get(UserViewModel.class);
//
//        binding.setUsermodel(viewModel);
//        binding.setLifecycleOwner(this);

//        vi ewModel.mutableLiveData.observe(this, new Observer<String>() {todo دي عوضناها بال  xml file
//            @Override
//            public void onChanged(String s) {
//                binding.textView.setText(s);
//            }
//        });
//
//        binding.button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                viewModel.getUsername();
//            }
//        });

    }
}