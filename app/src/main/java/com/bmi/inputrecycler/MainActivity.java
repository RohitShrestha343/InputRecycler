package com.bmi.inputrecycler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.bmi.inputrecycler.Adapter.DetailsAdapter;
import com.bmi.inputrecycler.Model.Details;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RadioGroup radioGroup;
    private RecyclerView recyclerView;
    private EditText etName, etAge;
    private RadioButton radioButton;
    Spinner spinImage;
    private TextView tvGender;
    private Button btnSave;
    String gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        etName = findViewById(R.id.etName);
        etAge = findViewById(R.id.etAge);
        radioGroup = findViewById(R.id.rdoRadioGroup);
        tvGender = findViewById(R.id.txtGender);
        btnSave = findViewById(R.id.btnSave);
        spinImage = findViewById(R.id.spinImage);
        final List<Details> detailsList = new ArrayList<>();
        final int[] picture = {
                R.drawable.cat,
                R.drawable.cow,
                R.drawable.dog,
                R.drawable.lion,
                R.drawable.tiger
        };

        final String image[] = {"cat", "cow", "dog", "lion", "tiger"};

        ArrayAdapter arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, image);
        spinImage.setAdapter(arrayAdapter);


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = etName.getText().toString();
                String Age = etAge.getText().toString();
                int Gender = radioGroup.getCheckedRadioButtonId();
                RadioButton radioButton = findViewById(Gender);
                gender = radioButton.getText().toString();
                int image = (spinImage.getSelectedItemPosition());
                int imagePosition = picture[image];

                detailsList.add(new Details(name, Age, gender, imagePosition));

                DetailsAdapter detailsAdapter = new DetailsAdapter(MainActivity.this, detailsList);
                recyclerView.setAdapter(detailsAdapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                clear();
            }
        });

    }

    public void clear() {
        etName.setText("");
        etAge.setText("");
        radioGroup.clearCheck();
    }
}
