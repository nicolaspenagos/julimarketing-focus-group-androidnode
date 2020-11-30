/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * @author Nicolás Penagos Montoya
 * nicolas.penagosm98@gmail.com
 **~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package com.example.julimarketing_focus_group_androidnode;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.julimarketing_focus_group_androidnode.model.Score;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    // -------------------------------------
    // Database
    // -------------------------------------
    private FirebaseDatabase database;

    // -------------------------------------
    // XML references
    // -------------------------------------
    private TextView questionTextView;
    private EditText scoreEditText;
    private Button okButton;

    // -------------------------------------
    // Android methods
    // -------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        questionTextView = findViewById(R.id.questionTextView);
        scoreEditText = findViewById(R.id.scoreEditText);
        okButton = findViewById(R.id.okButton);

        database = FirebaseDatabase.getInstance();
        loadDatabase();

        okButton.setEnabled(false);
        okButton.getBackground().setAlpha(128);

        okButton.setOnClickListener(
                (view)->{

                    String input = scoreEditText.getText().toString();
                    if(isInteger(input)){

                        int score = Integer.parseInt(input);
                        if(score>=1 && score<=10){

                            String id = UUID.randomUUID().toString();
                            DatabaseReference reference = database.getReference().child("currentQuestion/scores").child(id);

                            Score currentScore = new Score(
                                    UUID.randomUUID().toString(),
                                    score
                            );

                            reference.setValue(currentScore);
                            scoreEditText.setText("");

                            okButton.setEnabled(false);
                            okButton.getBackground().setAlpha(128);

                        }else{
                            Toast.makeText(this, "Please enter a number between 1 and 10", Toast.LENGTH_SHORT).show();
                        }

                    }else{
                        Toast.makeText(this, "Please enter a integer", Toast.LENGTH_SHORT).show();
                    }

                }
        );

    }

    // -------------------------------------
    // Methods
    // -------------------------------------
    public void loadDatabase(){

        DatabaseReference ref = database.getReference().child("currentQuestion/question");

        ref.addValueEventListener(

                new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot data) {

                        for(DataSnapshot child: data.getChildren()){

                            String question = child.getValue(String.class);

                            if(question.equals("NO_QUESTION")){

                                questionTextView.setText("");
                                okButton.setEnabled(false);
                                okButton.getBackground().setAlpha(128);

                            }else{

                                questionTextView.setText(question);
                                okButton.setEnabled(true);
                                okButton.getBackground().setAlpha(255);

                            }


                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                }

        );
    }

    public boolean isInteger( String input ) {

        try {
            Integer.parseInt( input );
            return true;
        }
        catch( Exception e ) {
            return false;
        }
        
    }

}