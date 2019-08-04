import com.codepine.api.testrail.TestRail

interface TestRailClient {
    fun createClient(endpoint: String, username: String, password: String) : TestRail
    fun addResult()
    fun addResults()
}