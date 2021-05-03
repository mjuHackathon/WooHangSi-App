package com.example.woohangsi_app;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

import com.example.woohangsi_app.DB.Category;
import com.example.woohangsi_app.DB.RequestAPI;

import java.io.IOException;

public class BudgetCategory extends AppCompatActivity {

    public static final String NOTIFICATION_CHANNEL_ID = "10001";
    private int count = 0;

    public static final int REQUEST_CODE_MENU=101;

    TextView txtCustomer, txtMonth, Budget, leftBudget, foodLastCost, cafeLastCost, alcholLastCost,
            lifeLastCost, shoppingLastCost, fashionLastCost, beautyLastCost, trafficLastCost, carLastCost,
            houseLastCost, healthLastCost, capitalLastCost, cultureLastCost, travelLastCost, educateLastCost,
            childrenLastCost, petLastCost, presentLastCost;
    Button btnSelect, btnSave;
    LinearLayout food, cafe, alchol, life, shopping, fashion, beauty, traffic, car, house, health, capital,
            culture, travel, educate, children, pet, present;
    EditText foodBudget, cafeBudget, alcholBudget, lifeBudget, shoppingBudget, fashionBudget, beautyBudget,
            trafficBudget, carBudget, houseBudget, healthBudget, capitalBudget, cultureBudget, travelBudget,
            educateBudget, childrenBudget, petBudget, presentBudget;

    LinearLayout [] layoutarray;
    String [] categoryArray;
    boolean [] checkArray;
    EditText [] editTextArray;

    NavigationView navigationView;
    DrawerLayout drawerLayout;

