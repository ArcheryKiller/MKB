package pavel.ivanov.mkb.data.api


import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONObject
import pavel.ivanov.mkb.data.response.MkbRequestApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*


//https://alpha.as50464.net:29870/moby-pre-44/core?r=BEYkZbmV&d=563B4852-6D4B-49D6-A86E-B273DD520FD2&t=ExchangeRates&v=44


interface ICurrencyApi {

    @POST(":29870/moby-pre-44/core")
    suspend fun getCurrencies(
        @Query("r") r: String = "BEYkZbmV",
        @Query("d") d: String = "563B4852-6D4B-49D6-A86E-B273DD520FD2",
        @Query("t") t: String = "ExchangeRates",
        @Query("v") v: String = "44",
    ): Deferred<MkbRequestApi>

    companion object {
        private val jsonObject = JSONObject()
        private val mediaType = "application/json".toMediaType()


        operator fun invoke(): ICurrencyApi {

            jsonObject.put("uid", "563B4852-6D4B-49D6-A86E-B273DD520FD2")
            jsonObject.put("type", "ExchangeRates")
            jsonObject.put("rid", "BEYkZbmV")

            val body = jsonObject.toString().toRequestBody(mediaType)

            val requestInterceptor = Interceptor { chain ->
                val url = chain.request()
                    .url
                    .newBuilder()
                    .build()
                val request = chain.request()
                    .newBuilder()
                    .url(url)
                    .get()
                    .post(body)
                    .header("User-Agent","Test GeekBrains iOS 3.0.0.182 (iPhone 11; iOS 14.4.1; Scale/2.00; Private)")
                    .header("Content-Type", "application/json")
                    .header("Accept", "application/json")
                    .build()
                return@Interceptor chain.proceed(request)
            }
            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(requestInterceptor)
                .build()

            return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("https://alpha.as50464.net/")
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ICurrencyApi::class.java)
        }
    }
}