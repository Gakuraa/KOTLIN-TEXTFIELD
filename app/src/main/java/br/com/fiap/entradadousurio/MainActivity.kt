package br.com.fiap.entradadousurio

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.fiap.entradadousurio.ui.theme.EntradaDoUsuárioTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EntradaDoUsuárioTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting() {

    var texto by remember {
        mutableStateOf("")
    }
    var idade by remember {
        mutableStateOf("")
    }
    var email by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier.padding(32.dp)
    ){
        TextField(
            value = texto,
            onValueChange = {
                            letra -> texto = letra
            },
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text = "Qual o seu nome?")
            },
            placeholder = {
                Text(text = "Digite o nome e sobrenome")
            },
            trailingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.settings_24),
                    contentDescription = "ícone de configuração"
                )
            }, leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.person_24),
                    contentDescription = "ícone de pessoa"
                )
            },
            keyboardOptions = KeyboardOptions(capitalization = KeyboardCapitalization.Sentences)

        )
        TextField(
            value = idade,
            onValueChange = {
                    letra -> idade = letra
            },
            modifier = Modifier.fillMaxWidth()
                .padding(top = 32.dp),
            label = {
                Text(text = "Qual a sua idade?")
            },
            placeholder = {
                Text(text = "Digite o valor numérico")
            },
            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = "ícone home"
                )
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        TextField(
            value = email,
            onValueChange = {
                    letra -> email = letra
            },
            modifier = Modifier.fillMaxWidth()
                .padding(top = 32.dp),
            label = {
                Text(text = "Qual seu email?")
            },
            placeholder = {
                Text(text = "Digite seu endereço de e-mail")
            },
            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = "ícone e-mail"
                )
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    EntradaDoUsuárioTheme {
        Greeting()
    }
}