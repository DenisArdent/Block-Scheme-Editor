package figures


import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraintsScope
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import kotlin.math.roundToInt

@Composable
fun BoxWithConstraintsScope.RoundedRectangle(parentHeight: Int, parentWidth: Int){
    val focusManager = LocalFocusManager.current
    Box(
        Modifier
            .border(3.dp, Color.Black, shape = RoundedCornerShape(100))
            .align(Alignment.TopStart)
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