import mill._, scalalib._

object millMinimal extends ScalaModule {
  def scalaVersion = "3.0.0-RC3"

  // Customize the coursier resolution to discover the OS-specific artifacts required by JavaFX
  // Note: this requires mill >= 0.9.7 (with pr/775 merged)
  def resolutionCustomizer = T.task {
     Some( (r: coursier.core.Resolution) =>
       r.withOsInfo(coursier.core.Activation.Os.fromProperties(sys.props.toMap))
     )
   }

  // Add dependency on JavaFX libraries
  val javaFXVersion  = "16-ea+7"
  val scalaFXVersion = "16.0.0-R22"
  val javaFXModules  = List("base", "controls", "fxml", "graphics", "media", "swing", "web")
    .map(m => ivy"org.openjfx:javafx-$m:$javaFXVersion")

  def ivyDeps = {
    Agg(
      ivy"org.scalafx::scalafx:$scalaFXVersion",
      ivy"org.controlsfx:controlsfx:11.1.0",
      //...
    ) ++ javaFXModules
  }
}
