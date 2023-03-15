package com.tana.sportassist.presentation.tabs.screens.fixture

import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Icon
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.tana.sportassist.R
import com.tana.sportassist.domain.modal.Fixture
import com.tana.sportassist.presentation.components.ErrorBody
import com.tana.sportassist.utils.SportAssistConstants
import kotlinx.coroutines.launch
import java.time.Instant
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun FixtureContent(
    uiState: FixtureUiState,
    onMatchClick: (Fixture) -> Unit,
    modifier: Modifier
) {
    val state = rememberLazyListState()
    val scope = rememberCoroutineScope()

    if (uiState.errorMessage.isBlank()) {
        Box(
            modifier = modifier
                .fillMaxSize()
                .padding(vertical = 12.dp)
        ) {
            val context = LocalContext.current
            Fixture(
                uiState = uiState,
                onMatchClick = onMatchClick,
                modifier = modifier,
                state = state
            )
            val showTopButton by remember {
                derivedStateOf {
                    state.firstVisibleItemIndex > 0
                }
            }

            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AnimatedVisibility(visible = showTopButton) {
                    IconButton(
                        onClick = {
                            scope.launch {
                                state.animateScrollToItem(0)
                            }
                        }
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.chevron_circled_top),
                            contentDescription = "Scroll to top button",
                            modifier = modifier
                                .size(26.dp),
                            tint = MaterialTheme.colorScheme.onBackground
                        )
                    }
                }
            }
        }
    } else {
        ErrorBody(modifier = modifier, message = uiState.errorMessage)
    }
}


@OptIn(ExperimentalFoundationApi::class)
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Fixture(
    uiState: FixtureUiState,
    onMatchClick: (Fixture) -> Unit,
    modifier: Modifier,
    state: LazyListState
) {
    val groupedFixture = uiState.fixture.groupBy {
        it.fixture.date
    }
    LazyColumn(
        state = state,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        groupedFixture.forEach { (date, fixtures) ->
            stickyHeader(key = date) {

                val formattedDate = "${date.dayOfMonth} ${date.month.name} ${date.year}"
                Text(
                    text = formattedDate,
                    style = MaterialTheme.typography.bodySmall,
                    modifier = modifier.padding(start = 16.dp)
                )
            }
            items(fixtures) { fixture ->
                FixtureItem(fixture = fixture, onMatchClick = onMatchClick, modifier = modifier)
            }
        }
    }
}


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun FixtureItem(
    fixture: Fixture,
    onMatchClick: (Fixture) -> Unit,
    modifier: Modifier
) {
    val cardColors = CardDefaults.cardColors(
        contentColor = MaterialTheme.colorScheme.onBackground
    )
    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onMatchClick(fixture) },
        colors = cardColors
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(text = fixture.fixture.time.toString(), fontWeight = FontWeight.ExtraBold)
            Column(
                modifier = modifier
                    .weight(1f),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Row(
                    modifier = modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    AsyncImage(
                        model = ImageRequest.Builder(
                            context = LocalContext.current
                        )
                            .data(fixture.teams.home.logo)
                            .build(),
                        contentDescription = "${fixture.teams.home.name} logo",
                        modifier = modifier
                            .size(14.dp)
                    )
                    Text(text = fixture.teams.home.name)
                }
                Row(
                    modifier = modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    AsyncImage(
                        model = ImageRequest.Builder(
                            context = LocalContext.current
                        )
                            .data(fixture.teams.away.logo)
                            .build(),
                        contentDescription = "${fixture.teams.away.name} logo",
                        modifier = modifier
                            .size(14.dp)
                    )
                    Text(text = fixture.teams.away.name)
                }
            }
            Text(
                text = fixture.fixture.date.dayOfWeek.name.take(3),
                style = MaterialTheme.typography.labelSmall,
            )
        }
    }
}

