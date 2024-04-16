package figures

import androidx.compose.foundation.gestures.detectDragGestures
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
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import kotlin.math.roundToInt

@Composable
fun RowScope.Hexagon (){
    val focusManager = LocalFocusManager.current
    Box(
        Modifier
            .drawWithCache {
                val height = this.size.height
                val width = this.size.width
                var x = 0f
                var y = height/2
                val path = Path()
                path.moveTo(x, y)
                path.lineTo(0.2f*width, 0f)
                path.lineTo(0.8f*width, 0f)
                path.lineTo(width, y)
                path.lineTo(0.8f*width, height)
                path.lineTo(0.2f*width, height)
                path.lineTo(x, y)
                path.close()

                onDrawBehind {
                    drawPath(path, Color.Black, style = Stroke(width = 3f))
                }
            }
            .align(Alignment.CenterVertically)
    ){
        OutlinedTextField(
            modifier = Modifier.size(width = 100.dp, 60.dp),
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
}