
package com.example.whatsappclone.lists

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Message
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.People
import androidx.compose.material.icons.filled.Update
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.vector.ImageVector

sealed class NavItem(
    val icon: ImageVector,
    val label: String,
) {
    data object Chats:  NavItem(
        icon = Icons.AutoMirrored.Filled.Message,
        label = "Chats"
    )

    data object  Updates : NavItem(
        icon = Icons.Default.Update,
        label = "Updates"
    )

    data object  Communities : NavItem(
        icon = Icons.Default.People,
        label = "Communities"
    )

    data object Calls : NavItem(
        icon = Icons.Default.Call,
        label = "Calls"
    )
}


@Composable
fun bottomBarItems(): List<NavItem> {
    return remember {
        listOf(
            NavItem.Chats,
            NavItem.Updates,
            NavItem.Communities,
            NavItem.Calls
        )
    }
}

