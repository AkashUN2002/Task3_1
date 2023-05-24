package com.example.task3_1

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(modifier=Modifier.fillMaxSize().background(Color.LightGray), horizontalAlignment = Alignment.CenterHorizontally) {


                var ps = remember{
                    mutableStateOf(String())
                }



                var db=remember{
                    mutableStateOf(false)
                }

                var db2=remember{
                    mutableStateOf(false)
                }

                Text(text = "The Button clicked is "+ps.value, Modifier.padding(30.dp))

                Button(onClick = { ps.value="ONE"
                    db.value=true

                                 }, colors=ButtonDefaults.buttonColors(Color.Black), modifier=Modifier.padding(30.dp)) {
                    Text(text = "ONE", color = Color.White)
                }
                if(db.value)
                {
                    AlertDialog(
                        onDismissRequest = { },
                        confirmButton = {
                            TextButton(onClick = { Toast.makeText(applicationContext,"1 was clicked", Toast.LENGTH_LONG).show()
                                db.value=false})
                            { Text(text = "1") }
                        },title = { Text(text = "Please confirm") }
                    )
                }

                Button(onClick = { ps.value="TWO"
                    db2.value=true},colors=ButtonDefaults.buttonColors(Color.Black), modifier=Modifier.padding(30.dp)) {
                    Text(text = "TWO")

                }
                if(db2.value)
                {
                    AlertDialog(
                        onDismissRequest = { },
                        confirmButton = {
                            TextButton(onClick = { Toast.makeText(applicationContext,"1 was clicked", Toast.LENGTH_LONG).show()
                                db2.value=false})
                            { Text(text = "1") }
                        }
                        , dismissButton = {
                                          TextButton(onClick={Toast.makeText(applicationContext,"2 was clicked", Toast.LENGTH_LONG).show()
                                          db2.value=false}){
                                              Text("2")
                                          }
                        }
                        ,title = { Text(text = "Please Choose") }
                    )
                }

            }
        }
    }
}


