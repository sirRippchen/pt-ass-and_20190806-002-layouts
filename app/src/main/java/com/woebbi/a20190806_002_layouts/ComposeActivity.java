package com.woebbi.a20190806_002_layouts;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Date;

public class ComposeActivity extends AppCompatActivity {
    private EditText cAFromInput, cAToInput, cASubjectInput, cATextContentInput;
    private Toolbar cAToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compose);
        cAFromInput = findViewById(R.id.composeActivityFromInput);
        cAToInput = findViewById(R.id.composeActivityToInput);
        cASubjectInput = findViewById(R.id.composeActivitySubjectInput);
        cATextContentInput = findViewById(R.id.composeActivityTextContentInput);
        cAToolbar =  findViewById(R.id.composeActivityToolbar);
        //Setzt toolbar
        setSupportActionBar(cAToolbar);


        SharedPreferences sp = getSharedPreferences("com.woebbi.a20190806_002_layouts", Context.MODE_PRIVATE);
        String username = sp.getString("user", "");
        cAFromInput.setText(username);
        cAFromInput.setEnabled(false);


    }
    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_compose, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //Switch will be filled with other cases Later TODO
        switch (item.getItemId()) {
            case R.id.menuComposeSend:
                //Toast.makeText(this, "ABC", Toast.LENGTH_LONG).show();
                String cAFrom = cAFromInput.getText().toString();
                String cATo = cAToInput.getText().toString();
                String cASubject = cASubjectInput.getText().toString();
                String cATextContent = cATextContentInput.getText().toString();

                if (cAFrom.length() > 0 && cATo.length() > 0 && cASubject.length() > 0 && cASubject != getText(R.string.composeActivitySubject) && cATextContent.length() > 0){
                    Toast.makeText(this, "rein", Toast.LENGTH_LONG).show();
                    Date dateNow = new Date();
                    Email theMail = new Email(cATo,cAFrom,cASubject,cATextContent,dateNow,null);
                    sendMail(theMail);
                }else{
                    Toast.makeText(this, "rausch", Toast.LENGTH_LONG).show();
                    if(cATo.length() == 0){
                        cAToInput.setText(R.string.composeActivityNeededTo);
                    }
                    if(cASubject.length() == 0 || cASubject != getText(R.string.composeActivitySubject)){
                        cASubjectInput.setText(R.string.composeActivityNeededSubject);
                    }
                    if(cATextContent.length() == 0){
                        cATextContentInput.setText(R.string.composeActivityNeededTextContent);
                    }
                }
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    private void sendMail(Email mail){
        //TODO, read Values und use them to to send a actual mail
        //EmailProvider

    }
}
