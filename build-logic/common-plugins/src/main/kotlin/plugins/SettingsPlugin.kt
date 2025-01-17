package plugins

import GithubAction
import com.gradle.scan.plugin.PublishedBuildScan
import org.gradle.api.Plugin
import org.gradle.api.initialization.Settings
import org.gradle.kotlin.dsl.gradleEnterprise

/** Gradle enterprise settings plugin with TOS accepted. */
class SettingsPlugin : Plugin<Settings> {
  override fun apply(settings: Settings) {
    settings.plugins.withId("com.gradle.enterprise") {
      settings.gradleEnterprise {
        buildScan {
          termsOfServiceUrl = "https://gradle.com/terms-of-service"
          termsOfServiceAgree = "yes"
          capture.isTaskInputFiles = true
          if (GithubAction.isEnabled) {
            publishAlways()
            isUploadInBackground = false
            tag("GITHUB_ACTION")
            buildScanPublished { addJobSummary() }
          }
        }
      }
    }
  }

  /** Add build scan details to GitHub Job summary report! */
  private fun PublishedBuildScan.addJobSummary() {
    GithubAction.setOutput("build_scan_uri", buildScanUri)
    GithubAction.addJobSummary(
        """
        | ##### 🚀 Gradle BuildScan [URL](${buildScanUri.toASCIIString()})
        """
            .trimMargin())
  }
}
