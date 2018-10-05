package com.example.logonrmlocal.notapadapp.view.formulario

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.logonrmlocal.notapadapp.model.Nota
import com.example.logonrmlocal.notapadapp.model.ResponseStatus
import com.example.logonrmlocal.notapadapp.repository.NotaRepositorio

class FormularioViewModel: ViewModel(){

    val notaRepository = NotaRepositorio()
    val responseStatus: MutableLiveData<ResponseStatus> = MutableLiveData()

    fun salvar(titulo: String, descricao: String){
        val nota = Nota(null,titulo,descricao)
        notaRepository.salvar(nota,onComplete = {
            responseStatus.value = ResponseStatus(true, "sucesso")
        },onError = {
            responseStatus.value = ResponseStatus(false,it?.message!!)
        })
    }
}