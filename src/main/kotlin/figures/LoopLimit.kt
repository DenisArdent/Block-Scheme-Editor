package figures

import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.draw.rotate
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
fun RowScope.LoopLimit (){
    val focusManager = LocalFocusManager.current
    Box(
        Modifier
            .drawWithCache {
                val height = this.size.height
                val width = this.size.width
                var x = width*0.2f
                var y = height*0.4f
                val path = Path()
                path.moveTo(0f, y)
                path.lineTo(x, 0f)
                path.lineTo(width-x, 0f)
                path.lineTo(width, y)
                path.lineTo(width, height)
                path.lineTo(0f, height)
                path.lineTo(0f, y)
                path.close()

                onDrawBehind {
                    drawPath(path, Color.Black, style = Stroke(width = 10f))
                }
            }
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