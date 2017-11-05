package com.example.android.justjava;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;


/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int quantity = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Context context = getApplicationContext();
        CharSequence text = "Hello toast!";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        //display(quantity);
        int price = calculatePrice();
        Log.i("MainJava","Price " + price);
        CheckBox checkBox = (CheckBox)findViewById(R.id.notify_me_checkbox);
        boolean hasWhippedCream = checkBox.isChecked();
        String summary = createOrderSummary(price,hasWhippedCream);
        displayMessage(summary);
    }

    private String createOrderSummary(int price,boolean hasWhippedCream){
        String result = "Name: Kaptain Kunal";
        result+="\nAdd whipped cream? " + hasWhippedCream;
        result+="\nQuantity: " + quantity;
        result+="\nTotal: $" +  price + "\nThank you!";
        return result;
    }

    /**
     * This method displays the given price on the screen.
     */
    private void displayMessage(String s) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(s);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    public void increment(View view){
        quantity++;
        displayQuantity(quantity);
    }

    public void decrement(View view){
        quantity--;
        displayQuantity(quantity);
    }

    private int calculatePrice() {
        int price = quantity * 5;
        return price;
    }
}
