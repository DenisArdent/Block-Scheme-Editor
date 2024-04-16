package figures

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.BoxWithConstraintsScope
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp

@Composable
fun RowScope.Diamond(){
    val focusManager = LocalFocusManager.current

    OutlinedTextField(
        modifier = Modifier
            .size(100.dp)
            .drawWithCache {
                val halfWidth = this.size.width / 2
                var x = halfWidth
                var y = halfWidth
                val path = Path()

                path.moveTo(x, y + halfWidth) // moving to Top
                path.lineTo(x - halfWidth, y) // draw from Top to Left
                path.lineTo(x, y - halfWidth) // draw from Left to Bottom
                path.lineTo(x + halfWidth, y) // draw from Bottom to Right
                path.lineTo(x, y + halfWidth) // draw from Right to Top
                path.close()

                onDrawBehind {
                    drawPath(path, Color.Black, style = Stroke(width = 3f))
                }
            },
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