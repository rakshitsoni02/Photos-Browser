package  com.rax.core.repository

data class HttpTransition(
    @HttpVerb.HttpVerbDef val verb: String,
    val url: String,
    val accept: String? = null
)
