package com.example.cocusChallenge.api.models

import com.google.gson.annotations.SerializedName

data class ApiUser(
    @SerializedName("clan")
    val clan: String,
    @SerializedName("codeChallenges")
    val codeChallenges: CodeChallenges,
    @SerializedName("honor")
    val honor: Int,
    @SerializedName("leaderboardPosition")
    val leaderBoardPosition: Int?,
    @SerializedName("name")
    val name: String,
    @SerializedName("ranks")
    val ranks: Ranks,
    @SerializedName("skills")
    val skills: List<Any>,
    @SerializedName("username")
    val username: String
) {
    val bestLanguage: String?
        get() {
            ranks.languages.maxByOrNull {
                it.value.score
            }.also {
                return "${it?.key}, ${it?.value?.score}"
            }
        }

    data class CodeChallenges(
        @SerializedName("totalAuthored")
        val totalAuthored: Int,
        @SerializedName("totalCompleted")
        val totalCompleted: Int
    )

    data class Ranks(
        @SerializedName("languages")
        val languages: Map<String, Language>,
        @SerializedName("overall")
        val overall: Language
    ) {
        data class Language(
            @SerializedName("color")
            val color: String,
            @SerializedName("name")
            val name: String,
            @SerializedName("rank")
            val rank: Int,
            @SerializedName("score")
            val score: Int
        )
    }
}