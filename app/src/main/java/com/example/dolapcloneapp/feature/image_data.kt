package com.example.dolapcloneapp.feature

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource

import com.example.dolapcloneapp.R

@Composable
fun getKeysAndValuesList(imageIndex: Int): List<Painter> {
    return when (imageIndex) {
        0 -> listOf(
            painterResource(id = R.drawable.image_1),
            painterResource(id = R.drawable.ayakkabi_1),
            painterResource(id = R.drawable.ayakkabi_3),
            painterResource(id = R.drawable.ayakkabi_4),
            painterResource(id = R.drawable.ayakkabi_5),
            painterResource(id = R.drawable.ayakkabi_6),
            painterResource(id = R.drawable.ayakkabi_7)
        )
        1 -> listOf(
            painterResource(id = R.drawable.image_2),
            painterResource(id = R.drawable.ceket_1),
            painterResource(id = R.drawable.ceket_2)
        )
        2 -> listOf(
            painterResource(id = R.drawable.image_3),
            painterResource(id = R.drawable.tent_1),
            painterResource(id = R.drawable.tent_2),
            painterResource(id = R.drawable.tent_3),
            painterResource(id = R.drawable.tent_4),
            painterResource(id = R.drawable.tent_5)
        )
        3 -> listOf(
            painterResource(id = R.drawable.image_5),
            painterResource(id = R.drawable.tnf_1),
            painterResource(id = R.drawable.tnf_2)
        )
        else -> emptyList() // Varsayılan durum, başka bir durum varsa boş liste döner
    }
}
