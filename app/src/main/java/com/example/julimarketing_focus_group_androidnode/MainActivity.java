/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * @author Nicolás Penagos Montoya
 * nicolas.penagosm98@gmail.com
 **~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package com.example.julimarketing_focus_group_androidnode;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.FirebaseDatabase;

/*
 * This class controls the screen where the user enters their score for each question.
 */
public class MainActivity extends AppCompatActivity {

    // -------------------------------------
    // Database
    // -------------------------------------
    private FirebaseDatabase database;

    // -------------------------------------
    // XML references
    // -------------------------------------
    private TextView questionTextView;
    private TextView scoreTextView;
    private Button okButton;

    // -------------------------------------
    // Android methods
    // -------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}