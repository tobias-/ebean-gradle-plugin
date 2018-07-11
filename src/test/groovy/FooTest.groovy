import org.gradle.testkit.runner.GradleRunner
import org.gradle.testkit.runner.TaskOutcome
import org.junit.Rule
import org.junit.rules.TemporaryFolder
import spock.lang.Specification

class FooTest extends Specification {
  @Rule
  TemporaryFolder testProjectDir = new TemporaryFolder()

  def "hello world task prints hello world"() {
    given:
    testProjectDir.newFile('build.gradle') << """
        def outcome = null
        task helloWorld {
           System.err.println("Hello world!");
        }
    """

    when:
    def result = GradleRunner.create()
      .withProjectDir(testProjectDir.root)
      .withArguments('helloWorld')
      .withPluginClasspath()
      .build()

    then:
    result.output.contains('Hello world!')
    result.task(":helloWorld").outcome == TaskOutcome.UP_TO_DATE
  }

}
