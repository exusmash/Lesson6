package ru.mirea.kokorevkv.employeedb;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppDatabase appDatabase = App.getInstance().getDatabase();
        EmployeeDao employeeDao = appDatabase.employeeDao();
        Employee employee = new Employee();
        employee.id = 2;
        employee.name = "John Smith";
        employee.salary = 100000;
        employeeDao.insert(employee);
        List<Employee> employees = employeeDao.getAll();
        employee = employeeDao.getById(1);
        employee.salary = 20000;
        employeeDao.update(employee);
        Log.d(TAG, employee.name + " " + employee.salary);
    }
}