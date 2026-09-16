from PyQt6.QtCore import QSize, Qt
from PyQt6.QtWidgets import QApplication, QMainWindow, QPushButton

class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()

        self.setWindowTitle("Mi Aplicacion")

        boton = QPushButton("Pulsa")
        boton.setCheckable(True)

        boton.pressed.connect(self.botonPulsado)
        boton.released.connect(self.botonSoltado)
        boton.clicked.connect(self.botonPulsadoySoltado)

        self.setCentralWidget(boton)
        
    def botonPulsado(self):
        print("Botón pulsado")

    def botonSoltado(self):
        print("Botón soltado")

    def botonPulsadoySoltado(self):
        print("Botón pulsado y soltado")


app = QApplication([])

window = MainWindow()

window.show()

app.exec()