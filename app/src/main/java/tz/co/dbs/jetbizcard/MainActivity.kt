package tz.co.dbs.jetbizcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import tz.co.dbs.jetbizcard.ui.theme.JetBizCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetBizCardTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CreateBizCard(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun CreateBizCard(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier.fillMaxSize()
    ) {
        Card(
            modifier = modifier.width(100.dp).height(390.dp).padding(12.dp),
            shape = RoundedCornerShape(corner = CornerSize(24.dp)),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(4.dp)) {
            Column(
                modifier = modifier.height(300.dp).fillMaxWidth(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Profile()
                HorizontalDivider()
                UserInfo()
                PortfolioBtn()
            }
        }
    }
}

@Preview
@Composable
fun Content(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.fillMaxSize().padding(6.dp)
    ) {
        Surface(
            modifier = modifier.padding(2.dp).fillMaxSize(),
            shape = RoundedCornerShape(corner = CornerSize(6.dp)),
            border = BorderStroke(width = 1.dp, color = Color.LightGray)
        ) {
            PortfolioList(data = listOf("Portfolio 1", "Portfolio 2", "Portfolio 3"))
        }
    }
}

@Composable
private fun PortfolioBtn() {
    Button(onClick = {}) {
        Text(text = "Portfolio")
    }
}

@Composable
private fun PortfolioList(data: List<String>) {

}

@Composable
private fun UserInfo(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.padding(6.dp)
    ) {
        Text(
            text = "Miles M.",
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.primary
        )
        Text(
            text = "Jetpack Compose Developer",
            modifier = modifier.padding(3.dp)
        )
        Text(
            text = "@miles.dev",
            modifier = modifier.padding(3.dp),
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Composable
private fun Profile() {
    Surface(
        modifier = Modifier
            .size(150.dp)
            .padding(4.dp),
        shape = CircleShape,
        color = MaterialTheme.colorScheme.surface.copy(alpha = 0.5f),
        border = BorderStroke(0.5.dp, Color.LightGray),
    ) {
        Image(
            painter = painterResource(
                id = R.drawable.user
            ),
            contentDescription = "User",
            modifier = Modifier.size(135.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetBizCardTheme {
        CreateBizCard()
    }
}