interface TestRailClient {
    fun createClient(endpoint: String, username: String, password: String)
    fun addResults()
}