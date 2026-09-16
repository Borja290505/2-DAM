from PyQt6.QtCore import QSize, Qt
from PyQt6.QtWidgets import QApplication, QMainWindow, QPushButton

class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()

        self.setWindowTitle("Mi Aplicacion")

        boton = QPushButton("Pulsa")
        boton.setCheckable(True)

        #Ejecucion de la funcion botonActivado
        boton.clicked.connect(self.botonActivado)
        self.setCentralWidget(boton)

    #Cada vez que pulso manda true o false luego los muestra de forma alterna
    def botonActivado(self,p):
        print(p)

app = QApplication([])

window = MainWindow()

window.show()

app.exec()