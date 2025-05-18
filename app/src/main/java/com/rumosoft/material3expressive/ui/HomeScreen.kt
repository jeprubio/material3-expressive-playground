package com.rumosoft.material3expressive.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    onLoadingIndicatorSelected: () -> Unit = {},
    onSplitButtonSelected: () -> Unit = {},
    onFloatingActionButtonSelected: () -> Unit = {},
    onButtonGroupSelected: () -> Unit = {},
    onVerticalFloatingToolbarSelected: () -> Unit = {},
    onHorizontalFloatingToolbarSelected: () -> Unit = {},
    onFlexibleBottomAppBarSelected: () -> Unit = {},
) {
    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = modifier
            .fillMaxSize()
    ) {
        item {
            OptionButton(
                text = "LoadingIndicator",
                onClick = onLoadingIndicatorSelected,
            )
        }
        item {
            OptionButton(
                text = "SplitButton",
                onClick = onSplitButtonSelected,
            )
        }
        item {
            OptionButton(
                text = "FloatingActionButton",
                onClick = onFloatingActionButtonSelected,
            )
        }
        item {
            OptionButton(
                text = "ButtonGroup",
                onClick = onButtonGroupSelected,
            )
        }
        item {
            ToolbarSelectionSection(
                onVerticalFloatingToolbarSelected,
                onHorizontalFloatingToolbarSelected,
            )
        }
        item {
            OptionButton(
                text = "FlexibleBottomAppBar",
                onClick = onFlexibleBottomAppBarSelected,
            )
        }
    }
}

@Composable
private fun ToolbarSelectionSection(
    onVerticalFloatingToolbarSelected: () -> Unit = {},
    onHorizontalFloatingToolbarSelected: () -> Unit = {},
) {
    var isExpanded by rememberSaveable { mutableStateOf(false) }

    Column(modifier = Modifier.padding(vertical = 8.dp)) {
        ToolbarSectionHeader(
            isExpanded = isExpanded,
            onToggle = { isExpanded = !isExpanded }
        )

        AnimatedVisibility(
            visible = isExpanded,
            enter = fadeIn() + expandVertically(),
            exit = fadeOut() + shrinkVertically()
        ) {
            ToolbarOptionsList(onVerticalFloatingToolbarSelected, onHorizontalFloatingToolbarSelected)
        }
    }
}

@Composable
private fun ToolbarSectionHeader(
    isExpanded: Boolean,
    onToggle: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clickable(onClick = onToggle)
            .padding(vertical = 12.dp, horizontal = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
    ) {
        Text(
            text = "Toolbars",
            style = MaterialTheme.typography.titleMedium,
        )

        Icon(
            imageVector = if (isExpanded) Icons.Default.ExpandLess else Icons.Default.ExpandMore,
            contentDescription = if (isExpanded) "Collapse" else "Expand",
            tint = MaterialTheme.colorScheme.onSurface,
        )
    }
}

@Composable
private fun ToolbarOptionsList(
    onVerticalFloatingToolbarSelected: () -> Unit = {},
    onHorizontalFloatingToolbarSelected: () -> Unit = {},
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.1f))
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        OptionButton(
            text = "Vertical Floating Toolbar",
            onClick = onVerticalFloatingToolbarSelected,
        )

        OptionButton(
            text = "Horizontal Floating Toolbar",
            onClick = onHorizontalFloatingToolbarSelected
        )
    }
}

@Composable
private fun OptionButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier,
    ) {
        Text(text = text)
    }
}
