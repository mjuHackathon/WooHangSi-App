package com.example.woohangsi_app;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

public class Alarm extends AppCompatActivity {

  public static final String NOTIFICATION_CHANNEL_ID = "10001";
  private int count = 0;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.alarm);

    Button button = (Button) findViewById(R.id.button);
    button.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View arg0) {

        // 버튼을 누를때마다 count 를 증가시며 최근에 보낸 노티피케이션만 사용자의 탭 대기중인지 테스트
        count++;
        NotificationSomethings();
      }
    });
  }

  public void NotificationSomethings() {


    NotificationManager notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);

    Intent notificationIntent = new Intent(this, Alarm.class);
    notificationIntent.putExtra("notificationId", count); //전달할 값
    notificationIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK) ;
    PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent,  PendingIntent.FLAG_UPDATE_CURRENT);

    NotificationCompat.Builder builder = new NotificationCompat.Builder(this, NOTIFICATION_CHANNEL_ID)
            .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.logo)) //BitMap 이미지 요구
            .setContentTitle("패션")
//            .setContentText("거래처 : OneOfOne / 지출 : 160,000원 / 남은 예산 : 40,000원")
            // 더 많은 내용이라서 일부만 보여줘야 하는 경우 아래 주석을 제거하면 setContentText에 있는 문자열 대신 아래 문자열을 보여줌
            .setStyle(new NotificationCompat.BigTextStyle().bigText("거래처 : OneOfOne\n지출 : 160,000원\n남은 예산 : 40,000원"))
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setContentIntent(pendingIntent) // 사용자가 노티피케이션을 탭시 ResultActivity로 이동하도록 설정
            .setAutoCancel(true);

    //OREO API 26 이상에서는 채널 필요
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

      builder.setSmallIcon(R.drawable.ic_launcher_foreground); //mipmap 사용시 Oreo 이상에서 시스템 UI 에러남
      CharSequence channelName  = "노티페케이션 채널";
      String description = "오레오 이상을 위한 것임";
      int importance = NotificationManager.IMPORTANCE_HIGH;

      NotificationChannel channel = new NotificationChannel(NOTIFICATION_CHANNEL_ID, channelName , importance);
      channel.setDescription(description);

      // 노티피케이션 채널을 시스템에 등록
      assert notificationManager != null;
      notificationManager.createNotificationChannel(channel);

    }else builder.setSmallIcon(R.mipmap.ic_launcher); // Oreo 이하에서 mipmap 사용하지 않으면 Couldn't create icon: StatusBarIcon 에러남

    assert notificationManager != null;
    notificationManager.notify(1234, builder.build()); // 고유숫자로 노티피케이션 동작시킴

  }

}