package com.katza.hadertips222;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btnInsert, btnSelect, btnUpdate, btnDelete, btnSelectAll;
    EditText etId, etName, etGrade;
    TextView tvcontent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        FirestoreDAO fsDAO = new FirestoreDAO();
        etGrade = findViewById(R.id.grade);
        etName = findViewById(R.id.fullname);
        etId = findViewById(R.id.tz);
        btnInsert = findViewById(R.id.btnInsert);
        btnSelect = findViewById(R.id.btnSelect);
        tvcontent = findViewById(R.id.tvcontent);
        btnSelectAll = findViewById(R.id.btnSelectAll);



        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fsDAO.createDocument(etName.getText().toString(),
                        etId.getText().toString(),
                        Integer.parseInt(etGrade.getText().toString()));
            }
        });

        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fsDAO.readDocumentById(etId.getText().toString(), new FirestoreCallback() {
                    @Override
                    public void onDataReceived(ArrayList<Student> students) {
                        tvcontent.setText(students.get(0).toString());
                    }
                });
            }
        });

        btnSelectAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvcontent.setText("");
                fsDAO.readAllDocuments(new FirestoreCallback() {
                    @Override
                    public void onDataReceived(ArrayList<Student> students) {
                        for (int i = 0; i < students.size(); i++)
                            tvcontent.setText(tvcontent.getText().toString() + students.get(i).toString());
                    }
                });
            }
        });


    }
}