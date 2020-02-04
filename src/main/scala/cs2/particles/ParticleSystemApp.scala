package cs2.particles

import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.scene.Scene
import scalafx.scene.canvas.Canvas
import scalafx.animation.AnimationTimer
import cs2.util.Vec2
import scalafx.scene.paint.Color

object ParticleSystemApp extends JFXApp {
    stage = new JFXApp.PrimaryStage {
        title = "Particles!"
        scene = new Scene(600,600) {
            val canvas = new Canvas(600,600)
            content = canvas
            val g = canvas.graphicsContext2D

            val p = new ParticleSystem(new Vec2(200,200))
            val timer = AnimationTimer(t => {
                g.setFill(Color.White)
                g.fillRect(0,0, 600,600)
                p.display(g)
                p.timeStep
                p.addParticle
                p.applyForce(new Vec2(0,0.5))
            })
            timer.start

        }
    }
}