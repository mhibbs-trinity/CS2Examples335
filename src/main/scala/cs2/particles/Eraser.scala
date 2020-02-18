package cs2.particles

import cs2.util.Vec2
import scalafx.scene.canvas.GraphicsContext
import scalafx.scene.paint.Color

class Eraser(private val pos:Vec2, private val r:Double) {
    def overlap(p:Particle):Boolean = {
        val dx = pos.x - p.position.x
        val dy = pos.y - p.position.y
        if(math.sqrt(dx*dx + dy*dy) < r + p.radius) true
        else false
    }
    def display(g:GraphicsContext):Unit = {
        g.setStroke(Color.Black)
        g.strokeOval(pos.x-r, pos.y-r, r*2, r*2)
    }
}