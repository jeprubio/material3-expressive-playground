package com.rumosoft.material3expressive.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.FlexibleBottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

// https://m3.material.io/components/toolbars/overview

@Composable
fun FlexibleBottomAppBarScreen() {
    FlexibleBottomAppBarEx()
}

@OptIn(ExperimentalMaterial3ExpressiveApi::class, ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
private fun FlexibleBottomAppBarEx() {
    Scaffold(
        bottomBar = {
            FlexibleBottomAppBar(
                horizontalArrangement = Arrangement.SpaceEvenly,
                contentPadding = PaddingValues(horizontal = 0.dp),
                content = {
                    IconButton(onClick = { /* do nothing */ }) {
                        Icon(
                            Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back",
                        )
                    }

                    FilledIconButton(
                        modifier = Modifier.width(56.dp),
                        onClick = { /* do nothing */ }
                    ) {
                        Icon(
                            Icons.Filled.Add,
                            contentDescription = "Add",
                        )
                    }
                    IconButton(onClick = { /* do nothing */ }) {
                        Icon(
                            Icons.AutoMirrored.Filled.ArrowForward,
                            contentDescription = "Forward",
                        )
                    }

                }
            )
        },
        content = { innerPadding ->
            LazyColumn(Modifier.padding(innerPadding).padding(16.dp)) {
                val list = (0..50).map { it.toString() }
                items(count = list.size) {
                    Text(
                        text = list[it],
                    )
                }
            }
        }
    )
}