    ActionBarDrawerToggle barDrawerToggle;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category_budget);

        navigationView=findViewById(R.id.nav);
        drawerLayout=findViewById(R.id.layout_drawer);
        navigationView.setItemIconTintList(null);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.Main:
                        Intent intent=new Intent(com.example.woohangsi_app.BudgetCategory.this,MainActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.totalBudget_inquiry:
                        intent = new Intent(BudgetCategory.this, InquiryBudgetTotal.class);
                        startActivity(intent);
                        break;
                    case R.id.categoryBudget_inquiry:
                        intent = new Intent(BudgetCategory.this, InquiryBudgetCategory.class);
                        startActivity(intent);
                        break;
                    case R.id.brandBudget_inquiry:
                        intent = new Intent(BudgetCategory.this, InquiryBudgetCustom.class);
                        startActivity(intent);
                        break;
                    case R.id.totalBudget_set:
                        intent = new Intent(BudgetCategory.this, BudgetTotal.class);
                        startActivity(intent);
                        break;
                    case R.id.categoryBudget_set:
                        intent = new Intent(BudgetCategory.this, BudgetCategory.class);
                        startActivity(intent);
                        break;
                    case R.id.brandBudget_set:
                        intent = new Intent(BudgetCategory.this, CategoryCustom.class);
                        startActivity(intent);
                        break;
                    case R.id.top3_analysis:
                        intent = new Intent(BudgetCategory.this, TopCategory.class);
                        startActivity(intent);
                        break;
                    case R.id.month3_analysis:
                        intent = new Intent(BudgetCategory.this, SpendThreeMonth.class);
                        startActivity(intent);
                        break;
                    case R.id.consumption_analysis:
                        intent = new Intent(BudgetCategory.this, ConsumptionPattern.class);
                        startActivity(intent);
                        break;
                    case R.id.point_add:
                        intent = new Intent(BudgetCategory.this, BudgetCheck.class);
                        startActivity(intent);
                        break;
                    case R.id.point_inquiry:
                        intent = new Intent(BudgetCategory.this, EarnPoint.class);
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
        txtMonth = (TextView) findViewById(R.id.txtMonth);
        Budget = (TextView) findViewById(R.id.Budget);
        leftBudget = (TextView) findViewById(R.id.leftBudget);
        foodLastCost = (TextView) findViewById(R.id.foodLastCost);
        cafeLastCost = (TextView) findViewById(R.id.cafeLastCost);
        alcholLastCost = (TextView) findViewById(R.id.alcholLastCost);
        lifeLastCost = (TextView) findViewById(R.id.lifeLastCost);
        shoppingLastCost = (TextView) findViewById(R.id.shoppingLastCost);
        fashionLastCost = (TextView) findViewById(R.id.fashionLastCost);
        beautyLastCost = (TextView) findViewById(R.id.beautyLastCost);
        trafficLastCost = (TextView) findViewById(R.id.trafficLastCost);
        carLastCost = (TextView) findViewById(R.id.carLastCost);
        houseLastCost = (TextView) findViewById(R.id.houseLastCost);
        healthLastCost = (TextView) findViewById(R.id.healthLastCost);
        capitalLastCost = (TextView) findViewById(R.id.capitalLastCost);
        cultureLastCost = (TextView) findViewById(R.id.cultureLastCost);
        travelLastCost = (TextView) findViewById(R.id.travelLastCost);
        educateLastCost = (TextView) findViewById(R.id.educateLastCost);
        childrenLastCost = (TextView) findViewById(R.id.childrenLastCost);
        petLastCost = (TextView) findViewById(R.id.petLastCost);
        presentLastCost = (TextView) findViewById(R.id.presentLastCost);

        btnSelect = (Button) findViewById(R.id.btnSelect);
        btnSave = (Button) findViewById(R.id.btnSave);

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

        foodBudget = (EditText) findViewById(R.id.foodBudget);
        cafeBudget = (EditText) findViewById(R.id.cafeBudget);
        alcholBudget = (EditText) findViewById(R.id.alcholBudget);
        lifeBudget = (EditText) findViewById(R.id.lifeBudget);
        shoppingBudget = (EditText) findViewById(R.id.shoppingBudget);
        fashionBudget = (EditText) findViewById(R.id.fashionBudget);
        beautyBudget = (EditText) findViewById(R.id.beautyBudget);
        trafficBudget = (EditText) findViewById(R.id.trafficBudget);
        carBudget = (EditText) findViewById(R.id.carBudget);
        houseBudget = (EditText) findViewById(R.id.houseBudget);
        healthBudget = (EditText) findViewById(R.id.healthBudget);
        capitalBudget = (EditText) findViewById(R.id.capitalBudget);
        cultureBudget = (EditText) findViewById(R.id.cultureBudget);
        travelBudget = (EditText) findViewById(R.id.travelBudget);
        educateBudget = (EditText) findViewById(R.id.educateBudget);
        childrenBudget = (EditText) findViewById(R.id.childrenBudget);
        petBudget = (EditText) findViewById(R.id.petBudget);
        presentBudget = (EditText) findViewById(R.id.presentBudget);

        leftBudget.setText(Budget.getText());

        layoutarray = new LinearLayout[] {food, cafe, alchol, life, shopping, fashion, beauty, traffic, car, house, health, capital, culture, travel, educate, children, pet, present};

        categoryArray = new String[] {"식비", "카페", "술/유흥", "생활", "온라인 쇼핑", "패션", "뷰티", "교통", "자동차", "주거/통신", "의료/건강", "금융",
                "문화/여가", "여행/숙박", "교육/학습", "자녀/육아", "반려동물", "경조/선물"};
        checkArray = new boolean[]{false, false, false, false, false, false, false, false, false, false,
                false, false, false, false, false, false, false, false};

        editTextArray = new EditText[] {foodBudget, cafeBudget, alcholBudget, lifeBudget, shoppingBudget, fashionBudget, beautyBudget, trafficBudget, carBudget, houseBudget, healthBudget, capitalBudget, cultureBudget, travelBudget, educateBudget, childrenBudget, petBudget, presentBudget};
        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(BudgetCategory.this);
                dlg.setTitle("예산 설정을 원하는 카테고리를 선택");
                dlg.setIcon(R.drawable.logo);
                dlg.setMultiChoiceItems(categoryArray, checkArray, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which, boolean isChecked) {
                        if(checkArray[which]=isChecked){
                            layoutarray[which].setVisibility(View.VISIBLE);
                        }
                        else{
                            layoutarray[which].setVisibility(View.GONE);
                        }
                    }
                });
                dlg.setPositiveButton("완료", null);
                dlg.show();
            }
        });

        Handler handler = new Handler();

        txtCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        NotificationSomethings();
                        count++;
                    }
                }, 5000);
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String num1 = Budget.getText().toString();
                String num2 = trafficBudget.getText().toString();
                String num3 = cafeBudget.getText().toString();
                String num4 = foodBudget.getText().toString();
                String num5 = shoppingBudget.getText().toString();

                Integer result = Integer.parseInt(num1)-Integer.parseInt(num2)-Integer.parseInt(num3)-Integer.parseInt(num4)-Integer.parseInt(num5);

                leftBudget.setText(result.toString());

                for (int i=0; i<checkArray.length;i++) {
                    if (checkArray[i]==true) {
                        Category category = new Category();
                        handlePostBtn(category.getBudgetAddUrl(),category.getBudgetAddBody(Integer.parseInt(editTextArray[i].getText().toString()),1,"C00"+Integer.toString(i+1),"5"));
                    }
                }
            }
        });
    }
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_MENU) {
            if (resultCode == RESULT_OK) {
                String total = data.getStringExtra("total");
                Budget.setText(total);
                leftBudget.setText(Budget.getText());
            }
        }
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        barDrawerToggle.onOptionsItemSelected(item);
        return super.onOptionsItemSelected(item);
    }

    public void NotificationSomethings() {

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        Intent notificationIntent = new Intent(this, BudgetCategory.class);
        notificationIntent.putExtra("notificationId", count); //전달할 값
        notificationIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, NOTIFICATION_CHANNEL_ID)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.logo)) //BitMap 이미지 요구
                .setContentTitle("패션")
