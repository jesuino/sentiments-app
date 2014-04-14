var Scene = Java.type('javafx.scene.Scene')
var VBox = Java.type('javafx.scene.layout.VBox')
var Label = Java.type('javafx.scene.control.Label')


var root = new VBox(10)
var scene = new Scene(root)
var lbl = new Label("Hello World")

root.children.addAll(lbl)
stage.scene = scene
stage.title = "Olá Mundo"
stage.width = 300
stage.height = 300
stage.show()
