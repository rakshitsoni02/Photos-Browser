package  com.rax.core.repository

import androidx.annotation.StringDef

class HttpVerb {

    companion object {
        const val GET = "GET"
    }

    @StringDef(GET)
    @Retention(AnnotationRetention.SOURCE)
    annotation class HttpVerbDef
}
