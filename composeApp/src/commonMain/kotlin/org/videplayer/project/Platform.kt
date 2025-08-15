package org.videplayer.project

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform