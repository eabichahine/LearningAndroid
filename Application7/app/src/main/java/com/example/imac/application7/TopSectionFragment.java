package com.example.imac.application7;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.app.Activity;
import android.widget.Button;
import android.widget.EditText;

public class TopSectionFragment extends Fragment
{
    private static EditText topTextInput;
    private static EditText bottomTextInput;

    TopSectionListener activityCommander;

    //This interface class was created so that we guarantee that the MainActivity has a method that
    //we can call and transfer the data to
    public interface TopSectionListener
    {
        public void createMeme(String top, String bottom);
    }

    //We are making sure that the activityCommander is linked to the MainActivity
    @Override
    public void onAttach(Context context)
    {
        super.onAttach(context);
        try
        {
            //setting the activityCommander equal to the MainActivity
            activityCommander = (TopSectionListener)context;
        }
        catch(ClassCastException e)
        {
            throw new ClassCastException(context.toString());
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.top_section_fragment, container, false);

        topTextInput = (EditText)view.findViewById(R.id.topTextInput);
        bottomTextInput = (EditText)view.findViewById(R.id.bottomTextInput);

        final Button button = (Button)view.findViewById(R.id.button);
        button.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View v)
                    {
                        buttonClicked(v);
                    }
                }
        );

        return view;
    }

    //Calls this when the button is clicked
    public void buttonClicked(View v)
    {
        //Call the MainActivity createMeme method in order to transfer the data
        activityCommander.createMeme(topTextInput.getText().toString(), bottomTextInput.getText().toString());
    }
}
