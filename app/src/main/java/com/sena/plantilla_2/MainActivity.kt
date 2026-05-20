package com.sena.plantilla_2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sena.plantilla_2.ui.theme.Plantilla_2Theme
import com.sena.plantilla_2.ui.theme.*
import androidx.compose.material.icons.filled.*

// COLORES
val PurplePrimary = Color(0xFF4A148C)
val BackgroundLight = Color(0xFFF5F6FA)
val TextDark = Color(0xFF1A1A1A)
val TextGray = Color(0xFF757575)
val BorderGray = Color(0xFFE0E0E0)

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            Plantilla_2Theme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->

                    MisTareasScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun MisTareasScreen(modifier: Modifier = Modifier) {

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(BackgroundLight)
            .padding(16.dp),

        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {

        HeaderSection()

        IllustrationSection()

        ResumenSection()

        ProximasTareasSection()

        Spacer(modifier = Modifier.weight(1f))

        BottomButtonsSection()
    }
}

@Composable
fun HeaderSection() {

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Column {

            Text(
                text = "Mis Tareas",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = TextDark
            )

            Text(
                text = "Hoy es un buen día para codificar 💻✨",
                fontSize = 14.sp,
                color = TextGray
            )
        }

        Icon(
            imageVector = Icons.Default.Star,
            contentDescription = null,
            tint = Color(0xFFFFB300),
            modifier = Modifier.size(36.dp)
        )
    }
}

@Composable
fun IllustrationSection() {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(180.dp)
            .background(Color.White, RoundedCornerShape(16.dp))
            .border(1.dp, BorderGray, RoundedCornerShape(16.dp)),

        contentAlignment = Alignment.Center
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Icon(
                imageVector = Icons.Default.List,
                contentDescription = null,
                tint = PurplePrimary,
                modifier = Modifier.size(80.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "¡Todo al día!",
                fontWeight = FontWeight.SemiBold,
                color = TextGray
            )
        }
    }
}

@Composable
fun ResumenSection() {

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {

        Text(
            text = "Resumen",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = TextDark
        )

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            ResumenCard(
                itemCount = "8",
                label = "Pendientes",
                modifier = Modifier.weight(1f)
            )

            ResumenCard(
                itemCount = "3",
                label = "Completadas",
                modifier = Modifier.weight(1f)
            )

            ResumenCard(
                itemCount = "2",
                label = "En progreso",
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
fun ResumenCard(
    itemCount: String,
    label: String,
    modifier: Modifier = Modifier
) {

    Box(
        modifier = modifier
            .background(Color.White, RoundedCornerShape(12.dp))
            .border(1.dp, BorderGray, RoundedCornerShape(12.dp))
            .padding(12.dp),

        contentAlignment = Alignment.Center
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = itemCount,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = PurplePrimary
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = label,
                fontSize = 12.sp,
                color = TextGray
            )
        }
    }
}

@Composable
fun ProximasTareasSection() {

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {

        Text(
            text = "Próximas tareas",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = TextDark
        )

        Spacer(modifier = Modifier.height(8.dp))

        TareaItem(
            icon = Icons.Default.Build,
            titulo = "Estudiar Jetpack Compose",
            subtitulo = "Repasar layouts básicos",
            tiempo = "1 h",
            dotColor = Color.Blue
        )

        Spacer(modifier = Modifier.height(8.dp))

        TareaItem(
            icon = Icons.Default.Info,
            titulo = "Leer documentación",
            subtitulo = "Column, Row y Box",
            tiempo = "30 min",
            dotColor = Color.Green
        )

        Spacer(modifier = Modifier.height(8.dp))

        TareaItem(
            icon = Icons.Default.Home,
            titulo = "Practicar UI",
            subtitulo = "Crear 3 pantallas distintas",
            tiempo = "45 min",
            dotColor = Color.Red
        )
    }
}

@Composable
fun TareaItem(
    icon: ImageVector,
    titulo: String,
    subtitulo: String,
    tiempo: String,
    dotColor: Color
) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White, RoundedCornerShape(12.dp))
            .border(1.dp, BorderGray, RoundedCornerShape(12.dp))
            .padding(12.dp)
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Box(
                modifier = Modifier
                    .size(40.dp)
                    .background(
                        BackgroundLight,
                        RoundedCornerShape(8.dp)
                    ),

                contentAlignment = Alignment.Center
            ) {

                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = TextDark
                )
            }

            Spacer(modifier = Modifier.width(12.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {

                Text(
                    text = titulo,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    color = TextDark
                )

                Text(
                    text = subtitulo,
                    fontSize = 12.sp,
                    color = TextGray
                )
            }

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    text = tiempo,
                    fontSize = 12.sp,
                    color = TextGray
                )

                Spacer(modifier = Modifier.width(6.dp))

                Box(
                    modifier = Modifier
                        .size(8.dp)
                        .background(
                            dotColor,
                            RoundedCornerShape(50)
                        )
                )
            }
        }
    }
}

@Composable
fun BottomButtonsSection() {

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        Box(
            modifier = Modifier
                .weight(1f)
                .height(48.dp)
                .border(
                    1.dp,
                    Color.Red,
                    RoundedCornerShape(24.dp)
                )
                .background(
                    Color.White,
                    RoundedCornerShape(24.dp)
                ),

            contentAlignment = Alignment.Center
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = null,
                    tint = Color.Red
                )

                Spacer(modifier = Modifier.width(4.dp))

                Text(
                    text = "Eliminar",
                    color = Color.Red,
                    fontSize = 14.sp
                )
            }
        }

        Button(
            onClick = { },
            colors = ButtonDefaults.buttonColors(
                containerColor = PurplePrimary
            ),

            modifier = Modifier
                .weight(1f)
                .height(48.dp),

            shape = RoundedCornerShape(24.dp)
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = null,
                    tint = Color.White
                )

                Spacer(modifier = Modifier.width(4.dp))

                Text(
                    text = "Nueva tarea",
                    color = Color.White
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMisTareas() {

    Plantilla_2Theme {
        MisTareasScreen()
    }
}

