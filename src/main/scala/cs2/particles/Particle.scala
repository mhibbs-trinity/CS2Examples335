package cs2.particles

import cs2.util.Vec2
import scalafx.scene.canvas.GraphicsContext

class Particle(var pos:Vec2, var vel:Vec2) {
    var r = 10.0

    def display(g:GraphicsContext):Unit = {
        g.fillOval(pos.x-r,pos.y-r, r*2,r*2)
    }

    def timeStep():Unit = {
        pos += vel
    }

}