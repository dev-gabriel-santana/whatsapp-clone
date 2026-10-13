package com.example.whatsappclone.lists

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Message
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.People
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Update
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.vector.ImageVector

open class IBottomAppBarItem(
    val icon: ImageVector,
    val label: String,
)

class ITopAppBarItem(
    val title: String, val icons: List<ImageVector> = emptyList()
)

sealed class ScreenItem(
    val topAppItem: ITopAppBarItem, val bottomAppItem: IBottomAppBarItem
) {
    data object Chats : ScreenItem(

        topAppItem = ITopAppBarItem(
            title = "WhatsApp Clone", icons = listOf(
                Icons.Default.CameraAlt,
                Icons.Default.Search,
                Icons.Default.MoreVert,
            )
        ),
        bottomAppItem = IBottomAppBarItem(
            icon = Icons.AutoMirrored.Filled.Message, label = "Chats"
        ),

        )

    data object Updates : ScreenItem(

        topAppItem = ITopAppBarItem(
            title = "Updates", icons = listOf(
                Icons.Default.CameraAlt,
                Icons.Default.MoreVert,
            )
        ),
        bottomAppItem = IBottomAppBarItem(
            icon = Icons.Default.Update, label = "Updates"
        ),


        )

    data object Communities : ScreenItem(

        topAppItem = ITopAppBarItem(
            title = "Communities", icons = listOf(
                Icons.Default.CameraAlt,
                Icons.Default.Search,
                Icons.Default.MoreVert,
            )
        ),
        bottomAppItem = IBottomAppBarItem(
            icon = Icons.Default.People, label = "Communities"
        ),


        )

    data object Calls : ScreenItem(

        topAppItem = ITopAppBarItem(
            title = "Calls", icons = listOf(
                Icons.Default.CameraAlt,
                Icons.Default.MoreVert,
            )
        ),
        bottomAppItem = IBottomAppBarItem(
            icon = Icons.Default.Call, label = "Calls"
        ),


        )
}


@Composable
fun bottomBarItems(): List<ScreenItem> {
    return remember {
        listOf(
            ScreenItem.Chats, ScreenItem.Updates, ScreenItem.Communities, ScreenItem.Calls
        )
    }
}

