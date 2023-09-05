package com.example.newsapp.presentation.theme

import android.app.Activity
import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import com.example.newsapp.ui.theme.Typography
import com.google.accompanist.systemuicontroller.rememberSystemUiController

/*
private val DarkColorScheme = darkColorScheme(
    primaryContainer = Color.Black,
    onPrimaryContainer = Color.White
)

private val LightColorScheme = lightColorScheme(
    primaryContainer = RoyalBlue,
    onPrimaryContainer = Color.White

    */
/* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    *//*

)

@Composable
fun NewsAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primaryContainer.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}*/


private val DarkColorScheme = darkColorScheme(
    primaryContainer = Color.Black,
    onPrimaryContainer = Color.White
)

private val LightColorScheme = lightColorScheme(
    primary = RoyalBlue,
    primaryContainer = RoyalBlue,
    onPrimaryContainer = Color.White
//    primary = RoyalBlue,
//    onPrimary = RoyalBlue,
//    primaryContainer = RoyalBlue,
//    onPrimaryContainer = Color.White

    /*primary = Color(0xFF6200EE),
//    primaryVariant = Color(0xFF3700DC),
    onPrimary = Color(0xFFFF00FF),

    secondary = Color(0xFF03DAC6),
//    secondaryVariant = Color(0xFF018786),
    onSecondary = Color(0xFFFF4500),

    background = Color(0xFFFFFFFF),
    onBackground = Color(0xFF000000),

    surface = Color(0xFFFFFF00),
    onSurface = Color(0xFFADD8E6),

    error = Color(0xFFF10B0B),
    onError = Color(0xFFCCCCCC),*/
)

@RequiresApi(Build.VERSION_CODES.R)
@Composable
fun NewsAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = if (darkTheme)  Color.Black.toArgb() else RoyalBlue.toArgb()
//            window.statusBarColor = colorScheme.primary.toArgb()
//            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )


    val systemUiController = rememberSystemUiController()
    if (darkTheme) {
        systemUiController.setSystemBarsColor(
            color = Color.Black
        )
    } else {
        systemUiController.setSystemBarsColor(
            color = RoyalBlue
        )
    }

}


