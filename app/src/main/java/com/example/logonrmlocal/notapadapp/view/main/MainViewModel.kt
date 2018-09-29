package com.example.logonrmlocal.notapadapp.view.main

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.logonrmlocal.notapadapp.model.Nota
import com.example.logonrmlocal.notapadapp.repository.NotaRepositorio

class MainViewModel : ViewModel(){
    val notaRepository = NotaRepositorio()

    var notas: MutableLiveData<List<Nota>> = MutableLiveData()
    var isLoading: MutableLiveData<Boolean> = MutableLiveData()

    fun buscarTodos(){
        isLoading.value = true
        notaRepository
                .buscarTodos(onComplete = {
                    isLoading.value = false
                    notas.value = it
                }, onError = {
                    isLoading.value = false
                    notas.value = arrayListOf()
                })
    }
}