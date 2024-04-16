import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import figures.Diamond
import figures.Hexagon
import figures.Rectangle

@Composable
fun MainScreen(viewModel: MainViewModel = MainViewModel()){
    val figures = viewModel.mainUiState.collectAsState()
    LazyColumn {
        item {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                Rectangle()
                Hexagon()
                Diamond()
            }
        }
    }
}