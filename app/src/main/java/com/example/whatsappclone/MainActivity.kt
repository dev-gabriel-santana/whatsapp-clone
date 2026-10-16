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
import com.example.whatsappclone.chatsList.ChatsListScreen
import com.example.whatsappclone.lists.ITopAppBarItem
import com.example.whatsappclone.lists.ScreenItem
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
    val screens = bottomBarItems()
    var currentScreen by remember { mutableStateOf(screens.first()) }
    val pageState = rememberPagerState() { screens.size }

    LaunchedEffect(currentScreen) {
        pageState.animateScrollToPage(screens.indexOf(currentScreen))
    }

    LaunchedEffect(pageState.targetPage) {
        currentScreen = screens[pageState.targetPage]
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { TopBar(currentScreen.topAppItem) },
        bottomBar = {
            BottomAppBar() {
                screens.forEach { it ->
                    NavigationBarItem(selected = currentScreen == it, onClick = {
                        currentScreen = it
                    }, icon = { Icon(it.bottomAppItem.icon, contentDescription = null) }, label = {
                        Text(it.bottomAppItem.label)
                    })
                }
            }
        }) { innerPadding ->
        HorizontalPager(
            pageState, Modifier.padding(innerPadding)
        ) { page ->
            val screen = screens[page]
            when (screen) {
                ScreenItem.Calls -> CallsScreen()
                ScreenItem.Chats -> ChatsListScreen()
                ScreenItem.Communities -> CommunitiesScreen()
                ScreenItem.Updates -> UpdatesScreen()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(item: ITopAppBarItem) {
    TopAppBar(
        title = {
            Text(item.title)
        },
        actions = {
            Row(
                Modifier.padding(8.dp), horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                item.icons.forEach {
                    Icon(
                        it, contentDescription = "Icon de camera"
                    )
                }

            }
        },
    )
}




@Composable
fun UpdatesScreen(modifier: Modifier = Modifier) {
    Box(modifier.fillMaxSize()) {
        Text(
            "UpdatesScreen", Modifier.align(Alignment.Center), style = TextStyle.Default.copy(
                fontSize = 32.sp
            )
        )
    }
}

@Composable
fun CommunitiesScreen(modifier: Modifier = Modifier) {
    Box(modifier.fillMaxSize()) {
        Text(
            "CommunitiesScreen", Modifier.align(Alignment.Center), style = TextStyle.Default.copy(
                fontSize = 32.sp
            )
        )
    }
}

@Composable
fun CallsScreen(modifier: Modifier = Modifier) {
    Box(modifier.fillMaxSize()) {
        Text(
            "CallsScreen", Modifier.align(Alignment.Center), style = TextStyle.Default.copy(
                fontSize = 32.sp
            )
        )
    }
}

@Preview
@Composable
private fun AppPreview() {
    WhatsAppCloneTheme {
        App()
    }
}