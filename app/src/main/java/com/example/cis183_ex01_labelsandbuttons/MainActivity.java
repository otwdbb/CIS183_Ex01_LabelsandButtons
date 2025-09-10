package com.example.cis183_ex01_labelsandbuttons;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity
{

    //creating all variables here
    //they will be global

    // you cannot assign references to any GUI element before onCreate()
    TextView tv_j_greeting;
    EditText et_j_name;
    Button btn_j_getName;

    TextView tv_j_errorMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);





        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //all code goes after setContentView()
        //make the connection between xml gui elements and java code

        tv_j_greeting = findViewById(R.id.tv_v_greeting);
        et_j_name = findViewById(R.id.et_v_name);
        btn_j_getName = findViewById(R.id.btn_v_getGreeting);
        tv_j_errorMessage = findViewById(R.id.tv_v_dataEntryError);

       // call listeners
        setOnClickListenerBegin();
    }
    //=============================================================
    //                      All listeners
    //=============================================================


    public void setOnClickListenerBegin()
    {
        //this is just setting up the listener
        btn_j_getName.setOnClickListener(new View.OnClickListener() {
            @Override

            //this what we do when the btn_j_getName button was pressed
            public void onClick(View v) {
                //Log.d("--DEBUG--", "Begin Button has been pressed");
                if(inputValidation())
                {
                    String message = createGreetingMessage();
                    setGreetingMessage(message);
                   //arNameTextbox();
                    //did the right thing
                    tv_j_errorMessage.setVisibility(TextView.INVISIBLE);
                    btn_j_getName.setClickable(false);
                }
                else
                {
                    //user did not input valid name
                    tv_j_errorMessage.setVisibility(TextView.VISIBLE);
                    //inputValidation();


                }


                clearNameTextbox();
            }
        });


    }


    public String createGreetingMessage()
    {
        String message = "Welcome ";
        String name = et_j_name.getText().toString();


        message += name;


        return message;
    }
    public void setGreetingMessage(String message)
    {

        //set the greeting message to whatever the user enters
        tv_j_greeting.setText(message);
        tv_j_greeting.setVisibility(TextView.VISIBLE);
    }


    public void clearNameTextbox()
    {
        et_j_name.setText("");


    }
    //clear text box after use
    //good job
    public boolean inputValidation()
    {
        boolean validUserInput = true;

        String name = et_j_name.getText().toString();

        if(name.isEmpty())
        {
            Log.d("Error:", "No name entered");
            return false;
        }
        else if(containsNoAlphaNumberic(name))
        {
            Log.d("Error:", "Names should not contain no alpha text");
            return false;
        }
        else
        {
            return true;
        }










    }



    public boolean containsNoAlphaNumberic(String name)
    {
        String specials = "`~!@#$%^&*()_+=-[]{}|;:.><,?/";
                for(int i = 0; i < name.length(); i++)
                {
                    for(int j = 0 ; j < specials.length(); j++)
                    {

                        if(name.charAt(i) == specials.charAt(j))
                        {
                            return true;
                        }
                    }
                }

                return false;


    }






    //only show message if name was entered
    //




        //name was entered
    // only one greeting per run




}