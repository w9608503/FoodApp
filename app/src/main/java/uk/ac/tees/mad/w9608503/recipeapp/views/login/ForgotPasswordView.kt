package uk.ac.tees.mad.w9608503.recipeapp.views.login

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import uk.ac.tees.mad.w9608503.recipeapp.R
import uk.ac.tees.mad.w9608503.recipeapp.viewModel.Alert
import uk.ac.tees.mad.w9608503.recipeapp.viewModel.LoginViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ForgotPasswordView(navController: NavController, loginViewModel: LoginViewModel) {

    val mContext = LocalContext.current
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxSize()) {
        var email by remember { mutableStateOf("") }
        Spacer(
            modifier = Modifier.height(8.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.recipe),
            contentDescription = "Logo")
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text(text = "Email") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 30.dp, end = 30.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                loginViewModel.forgotPassword(
                    email
                ) {
                    val toast = Toast.makeText(mContext, "Email sent with password reset instructions",
                        Toast.LENGTH_SHORT) // in Activity
                    toast.show()
                    navController.navigate("Login")
                }
            }, modifier = Modifier
                .fillMaxWidth()
                .padding(start = 30.dp, end = 30.dp)
        ) {
            Text(text = "Password Reset")
        }
        if (loginViewModel.showAlert) {
            Alert(
                title = "Alert",
                message = "Please provide Email.",
                confirmText = "To accept",
                onConfirmClick = { loginViewModel.closeAlert() }) {
            }
        }
    }

}