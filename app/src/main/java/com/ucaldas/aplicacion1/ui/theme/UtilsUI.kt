package com.ucaldas.aplicacion1.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.ucaldas.aplicacion1.Nombres


@Composable
fun HeroImage(
    imageUrl: String,
    contentDescription: String,
    modifier: Modifier = Modifier
) {
    AsyncImage(
        model = imageUrl,
        contentDescription = contentDescription,
        modifier = modifier
            .fillMaxWidth()
            .height(220.dp),
        contentScale = ContentScale.Crop
    )
}


@Composable
fun HeroInfo(
    hero: Nombres,
    modifier: Modifier = Modifier
) {

    Column(modifier = modifier.padding(16.dp)) {

        Text(
            text = "ID: ${hero.id}",
            style = MaterialTheme.typography.labelMedium
        )

        Text(
            text = hero.nombre,
            style = MaterialTheme.typography.displayMedium,
            modifier = Modifier.padding(top = 4.dp)
        )

        Text(
            text = hero.descripcion,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(top = 8.dp)
        )

        Text(
            text = "Superpoderes: ${hero.superPoderes.joinToString()}",
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier.padding(top = 8.dp)
        )

    }
}


@OptIn(ExperimentalLayoutApi::class)
@Composable
fun HeroInfoDetail(
    hero: Nombres,
    modifier: Modifier = Modifier
) {

    Column(
        modifier = modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        // 1. Bloque principal destacado
        Surface(
            modifier = Modifier.fillMaxWidth(),
            shape = MaterialTheme.shapes.large,
            color = MaterialTheme.colorScheme.primaryContainer
        ) {

            Row(
                modifier = Modifier.padding(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {

                Box(
                    modifier = Modifier
                        .size(64.dp)
                        .background(
                            color = MaterialTheme.colorScheme.primary,
                            shape = CircleShape
                        ),
                    contentAlignment = Alignment.Center
                ) {

                    Text(
                        text = hero.nombre.firstOrNull()?.uppercase() ?: "?",
                        style = MaterialTheme.typography.headlineMedium,
                        color = MaterialTheme.colorScheme.onPrimary,
                        fontWeight = FontWeight.Bold
                    )
                }

                Column(
                    modifier = Modifier.weight(1f)
                ) {

                    Text(
                        text = "HÉROE #${hero.id}",
                        style = MaterialTheme.typography.labelMedium
                    )

                    Text(
                        text = hero.nombre,
                        style = MaterialTheme.typography.headlineMedium,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }

        // 2. Descripción del héroe
        Surface(
            modifier = Modifier.fillMaxWidth(),
            shape = MaterialTheme.shapes.medium,
            tonalElevation = 2.dp
        ) {

            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {

                Text(
                    text = "Historia del héroe",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = hero.descripcion,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }

        // 3. Estadísticas
        Surface(
            modifier = Modifier.fillMaxWidth(),
            shape = MaterialTheme.shapes.medium
        ) {

            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {

                Text(
                    text = "Métricas",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Column {
                        Text(
                            text = "ID",
                            style = MaterialTheme.typography.labelMedium
                        )

                        Text(
                            text = hero.id.toString(),
                            style = MaterialTheme.typography.titleLarge
                        )
                    }

                    Column {
                        Text(
                            text = "Superpoderes",
                            style = MaterialTheme.typography.labelMedium
                        )

                        Text(
                            text = hero.superPoderes.size.toString(),
                            style = MaterialTheme.typography.titleLarge
                        )
                    }
                }
            }
        }

        // 4. Superpoderes como chips
        Surface(
            modifier = Modifier.fillMaxWidth(),
            shape = MaterialTheme.shapes.medium
        ) {

            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {

                Text(
                    text = "Habilidades especiales",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )

                FlowRow(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalArrangement = Arrangement.spacedBy(4.dp)
                ) {

                    hero.superPoderes.forEach { poder ->

                        AssistChip(
                            onClick = {},
                            label = {
                                Text(text = poder)
                            }
                        )
                    }
                }
            }
        }

        // 5. Resumen táctico
        Surface(
            modifier = Modifier.fillMaxWidth(),
            shape = MaterialTheme.shapes.medium,
            color = MaterialTheme.colorScheme.secondaryContainer
        ) {

            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {

                Text(
                    text = "Resumen táctico",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "Perfil: ${heroProfile(hero.superPoderes)}\n\n" +
                            "${hero.nombre} cuenta con " +
                            "${hero.superPoderes.size} habilidades registradas. " +
                            "Consulta sus capacidades para conocer mejor su perfil.",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}

private fun heroProfile(superPoderes: List<String>): String = when {

    superPoderes.any {
        it.contains("Inteligencia", ignoreCase = true)
    } &&
            superPoderes.any {
                it.contains("Combate", ignoreCase = true)
            } -> "Estratega"

    superPoderes.any {
        it.contains("Energia", ignoreCase = true)
    } -> "Cosmico"

    superPoderes.any {
        it.contains("velocidad", ignoreCase = true)
    } -> "Velocista"

    else -> "Titan"
}


@Composable
fun HeroCard(
    hero: Nombres,
    onClick: (() -> Unit)? = null,
    option: Int = 0,
    modifier: Modifier = Modifier
) {

    Card(
        modifier = modifier
            .fillMaxWidth()
            .then(
                if (onClick != null) {
                    Modifier.clickable { onClick() }
                } else {
                    Modifier
                }
            )
    ) {

        HeroImage(
            imageUrl = hero.imagenUrl,
            contentDescription = hero.nombre
        )

        if (option == 0) {
            HeroInfo(hero = hero)
        } else {
            HeroInfoDetail(hero = hero)
        }

    }
}

