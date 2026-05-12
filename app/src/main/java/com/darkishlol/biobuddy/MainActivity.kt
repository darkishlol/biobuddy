package com.darkishlol.biobuddy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.darkishlol.biobuddy.ui.screens.HomeScreen
import com.darkishlol.biobuddy.ui.theme.BioBuddyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BioBuddyTheme {
                HomeScreen() // 👈 ВОТ ЭТО ДОБАВЬ
            }
        }
    }
}