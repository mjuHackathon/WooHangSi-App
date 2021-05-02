package com.example.woohangsi_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

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
import android.widget.TextView;

import com.example.woohangsi_app.DB.Account;
import com.example.woohangsi_app.DB.Brand;
import com.example.woohangsi_app.DB.Category;
import com.example.woohangsi_app.DB.Entire;
import com.example.woohangsi_app.DB.FixedSpending;
import com.example.woohangsi_app.DB.Point;
import com.example.woohangsi_app.DB.RequestAPI;
import com.example.woohangsi_app.requests.Body;
import com.example.woohangsi_app.requests.CallAPI;
import com.example.woohangsi_app.requests.Urls;

import java.io.IOException;

public class CheckApi extends AppCompatActivity {

    // acount
    Button btnAllAccount, btnTransactions;
    // brand
    Button btnBrand, btnBrandAdd, btnBrandBudgetAdd, btnBrandSpendingAdd, btnBrandBudgetUpdate, btnBrandBudgetDelete;
    // category
    Button btnCategory, btnCategoryBudgetAdd, btnCategorySpendingAdd, btnCategoryBudgetUpdate, btnCategoryBudgetDelete;
    // entire
    Button btnEntire, btnEntireAdd, btnEntireUpdate, btnEntireDelete;
    // fixed spending
    Button btnFixedSpending, btnFixedSpendingAdd, btnFixedSpendingUpdate, btnFixedSpendingDelete;
    // point
    Button btnPoint, btnPointManage, btnPointList;

    String data;
    TextView textView;

