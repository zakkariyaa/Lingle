package com.example.lingle.data.network

import com.example.lingle.utils.anonKey
import com.example.lingle.utils.url
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.gotrue.GoTrue
object SupabaseClient {
    val client = createSupabaseClient(
        supabaseUrl = url,
        supabaseKey = anonKey
    ) {
        install(GoTrue)
    }
}