package com.example.woohangsi_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class BudgetCheck extends AppCompatActivity {
    NavigationView navigationView;
    DrawerLayout drawerLayout;

    ActionBarDrawerToggle barDrawerToggle;

    ViewFlipper vFlipper;
    TextView txtCustomer, goal_budget, pay_budget;
    EditText Budget;
    Button detail_btn, getPoint_btn, back_btn;
    View divider;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.check_budget);
        navigationView=findViewById(R.id.nav);
        drawerLayout=findViewById(R.id.layout_drawer);
        navigationView.setItemIconTintList(null);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.Main:
                        Intent intent=new Intent(com.example.woohangsi_app.BudgetCheck.this,MainActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.totalBudget_inquiry:
                        intent = new Intent(BudgetCheck.this, InquiryBudgetTotal.class);
                        startActivity(intent);
                        break;
                    case R.id.categoryBudget_inquiry:
                        intent = new Intent(BudgetCheck.this, InquiryBudgetCategory.class);
                        startActivity(intent);
                        break;
                    case R.id.brandBudget_inquiry:
                        intent = new Intent(BudgetCheck.this, InquiryBudgetCustom.class);
                        startActivity(intent);
                        break;
                    case R.id.totalBudget_set:
                        intent = new Intent(BudgetCheck.this, BudgetTotal.class);
                        startActivity(intent);
                        break;
                    case R.id.categoryBudget_set:
                        intent = new Intent(BudgetCheck.this, BudgetCategory.class);
                        startActivity(intent);
                        break;
                    case R.id.brandBudget_set:
                        intent = new Intent(BudgetCheck.this, CategoryCustom.class);
                        startActivity(intent);
                        break;
                    case R.id.top3_analysis:
                        intent = new Intent(BudgetCheck.this, TopCategory.class);
                        startActivity(intent);
                        break;
                    case R.id.month3_analysis:
                        intent = new Intent(BudgetCheck.this, SpendThreeMonth.class);
                        startActivity(intent);
                        break;
                    case R.id.consumption_analysis:
                        intent = new Intent(BudgetCheck.this, ConsumptionPattern.class);
                        startActivity(intent);
                        break;
                    case R.id.point_add:
                        intent = new Intent(BudgetCheck.this, BudgetCheck.class);
                        startActivity(intent);
                        break;
                    case R.id.point_inquiry:
                        intent = new Intent(BudgetCheck.this, EarnPoint.class);
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

        vFlipper = (ViewFlipper) findViewById(R.id.vFlipper);

        txtCustomer = (TextView) findViewById(R.id.txtCustomer);
        goal_budget = (TextView) findViewById(R.id.goal_budget);
        pay_budget = (TextView) findViewById(R.id.pay_budget);

        Budget = (EditText)findViewById(R.id.Budget);

        detail_btn = (Button) findViewById(R.id.detail_btn);
        getPoint_btn = (Button) findViewById(R.id.getPoint_btn);
        back_btn = (Button) findViewById(R.id.back_btn);

        divider = (View) findViewById(R.id.divider);

        getPoint_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), EarnPoint.class);
                startActivity(intent);
            }
        });

        detail_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vFlipper.showNext();
            }
        });

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vFlipper.showPrevious();
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        barDrawerToggle.onOptionsItemSelected(item);
        return super.onOptionsItemSelected(item);
    }

}
