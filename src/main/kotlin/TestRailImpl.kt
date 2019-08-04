import com.codepine.api.testrail.TestRail
import com.codepine.api.testrail.model.Result
import com.typesafe.config.Config
import com.typesafe.config.ConfigFactory

class TestRailImpl : TestRailClient {

    val client = createClient(
        endpoint = Configuration.endpoint,
        username = Configuration.username,
        password = Configuration.password
    )

    val result = Result().apply {
        testId = 1
        caseId = 1
        statusId = 1
        assignedtoId = 1
        comment = "foobar"
        elapsed = "..."
        defects = listOf("foo","bar")
        version = "..."
    }
    val resultFields = client.ResultFields().list().execute()

    val listOfResults = listOf(result,result,result)

    override fun createClient(endpoint: String, username: String, password: String): TestRail {
        return TestRail.builder(endpoint, username, password).build()
    }

    override fun addResult() {
        client.Results().add(1, result, resultFields).execute()
    }

    override fun addResults() {
        client.Results().add(1, listOfResults, resultFields).execute()
    }

    object Configuration {
        private val baseConfig: Config = ConfigFactory.load().getConfig("config.testrail")
        val endpoint: String = baseConfig.getString("endpoint")
        val username: String = baseConfig.getString("username")
        val password: String = baseConfig.getString("password")
    }
}