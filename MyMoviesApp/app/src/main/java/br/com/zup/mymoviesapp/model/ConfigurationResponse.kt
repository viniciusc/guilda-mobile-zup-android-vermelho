package br.com.zup.mymoviesapp.model

data class ConfigurationResponse(
    val images: ImagesConfiguration,
    val change_keys: List<String>
)