package com.haru067.playground.components.strongskipping

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class StrongSkippingViewModel(
  userRepository: UserRepository = UserRepository(),
) : ViewModel() {

  val userNames = userRepository.getUsers().map { users -> users.map { it.name } }

  val uiState2: StateFlow<StrongSkippingUiState> = combine(
    userNames,
    userRepository.getSomeData(),
  ) { userNames, someData ->
    StrongSkippingUiState(
      userNames = userNames,
      someData = someData,
    )
  }.stateIn(
    viewModelScope,
    started = SharingStarted.Lazily,
    initialValue = StrongSkippingUiState(emptyList(), ""),
  )

  val uiState: StateFlow<StrongSkippingUiState> = combine(
    userRepository.getUsers(),
    userRepository.getSomeData(),
  ) { users, someData ->
    StrongSkippingUiState(
      userNames = users.map { it.name },
      someData = someData,
    )
  }.stateIn(
    viewModelScope,
    started = SharingStarted.Lazily,
    initialValue = StrongSkippingUiState(emptyList(), ""),
  )
}

class UserRepository {
  fun getUsers(): Flow<List<User>> = flow {
    delay(500)
    emit(
      listOf(
        User("Alice", 20),
        User("Bob", 25),
        User("Charlie", 30),
      )
    )
  }

  fun getSomeData(): Flow<String> = flow {
    var i = 0
    while (true) {
      delay(500)
      emit("Some data $i")
      Log.d("StrongSkippingViewModel", "Emitting Some data $i")
      i++
    }
  }
}

data class User(
  val name: String,
  val age: Int,
)
