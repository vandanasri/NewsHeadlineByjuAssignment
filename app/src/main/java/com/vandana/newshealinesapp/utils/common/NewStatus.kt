package com.vandana.newshealinesapp.utils.common

sealed class NewStatus {

    object Success: NewStatus()
    object Error: NewStatus()
}