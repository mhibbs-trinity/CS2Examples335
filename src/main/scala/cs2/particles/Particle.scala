package cs2.particles

import cs2.util.Vec2
import scalafx.scene.canvas.GraphicsContext
import scalafx.scene.paint.Color

abstract class Particle(protected var pos:Vec2, private var vel:Vec2) {
    protected var r = 10.0
    protected var col = Color.OrangeRed

    def display(g:GraphicsContext):Unit

    def timeStep():Unit = {
        pos += vel
    }

    def applyForce(acc:Vec2):Unit = {
        vel += acc
    }

}