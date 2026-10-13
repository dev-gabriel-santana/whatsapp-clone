
package com.example.whatsappclone.lists

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Message
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.People
import androidx.compose.material.icons.filled.Update
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.vector.ImageVector

data class NavItem(
    val icon: ImageVector,
    val label: String,
) {
    val description: String
        get() = "Ícone da tela $label"
}


@Composable
fun BottomBarItems(): List<NavItem> {
    return remember {
        listOf(
            NavItem(
                icon = Icons.AutoMirrored.Filled.Message,
                label = "Chats"
            ),
            NavItem(
                icon = Icons.Default.Update,
                label = "Updates"
            ),
            NavItem(
                icon = Icons.Default.People,
                label = "Communities"
            ),
            NavItem(
                icon = Icons.Default.Call,
                label = "Calls"
            )
        )
    }
}

