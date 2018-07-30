package sg.edu.rp.c346.practicalquiz;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnSubmit;
    EditText etAcc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSubmit = findViewById(R.id.button);
        etAcc = findViewById(R.id.editText);


        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);

                String acc = etAcc.getText().toString();


                myBuilder.setTitle("Account Submission");
                myBuilder.setMessage("Submit " + acc);

                myBuilder.setCancelable(false);
                myBuilder.setNegativeButton("cancel", null);

                myBuilder.setPositiveButton("confirm", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String acc = etAcc.getText().toString();
                        Context context = getApplicationContext();
                        int duration = Toast.LENGTH_LONG;
                        CharSequence text = acc + " submitted";

                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                    }
                });

                AlertDialog myDialog = myBuilder.create();
                myDialog.show();


            }
        });
    }
}
