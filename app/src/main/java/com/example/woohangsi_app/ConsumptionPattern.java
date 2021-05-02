package com.example.woohangsi_app;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class ConsumptionPattern extends AppCompatActivity {

    public static final String NOTIFICATION_CHANNEL_ID = "10001";
    private int count = 0;

    NavigationView navigationView;
    DrawerLayout drawerLayout;

    ActionBarDrawerToggle barDrawerToggle;

    TextView txtCustomer, pattern_name, pattern_cycle, inquiry_pattern_year, inquiry_pattern_month,
            inquiry_pattern_day, inquiry_pattern_store, inquiry_pattern_money;

    ImageView pattern_img, inquiry_pattern_img;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pattern_consumption);
        navigationView = findViewById(R.id.nav);
        drawerLayout = findViewById(R.id.layout_drawer);
        navigationView.setItemIconTintList(null);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.Main:
                        Intent intent = new Intent(com.example.woohangsi_app.ConsumptionPattern.this, MainActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.totalBudget_inquiry:
                        intent = new Intent(ConsumptionPattern.this, InquiryBudgetTotal.class);
                        startActivity(intent);
                        break;
                    case R.id.categoryBudget_inquiry:
                        intent = new Intent(ConsumptionPattern.this, InquiryBudgetCategory.class);
                        startActivity(intent);
                        break;
                    case R.id.brandBudget_inquiry:
                        intent = new Intent(ConsumptionPattern.this, InquiryBudgetCustom.class);
                        startActivity(intent);
                        break;
                    case R.id.totalBudget_set:
                        intent = new Intent(ConsumptionPattern.this, BudgetTotal.class);
                        startActivity(intent);
                        break;
                    case R.id.categoryBudget_set:
                        intent = new Intent(ConsumptionPattern.this, BudgetCategory.class);
                        startActivity(intent);
                        break;
                    case R.id.brandBudget_set:
                        intent = new Intent(ConsumptionPattern.this, CategoryCustom.class);
                        startActivity(intent);
                        break;
                    case R.id.top3_analysis:
                        intent = new Intent(ConsumptionPattern.this, TopCategory.class);
                        startActivity(intent);
                        break;
                    case R.id.month3_analysis:
                        intent = new Intent(ConsumptionPattern.this, SpendThreeMonth.class);
                        startActivity(intent);
                        break;
                    case R.id.consumption_analysis:
                        intent = new Intent(ConsumptionPattern.this, ConsumptionPattern.class);
                        startActivity(intent);
                        break;
                    case R.id.MyPoint:
                        intent = new Intent(ConsumptionPattern.this, EarnPoint.class);
                        startActivity(intent);
                        break;
                    case R.id.point_add:
                        intent = new Intent(ConsumptionPattern.this, BudgetCheck.class);
                        startActivity(intent);
                        break;
                    case R.id.point_inquiry:
                        intent = new Intent(ConsumptionPattern.this, EarnPoint.class);
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
        pattern_name = (TextView) findViewById(R.id.pattern_name);
        pattern_cycle = (TextView) findViewById(R.id.pattern_cycle);
        inquiry_pattern_year = (TextView) findViewById(R.id.inquiry_pattern_year);
        inquiry_pattern_month = (TextView) findViewById(R.id.inquiry_pattern_month);
        inquiry_pattern_day = (TextView) findViewById(R.id.inquiry_pattern_day);
        inquiry_pattern_store = (TextView) findViewById(R.id.inquiry_pattern_store);
        inquiry_pattern_money = (TextView) findViewById(R.id.inquiry_pattern_money);

        pattern_img = (ImageView) findViewById(R.id.pattern_img);
        inquiry_pattern_img = (ImageView) findViewById(R.id.inquiry_pattern_img);

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
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        barDrawerToggle.onOptionsItemSelected(item);
        return super.onOptionsItemSelected(item);
    }

    public void NotificationSomethings() {


        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        Intent notificationIntent = new Intent(this, ConsumptionPattern.class);
        notificationIntent.putExtra("notificationId", count); //전달할 값
        notificationIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, NOTIFICATION_CHANNEL_ID)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.logo)) //BitMap 이미지 요구
                .setContentTitle("고객님!")
//            .setContentText("거래처 : OneOfOne / 지출 : 160,000원 / 남은 예산 : 40,000원")
                // 더 많은 내용이라서 일부만 보여줘야 하는 경우 아래 주석을 제거하면 setContentText에 있는 문자열 대신 아래 문자열을 보여줌
                .setStyle(new NotificationCompat.BigTextStyle().bigText("'더페이스샵'에서 화장품을 구매하실 시기가 아니신가요?"))
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
}