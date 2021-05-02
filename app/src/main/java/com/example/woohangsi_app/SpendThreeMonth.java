package com.example.woohangsi_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class SpendThreeMonth extends AppCompatActivity {
    NavigationView navigationView;
    DrawerLayout drawerLayout;

    ActionBarDrawerToggle barDrawerToggle;

    TextView txtCustomer, txtMonth1, txtMonth2, txtMonth3, Month1_money, Month2_money, Month3_money;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.three_month_spend);
        navigationView=findViewById(R.id.nav);
        drawerLayout=findViewById(R.id.layout_drawer);
        navigationView.setItemIconTintList(null);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.Main:
                        Intent intent=new Intent(com.example.woohangsi_app.SpendThreeMonth.this,MainActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.totalBudget_inquiry:
                        intent = new Intent(SpendThreeMonth.this, InquiryBudgetTotal.class);
                        startActivity(intent);
                        break;
                    case R.id.categoryBudget_inquiry:
                        intent = new Intent(SpendThreeMonth.this, InquiryBudgetCategory.class);
                        startActivity(intent);
                        break;
                    case R.id.brandBudget_inquiry:
                        intent = new Intent(SpendThreeMonth.this, InquiryBudgetCustom.class);
                        startActivity(intent);
                        break;
                    case R.id.totalBudget_set:
                        intent = new Intent(SpendThreeMonth.this, BudgetTotal.class);
                        startActivity(intent);
                        break;
                    case R.id.categoryBudget_set:
                        intent = new Intent(SpendThreeMonth.this, BudgetCategory.class);
                        startActivity(intent);
                        break;
                    case R.id.brandBudget_set:
                        intent = new Intent(SpendThreeMonth.this, CategoryCustom.class);
                        startActivity(intent);
                        break;
                    case R.id.top3_analysis:
                        intent = new Intent(SpendThreeMonth.this, TopCategory.class);
                        startActivity(intent);
                        break;
                    case R.id.month3_analysis:
                        intent = new Intent(SpendThreeMonth.this, SpendThreeMonth.class);
                        startActivity(intent);
                        break;
                    case R.id.consumption_analysis:
                        intent = new Intent(SpendThreeMonth.this, ConsumptionPattern.class);
                        startActivity(intent);
                        break;
                    case R.id.MyPoint:
                        intent = new Intent(SpendThreeMonth.this, EarnPoint.class);
                        startActivity(intent);
                        break;
                    case R.id.point_add:
                        intent = new Intent(SpendThreeMonth.this, BudgetCheck.class);
                        startActivity(intent);
                        break;
                    case R.id.point_inquiry:
                        intent = new Intent(SpendThreeMonth.this, EarnPoint.class);
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


        txtCustomer = (TextView) findViewById(R.id.txtCustomer);
        txtMonth1 = (TextView) findViewById(R.id.txtMonth1);
        txtMonth2 = (TextView) findViewById(R.id.txtMonth2);
        txtMonth3 = (TextView) findViewById(R.id.txtMonth3);
        Month1_money = (TextView)findViewById(R.id.Month1_money);
        Month2_money = (TextView)findViewById(R.id.Month2_money);
        Month3_money = (TextView)findViewById(R.id.Month3_money);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        barDrawerToggle.onOptionsItemSelected(item);
        return super.onOptionsItemSelected(item);
    }
}
