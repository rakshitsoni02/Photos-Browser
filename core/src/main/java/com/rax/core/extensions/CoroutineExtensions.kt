package com.rax.core.extensions

import android.util.Log
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

private val fallbackExceptionHandler =
    CoroutineExceptionHandler { _, throwable ->
        Log.d(
            "error",
            throwable.message ?: "coroutine exception"
        )
    }

fun CoroutineScope.launchSafely(
    coroutineExceptionHandler: CoroutineExceptionHandler = fallbackExceptionHandler,
    block: suspend CoroutineScope.() -> Unit
) = this.launch(coroutineExceptionHandler) { tryInvoke(block, coroutineExceptionHandler) }


private suspend fun tryInvoke(
    block: suspend CoroutineScope.() -> Unit,
    coroutineExceptionHandler: CoroutineExceptionHandler
) {
    coroutineScope {
        try {
            block.invoke(this)
        } catch (exception: Exception) {
            coroutineExceptionHandler.handleException(coroutineContext, exception)
        }
    }
}
