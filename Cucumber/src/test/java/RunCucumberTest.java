/*
// @RunWith
// Указание класса для запуска тестов
@RunWith(Cucumber.class)
// @CucumberOptions
// Указание опции для запуска сценариев
@CucumberOptions(
    // Список папок с feature файлами - фичи/сценарии
    features = {"src/test/resources/features"},
    // Спиcок пакетов с steps файлами - шаги
    glue = {"steps"}
)
*/
/*
// @Suite
// Набор тестов
@Suite
// @IncludeEngines
// Тестовый движок
@IncludeEngines("cucumber")
// @SelectClasspathResource
// Папка с BDD сценариями на Gherkin
@SelectClasspathResource("features")
// @ConfigurationParameter
// Опции для запуска сценариев
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "steps, hooks")
@ConfigurationParameter(key = PLUGIN_PUBLISH_QUIET_PROPERTY_NAME, value = "true")
*/
public class RunCucumberTest {
}