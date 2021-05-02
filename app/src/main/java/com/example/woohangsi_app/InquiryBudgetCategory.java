package com.example.woohangsi_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class InquiryBudgetCategory extends AppCompatActivity {
    NavigationView navigationView;
    DrawerLayout drawerLayout;

    ActionBarDrawerToggle barDrawerToggle;

    LinearLayout food, cafe, alchol, life, shopping, fashion, beauty, traffic, car, house, health, capital,
            culture, travel, educate, children, pet, present;

    TextView foodLastCost, foodBudget, cafeLastCost, cafeBudget, alcholLastCost, alcholBudget,
            lifeLastCost, lifeBudget, shoppingLastCost, shoppingBudget, fashionLastCost, fashionBudget,
            beautyLastCost, beautyBudget, trafficLastCost, trafficBudget, carLastCost, carBudget,
            houseLastCost, houseBudget, healthLastCost, healthBudget, capitalLastCost, capitalBudget,
            cultureLastCost, cultureBudget, travelLastCost, travelBudget, educateLastCost, educateBudget,
            childrenLastCost, childrenBudget, petLastCost, petBudget, presentLastCost, presentBudget;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category_budget_inquiry);

        navigationView=findViewById(R.id.nav);
        drawerLayout=findViewById(R.id.layout_drawer);
        navigationView.setItemIconTintList(null);


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.Main:
                        Intent intent=new Intent(com.example.woohangsi_app.InquiryBudgetCategory.this,MainActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.totalBudget_inquiry:
                        intent = new Intent(InquiryBudgetCategory.this, InquiryBudgetTotal.class);
                        startActivity(intent);
                        break;
                    case R.id.categoryBudget_inquiry:
                        intent = new Intent(InquiryBudgetCategory.this, InquiryBudgetCategory.class);
                        startActivity(intent);
                        break;
                    case R.id.brandBudget_inquiry:
                        intent = new Intent(InquiryBudgetCategory.this, InquiryBudgetCustom.class);
                        startActivity(intent);
                        break;
                    case R.id.totalBudget_set:
                        intent = new Intent(InquiryBudgetCategory.this, BudgetTotal.class);
                        startActivity(intent);
                        break;
                    case R.id.categoryBudget_set:
                        intent = new Intent(InquiryBudgetCategory.this, BudgetCategory.class);
                        startActivity(intent);
                        break;
                    case R.id.brandBudget_set:
                        intent = new Intent(InquiryBudgetCategory.this, CategoryCustom.class);
                        startActivity(intent);
                        break;
                    case R.id.top3_analysis:
                        intent = new Intent(InquiryBudgetCategory.this, TopCategory.class);
                        startActivity(intent);
                        break;
                    case R.id.month3_analysis:
                        intent = new Intent(InquiryBudgetCategory.this, SpendThreeMonth.class);
                        startActivity(intent);
                        break;
                    case R.id.consumption_analysis:
                        intent = new Intent(InquiryBudgetCategory.this, ConsumptionPattern.class);
                        startActivity(intent);
                        break;
                    case R.id.point_add:
                        intent = new Intent(InquiryBudgetCategory.this, BudgetCheck.class);
                        startActivity(intent);
                        break;
                    case R.id.point_inquiry:
                        intent = new Intent(InquiryBudgetCategory.this, EarnPoint.class);
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


        food = (LinearLayout) findViewById(R.id.food);
        cafe = (LinearLayout) findViewById(R.id.cafe);
        alchol = (LinearLayout) findViewById(R.id.alchol);
        life = (LinearLayout) findViewById(R.id.life);
        shopping = (LinearLayout) findViewById(R.id.shopping);
        fashion = (LinearLayout) findViewById(R.id.fashion);
        beauty = (LinearLayout) findViewById(R.id.beauty);
        traffic = (LinearLayout) findViewById(R.id.traffic);
        car = (LinearLayout) findViewById(R.id.car);
        house = (LinearLayout) findViewById(R.id.house);
        health = (LinearLayout) findViewById(R.id.health);
        capital = (LinearLayout) findViewById(R.id.capital);
        culture = (LinearLayout) findViewById(R.id.culture);
        travel = (LinearLayout) findViewById(R.id.travel);
        educate = (LinearLayout) findViewById(R.id.educate);
        children = (LinearLayout) findViewById(R.id.children);
        pet = (LinearLayout) findViewById(R.id.pet);
        present = (LinearLayout) findViewById(R.id.present);

        foodLastCost = (TextView) findViewById(R.id.foodLastCost);
        foodBudget = (TextView) findViewById(R.id.foodBudget);
        cafeLastCost = (TextView) findViewById(R.id.cafeLastCost);
        cafeBudget = (TextView) findViewById(R.id.cafeBudget);
        alcholLastCost = (TextView) findViewById(R.id.alcholLastCost);
        alcholBudget = (TextView) findViewById(R.id.alcholBudget);
        lifeLastCost = (TextView) findViewById(R.id.lifeLastCost);
        lifeBudget = (TextView) findViewById(R.id.lifeBudget);
        shoppingLastCost = (TextView) findViewById(R.id.shoppingLastCost);
        shoppingBudget = (TextView) findViewById(R.id.shoppingBudget);
        fashionLastCost = (TextView) findViewById(R.id.fashionLastCost);
        fashionBudget = (TextView) findViewById(R.id.fashionBudget);
        beautyLastCost = (TextView) findViewById(R.id.beautyLastCost);
        beautyBudget = (TextView) findViewById(R.id.beautyBudget);
        trafficLastCost = (TextView) findViewById(R.id.trafficLastCost);
        trafficBudget = (TextView) findViewById(R.id.trafficBudget);
        carLastCost = (TextView) findViewById(R.id.carLastCost);
        carBudget = (TextView) findViewById(R.id.carBudget);
        houseLastCost = (TextView) findViewById(R.id.houseLastCost);
        houseBudget = (TextView) findViewById(R.id.houseBudget);
        healthLastCost = (TextView) findViewById(R.id.healthLastCost);
        healthBudget = (TextView) findViewById(R.id.healthBudget);
        capitalLastCost = (TextView) findViewById(R.id.capitalLastCost);
        capitalBudget = (TextView) findViewById(R.id.capitalBudget);
        cultureLastCost = (TextView) findViewById(R.id.cultureLastCost);
        cultureBudget = (TextView) findViewById(R.id.cultureBudget);
        travelLastCost = (TextView) findViewById(R.id.travelLastCost);
        travelBudget = (TextView) findViewById(R.id.travelBudget);
        educateLastCost = (TextView) findViewById(R.id.educateLastCost);
        educateBudget = (TextView) findViewById(R.id.educateBudget);
        childrenLastCost = (TextView) findViewById(R.id.childrenLastCost);
        childrenBudget = (TextView) findViewById(R.id.childrenBudget);
        petLastCost = (TextView) findViewById(R.id.petLastCost);
        petBudget = (TextView) findViewById(R.id.petBudget);
        presentLastCost = (TextView) findViewById(R.id.presentLastCost);
        presentBudget = (TextView) findViewById(R.id.presentBudget);

    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        barDrawerToggle.onOptionsItemSelected(item);
        return super.onOptionsItemSelected(item);
    }

}
