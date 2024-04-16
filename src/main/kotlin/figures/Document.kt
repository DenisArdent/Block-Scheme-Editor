package figures

import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import kotlin.math.roundToInt

@Composable
fun RowScope.Document(){
    val focusManager = LocalFocusManager.current

    OutlinedTextField(
        modifier = Modifier
            .height(100.dp)
            .width(200.dp)
            .drawWithCache {
                val height = this.size.height
                val width = this.size.width
                val path = Path()
                path.lineTo(width, 0f)
                path.lineTo(width, 0.75f*height)
                path.quadraticBezierTo(0.75f*width, 0.75f*height, 0.5f*width, 0.85f*height)
                path.quadraticBezierTo(0.25f*width, height, 0f, 0.85f*height)
                path.lineTo(0f, 0f)

                onDrawBehind {
                    drawPath(path, Color.Black, style = Stroke(width = 3f))
                }
            }
            .align(Alignment.CenterVertically),
        value = "HI",
        colors =  TextFieldDefaults.outlinedTextFieldColors(
            unfocusedBorderColor = Color.Transparent,
            focusedBorderColor = Color.Transparent
        ),
        keyboardActions = KeyboardActions(onAny = {
            focusManager.clearFocus()
        }),
        singleLine = true,
        onValueChange = {},
    )
}

