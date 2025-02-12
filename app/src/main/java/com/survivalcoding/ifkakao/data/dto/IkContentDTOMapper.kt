package com.survivalcoding.ifkakao.data.dto

import com.survivalcoding.ifkakao.domain.model.IkSession

internal fun IkContentDTO.toEntity(): IkSession {
    return IkSession(
        success = success ?: false,
        sessions = data?.map { it.toEntity() } ?: listOf(),
        errorMessage = errorMessage ?: ""
    )
}