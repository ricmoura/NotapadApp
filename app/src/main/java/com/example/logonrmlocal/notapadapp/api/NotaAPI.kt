package com.example.logonrmlocal.notapadapp.api

import com.example.logonrmlocal.notapadapp.model.Nota
import retrofit2.Call
import retrofit2.http.*

interface NotaAPI {

    @GET("/nota")
    fun buscarTodos(): Call<List<Nota>>


    @GET("/nota/titulo/{titulo}")
    fun buscarPorTitulo(@Path("titulo") titulo: String): Call<List<Nota>>

    @POST("/nota")
    fun salvar(@Body nota: Nota): Call<Nota>

    @DELETE("/nota/{id}")
    fun apagar(@Path("id") id: String): Call<Void>
}