package com.tana.sportassist.presentation.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.tana.sportassist.R


private val ubuntuLight = FontFamily(Font(R.font.ubuntu_light))
private val ubuntuMedium = FontFamily(Font(R.font.ubuntu_medium))
private val ubuntuRegular = FontFamily(Font(R.font.ubuntu_regular))


// Set of Material typography styles to start with
val Typography = Typography(
    bodySmall = TextStyle(
        fontFamily = ubuntuLight,
        fontWeight = FontWeight.W600,
        fontSize = 14.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.1.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = ubuntuLight,
        fontWeight = FontWeight.W600,
        fontSize = 14.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.1.sp
    ),
    labelLarge = TextStyle(
        fontFamily = ubuntuMedium,
        fontSize = 16.sp
    ),
    labelSmall = TextStyle(
        fontFamily = ubuntuRegular,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 12.sp,
    )

    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)