//            .setContentText("거래처 : OneOfOne / 지출 : 160,000원 / 남은 예산 : 40,000원")
                // 더 많은 내용이라서 일부만 보여줘야 하는 경우 아래 주석을 제거하면 setContentText에 있는 문자열 대신 아래 문자열을 보여줌
                .setStyle(new NotificationCompat.BigTextStyle().bigText("지출 : 160,000원 / 남은 예산 : 40,000원"))
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setContentIntent(pendingIntent) // 사용자가 노티피케이션을 탭시 ResultActivity로 이동하도록 설정
                .setAutoCancel(true);

        //OREO API 26 이상에서는 채널 필요
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            builder.setSmallIcon(R.drawable.ic_launcher_foreground); //mipmap 사용시 Oreo 이상에서 시스템 UI 에러남
            CharSequence channelName = "노티페케이션 채널";
            String description = "오레오 이상을 위한 것임";
            int importance = NotificationManager.IMPORTANCE_HIGH;

            NotificationChannel channel = new NotificationChannel(NOTIFICATION_CHANNEL_ID, channelName, importance);
            channel.setDescription(description);

            // 노티피케이션 채널을 시스템에 등록
            assert notificationManager != null;
            notificationManager.createNotificationChannel(channel);

        } else
            builder.setSmallIcon(R.mipmap.ic_launcher); // Oreo 이하에서 mipmap 사용하지 않으면 Couldn't create icon: StatusBarIcon 에러남

        assert notificationManager != null;
        notificationManager.notify(1234, builder.build()); // 고유숫자로 노티피케이션 동작시킴

    }

    public void handlePostBtn(String subUrl, String bodyString) {
        Thread thread = new Thread() {
            public void run() {
                try {
                    RequestAPI requestAPI = new RequestAPI();
                    requestAPI.requestPost(subUrl, bodyString);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();
    }

}