    RequestAPI requestAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.api_check);

        Button button = (Button) findViewById(R.id.button);

        textView = (TextView)findViewById(R.id.textView2);



        // account
        btnAllAccount = (Button)findViewById(R.id.btnAllAccount);
        btnTransactions = (Button)findViewById(R.id.btnTransactions);
        // brand
        btnBrand = (Button) findViewById(R.id.btnBrand);
        btnBrandAdd = (Button) findViewById(R.id.btnBrandAdd);
        btnBrandBudgetAdd = (Button) findViewById(R.id.btnBrandBudgetAdd);
        btnBrandBudgetUpdate = (Button) findViewById(R.id.btnBrandBudgetUpdate);
        btnBrandBudgetDelete = (Button) findViewById(R.id.btnBrandBudgetDelete);
        btnBrandSpendingAdd = (Button) findViewById(R.id.btnBrandSpendingAdd);
        // category
        btnCategory = (Button) findViewById(R.id.btnCategory);
        btnCategoryBudgetAdd = (Button) findViewById(R.id.btnCategoryBudgetAdd);
        btnCategoryBudgetUpdate = (Button) findViewById(R.id.btnCategoryBudgetUpdate);
        btnCategoryBudgetDelete = (Button) findViewById(R.id.btnCategoryBudgetDelete);
        btnCategorySpendingAdd = (Button) findViewById(R.id.btnCategorySpendingAdd);
        // entire
        btnEntire = (Button) findViewById(R.id.btnEntire);
        btnEntireAdd = (Button) findViewById(R.id.btnEntireAdd);
        btnEntireUpdate = (Button) findViewById(R.id.btnEntireUpdate);
        btnEntireDelete = (Button) findViewById(R.id.btnEntireDelete);
        // fixed spending
        btnFixedSpending = (Button) findViewById(R.id.btnFixedSpending);
        btnFixedSpendingAdd = (Button) findViewById(R.id.btnFixedSpendingAdd);
        btnFixedSpendingUpdate = (Button) findViewById(R.id.btnFixedSpendingUpdate);
        btnFixedSpendingDelete = (Button) findViewById(R.id.btnFixedSpendingDelete);
        // point
        btnPoint = (Button) findViewById(R.id.btnPoint);
        btnPointManage = (Button) findViewById(R.id.btnPointManage);
        btnPointList = (Button) findViewById(R.id.btnPointList);

        // account
        btnAllAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Account account = new Account();
                handlePostBtn(account.getGetAllAccountUrl(),account.getGetAllAccountBody("1"));
            }
        });

        btnTransactions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Account account = new Account();
                handlePostBtn(account.getGetTransactionsUrl(),account.getGetTransactionsBody("1002881893528"));
            }
        });

        // brand
        btnBrand.setOnClickListener(new View.OnClickListener() {
            // 브랜드예산조회
            @Override
            public void onClick(View view) {
                Brand brand = new Brand();
                handlePostBtn(brand.getRootUrl(),brand.getRootBody("1","1","3"));
            }
        });
        btnBrandAdd.setOnClickListener(new View.OnClickListener() {
            // 브랜드 추가
            @Override
            public void onClick(View view) {
                Brand brand = new Brand();
                handlePostBtn(brand.getAddUrl(),brand.getAddBody("BHC","C001"));
            }
        });
        btnBrandBudgetAdd.setOnClickListener(new View.OnClickListener() {
            // 브랜드 예산 추가
            @Override
            public void onClick(View view) {
                Brand brand = new Brand();
                handlePostBtn(brand.getBudgetAddUrl(),brand.getBudgetAddBody("1","1","500000","30000","3"));
            }
        });
        btnBrandBudgetUpdate.setOnClickListener(new View.OnClickListener() {
            // 브랜드 예산 수정
            @Override
            public void onClick(View view) {
                Brand brand = new Brand();
                handlePutBtn(brand.getBudgetUpdateUrl(),brand.getBudgetUpdateBody("400000","3"));
            }
        });
        btnBrandBudgetDelete.setOnClickListener(new View.OnClickListener() {
            // 브랜드 예산 삭제
            @Override
            public void onClick(View view) {
                Brand brand = new Brand();
                handleDeleteBtn(brand.getBudgetDeleteUrl(),brand.getBudgetDeleteBody("3"));
            }
        });
        btnBrandSpendingAdd.setOnClickListener(new View.OnClickListener() {
            // 브랜드 지출 추가
            @Override
            public void onClick(View view) {
                Brand brand = new Brand();
                handlePutBtn(brand.getSpendingUpdateUrl(),brand.getSpendingUpdateBody("20000","4"));
            }
        });

        // category
        btnCategory.setOnClickListener(new View.OnClickListener() {
            // 카테고리예산조회
            @Override
            public void onClick(View view) {
                Category category = new Category();
                handlePostBtn(category.getRootUrl(), category.getRootBody(1,"C001","3"));
            }
        });
        btnCategoryBudgetAdd.setOnClickListener(new View.OnClickListener() {
            // 카테고리 예산 추가
            @Override
            public void onClick(View view) {
                Category category = new Category();
                handlePostBtn(category.getBudgetAddUrl(),category.getBudgetAddBody(400000,1,"C001","3"));
            }
        });
        btnCategoryBudgetUpdate.setOnClickListener(new View.OnClickListener() {
            // 카테고리 예산 수정
            @Override
            public void onClick(View view) {
                Category category = new Category();
                handlePutBtn(category.getBudgetUpdateUrl(),category.getBudgetUpdateBody(500000,3));
            }
        });
        btnCategoryBudgetDelete.setOnClickListener(new View.OnClickListener() {
            // 카테고리 예산 삭제
            @Override
            public void onClick(View view) {
                Category category = new Category();
                handleDeleteBtn(category.getBudgetDeleteUrl(),category.getBudgetDeleteBody(2));
            }
        });
        btnCategorySpendingAdd.setOnClickListener(new View.OnClickListener() {
            // 카테고리 지출 추가
            @Override
            public void onClick(View view) {
                Category category = new Category();
                handlePutBtn(category.getSpendingUpdateUrl(),category.getSpendingUpdateBody("3","40000"));
            }
        });

        // entire
        btnEntire.setOnClickListener(new View.OnClickListener() {
            // 전체 예산/지출 조회
            @Override
            public void onClick(View view) {
                Entire entire = new Entire();
                handlePostBtn(entire.getRootUrl(), entire.getRootBody(1,"3"));
            }
        });
        btnEntireAdd.setOnClickListener(new View.OnClickListener() {
            // 전체 예산 추가
            @Override
            public void onClick(View view) {
                Entire entire = new Entire();
                handlePostBtn(entire.getAddUrl(), entire.getAddBody(1500000,1,"3"));
            }
        });
        btnEntireUpdate.setOnClickListener(new View.OnClickListener() {
            // 전체 예산 수정
            @Override
            public void onClick(View view) {
                Entire entire = new Entire();
                handlePutBtn(entire.getUpdateUrl(),entire.getUpdateBody(1800000,1));
            }
        });
        btnEntireDelete.setOnClickListener(new View.OnClickListener() {
            // 전체 예산 삭제
            @Override
            public void onClick(View view) {
                Entire entire = new Entire();
                handleDeleteBtn(entire.getDeleteUrl(),entire.getDeleteBody(1));
            }
        });

        // fixed spending
        btnFixedSpending.setOnClickListener(new View.OnClickListener() {
            // 고정 \n지출 \n조회
            @Override
            public void onClick(View view) {
                FixedSpending fixedSpending = new FixedSpending();
                handlePostBtn(fixedSpending.getRootUrl(), fixedSpending.getRootBody(1,"3"));
            }
        });
        btnFixedSpendingAdd.setOnClickListener(new View.OnClickListener() {
            // 고정 지출 추가
            @Override
            public void onClick(View view) {
                FixedSpending fixedSpending = new FixedSpending();
                handlePostBtn(fixedSpending.getAddUrl(),fixedSpending.getAddBody("월세",450000,1,"3"));
            }
        });
        btnFixedSpendingUpdate.setOnClickListener(new View.OnClickListener() {
            // 고정 지출 수정
            @Override
            public void onClick(View view) {
                FixedSpending fixedSpending = new FixedSpending();
                handlePutBtn(fixedSpending.getUpdateUrl(),fixedSpending.getUpdateBody("관리비",30000,1));
            }
        });
        btnFixedSpendingDelete.setOnClickListener(new View.OnClickListener() {
            // 고정 지출 삭제
            @Override
            public void onClick(View view) {
                FixedSpending fixedSpending = new FixedSpending();
                handleDeleteBtn(fixedSpending.getDeleteUrl(), fixedSpending.getDeleteBody(5));
            }
        });

        // point
        btnPoint.setOnClickListener(new View.OnClickListener() {
            // 총 포인트 조회
            @Override
            public void onClick(View view) {
                Point point = new Point();
                handlePostBtn(point.getRootUrl(),point.getRootBody(1));
            }
        });
        btnPointManage.setOnClickListener(new View.OnClickListener() {
            // 포인트 적립/차감
            @Override
            public void onClick(View view) {
                Point point = new Point();
                handlePostBtn(point.getManageUrl(),point.getManageBody(1,"적립",1));
            }
        });
        btnPointList.setOnClickListener(new View.OnClickListener() {
            // 포인트 내역 조회
            @Override
            public void onClick(View view) {
                Point point = new Point();
                handlePostBtn(point.getListUrl(),point.getListBody(1));
            }
        });
    }



    public void handlePostBtn(String subUrl, String bodyString) {
        textView = (TextView)findViewById(R.id.textView2);
        Thread thread = new Thread() {
            public void run() {
                try {
                    requestAPI = new RequestAPI();

                    data = requestAPI.requestPost(subUrl, bodyString);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            textView.setText(data);
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();
    }
    public void handlePutBtn(String subUrl, String bodyString) {
        textView = (TextView)findViewById(R.id.textView2);
        Thread thread = new Thread() {
            public void run() {
                try {
                    requestAPI = new RequestAPI();

                    requestAPI.requestPut(subUrl, bodyString);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();
    }
    public void handleDeleteBtn(String subUrl, String bodyString) {
        textView = (TextView)findViewById(R.id.textView2);
        Thread thread = new Thread() {
            public void run() {
                try {
                    requestAPI = new RequestAPI();

                    requestAPI.requestDelete(subUrl, bodyString);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();
    }

}
