package com.example.woohangsi_app;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.woohangsi_app.DB.Account;
import com.example.woohangsi_app.DB.RequestAPI;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class InquiryList extends Fragment {

    Button monthPrev, monthNext;
    TextView month, income, payment, inquiry_month, inquiry_day, inquiry_name, inquiry_category,
            inquiry_account, inquiry_plus, inquiry_minus, inquiry_money;
    LinearLayout inquiry_image;
    Spinner spinner;
    View divider3, divider4;
    String incomeVal, payVal;
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_inquiry, container, false);

        monthPrev = (Button)view.findViewById(R.id.monthPrev);
        monthNext = (Button)view.findViewById(R.id.monthNext);

        month = (TextView)view.findViewById(R.id.month);
        income = (TextView)view.findViewById(R.id.income);

        payment = (TextView)view.findViewById(R.id.payment);
        inquiry_month = (TextView)view.findViewById(R.id.inquiry_month);
        inquiry_day = (TextView)view.findViewById(R.id.inquiry_day);
        inquiry_name = (TextView)view.findViewById(R.id.inquiry_name);
        inquiry_category = (TextView)view.findViewById(R.id.inquiry_category);
        inquiry_account = (TextView)view.findViewById(R.id.inquiry_account);
        inquiry_plus = (TextView)view.findViewById(R.id.inquiry_plus);
        inquiry_minus = (TextView)view.findViewById(R.id.inquiry_minus);
        inquiry_money = (TextView)view.findViewById(R.id.inquiry_money);

        inquiry_image = (LinearLayout)view.findViewById(R.id.inquiry_image);

        spinner = (Spinner) view.findViewById(R.id.spinner);

        divider3 = (View) view.findViewById(R.id.divider3);
        divider4 = (View) view.findViewById(R.id.divider4);

        getTransactions();
        setHasOptionsMenu(true);
        return inflater.inflate(R.layout.list_inquiry, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }

    public void getTransactions() {
        Account account = new Account();
        Thread thread = new Thread() {
            public void run() {
                try {
                    RequestAPI requestAPI = new RequestAPI();
                    String data = requestAPI.requestPost(account.getGetTransactionsUrl(), account.getGetTransactionsBody("1002881893528"));
                    JSONArray objArray = new JSONArray(data);
                    incomeVal = getIncome(objArray);
                    System.out.println(incomeVal);
                    payVal = getPayment(objArray);
                    System.out.println(payVal);
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            income.setText(incomeVal); //수입 값
                            payment.setText(payVal); //지출 값
                        }
                    });
                } catch (IOException | JSONException e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();
    }
    public String getIncome(JSONArray jsonArray) throws JSONException {
        int res = 0;
        for (int i=0; i<jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            res += jsonObject.getInt("rcv_am");
        }
        return Integer.toString(res);
    }
    public String getPayment(JSONArray jsonArray) throws JSONException {
        int res = 0;
        for (int i=0; i<jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            res += jsonObject.getInt("pay_am");
        }
        return Integer.toString(res);
    }
}
