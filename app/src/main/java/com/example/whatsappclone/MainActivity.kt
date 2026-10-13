package com.example.whatsappclone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Message
import androidx.compose.material.icons.filled.Camera
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.whatsappclone.ui.theme.WhatsAppCloneTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.example.whatsappclone.lists.NavItem
import com.example.whatsappclone.lists.bottomBarItems

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WhatsAppCloneTheme {
                App()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App() {
    // states
    val bottomBarItems = bottomBarItems()
    var selectedItem by remember { mutableStateOf(bottomBarItems.first())}
    val pageState = rememberPagerState() {bottomBarItems.size}

    LaunchedEffect(selectedItem) {
        pageState.animateScrollToPage(bottomBarItems.indexOf(selectedItem))
    }

    LaunchedEffect(pageState.targetPage) {
        selectedItem = bottomBarItems[pageState.targetPage]
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {TopBar()},
        bottomBar = {
            BottomAppBar() {
                bottomBarItems.forEach { it ->
                    NavigationBarItem(
                    selected = selectedItem == it,
                    onClick = {
                        selectedItem = it
                    },
                    icon = {Icon(it.icon, contentDescription = null)},
                    label = {
                        Text(it.label)
                    }
                ) }
            }
        }
    ) { innerPadding ->
        HorizontalPager(
            pageState,
            Modifier.padding(innerPadding)
        ) { page ->
            val item = bottomBarItems[page]
            when(item) {
                NavItem.Calls -> CallsScreen()
                NavItem.Chats -> ChatsListScreen()
                NavItem.Communities -> CommunitiesScreen()
                NavItem.Updates -> UpdatesScreen()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar() {
    TopAppBar(
        title = {
            Text("WhatsApp Clone")
        },
        actions = {
            Row(
                Modifier.padding(8.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Icon(
                    Icons.Default.CameraAlt,
                    contentDescription = "Icon de camera"
                )
                Icon(
                    Icons.Default.MoreVert,
                    contentDescription = "Icon de 3 pontos"
                )
            }
        },
    )
}


@Composable
fun ChatsListScreen(modifier: Modifier = Modifier) {
    Box(modifier.fillMaxSize()){
        Text("Chats List", Modifier.align(Alignment.Center), style = TextStyle.Default.copy(
            fontSize = 32.sp
        ))
    }
}

@Composable
fun UpdatesScreen(modifier: Modifier = Modifier) {
    Box(modifier.fillMaxSize()){
        Text("UpdatesScreen", Modifier.align(Alignment.Center), style = TextStyle.Default.copy(
            fontSize = 32.sp
        ))
    }
}

@Composable
fun CommunitiesScreen(modifier: Modifier = Modifier) {
    Box(modifier.fillMaxSize()){
        Text("CommunitiesScreen", Modifier.align(Alignment.Center), style = TextStyle.Default.copy(
            fontSize = 32.sp
        ))
    }
}

@Composable
fun CallsScreen(modifier: Modifier = Modifier) {
    Box(modifier.fillMaxSize()){
        Text("CallsScreen", Modifier.align(Alignment.Center), style = TextStyle.Default.copy(
            fontSize = 32.sp
        ))
    }
}

@Preview
@Composable
private fun AppPreview() {
    WhatsAppCloneTheme {
        App()
    }
}