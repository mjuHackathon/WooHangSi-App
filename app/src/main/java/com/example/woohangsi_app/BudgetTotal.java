package com.example.woohangsi_app;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.woohangsi_app.DB.Entire;
import com.example.woohangsi_app.DB.RequestAPI;
import com.google.android.material.navigation.NavigationView;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;

public class BudgetTotal extends AppCompatActivity {
    NavigationView navigationView;
    DrawerLayout drawerLayout;

    ActionBarDrawerToggle barDrawerToggle;

    TextView txtCustomer, txtMonth, txtSetting;
    EditText Budget_write;
    LinearLayout Budget_write_btn;
    Button btnApply, btnCancel;

    RequestAPI requestAPI;
    String data;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.total_budget);
        navigationView=findViewById(R.id.nav);
        drawerLayout=findViewById(R.id.layout_drawer);
        navigationView.setItemIconTintList(null);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.Main:
                        Intent intent=new Intent(com.example.woohangsi_app.BudgetTotal.this,MainActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.totalBudget_inquiry:
                        intent = new Intent(BudgetTotal.this, InquiryBudgetTotal.class);
                        startActivity(intent);
                        break;
                    case R.id.categoryBudget_inquiry:
                        intent = new Intent(BudgetTotal.this, InquiryBudgetCategory.class);
                        startActivity(intent);
                        break;
                    case R.id.brandBudget_inquiry:
                        intent = new Intent(BudgetTotal.this, InquiryBudgetCustom.class);
                        startActivity(intent);
                        break;
                    case R.id.totalBudget_set:
                        intent = new Intent(BudgetTotal.this, BudgetTotal.class);
                        startActivity(intent);
                        break;
                    case R.id.categoryBudget_set:
                        intent = new Intent(BudgetTotal.this, BudgetCategory.class);
                        startActivity(intent);
                        break;
                    case R.id.brandBudget_set:
                        intent = new Intent(BudgetTotal.this, CategoryCustom.class);
                        startActivity(intent);
                        break;
                    case R.id.top3_analysis:
                        intent = new Intent(BudgetTotal.this, TopCategory.class);
                        startActivity(intent);
                        break;
                    case R.id.month3_analysis:
                        intent = new Intent(BudgetTotal.this, SpendThreeMonth.class);
                        startActivity(intent);
                        break;
                    case R.id.consumption_analysis:
                        intent = new Intent(BudgetTotal.this, ConsumptionPattern.class);
                        startActivity(intent);
                        break;
                    case R.id.point_add:
                        intent = new Intent(BudgetTotal.this, BudgetCheck.class);
                        startActivity(intent);
                        break;
                    case R.id.point_inquiry:
                        intent = new Intent(BudgetTotal.this, EarnPoint.class);
                        startActivity(intent);
                        break;
                    default:
                        break;
                }


                drawerLayout.closeDrawer(navigationView);

                return false;
            }
        });

        barDrawerToggle= new ActionBarDrawerToggle(this, drawerLayout, R.string.app_name,R.string.app_name);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        barDrawerToggle.syncState();

        drawerLayout.addDrawerListener(barDrawerToggle);

        txtCustomer = (TextView)findViewById(R.id.txtCustomer);
        txtMonth = (TextView)findViewById(R.id.txtMonth);

        Budget_write = (EditText)findViewById(R.id.Budget_write);

        btnApply = (Button)findViewById(R.id.btnApply);
        btnCancel = (Button)findViewById(R.id.btnCancel);

        btnApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Budget_write.setText(Budget_write.getText().toString());
                Intent intent = new Intent();
                intent.putExtra("total", Budget_write.getText().toString());
                setResult(RESULT_OK, intent);

                String value = Budget_write.getText().toString();
                int budget = Integer.parseInt(value);

                Entire entire = new Entire();
                handlePost(entire.getAddUrl(), entire.getAddBody(budget, 1,"5"));
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Budget_write.getText().clear();
            }
        });
    }

    public void handlePost(String subUrl, String bodyString) {
        Thread thread = new Thread() {
            public void run() {
                try {
                    requestAPI = new RequestAPI();
                    data = requestAPI.requestPost(subUrl, bodyString);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        barDrawerToggle.onOptionsItemSelected(item);
        return super.onOptionsItemSelected(item);
    }

}
