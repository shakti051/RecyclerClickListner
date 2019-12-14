package com.example.employeerecycler;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Toast;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  {
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<EmpModel> employe;
    Boolean  isScrolling = false;
    int currentItems,totalItems,scrolledOutItems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         recyclerView = findViewById(R.id.list);
         recyclerView.hasFixedSize();
         layoutManager = new LinearLayoutManager(this);
         recyclerView.setLayoutManager(layoutManager);
        employe = new ArrayList<>();
        employe.add(new EmpModel("Sandeep","DBA","Infosys","Bangl"));
        employe.add(new EmpModel("Vikas","Data Analyst","Accenture","Noida"));
        employe.add(new EmpModel("Anupam","Ios Developer","Capgemeny","Bangl"));
        employe.add(new EmpModel("Aman","DBA","Infosys","Hyd"));
        employe.add(new EmpModel("Shweta","Php Developer","Webkul","Bombay"));
        employe.add(new EmpModel("Sandeep","DBA","Infosys","Bangl"));
        employe.add(new EmpModel("Vikas","Data Analyst","Accenture","Noida"));
        employe.add(new EmpModel("Anupam","Ios Developer","Capgemeny","Bangl"));
        employe.add(new EmpModel("Aman","DBA","Infosys","Hyd"));
        employe.add(new EmpModel("Shweta","Php Developer","Webkul","Bombay"));


        adapter = new EmpAdapter(employe, this, new EmpAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {
                Toast.makeText(getApplicationContext(),"Your position "+position,Toast.LENGTH_SHORT).show();
            }
        });
        recyclerView.setAdapter(adapter);


        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL)
                    isScrolling = true;
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                    int i=0;
                currentItems = layoutManager.getChildCount();
                totalItems = layoutManager.getItemCount();


            }
        });
    }

}
