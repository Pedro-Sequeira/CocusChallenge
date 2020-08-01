package com.example.cocusChallenge.models

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("clan")
    val clan: String,
    @SerializedName("codeChallenges")
    val codeChallenges: CodeChallenges,
    @SerializedName("honor")
    val honor: Int,
    @SerializedName("leaderboardPosition")
    val leaderboardPosition: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("ranks")
    val ranks: Ranks,
    @SerializedName("skills")
    val skills: List<Any>,
    @SerializedName("username")
    val username: String
) {
    data class CodeChallenges(
        @SerializedName("totalAuthored")
        val totalAuthored: Int,
        @SerializedName("totalCompleted")
        val totalCompleted: Int
    )

    data class Ranks(
        @SerializedName("languages")
        val languages: Languages,
        @SerializedName("overall")
        val overall: Overall
    ) {
        data class Languages(
            @SerializedName("c")
            val c: C,
            @SerializedName("clojure")
            val clojure: Clojure,
            @SerializedName("cobol")
            val cobol: Cobol,
            @SerializedName("coffeescript")
            val coffeescript: Coffeescript,
            @SerializedName("coq")
            val coq: Coq,
            @SerializedName("cpp")
            val cpp: Cpp,
            @SerializedName("crystal")
            val crystal: Crystal,
            @SerializedName("csharp")
            val csharp: Csharp,
            @SerializedName("dart")
            val dart: Dart,
            @SerializedName("elixir")
            val elixir: Elixir,
            @SerializedName("erlang")
            val erlang: Erlang,
            @SerializedName("factor")
            val factor: Factor,
            @SerializedName("forth")
            val forth: Forth,
            @SerializedName("fortran")
            val fortran: Fortran,
            @SerializedName("fsharp")
            val fsharp: Fsharp,
            @SerializedName("go")
            val go: Go,
            @SerializedName("groovy")
            val groovy: Groovy,
            @SerializedName("haskell")
            val haskell: Haskell,
            @SerializedName("haxe")
            val haxe: Haxe,
            @SerializedName("java")
            val java: Java,
            @SerializedName("javascript")
            val javascript: Javascript,
            @SerializedName("julia")
            val julia: Julia,
            @SerializedName("kotlin")
            val kotlin: Kotlin,
            @SerializedName("lua")
            val lua: Lua,
            @SerializedName("nim")
            val nim: Nim,
            @SerializedName("objc")
            val objc: Objc,
            @SerializedName("ocaml")
            val ocaml: Ocaml,
            @SerializedName("php")
            val php: Php,
            @SerializedName("powershell")
            val powershell: Powershell,
            @SerializedName("prolog")
            val prolog: Prolog,
            @SerializedName("python")
            val python: Python,
            @SerializedName("r")
            val r: R,
            @SerializedName("racket")
            val racket: Racket,
            @SerializedName("reason")
            val reason: Reason,
            @SerializedName("ruby")
            val ruby: Ruby,
            @SerializedName("rust")
            val rust: Rust,
            @SerializedName("scala")
            val scala: Scala,
            @SerializedName("shell")
            val shell: Shell,
            @SerializedName("solidity")
            val solidity: Solidity,
            @SerializedName("sql")
            val sql: Sql,
            @SerializedName("swift")
            val swift: Swift,
            @SerializedName("typescript")
            val typescript: Typescript,
            @SerializedName("vb")
            val vb: Vb
        ) {
            data class C(
                @SerializedName("color")
                val color: String,
                @SerializedName("name")
                val name: String,
                @SerializedName("rank")
                val rank: Int,
                @SerializedName("score")
                val score: Int
            )

            data class Clojure(
                @SerializedName("color")
                val color: String,
                @SerializedName("name")
                val name: String,
                @SerializedName("rank")
                val rank: Int,
                @SerializedName("score")
                val score: Int
            )

            data class Cobol(
                @SerializedName("color")
                val color: String,
                @SerializedName("name")
                val name: String,
                @SerializedName("rank")
                val rank: Int,
                @SerializedName("score")
                val score: Int
            )

            data class Coffeescript(
                @SerializedName("color")
                val color: String,
                @SerializedName("name")
                val name: String,
                @SerializedName("rank")
                val rank: Int,
                @SerializedName("score")
                val score: Int
            )

            data class Coq(
                @SerializedName("color")
                val color: String,
                @SerializedName("name")
                val name: String,
                @SerializedName("rank")
                val rank: Int,
                @SerializedName("score")
                val score: Int
            )

            data class Cpp(
                @SerializedName("color")
                val color: String,
                @SerializedName("name")
                val name: String,
                @SerializedName("rank")
                val rank: Int,
                @SerializedName("score")
                val score: Int
            )

            data class Crystal(
                @SerializedName("color")
                val color: String,
                @SerializedName("name")
                val name: String,
                @SerializedName("rank")
                val rank: Int,
                @SerializedName("score")
                val score: Int
            )

            data class Csharp(
                @SerializedName("color")
                val color: String,
                @SerializedName("name")
                val name: String,
                @SerializedName("rank")
                val rank: Int,
                @SerializedName("score")
                val score: Int
            )

            data class Dart(
                @SerializedName("color")
                val color: String,
                @SerializedName("name")
                val name: String,
                @SerializedName("rank")
                val rank: Int,
                @SerializedName("score")
                val score: Int
            )

            data class Elixir(
                @SerializedName("color")
                val color: String,
                @SerializedName("name")
                val name: String,
                @SerializedName("rank")
                val rank: Int,
                @SerializedName("score")
                val score: Int
            )

            data class Erlang(
                @SerializedName("color")
                val color: String,
                @SerializedName("name")
                val name: String,
                @SerializedName("rank")
                val rank: Int,
                @SerializedName("score")
                val score: Int
            )

            data class Factor(
                @SerializedName("color")
                val color: String,
                @SerializedName("name")
                val name: String,
                @SerializedName("rank")
                val rank: Int,
                @SerializedName("score")
                val score: Int
            )

            data class Forth(
                @SerializedName("color")
                val color: String,
                @SerializedName("name")
                val name: String,
                @SerializedName("rank")
                val rank: Int,
                @SerializedName("score")
                val score: Int
            )

            data class Fortran(
                @SerializedName("color")
                val color: String,
                @SerializedName("name")
                val name: String,
                @SerializedName("rank")
                val rank: Int,
                @SerializedName("score")
                val score: Int
            )

            data class Fsharp(
                @SerializedName("color")
                val color: String,
                @SerializedName("name")
                val name: String,
                @SerializedName("rank")
                val rank: Int,
                @SerializedName("score")
                val score: Int
            )

            data class Go(
                @SerializedName("color")
                val color: String,
                @SerializedName("name")
                val name: String,
                @SerializedName("rank")
                val rank: Int,
                @SerializedName("score")
                val score: Int
            )

            data class Groovy(
                @SerializedName("color")
                val color: String,
                @SerializedName("name")
                val name: String,
                @SerializedName("rank")
                val rank: Int,
                @SerializedName("score")
                val score: Int
            )

            data class Haskell(
                @SerializedName("color")
                val color: String,
                @SerializedName("name")
                val name: String,
                @SerializedName("rank")
                val rank: Int,
                @SerializedName("score")
                val score: Int
            )

            data class Haxe(
                @SerializedName("color")
                val color: String,
                @SerializedName("name")
                val name: String,
                @SerializedName("rank")
                val rank: Int,
                @SerializedName("score")
                val score: Int
            )

            data class Java(
                @SerializedName("color")
                val color: String,
                @SerializedName("name")
                val name: String,
                @SerializedName("rank")
                val rank: Int,
                @SerializedName("score")
                val score: Int
            )

            data class Javascript(
                @SerializedName("color")
                val color: String,
                @SerializedName("name")
                val name: String,
                @SerializedName("rank")
                val rank: Int,
                @SerializedName("score")
                val score: Int
            )

            data class Julia(
                @SerializedName("color")
                val color: String,
                @SerializedName("name")
                val name: String,
                @SerializedName("rank")
                val rank: Int,
                @SerializedName("score")
                val score: Int
            )

            data class Kotlin(
                @SerializedName("color")
                val color: String,
                @SerializedName("name")
                val name: String,
                @SerializedName("rank")
                val rank: Int,
                @SerializedName("score")
                val score: Int
            )

            data class Lua(
                @SerializedName("color")
                val color: String,
                @SerializedName("name")
                val name: String,
                @SerializedName("rank")
                val rank: Int,
                @SerializedName("score")
                val score: Int
            )

            data class Nim(
                @SerializedName("color")
                val color: String,
                @SerializedName("name")
                val name: String,
                @SerializedName("rank")
                val rank: Int,
                @SerializedName("score")
                val score: Int
            )

            data class Objc(
                @SerializedName("color")
                val color: String,
                @SerializedName("name")
                val name: String,
                @SerializedName("rank")
                val rank: Int,
                @SerializedName("score")
                val score: Int
            )

            data class Ocaml(
                @SerializedName("color")
                val color: String,
                @SerializedName("name")
                val name: String,
                @SerializedName("rank")
                val rank: Int,
                @SerializedName("score")
                val score: Int
            )

            data class Php(
                @SerializedName("color")
                val color: String,
                @SerializedName("name")
                val name: String,
                @SerializedName("rank")
                val rank: Int,
                @SerializedName("score")
                val score: Int
            )

            data class Powershell(
                @SerializedName("color")
                val color: String,
                @SerializedName("name")
                val name: String,
                @SerializedName("rank")
                val rank: Int,
                @SerializedName("score")
                val score: Int
            )

            data class Prolog(
                @SerializedName("color")
                val color: String,
                @SerializedName("name")
                val name: String,
                @SerializedName("rank")
                val rank: Int,
                @SerializedName("score")
                val score: Int
            )

            data class Python(
                @SerializedName("color")
                val color: String,
                @SerializedName("name")
                val name: String,
                @SerializedName("rank")
                val rank: Int,
                @SerializedName("score")
                val score: Int
            )

            data class R(
                @SerializedName("color")
                val color: String,
                @SerializedName("name")
                val name: String,
                @SerializedName("rank")
                val rank: Int,
                @SerializedName("score")
                val score: Int
            )

            data class Racket(
                @SerializedName("color")
                val color: String,
                @SerializedName("name")
                val name: String,
                @SerializedName("rank")
                val rank: Int,
                @SerializedName("score")
                val score: Int
            )

            data class Reason(
                @SerializedName("color")
                val color: String,
                @SerializedName("name")
                val name: String,
                @SerializedName("rank")
                val rank: Int,
                @SerializedName("score")
                val score: Int
            )

            data class Ruby(
                @SerializedName("color")
                val color: String,
                @SerializedName("name")
                val name: String,
                @SerializedName("rank")
                val rank: Int,
                @SerializedName("score")
                val score: Int
            )

            data class Rust(
                @SerializedName("color")
                val color: String,
                @SerializedName("name")
                val name: String,
                @SerializedName("rank")
                val rank: Int,
                @SerializedName("score")
                val score: Int
            )

            data class Scala(
                @SerializedName("color")
                val color: String,
                @SerializedName("name")
                val name: String,
                @SerializedName("rank")
                val rank: Int,
                @SerializedName("score")
                val score: Int
            )

            data class Shell(
                @SerializedName("color")
                val color: String,
                @SerializedName("name")
                val name: String,
                @SerializedName("rank")
                val rank: Int,
                @SerializedName("score")
                val score: Int
            )

            data class Solidity(
                @SerializedName("color")
                val color: String,
                @SerializedName("name")
                val name: String,
                @SerializedName("rank")
                val rank: Int,
                @SerializedName("score")
                val score: Int
            )

            data class Sql(
                @SerializedName("color")
                val color: String,
                @SerializedName("name")
                val name: String,
                @SerializedName("rank")
                val rank: Int,
                @SerializedName("score")
                val score: Int
            )

            data class Swift(
                @SerializedName("color")
                val color: String,
                @SerializedName("name")
                val name: String,
                @SerializedName("rank")
                val rank: Int,
                @SerializedName("score")
                val score: Int
            )

            data class Typescript(
                @SerializedName("color")
                val color: String,
                @SerializedName("name")
                val name: String,
                @SerializedName("rank")
                val rank: Int,
                @SerializedName("score")
                val score: Int
            )

            data class Vb(
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

        data class Overall(
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