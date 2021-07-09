package com.example.haftab;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;

public class player1 extends Fragment {

    NumberPicker smallCards, highCards, valueCards, jokerCards, redBooks, blackBooks,
            smallHand, highHand, valueHand, jokerHand, redThree, blackThree;

    Button submit;
    EditText roundOne, roundTwo, roundThree, finalRound;
    View parentHolder;
    Activity referenceAct;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        referenceAct = getActivity();
        parentHolder = inflater.inflate(R.layout.fragment_player1, container, false);

        submit = parentHolder.findViewById(R.id.submitButton);
        roundOne = parentHolder.findViewById(R.id.roundOne);
        roundTwo = parentHolder.findViewById(R.id.roundTwo);
        roundThree = parentHolder.findViewById(R.id.roundThree);
        finalRound = parentHolder.findViewById(R.id.finalRound);

        // On board variables
        smallCards = parentHolder.findViewById(R.id.smallCards);
        highCards = parentHolder.findViewById(R.id.highCards);
        valueCards = parentHolder.findViewById(R.id.valueCards);
        jokerCards = parentHolder.findViewById(R.id.jokerCards);
        redBooks = parentHolder.findViewById(R.id.redBooks);
        blackBooks = parentHolder.findViewById(R.id.blackBooks);

        smallCards.setMinValue(0);
        smallCards.setMaxValue(72);
        highCards.setMinValue(0);
        highCards.setMaxValue(48);
        valueCards.setMinValue(0);
        valueCards.setMaxValue(24);
        jokerCards.setMinValue(0);
        jokerCards.setMaxValue(6);
        redBooks.setMinValue(0);
        redBooks.setMaxValue(11);
        blackBooks.setMinValue(0);
        blackBooks.setMaxValue(11);

        // In Hand & Foot variables
        smallHand = parentHolder.findViewById(R.id.smallHand);
        highHand = parentHolder.findViewById(R.id.highHand);
        valueHand = parentHolder.findViewById(R.id.valueHand);
        jokerHand = parentHolder.findViewById(R.id.jokerHand);
        redThree = parentHolder.findViewById(R.id.redThree);
        blackThree = parentHolder.findViewById(R.id.blackThree);

        smallHand.setMinValue(0);
        smallHand.setMaxValue(72);
        highHand.setMinValue(0);
        highHand.setMaxValue(48);
        valueHand.setMinValue(0);
        valueHand.setMaxValue(24);
        jokerHand.setMinValue(0);
        jokerHand.setMaxValue(6);
        redThree.setMinValue(0);
        redThree.setMaxValue(12);
        blackThree.setMinValue(0);
        blackThree.setMaxValue(12);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Reset = submit.getText().toString();

                if(Reset == "Reset")
                {
                    roundOne.setText("");
                    roundTwo.setText("");
                    roundThree.setText("");
                    finalRound.setText("");
                    submit.setText("Submit");
                }
                else
                {
                    int onBoard = (smallCards.getValue() * 5) + (highCards.getValue() * 10)
                            + (valueCards.getValue() * 20) + (jokerCards.getValue() * 50)
                            + (redBooks.getValue() * 500) + (blackBooks.getValue() * 300);

                    int inHand = (smallHand.getValue() * 5) + (highHand.getValue() * 10)
                            + (valueHand.getValue() * 20) + (jokerHand.getValue() * 50)
                            + (redThree.getValue() * 500) + (blackThree.getValue() * 300);

                    int sum = onBoard - inHand;

                    String R1 = roundOne.getText().toString();
                    String R2 = roundTwo.getText().toString();
                    String R3 = roundThree.getText().toString();
                    //String R4 = finalRound.getText().toString();

                    if(R1.matches(""))
                    {
                        if(sum < 0) roundOne.setTextColor(Color.RED);
                        else if(sum > 0) roundOne.setTextColor(Color.GREEN);
                        else roundOne.setTextColor(Color.GRAY);

                        roundOne.setText(String.valueOf(sum));
                    }
                    else if(R2.matches(""))
                    {
                        sum += Integer.parseInt(roundOne.getText().toString());

                        if(sum < 0) roundTwo.setTextColor(Color.RED);
                        else if(sum > 0) roundTwo.setTextColor(Color.GREEN);
                        else roundTwo.setTextColor(Color.GRAY);

                        roundTwo.setText(String.valueOf(sum));
                    }
                    else if(R3.matches(""))
                    {
                        sum += Integer.parseInt(roundTwo.getText().toString());

                        if(sum < 0) roundThree.setTextColor(Color.RED);
                        else if(sum > 0) roundThree.setTextColor(Color.GREEN);
                        else roundThree.setTextColor(Color.GRAY);

                        roundThree.setText(String.valueOf(sum));
                    }
                    else
                    {
                        sum += Integer.parseInt(roundThree.getText().toString());

                        if(sum < 0) finalRound.setTextColor(Color.RED);
                        else if(sum > 0) finalRound.setTextColor(Color.GREEN);
                        else finalRound.setTextColor(Color.GRAY);

                        finalRound.setText(String.valueOf(sum));
                        submit.setText("Reset");
                    }
                }

                smallCards.setValue(0);
                highCards.setValue(0);
                valueCards.setValue(0);
                jokerCards.setValue(0);
                redBooks.setValue(0);
                blackBooks.setValue(0);

                smallHand.setValue(0);
                highHand.setValue(0);
                valueHand.setValue(0);
                jokerHand.setValue(0);
                redThree.setValue(0);
                blackThree.setValue(0);
            }
        });

        // Inflate the layout for this fragment
        return parentHolder;
    }
}