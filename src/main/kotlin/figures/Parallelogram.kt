package figures

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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import kotlin.math.roundToInt

@Composable
fun RowScope.Parallelogram (parentHeight: Int, parentWidth: Int){
    val focusManager = LocalFocusManager.current
    Box(
        Modifier
            .drawWithCache {
                val height = this.size.height
                val width = this.size.width
                var x = 0.2f*width
                var y = 0f
                val path = Path()
                path.moveTo(x, y)
                path.lineTo(width, y) // draw from top left to top right
                path.lineTo(0.8f*width, height) // draw from top to bottom
                path.lineTo(0f, height) // draw from bottom Right to bottom left
                path.lineTo(x, 0f) // draw from bottom to Top
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