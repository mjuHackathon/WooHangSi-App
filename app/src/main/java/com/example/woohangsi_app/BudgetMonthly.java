package com.example.woohangsi_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class BudgetMonthly extends AppCompatActivity {
    NavigationView navigationView;
    DrawerLayout drawerLayout;

    ActionBarDrawerToggle barDrawerToggle;

    TextView txtCustomer, threemonth_budget;
    Button detail_btn;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.monthly_budget);
        navigationView=findViewById(R.id.nav);
        drawerLayout=findViewById(R.id.layout_drawer);
        navigationView.setItemIconTintList(null);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.Main:
                        Intent intent=new Intent(com.example.woohangsi_app.BudgetMonthly.this,MainActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.totalBudget_inquiry:
                        intent = new Intent(BudgetMonthly.this, InquiryBudgetTotal.class);
                        startActivity(intent);
                        break;
                    case R.id.categoryBudget_inquiry:
                        intent = new Intent(BudgetMonthly.this, InquiryBudgetCategory.class);
                        startActivity(intent);
                        break;
                    case R.id.brandBudget_inquiry:
                        intent = new Intent(BudgetMonthly.this, InquiryBudgetCustom.class);
                        startActivity(intent);
                        break;
                    case R.id.totalBudget_set:
                        intent = new Intent(BudgetMonthly.this, BudgetTotal.class);
                        startActivity(intent);
                        break;
                    case R.id.categoryBudget_set:
                        intent = new Intent(BudgetMonthly.this, BudgetCategory.class);
                        startActivity(intent);
                        break;
                    case R.id.brandBudget_set:
                        intent = new Intent(BudgetMonthly.this, CategoryCustom.class);
                        startActivity(intent);
                        break;
                    case R.id.top3_analysis:
                        intent = new Intent(BudgetMonthly.this, TopCategory.class);
                        startActivity(intent);
                        break;
                    case R.id.month3_analysis:
                        intent = new Intent(BudgetMonthly.this, SpendThreeMonth.class);
                        startActivity(intent);
                        break;
                    case R.id.consumption_analysis:
                        intent = new Intent(BudgetMonthly.this, ConsumptionPattern.class);
                        startActivity(intent);
                        break;
                    case R.id.MyPoint:
                        intent = new Intent(BudgetMonthly.this, EarnPoint.class);
                        startActivity(intent);
                        break;
                    case R.id.point_add:
                        intent = new Intent(BudgetMonthly.this, BudgetCheck.class);
                        startActivity(intent);
                        break;
                    case R.id.point_inquiry:
                        intent = new Intent(BudgetMonthly.this, EarnPoint.class);
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
        threemonth_budget = (TextView)findViewById(R.id.threemonth_budget);

        detail_btn = (Button) findViewById(R.id.detail_btn);

        detail_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SpendThreeMonth.class);
                startActivity(intent);
            }
        });

    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        barDrawerToggle.onOptionsItemSelected(item);
        return super.onOptionsItemSelected(item);
    }

}
