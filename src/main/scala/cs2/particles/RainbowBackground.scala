package cs2.particles

import scalafx.scene.canvas.GraphicsContext

class RainbowBackground(val w:Double, val h:Double) extends ColorRotation {
    def display(g:GraphicsContext):Unit = {
        g.setFill(stepColor)
        g.fillRect(0,0, w,h)
    }
}