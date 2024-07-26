package com.example.kd;

import static android.content.ContentValues.TAG;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
List<DataModel> dataModelList=new ArrayList<>();
List<SeeAllTasks> data=new ArrayList<>();
List<SeeAllTasks> data1=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.recycler_view);
        RecyclerView recyclerView=findViewById(R.id.recycler_view);
        Log.d(TAG, "onCreate: recyclerView = " + recyclerView);
       ApiService api=ApiClient.getClient();

        api.getAllTasks().enqueue(new Callback<List<SeeAllTasks>>() {
            @Override
            public void onResponse(@NonNull Call<List<SeeAllTasks>> call, @NonNull Response<List<SeeAllTasks>> response) {
                Log.e("resp",response.code()+","+response.message());

                if(response.isSuccessful()) {
                    Log.i("resp", "successfile");
                    data1 = response.body();

                    if (data1!=null) {
                        for (SeeAllTasks dataModel : data1) {
                            Log.d("STUART LITTLE", dataModel.print());
                            data.add(dataModel);
                        }
                        //adding the code outside will result in recycler view getting started first due to asynchronous calls
                        RVAdapter rvAdapter=new RVAdapter(data,MainActivity.this);
                        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                        recyclerView.setAdapter(rvAdapter);
                        Log.d(TAG, "onCreate: adapter = " + rvAdapter.onCreateViewHolder(recyclerView,0));
                        Log.d(TAG, "onCreate: dataModelList size = " + rvAdapter.getItemCount());
                    }
                }
                else {
                    Log.e("err","Response failure +" +data);
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<SeeAllTasks>> call, @NonNull Throwable t) {
                    Log.e("fail","failed to access api with throwable:"+t);
            }
        });
        SeeAllTasks data2=new SeeAllTasks(200,"Kendall","Try to print prime numbers using recursion and stack");
        SeeAllTasks data1=new SeeAllTasks(100,"Lawrence","Sort elements using merge sort");
        data.add(data1);
        data.add(data2);
        for(SeeAllTasks data:data){
            Log.d("data",data.toString());
        }


    }
}