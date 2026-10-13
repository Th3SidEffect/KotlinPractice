package com.example.composepractice

import android.widget.Button
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.currentRecomposeScope

@Composable
fun Calculator(modifier: Modifier) {
    var display by remember { mutableStateOf("") }
    var firstNumber by remember { mutableStateOf(0.0) }
    var secondNumber by remember { mutableStateOf(0.0) }
    var operator by remember { mutableStateOf("") }

    fun Calculate(x: Double, y: Double): Any {
        val result = when (operator) {
            "+" -> x + y
            "-" -> x - y
            "x" -> x * y
            "÷" -> x / y
            else -> 0
        }
        return result
    }


    fun AddValueToNumber(x: Double) {
        if(operator == "") {
            firstNumber = (firstNumber * 10) + x
        }
        else {
            secondNumber = (secondNumber * 10) + x
        }
    }

    Column(modifier = Modifier.fillMaxSize()) {
        TextField(
            value = display,
            onValueChange = {}
        )

        Row(modifier = Modifier.fillMaxWidth()) {
            Button({
                display += "1"
                AddValueToNumber(1.0)
            }) {
                Text(text = "1")
            }
            Button({
                display += "2"
                AddValueToNumber(2.0)
            }) {
                Text(text = "2")
            }
            Button({
                display += "3"
                AddValueToNumber(3.0)
            }) {
                Text(text = "3")
            }
            Button({
                operator = "+"
                display += " + "
            }) {
                Text(text = "+")
            }
        }

        Row(modifier = Modifier.fillMaxWidth()) {
            Button({
                display += "4"
                AddValueToNumber(4.0)
            }) {
                Text(text = "4")
            }
            Button({
                display += "5"
                AddValueToNumber(5.0)
            }) {
                Text(text = "5")
            }
            Button({
                display += "6"
                AddValueToNumber(6.0)
            }) {
                Text(text = "6")
            }
            Button({
                operator = "-"
                display += "-"
            }) {
                Text(text = " - ")
            }
        }

        Row(modifier = Modifier.fillMaxWidth()) {
            Button({
                display += "7"
                AddValueToNumber(7.0)
            }) {
                Text(text = "7")
            }
            Button({
                display += 8
                AddValueToNumber(8.0)
            }) {
                Text(text = "8")
            }
            Button({
                display += 9
                AddValueToNumber(9.0)
            }) {
                Text(text = "9")
            }
            Button({
                operator = "x"
                display += "x"
            }) {
                Text(text = " x ")
            }
        }

        Row(modifier = Modifier.fillMaxWidth()) {
            Button({
                display += "0"
                AddValueToNumber(0.0)
            }) {
                Text(text = "0")
            }
            Button({
                display = ""
                firstNumber = 0.0
                secondNumber = 0.0
                operator = ""
            }) {
                Text(text = "C")
            }
            Button({
                display = Calculate(firstNumber, secondNumber).toString()
            }) {
                Text(text = "=")
            }
            Button({
                operator = "÷"
                display += " ÷ "
            }) {
                Text(text = " ÷ ")
            }
        }
    }


}