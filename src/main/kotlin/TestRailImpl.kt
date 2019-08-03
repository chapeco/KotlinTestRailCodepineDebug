import com.codepine.api.testrail.TestRail
import com.typesafe.config.Config
import com.typesafe.config.ConfigFactory

class TestRailImpl : TestRailClient {
    val client = with(Configuration) {
        createClient(endpoint = endpoint, username = username, password = password)
    }

    override fun createClient(endpoint: String, username: String, password: String) {
        TestRail.builder(endpoint, username, password)
    }

    override fun addResults() {

    }

    object Configuration {
        private val baseConfig: Config = ConfigFactory.load().getConfig("config.testrail")
        val endpoint: String = baseConfig.getString("endpoint")
        val username: String = baseConfig.getString("username")
        val password: String = baseConfig.getString("password")
    }
}