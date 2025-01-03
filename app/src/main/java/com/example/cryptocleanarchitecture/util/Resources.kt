package com.example.cryptocleanarchitecture.util

// İsteğimizin state'ini kontrol etmemizi sağlar.
// Apiden istek gönderildiğinde hata mı aldık gönderildi mi, bekleniyor mu'yu öğreniriz.
sealed class Resources<T>(val data: T? = null, val message: String? = null) {
    class Success<T>(data: T): Resources<T>(data = data)
    class Error<T>(message: String, data: T? = null): Resources<T>(data = data, message = message)
    class Loading<T>(data: T? = null): Resources<T>(data = data)
}