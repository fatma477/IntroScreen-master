package com.labawsrh.aws.introscreen;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import android.widget.Toast;


public class ContactActivity extends AppCompatActivity {
    EditText mRecipientET,mSubjectET,mMessageET;
    Button mSendEmailBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        mRecipientET=findViewById(R.id.recipientET);
        mSubjectET=findViewById(R.id.subjectET);
        mMessageET=findViewById(R.id.messageET);
        mSendEmailBtn=findViewById(R.id.sendEmailBtn);
        mSendEmailBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String recipient=mRecipientET.getText().toString().trim();//trim tfasa5 les espace
                String subject=mSubjectET.getText().toString().trim();
                String message=mMessageET.getText().toString().trim();

                //methode call eli bch ne5dmo m3a input comme parametre
                sendEmail(recipient,subject,message);

            }
        });

    }

    private void sendEmail(String recipient, String subject, String message) {
            Intent mEmailIntent = new Intent(Intent.ACTION_SEND);
            mEmailIntent.setData(Uri.parse("mailto :"));
            mEmailIntent.setType("text/plain");
            mEmailIntent.putExtra(Intent.EXTRA_EMAIL,new String[] {recipient});
            mEmailIntent.putExtra(Intent.EXTRA_SUBJECT,subject);
            mEmailIntent.putExtra(Intent.EXTRA_TEXT,message);
            try {
                startActivity(Intent.createChooser(mEmailIntent,"choose an Email Client"));
            } catch (Exception e) {
                Toast.makeText(this,e.getMessage(),Toast.LENGTH_SHORT).show();
            }


    }
    public void ReturnOn(View view) {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }
    }


