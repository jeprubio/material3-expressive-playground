package com.rumosoft.material3expressive.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    onLoadingIndicatorSelected: () -> Unit = {},
    onSplitButtonSelected: () -> Unit = {},
    onFloatingActionButtonSelected: () -> Unit = {},
    onButtonGroupButtonSelected: () -> Unit = {},
) {
    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = modifier
            .fillMaxSize()
    ) {
        item {
            Button(onClick = { onLoadingIndicatorSelected() }) {
                Text(text = "LoadingIndicator")
            }
        }
        item {
            Button(onClick = { onSplitButtonSelected() }) {
                Text(text = "SplitButton")
            }
        }
        item {
            Button(onClick = { onFloatingActionButtonSelected() }) {
                Text(text = "FloatingActionButton")
            }
        }
        item {
            Button(onClick = { onButtonGroupButtonSelected() }) {
                Text(text = "ButtonGroup")
            }
        }
    }
}
