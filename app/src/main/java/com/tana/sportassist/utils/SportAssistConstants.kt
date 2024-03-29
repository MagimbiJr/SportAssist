package com.tana.sportassist.utils

import com.tana.sportassist.BuildConfig


object SportAssistConstants {
    const val API_KEY = BuildConfig.SPORT_ASSIST_API_KEY
    const val BASE_URL = "https://api-football-v1.p.rapidapi.com/v3/"
    const val PARAMS_FIXTURE_ID = "fixtureId"
    const val TAG = "SportAssistApp"
    const val FIXTURE_ROUTE = "fixture"
}