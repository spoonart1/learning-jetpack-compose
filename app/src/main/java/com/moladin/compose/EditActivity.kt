package com.moladin.compose

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.moladin.compose.data.CarEntity
import com.moladin.compose.data.Database
import com.moladin.compose.ui.screen.EditScreen
import com.moladin.compose.ui.theme.MoladinJetpackComposeTheme

const val SAVE_CODE = 1000
class EditActivity : ComponentActivity() {

    @SuppressLint("UnusedMaterialScaffoldPaddingParameter", "MutableCollectionMutableState")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val carId = intent.getIntExtra("car_id", 0)
        setContent {
            MoladinJetpackComposeTheme {

                val carEntity = Database.Instance.getCarById(carId)
                var carName by remember { mutableStateOf(TextFieldValue("")) }

                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = {
                                Text(text = "CAR ID: $carId")
                            },
                            navigationIcon = {
                                IconButton(onClick = {
                                    finish()
                                }) {
                                    Icon(Icons.Filled.ArrowBack, "back-button")
                                }
                            }
                        )
                    }
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 16.dp, vertical = 24.dp)
                            .background(Color.White)
                    ) {
                        EditScreen(
                            placeholder = carEntity?.name.orEmpty(),
                            value = carName,
                            onValueChange = {
                                carName = it
                            })

                        Spacer(modifier = Modifier.height(24.dp))
                        Button(
                            modifier = Modifier.fillMaxWidth(),
                            onClick = {
                            update(carId, carName.text)
                            setResult(SAVE_CODE)
                            finish()
                        }) {
                            Text(text = "Save")
                        }
                    }
                }
            }
        }
    }

    private fun update(carId: Int, newCarName: String) {
        if (newCarName.isNotEmpty()) {
            Database.Instance.update(CarEntity(carId, newCarName))
        }
    }
}