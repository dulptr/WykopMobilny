package io.github.feelfreelinux.wykopmobilny.utils.preferences

import android.content.Context
import javax.inject.Inject

interface BlacklistPreferencesApi {
    var blockedTags : Set<String>
    var blockedUsers : Set<String>
}

class BlacklistPreferences @Inject constructor (context : Context) : Preferences(context, false), BlacklistPreferencesApi {
    override var blockedTags: Set<String> by stringSetPref("blockedTagsSet")
    override var blockedUsers: Set<String> by stringSetPref("blockedUsersSet")
}

fun Set<String>.containsTagInBody(body : String) : Boolean {
    forEach {
        if (body.toLowerCase().contains("#" + it.removePrefix("#"))) {
            return true
        }
    }
    return false
}