import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel {
    private val _mainUiState = MutableStateFlow<List<FigureData>>(emptyList())
    val mainUiState: StateFlow<List<FigureData>> = _mainUiState.asStateFlow()


}