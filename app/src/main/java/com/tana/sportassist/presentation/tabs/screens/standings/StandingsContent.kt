package com.tana.sportassist.presentation.tabs.screens.standings

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.tana.sportassist.domain.modal.Standing
import com.tana.sportassist.presentation.components.ErrorBody

@Composable
fun StandingsContent(
    uiState: StandingsScreenUiState,
    modifier: Modifier,
) {
    if (uiState.errorMessage.isBlank()) {
        Column {
            Standings(uiState = uiState, modifier = modifier)
        }
    } else {
        ErrorBody(modifier = modifier, message = uiState.errorMessage)
    }
}

@Composable
fun Standings(
    uiState: StandingsScreenUiState,
    modifier: Modifier,
    state: LazyListState = rememberLazyListState()
) {
    LazyColumn(
        modifier = modifier
            .padding(12.dp)
            .padding(top = 12.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        item {
            StandingItemHeader(modifier = modifier)
            Spacer(modifier = modifier.height(12.dp))
            Divider()
        }
        itemsIndexed(uiState.standings) { index, standing ->
            StandingItem(modifier = modifier, standing = standing)
            Spacer(modifier = modifier.height(12.dp))
            Divider()
        }
    }
}


@Composable
fun StandingItem(
    modifier: Modifier,
    standing: Standing
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = modifier.weight(.2f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = standing.rank.toString())
        }
        //Spacer(modifier = modifier.width(6.dp))
        AsyncImage(
            model = ImageRequest.Builder(
                context = LocalContext.current
            )
                .data(standing.team.logo)
                .crossfade(enable = true)
                .build(),
            modifier = modifier
                .size(20.dp),
            contentDescription = "${standing.team.name} logo"
        )
        Spacer(modifier = modifier.width(5.dp))
        Text(text = standing.team.name, modifier = modifier.weight(1f))
        Spacer(modifier = modifier.width(5.dp))
        Column(
            modifier = modifier.weight(.2f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = standing.all.played.toString())
        }
        Column(
            modifier = modifier.weight(.2f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = standing.goalsDiff.toString())
        }
        Column(
            modifier = modifier.weight(.2f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = standing.points.toString())
        }
    }
}

@Composable
fun StandingItemHeader(
    modifier: Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Column(
            modifier = modifier.weight(.2f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "#")
        }
        Column(
            modifier = modifier.weight(1f),
        ) {
            Text(text = "Team".toUpperCase(Locale.current))
        }
        Spacer(modifier = modifier.width(5.dp))
        Column(
            modifier = modifier.weight(.2f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "P")
        }
        Column(
            modifier = modifier.weight(.2f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "GD")
        }
        Column(
            modifier = modifier.weight(.2f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "PTS")
        }
    }
}