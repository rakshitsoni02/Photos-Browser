package  com.rax.core.repository

data class HttpSuccessResponse(
    val code: Int,
    val body: String,
    val headers: Map<String, String>
)
