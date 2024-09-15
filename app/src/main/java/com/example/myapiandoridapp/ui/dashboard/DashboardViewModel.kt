package com.example.myapiandoridapp.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapiandoridapp.data.model.Entity
import com.example.myapiandoridapp.data.repository.InvestmentRepository
//import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
//import javax.inject.Inject
//import androidx.hilt.lifecycle.ViewModelInject
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(private val repository: InvestmentRepository) : ViewModel() {
    private val _entities = MutableLiveData<Result<List<Entity>>>()
    val entities: LiveData<Result<List<Entity>>> = _entities

    fun loadDashboard() {
        viewModelScope.launch {
            _entities.value = repository.getDashboard("keypass_value") // Replace with actual keypass
        }
    }
}