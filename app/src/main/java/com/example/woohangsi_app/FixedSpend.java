package com.example.woohangsi_app;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

public class FixedSpend extends Fragment implements View.OnClickListener{

    TextView txtCustomer, txtMonth;
    LinearLayout food, cafe, alchol, life, shopping, fashion, beauty, traffic, car, house, health, capital,
            culture, travel, educate, children, pet, present;

    Button btnSelect, btnSave;

    LinearLayout [] layoutarray;
    String [] categoryArray;
    boolean [] checkArray;


    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.spend_fixed, container, false);
        setHasOptionsMenu(true);

        txtCustomer = (TextView)view.findViewById(R.id.txtCustomer);
        txtMonth = (TextView)view.findViewById(R.id.txtMonth);

        food = (LinearLayout) view.findViewById(R.id.food);
        cafe = (LinearLayout) view.findViewById(R.id.cafe);
        alchol = (LinearLayout) view.findViewById(R.id.alchol);
        life = (LinearLayout) view.findViewById(R.id.life);
        shopping = (LinearLayout) view.findViewById(R.id.shopping);
        fashion = (LinearLayout) view.findViewById(R.id.fashion);
        beauty = (LinearLayout) view.findViewById(R.id.beauty);
        traffic = (LinearLayout) view.findViewById(R.id.traffic);
        car = (LinearLayout) view.findViewById(R.id.car);
        house = (LinearLayout) view.findViewById(R.id.house);
        health = (LinearLayout) view.findViewById(R.id.health);
        capital = (LinearLayout) view.findViewById(R.id.capital);
        culture = (LinearLayout) view.findViewById(R.id.culture);
        travel = (LinearLayout) view.findViewById(R.id.travel);
        educate = (LinearLayout) view.findViewById(R.id.educate);
        children = (LinearLayout) view.findViewById(R.id.children);
        pet = (LinearLayout) view.findViewById(R.id.pet);
        present = (LinearLayout) view.findViewById(R.id.present);

        btnSelect = (Button) view.findViewById(R.id.btnSelect);
        btnSave = (Button) view.findViewById(R.id.btnSave);

        layoutarray = new LinearLayout[] {food, cafe, alchol, life, shopping, fashion, beauty, traffic, car, house, health, capital, culture, travel, educate, children, pet, present};

        categoryArray = new String[] {"식비", "카페", "술/유흥", "생활", "온라인 쇼핑", "패션", "뷰티", "교통", "자동차", "주거/통신", "의료/건강", "금융",
                "문화/여가", "여행/숙박", "교육/학습", "자녀/육아", "반려동물", "경조/선물"};
        checkArray = new boolean[]{false, false, false, false, false, false, false, false, false, false,
                false, false, false, false, false, false, false, false};

        btnSelect.setOnClickListener(this);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnSelect:
                AlertDialog.Builder dlg = new AlertDialog.Builder(getActivity());
                dlg.setTitle("예산 설정을 원하는 카테고리를 선택");
                dlg.setIcon(R.drawable.logo);
                dlg.setMultiChoiceItems(categoryArray, checkArray, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which, boolean isChecked) {
                        if (checkArray[which] = isChecked) {
                            layoutarray[which].setVisibility(View.VISIBLE);
                        } else {
                            layoutarray[which].setVisibility(View.GONE);
                        }
                    }
                });
                dlg.setPositiveButton("완료", null);
                dlg.show();
                break;
        }
    }
}
