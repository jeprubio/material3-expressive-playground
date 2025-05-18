package com.rumosoft.material3expressive.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.FloatingToolbarDefaults
import androidx.compose.material3.HorizontalFloatingToolbar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp

@Composable
fun HorizontalFloatingToolbarScreen() {
    HorizontalFloatingToolbarWithFab()
}

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Preview
@Composable
private fun HorizontalFloatingToolbarWithFab() {
    val expanded by rememberSaveable { mutableStateOf(true) }
    val vibrantColors = FloatingToolbarDefaults.vibrantFloatingToolbarColors()
    Scaffold { innerPadding ->
        Box(
            Modifier
                .fillMaxSize()
                .padding(innerPadding).padding(16.dp)
        ) {
            Column(
                Modifier.verticalScroll(rememberScrollState())
            ) {
                Text(text = remember { LoremIpsum().values.first().take(800) })
            }

            HorizontalFloatingToolbar(
                expanded = expanded,
                floatingActionButton = {
                    FloatingToolbarDefaults.VibrantFloatingActionButton(
                        onClick = { /* do nothing */ },
                    ) {
                        Icon(Icons.Filled.Add, contentDescription = "")
                    }
                },
                modifier =
                    Modifier.align(Alignment.BottomEnd),
                colors = vibrantColors,
                content = {
                    IconButton(onClick = { /* do nothing */ }) {
                        Icon(Icons.Filled.Person, contentDescription = "")
                    }
                    IconButton(onClick = { /* do nothing */ }) {
                        Icon(Icons.Filled.Edit, contentDescription = "")
                    }
                },
            )
        }
    }
}
