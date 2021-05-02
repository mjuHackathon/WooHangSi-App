package com.example.woohangsi_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class TopCategory extends AppCompatActivity {
    NavigationView navigationView;
    DrawerLayout drawerLayout;

    ActionBarDrawerToggle barDrawerToggle;

    TextView txtCustomer, txtYear, txtMonth, txtTop1, txtTop2, txtTop3, txtCustomer2, nameTop1,
            top1LastCost, top1Recommend, nameTop2, top2LastCost, top2Recommend, nameTop3, top3LastCost,
            top3Recommend;
    ImageView top1, top2, top3, top1_2, top2_2, top3_2;
    Button btnRecommend, btnApply;
    ViewFlipper vFlipper;
    CheckBox top1check, top2check, top3check;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category_top);
        navigationView=findViewById(R.id.nav);
        drawerLayout=findViewById(R.id.layout_drawer);
        navigationView.setItemIconTintList(null);


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.Main:
                        Intent intent=new Intent(com.example.woohangsi_app.TopCategory.this,MainActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.totalBudget_inquiry:
                        intent = new Intent(TopCategory.this, InquiryBudgetTotal.class);
                        startActivity(intent);
                        break;
                    case R.id.categoryBudget_inquiry:
                        intent = new Intent(TopCategory.this, InquiryBudgetCategory.class);
                        startActivity(intent);
                        break;
                    case R.id.brandBudget_inquiry:
                        intent = new Intent(TopCategory.this, InquiryBudgetCustom.class);
                        startActivity(intent);
                        break;
                    case R.id.totalBudget_set:
                        intent = new Intent(TopCategory.this, BudgetTotal.class);
                        startActivity(intent);
                        break;
                    case R.id.categoryBudget_set:
                        intent = new Intent(TopCategory.this, BudgetCategory.class);
                        startActivity(intent);
                        break;
                    case R.id.brandBudget_set:
                        intent = new Intent(TopCategory.this, CategoryCustom.class);
                        startActivity(intent);
                        break;
                    case R.id.top3_analysis:
                        intent = new Intent(TopCategory.this, TopCategory.class);
                        startActivity(intent);
                        break;
                    case R.id.month3_analysis:
                        intent = new Intent(TopCategory.this, SpendThreeMonth.class);
                        startActivity(intent);
                        break;
                    case R.id.consumption_analysis:
                        intent = new Intent(TopCategory.this, ConsumptionPattern.class);
                        startActivity(intent);
                        break;
                    case R.id.point_add:
                        intent = new Intent(TopCategory.this, BudgetCheck.class);
                        startActivity(intent);
                        break;
                    case R.id.point_inquiry:
                        intent = new Intent(TopCategory.this, EarnPoint.class);
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
        txtCustomer2 = (TextView) findViewById(R.id.txtCustomer2);
        txtYear = (TextView) findViewById(R.id.txtYear);
        txtMonth = (TextView) findViewById(R.id.txtMonth);
        txtTop1 = (TextView) findViewById(R.id.txtTop1);
        txtTop2 = (TextView) findViewById(R.id.txtTop2);
        txtTop3 = (TextView) findViewById(R.id.txtTop3);
        nameTop1 = (TextView) findViewById(R.id.nameTop1);
        nameTop2 = (TextView) findViewById(R.id.nameTop2);
        nameTop3 = (TextView) findViewById(R.id.nameTop3);
        top1LastCost = (TextView) findViewById(R.id.top1LastCost);
        top2LastCost = (TextView) findViewById(R.id.top2LastCost);
        top3LastCost = (TextView) findViewById(R.id.top3LastCost);
        top1Recommend = (TextView) findViewById(R.id.top1Recommend);
        top2Recommend = (TextView) findViewById(R.id.top2Recommend);
        top3Recommend = (TextView) findViewById(R.id.top3Recommend);

        top1 = (ImageView) findViewById(R.id.top1);
        top2 = (ImageView) findViewById(R.id.top2);
        top3 = (ImageView) findViewById(R.id.top3);
        top1_2 = (ImageView) findViewById(R.id.top1_2);
        top2_2 = (ImageView) findViewById(R.id.top2_2);
        top3_2 = (ImageView) findViewById(R.id.top3_2);

        btnRecommend = (Button) findViewById(R.id.btnRecommend);
        btnApply = (Button) findViewById(R.id.btnApply);

        top1check = (CheckBox) findViewById(R.id.top1check);
        top2check = (CheckBox) findViewById(R.id.top2check);
        top2check = (CheckBox) findViewById(R.id.top3check);

        vFlipper = (ViewFlipper) findViewById(R.id.vFlipper);

        btnRecommend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vFlipper.showNext();
            }
        });

        btnApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        barDrawerToggle.onOptionsItemSelected(item);
        return super.onOptionsItemSelected(item);
    }

}
