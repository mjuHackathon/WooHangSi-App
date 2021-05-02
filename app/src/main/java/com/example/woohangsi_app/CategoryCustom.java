package com.example.woohangsi_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class CategoryCustom extends AppCompatActivity {
    NavigationView navigationView;
    DrawerLayout drawerLayout;

    ActionBarDrawerToggle barDrawerToggle;

    ViewFlipper vFlipper;
    ImageView food_img, cafe_img, alchol_img, life_img, shopping_img, fashion_img, beauty_img, traffic_img,
            car_img, house_img, health_img, capital_img, culture_img, travel_img, educate_img, children_img,
            pet_img, present_img;
    TextView food, cafe, alchol, life, shopping, fashion, beauty, traffic, car, house, health, capital,
            culture, travel, educate, children, pet, present;
    Button btnNext, btnPrev;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_category);
        navigationView=findViewById(R.id.nav);
        drawerLayout=findViewById(R.id.layout_drawer);
        navigationView.setItemIconTintList(null);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.Main:
                        Intent intent=new Intent(com.example.woohangsi_app.CategoryCustom.this,MainActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.totalBudget_inquiry:
                        intent = new Intent(CategoryCustom.this, InquiryBudgetTotal.class);
                        startActivity(intent);
                        break;
                    case R.id.categoryBudget_inquiry:
                        intent = new Intent(CategoryCustom.this, InquiryBudgetCategory.class);
                        startActivity(intent);
                        break;
                    case R.id.brandBudget_inquiry:
                        intent = new Intent(CategoryCustom.this, InquiryBudgetCustom.class);
                        startActivity(intent);
                        break;
                    case R.id.totalBudget_set:
                        intent = new Intent(CategoryCustom.this, BudgetTotal.class);
                        startActivity(intent);
                        break;
                    case R.id.categoryBudget_set:
                        intent = new Intent(CategoryCustom.this, BudgetCategory.class);
                        startActivity(intent);
                        break;
                    case R.id.brandBudget_set:
                        intent = new Intent(CategoryCustom.this, CategoryCustom.class);
                        startActivity(intent);
                        break;
                    case R.id.top3_analysis:
                        intent = new Intent(CategoryCustom.this, TopCategory.class);
                        startActivity(intent);
                        break;
                    case R.id.month3_analysis:
                        intent = new Intent(CategoryCustom.this, SpendThreeMonth.class);
                        startActivity(intent);
                        break;
                    case R.id.consumption_analysis:
                        intent = new Intent(CategoryCustom.this, ConsumptionPattern.class);
                        startActivity(intent);
                        break;
                    case R.id.MyPoint:
                        intent = new Intent(CategoryCustom.this, EarnPoint.class);
                        startActivity(intent);
                        break;
                    case R.id.point_add:
                        intent = new Intent(CategoryCustom.this, BudgetCheck.class);
                        startActivity(intent);
                        break;
                    case R.id.point_inquiry:
                        intent = new Intent(CategoryCustom.this, EarnPoint.class);
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


        vFlipper = (ViewFlipper)findViewById(R.id.vFlipper);

        food_img = (ImageView)findViewById(R.id.food_img);
        cafe_img = (ImageView)findViewById(R.id.cafe_img);
        alchol_img = (ImageView)findViewById(R.id.alchol_img);
        life_img = (ImageView)findViewById(R.id.life_img);
        shopping_img = (ImageView)findViewById(R.id.shopping_img);
        fashion_img = (ImageView)findViewById(R.id.fashion_img);
        beauty_img = (ImageView)findViewById(R.id.beauty_img);
        traffic_img = (ImageView)findViewById(R.id.traffic_img);
        car_img = (ImageView)findViewById(R.id.car_img);
        house_img = (ImageView)findViewById(R.id.house_img);
        health_img = (ImageView)findViewById(R.id.health_img);
        capital_img = (ImageView)findViewById(R.id.capital_img);
        culture_img = (ImageView)findViewById(R.id.culture_img);
        travel_img = (ImageView)findViewById(R.id.travel_img);
        educate_img = (ImageView)findViewById(R.id.educate_img);
        children_img = (ImageView)findViewById(R.id.children_img);
        pet_img = (ImageView)findViewById(R.id.pet_img);
        present_img = (ImageView)findViewById(R.id.present_img);

        food = (TextView)findViewById(R.id.food);
        cafe = (TextView)findViewById(R.id.cafe);
        alchol = (TextView)findViewById(R.id.alchol);
        life = (TextView)findViewById(R.id.life);
        shopping = (TextView)findViewById(R.id.shopping);
        fashion = (TextView)findViewById(R.id.fashion);
        beauty = (TextView)findViewById(R.id.beauty);
        traffic = (TextView)findViewById(R.id.traffic);
        car = (TextView)findViewById(R.id.car);
        house = (TextView)findViewById(R.id.house);
        health = (TextView)findViewById(R.id.health);
        capital = (TextView)findViewById(R.id.capital);
        culture = (TextView)findViewById(R.id.culture);
        travel = (TextView)findViewById(R.id.travel);
        educate = (TextView)findViewById(R.id.educate);
        children = (TextView)findViewById(R.id.children);
        pet = (TextView)findViewById(R.id.pet);
        present = (TextView)findViewById(R.id.present);

        btnNext = (Button)findViewById(R.id.btnNext);
        btnPrev = (Button)findViewById(R.id.btnPrev);

        cafe_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), BrandCustom.class);
                startActivity(intent);
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vFlipper.showNext();
            }
        });

        btnPrev.setOnClickListener(new View.OnClickListener() {
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
