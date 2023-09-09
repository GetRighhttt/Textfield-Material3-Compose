package com.example.textfieldsjetpackcomposemat3

import android.graphics.drawable.Icon
import android.icu.text.NumberFormat
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.CreditCard
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Money
import androidx.compose.material.icons.outlined.MonitorWeight
import androidx.compose.material.icons.outlined.Person2
import androidx.compose.material.icons.outlined.Scale
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.textfieldsjetpackcomposemat3.ui.theme.TextfieldsJetpackComposeMat3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TextfieldsJetpackComposeMat3Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        // fields to be used as text
                        var nameFieldText by remember {
                            mutableStateOf("")
                        }
                        var moneyFieldText by remember {
                            mutableStateOf("")
                        }
                        var weightFieldText by remember {
                            mutableStateOf("")
                        }
                        var outlinedFieldText by remember {
                            mutableStateOf("")
                        }

                        // using labels, leading icons, supporting text
                        TextField(
                            value = nameFieldText,
                            onValueChange = { nameFieldText = it },
                            textStyle = LocalTextStyle.current.copy(
                                textAlign = TextAlign.Start
                            ),
                            label = {
                                Text(text = "Enter your name")
                            },
                            leadingIcon = {
                                androidx.compose.material3.Icon(
                                    imageVector = Icons.Outlined.Person2,
                                    contentDescription = "Add Name"
                                )
                            },
                            supportingText = {
                                Text(text = "*required")
                            },
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Text,
                                imeAction = ImeAction.Next
                            ),
                            singleLine = true,
                            minLines = 1,
                            maxLines = 1
                        )

                        Spacer(modifier = Modifier.height(10.dp))

                        // using placeholder, prefix, and trailing icon
                        TextField(
                            value = moneyFieldText,
                            onValueChange = { moneyFieldText = it },
                            textStyle = LocalTextStyle.current.copy(
                                textAlign = TextAlign.Start
                            ),
                            placeholder = {
                                Text(text = "Amount")
                            },
                            leadingIcon = {
                                androidx.compose.material3.Icon(
                                    imageVector = Icons.Outlined.Money,
                                    contentDescription = "Money"
                                )
                            },
                            prefix = {
                                Text(text = "$")
                            },
                            supportingText = {
                                Text(text = "*required")
                            },
                            trailingIcon = {
                                androidx.compose.material3.Icon(
                                    imageVector = Icons.Outlined.CreditCard,
                                    contentDescription = "Money"
                                )
                            },
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Decimal,
                                imeAction = ImeAction.Next
                            ),
                            singleLine = true
                        )

                        Spacer(modifier = Modifier.height(10.dp))

                        // using suffix, and isError
                        OutlinedTextField(
                            value = weightFieldText,
                            onValueChange = { weightFieldText = it },
                            textStyle = LocalTextStyle.current.copy(
                                textAlign = TextAlign.Start
                            ),
                            placeholder = {
                                Text(text = "Weight")
                            },
                            leadingIcon = {
                                androidx.compose.material3.Icon(
                                    imageVector = Icons.Outlined.Scale,
                                    contentDescription = "Weight"
                                )
                            },
                            suffix = {
                                Text(text = "lbs")
                            },
                            supportingText = {
                                Text(text = "Please enter in pounds")
                            },
                            isError = weightFieldText < 0.toString(),
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Decimal,
                                imeAction = ImeAction.Next
                            ),
                            singleLine = true
                        )

                        Spacer(
                            modifier = Modifier.height(10.dp)
                        )

                        // Keyboard Actions, visual transformations also used here
                        OutlinedTextField(
                            value = outlinedFieldText,
                            onValueChange = { outlinedFieldText = it },
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Password,
                                imeAction = ImeAction.Done
                            ),
                            keyboardActions = KeyboardActions(
                                onDone = {
                                    Toast.makeText(
                                        applicationContext,
                                        "Finished",
                                        Toast.LENGTH_LONG
                                    ).show()
                                }
                            ),
                            visualTransformation = PasswordVisualTransformation(),
                            label = {
                                Text(text = "Enter Password")
                            },
                            supportingText = {
                                Text(text = "Please use one uppercase, lowercase, symbol, number")
                            },
                            leadingIcon = {
                                androidx.compose.material3.Icon(
                                    imageVector = Icons.Outlined.Lock,
                                    contentDescription = "Password"
                                )
                            },
                            isError = outlinedFieldText.isEmpty(),
                            singleLine = true
                        )

                        Spacer(modifier = Modifier.height(50.dp))

                        Button(
                            onClick = {
                                Toast.makeText(
                                    applicationContext,
                                    "Confirmed",
                                    Toast.LENGTH_LONG
                                ).show()
                            },
                            modifier = Modifier
                                .align(Alignment.End)
                                .padding(end = 70.dp)
                        ) {
                            Text(text = "Confirm")
                        }
                    }
                }
            }
        }
    }
}