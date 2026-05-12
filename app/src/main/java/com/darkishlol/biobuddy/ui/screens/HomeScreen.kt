package com.darkishlol.biobuddy.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Pets
import androidx.compose.material.icons.filled.Yard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.darkishlol.biobuddy.ui.components.BioCard


data class BioCardData(
    val name: String,
    val type: String, // "Pet" или "Plant"
    val icon: ImageVector,
    val hunger: Int,
    val happiness: Int,
    val moisture: Int = 50
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onCardClick: (String) -> Unit = {},
    onAddClick: () -> Unit = {}
) {

    val mockData = listOf(
        BioCardData("Барсик", "Pet", Icons.Filled.Pets, 80, 60),
        BioCardData("Фикус", "Plant", Icons.Filled.Yard, 50, 0),
        BioCardData("Рекс", "Pet", Icons.Filled.Pets, 30, 90),
        BioCardData("Кактус", "Plant", Icons.Filled.Yard, 20, 0)
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("BioBuddy") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = onAddClick,
                containerColor = MaterialTheme.colorScheme.primary
            ) {
                Icon(Icons.Default.Add, contentDescription = "Add new")
            }
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(mockData) { item ->
                BioCard(
                    name = item.name,
                    type = if (item.type == "Pet") "Питомец" else "Растение",
                    icon = item.icon,
                    hunger = item.hunger,
                    happiness = item.happiness,
                    moisture = item.moisture,
                    onClick = { onCardClick(item.name) }
                )
            }
        }
    }
}