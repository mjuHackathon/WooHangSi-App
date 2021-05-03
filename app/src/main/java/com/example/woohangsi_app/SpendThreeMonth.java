package com.example.woohangsi_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

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

public class SpendThreeMonth extends AppCompatActivity {
    NavigationView navigationView;
    DrawerLayout drawerLayout;

    ActionBarDrawerToggle barDrawerToggle;

    TextView txtCustomer, txtMonth1, txtMonth2, txtMonth3, Month1_money, Month2_money, Month3_money;

    RequestAPI requestAPI;
    String data;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.three_month_spend);
        navigationView = findViewById(R.id.nav);
        drawerLayout = findViewById(R.id.layout_drawer);
        navigationView.setItemIconTintList(null);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.Main:
                        Intent intent = new Intent(com.example.woohangsi_app.SpendThreeMonth.this, MainActivity.class);
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

        barDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.app_name, R.string.app_name);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        barDrawerToggle.syncState();

        drawerLayout.addDrawerListener(barDrawerToggle);


        txtCustomer = (TextView) findViewById(R.id.txtCustomer);
        txtMonth1 = (TextView) findViewById(R.id.txtMonth1);
        txtMonth2 = (TextView) findViewById(R.id.txtMonth2);
        txtMonth3 = (TextView) findViewById(R.id.txtMonth3);
        Month1_money = (TextView) findViewById(R.id.Month1_money);
        Month2_money = (TextView) findViewById(R.id.Month2_money);
        Month3_money = (TextView) findViewById(R.id.Month3_money);

        Entire entire = new Entire();
        handlePost1(entire.getRootUrl(), entire.getRootBody(1,"2"));
        handlePost2(entire.getRootUrl(), entire.getRootBody(1,"3"));
        handlePost3(entire.getRootUrl(), entire.getRootBody(1,"4"));
    }

    public void handlePost1(String subUrl, String bodyString) {
        Thread thread = new Thread() {
            public void run() {
                try {
                    requestAPI = new RequestAPI();
                    data = requestAPI.requestPost(subUrl, bodyString);
                    JSONArray jsonArray1 = new JSONArray(data);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                txtMonth1.setText(jsonArray1.getJSONObject(0).getString("month"));
                                Month1_money.setText(jsonArray1.getJSONObject(0).getString("spending"));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    });
                } catch (IOException | JSONException e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();
    }

    public void handlePost2(String subUrl, String bodyString) {
        Thread thread = new Thread() {
            public void run() {
                try {
                    requestAPI = new RequestAPI();
                    data = requestAPI.requestPost(subUrl, bodyString);
                    JSONArray jsonArray2 = new JSONArray(data);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                txtMonth2.setText(jsonArray2.getJSONObject(0).getString("month"));
                                Month2_money.setText(jsonArray2.getJSONObject(0).getString("spending"));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    });
                } catch (IOException | JSONException e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();
    }

    public void handlePost3(String subUrl, String bodyString) {
        Thread thread = new Thread() {
            public void run() {
                try {
                    requestAPI = new RequestAPI();
                    data = requestAPI.requestPost(subUrl, bodyString);
                    JSONArray jsonArray3 = new JSONArray(data);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                txtMonth3.setText(jsonArray3.getJSONObject(0).getString("month"));
                                Month3_money.setText(jsonArray3.getJSONObject(0).getString("spending"));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    });
                } catch (IOException | JSONException e) {
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
