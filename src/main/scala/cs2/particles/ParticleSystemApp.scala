package cs2.particles

import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.scene.Scene
import scalafx.scene.canvas.Canvas
import scalafx.animation.AnimationTimer
import cs2.util.Vec2
import scalafx.scene.paint.Color
import scalafx.scene.input.MouseEvent
import scalafx.scene.input.KeyEvent
import scalafx.scene.input.KeyCode
import scala.collection.mutable
import scalafx.scene.input.MouseButton

object ParticleSystemApp extends JFXApp {
    stage = new JFXApp.PrimaryStage {
        title = "Particles!"
        scene = new Scene(600,600) {
            val canvas = new Canvas(600,600)
            content = canvas
            val g = canvas.graphicsContext2D

            var ps:List[ParticleSystem] = Nil
            var erasers:mutable.Buffer[Eraser] = mutable.Buffer()

            canvas.onMouseClicked = (e:MouseEvent) => {
                if(e.button == MouseButton.PRIMARY) {
                    ps ::= new ParticleSystem(new Vec2(e.x, e.y))
                } else if(e.button == MouseButton.SECONDARY) {
                    erasers += new Eraser(new Vec2(e.x,e.y), 30)
                }
            }
            canvas.onKeyPressed = (e:KeyEvent) => {
                if(e.code == KeyCode.Space) {
                    ps = Nil
                }
            }
            canvas.requestFocus

            val bg = new RainbowBackground(width.value,height.value)

            val timer = AnimationTimer(t => {
                bg.display(g)
                for(p <- ps) {
                    p.display(g)
                    p.timeStep(erasers)
                    p.addParticle
                    p.applyForce(new Vec2(0,-0.5))
                    erasers.foreach(_.display(g))
                }
            })
            timer.start

        }
    }
}