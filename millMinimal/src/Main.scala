import javafx.scene.paint as jfxsp
import scalafx.Includes.*
import scalafx.application.JFXApp3
import scalafx.application.JFXApp3.PrimaryStage
import scalafx.beans.binding.ObjectBinding
import scalafx.scene.Scene
import scalafx.scene.paint.Color
import scalafx.scene.shape.Rectangle

object Main extends JFXApp3:
  def start(): Unit =
    stage = new PrimaryStage:
      title.value = "Hello Stage"
      width = 600
      height = 450
      scene = new Scene:
        fill = Color.LightGreen
        content = new Rectangle:
          x = 25
          y = 40
          width = 100
          height = 100
          // TODO Scala 3: variable `helper` was added to force type (and implicit conversions) on right side of `<==`
          val helper: ObjectBinding[jfxsp.Color] = when(hover) choose Color.Green otherwise Color.Red
          fill <== helper