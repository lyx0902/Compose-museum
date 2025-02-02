package com.piashcse.compose_museum.components

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.piashcse.compose_museum.R
import com.piashcse.compose_museum.navigation.Screen
import com.piashcse.compose_museum.navigation.currentRoute


@Composable
fun ExitAlertDialog(
    navController: NavController, cancel: (isOpen: Boolean) -> Unit, ok: () -> Unit
) {
    val openDialog = remember { mutableStateOf(true) }
    if (currentRoute(navController = navController) == Screen.Home.route && openDialog.value) {
        AlertDialog(
            onDismissRequest = {},
            // below line is use to display title of our dialog
            // box and we are setting text color to white.
            title = {
                Text(
                    text = stringResource(R.string.close_the_app),
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
            },
            text = {
                Text(text = stringResource(R.string.do_you_want_to_exit_the_app), fontSize = 16.sp)
            },
            confirmButton = {
                TextButton(onClick = {
                    openDialog.value = false
                    ok()
                }) {
                    Text(
                        stringResource(R.string.yes),
                        fontWeight = FontWeight.Bold,
                        style = TextStyle(color = Color.Black)
                    )
                }
            },
            dismissButton = {
                TextButton(onClick = {
                    openDialog.value = false
                    cancel(false)
                }) {
                    Text(
                        stringResource(R.string.no),
                        fontWeight = FontWeight.Bold,
                        style = TextStyle(color = Color.Black)
                    )
                }
            },
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ExitAlertDialogPreview() {
    val navController = rememberNavController()
    ExitAlertDialog(navController, {}, {})
}