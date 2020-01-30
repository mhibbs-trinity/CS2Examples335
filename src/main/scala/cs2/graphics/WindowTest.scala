package cs2.graphics

import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.scene.Scene
import scalafx.scene.canvas.Canvas
import scalafx.scene.paint.Color
import scalafx.scene.input.MouseEvent
import scalafx.scene.image.Image
import scalafx.animation.AnimationTimer

object WindowTest extends JFXApp {
    stage = new JFXApp.PrimaryStage {
        title = "Window!"
        scene = new Scene(600,600) {
            val canvas = new Canvas(600,600)
            content = canvas
            val g = canvas.graphicsContext2D

            var px = 300.0
            var py = 300.0
            var dx = math.random * 10 - 5
            var dy = math.random * 10 - 5
            val timer = AnimationTimer(t => {
                g.setFill(Color.White)
                g.fillRect(0,0, 600,600)
                g.setFill(Color.Red)
                g.fillOval(px-50,py-50, 100,100)
                if(py < 50 || py > 550) dy *= -1
                py += dy
                if(px < 50 || px > 550) dx *= -1
                px += dx
            })
            timer.start


            /*
            canvas.onMouseDragged = (e:MouseEvent) => {
                g.strokeLine(300,300, e.x,e.y)
            }

            val path = getClass.getResource("/images/player.png")
            println(path)
            val img = new Image(path.toString)
            g.drawImage(img, 100,200, 300,300)
            */
            /*
            for(x <- 0 until 600 by 20) {
                for(y <- 0 until 600 by 20) {
                    g.setFill(Color.rgb(x*255/600,y*255/600,0))
                    g.fillOval(x,y, 20,20)
                }
            }
            */

            /*
            g.setFill(Color.OLIVEDRAB)
            g.strokeRect(100,200, 300,100)
            g.fillOval(100,200, 300,100)
            g.fillText("Hello world!", 100,200)
            g.setStroke(Color.rgb(255,0,0))
            g.strokeLine(100,200, 600,600)
            */
        }
    }
}