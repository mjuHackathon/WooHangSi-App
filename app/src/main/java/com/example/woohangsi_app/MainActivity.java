package com.example.woohangsi_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.example.woohangsi_app.BrandCustom;
import com.example.woohangsi_app.BudgetCategory;
import com.example.woohangsi_app.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
  private BottomNavigationView mBottomNV;
  NavigationView navigationView;
  DrawerLayout drawerLayout;

  ActionBarDrawerToggle barDrawerToggle;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    navigationView=findViewById(R.id.nav);
    drawerLayout=findViewById(R.id.layout_drawer);
    //item icon색조를 적용하지 않도록.. 설정 안하면 회색 색조
    navigationView.setItemIconTintList(null);


    //네비게이션뷰의 아이템을 클릭했을때
    navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
      @Override
      public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
          case R.id.Main:
            Intent intent=new Intent(com.example.woohangsi_app.MainActivity.this,MainActivity.class);
            startActivity(intent);
            break;
          case R.id.totalBudget_inquiry:
            intent = new Intent(MainActivity.this, InquiryBudgetTotal.class);
            startActivity(intent);
            break;
          case R.id.categoryBudget_inquiry:
            intent = new Intent(MainActivity.this, InquiryBudgetCategory.class);
            startActivity(intent);
            break;
          case R.id.brandBudget_inquiry:
            intent = new Intent(MainActivity.this, InquiryBudgetCustom.class);
            startActivity(intent);
            break;
          case R.id.totalBudget_set:
            intent = new Intent(MainActivity.this, BudgetTotal.class);
            startActivity(intent);
            break;
          case R.id.categoryBudget_set:
            intent = new Intent(MainActivity.this, BudgetCategory.class);
            startActivity(intent);
            break;
          case R.id.brandBudget_set:
            intent = new Intent(MainActivity.this, CategoryCustom.class);
            startActivity(intent);
            break;
          case R.id.top3_analysis:
            intent = new Intent(MainActivity.this, TopCategory.class);
            startActivity(intent);
            break;
          case R.id.month3_analysis:
            intent = new Intent(MainActivity.this, SpendThreeMonth.class);
            startActivity(intent);
            break;
          case R.id.consumption_analysis:
            intent = new Intent(MainActivity.this, ConsumptionPattern.class);
            startActivity(intent);
            break;
          case R.id.point_add:
            intent = new Intent(MainActivity.this, BudgetCheck.class);
            startActivity(intent);
            break;
          case R.id.point_inquiry:
            intent = new Intent(MainActivity.this, EarnPoint.class);
            startActivity(intent);
            break;

          default:
            break;
        }

        //Drawer를 닫기...
        drawerLayout.closeDrawer(navigationView);

        return false;
      }
    });
    //Drawer 조절용 토글 버튼 객체 생성
    barDrawerToggle= new ActionBarDrawerToggle(this, drawerLayout, R.string.app_name,R.string.app_name);
    //ActionBar(제목줄)의 홈or업버튼의 위치에 토글아이콘이 보이게끔...
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    //삼선아이콘 모양으로 보이도록
    //토글버튼의 동기를 맞추기
    barDrawerToggle.syncState();

    //삼선 아이콘과 화살표아이콘이 자동으로 변환하도록
    drawerLayout.addDrawerListener(barDrawerToggle);


    mBottomNV = findViewById(R.id.nav_view);
    mBottomNV.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() { //NavigationItemSelecte
      @Override
      public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        BottomNavigate(menuItem.getItemId());


        return true;
      }
    });
    mBottomNV.setSelectedItemId(R.id.main1);
  }
  private void BottomNavigate(int id) {  //BottomNavigation 페이지 변경
    String tag = String.valueOf(id);
    FragmentManager fragmentManager = getSupportFragmentManager();
    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

    Fragment currentFragment = fragmentManager.getPrimaryNavigationFragment();
    if (currentFragment != null) {
      fragmentTransaction.hide(currentFragment);
    }

    Fragment fragment = fragmentManager.findFragmentByTag(tag);
    if (fragment == null) {
      if (id == R.id.main1) {
        fragment = new InquiryList();

      } else if (id == R.id.main2){

        fragment = new BarRating();
      }else {
        fragment = new FixedSpend();
      }

      fragmentTransaction.add(R.id.content_layout, fragment, tag);
    } else {
      fragmentTransaction.show(fragment);
    }

    fragmentTransaction.setPrimaryNavigationFragment(fragment);
    fragmentTransaction.setReorderingAllowed(true);
    fragmentTransaction.commitNow();


  }
  @Override
  public boolean onOptionsItemSelected(@NonNull MenuItem item) {
    barDrawerToggle.onOptionsItemSelected(item);
    return super.onOptionsItemSelected(item);
  }

}