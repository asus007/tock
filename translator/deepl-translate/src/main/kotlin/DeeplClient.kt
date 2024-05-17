/*
 * Copyright (C) 2017/2021 e-voyageurs technologies
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ai.tock
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import java.io.IOException

data class TranslationResponse(
    val translations: List<Translation>
)

data class Translation(
    val text: String
)

val DEEPL_URL_API = "https://api.deepl.com/v2/translate"

class DeeplClient(private val apiKey: String) {
    private val client = OkHttpClient()
    private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
    private val jsonAdapter = moshi.adapter(TranslationResponse::class.java)

    fun translate(text: String, sourceLang: String,targetLang: String): String? {
        // TODO Pass placeholders options in parameters
        val textWithTags = text.replace("{", "<x>").replace("}", "</x>")

        val requestBody = """
            text=$textWithTags&source_lang=$sourceLang&target_lang=$targetLang&tag_handling=xml&non_translatable_tags=x
        """.trimIndent().toRequestBody("application/x-www-form-urlencoded".toMediaTypeOrNull())

        val request = Request.Builder()
            .url(DEEPL_URL_API)
            .addHeader("Authorization", "DeepL-Auth-Key $apiKey")
            .post(requestBody)
            .build()

        client.newCall(request).execute().use { response ->
            if (!response.isSuccessful) throw IOException("Unexpected code $response")

            val responseBody = response.body?.string()
            val translationResponse = jsonAdapter.fromJson(responseBody!!)

            val translatedText = translationResponse?.translations?.firstOrNull()?.text
            return translatedText?.replace("<x>", "{")?.replace("</x>", "}")
        }
    }
}