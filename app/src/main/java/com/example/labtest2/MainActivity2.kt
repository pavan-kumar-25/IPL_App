package com.example.labtest2

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.MaterialAutoCompleteTextView
import com.google.android.material.textview.MaterialTextView
import java.util.*

class MainActivity2 : AppCompatActivity() {
    private var selectedAge: Int = 0
    private val calendar = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnSubmit = findViewById<MaterialButton>(R.id.btn_submit)
        val btnSelectAge = findViewById<MaterialButton>(R.id.btn_select_age)
        val tvSelectedAge = findViewById<MaterialTextView>(R.id.selected_age)
        val spinnerTeam = findViewById<MaterialAutoCompleteTextView>(R.id.spinner_team)

        val teams = resources.getStringArray(R.array.ipl_teams)
        val adapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, teams)
        spinnerTeam.setAdapter(adapter)


        btnSelectAge.setOnClickListener {
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(
                this,
                { _, selectedYear, selectedMonth, selectedDayOfMonth ->
                    val dobCalendar = Calendar.getInstance()
                    dobCalendar.set(selectedYear, selectedMonth, selectedDayOfMonth)

                    // Calculate age based on the current date
                    val currentDate = Calendar.getInstance()
                    var age = currentDate.get(Calendar.YEAR) - dobCalendar.get(Calendar.YEAR)

                    // Check if birthday has occurred this year
                    if (currentDate.get(Calendar.DAY_OF_YEAR) < dobCalendar.get(Calendar.DAY_OF_YEAR)) {
                        age--
                    }
                    selectedAge = age

                    // Update TextView with selected age
                    tvSelectedAge.text = "Age: $selectedAge" // Set the age beside the button
                },
                year,
                month,
                day
            )

            datePickerDialog.show()
        }

        btnSubmit.setOnClickListener {
            val isAnyFieldEmpty = spinnerTeam.text.isNullOrEmpty() || tvSelectedAge.text.isNullOrEmpty()

            if (isAnyFieldEmpty) {
                Snackbar.make(it, "Please fill all fields", Snackbar.LENGTH_SHORT).show()
            } else {
                // All fields are filled, navigate to the next activity
                startActivity(Intent(this@MainActivity2, MainActivity3::class.java))
            }
        }

    }
}



