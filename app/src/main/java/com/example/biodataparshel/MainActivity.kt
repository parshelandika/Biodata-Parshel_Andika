package com.example.biodataparshel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.biodataparshel.ui.theme.BIODATAPARSHELTheme
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.example.biodataparshel.model.Biodataparshel
import com.example.biodataparshel.data.Datasource
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.platform.LocalContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BIODATAPARSHELTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Foto(name = "Android")
                    BiodataparshelApp()
                }
            }
        }
    }
}

@Composable
fun Foto(name: String, modifier: Modifier = Modifier) {
    Card {
        Column(
            modifier = modifier
                .padding(16.dp)
        ) {
            Image(
                modifier = modifier
                    .fillMaxWidth()
                    .height(360.dp)
                    .padding(16.dp)
                    .clip(CircleShape),
                painter = painterResource(R.drawable.parshel),
                contentScale = ContentScale.FillWidth,
                contentDescription = "User Profile"
            )
            Spacer(modifier = modifier.height(16.dp))
        }
    }
}

@Composable
fun BiodataparshelApp(modifier: Modifier = Modifier) {
    BiodataparshelList(
        biodataparshelList = Datasource().Loadbiodataparshel(),
    )
}

@Composable
fun BiodataparshelCard(biodataparshel: Biodataparshel, modifier: Modifier = Modifier) {
    Card(modifier = modifier){
        Column {
            Text(
                text = LocalContext.current.getString(biodataparshel.stringResourceId),
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.headlineSmall
            )
        }
    }
}

@Composable
fun BiodataparshelList(biodataparshelList: List<Biodataparshel>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(biodataparshelList) { biodataparshel ->
            BiodataparshelCard(
                biodataparshel = biodataparshel,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}